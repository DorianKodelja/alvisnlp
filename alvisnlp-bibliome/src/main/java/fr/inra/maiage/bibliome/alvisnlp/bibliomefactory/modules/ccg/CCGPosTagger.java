/*
Copyright 2016, 2017 Institut National de la Recherche Agronomique

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/


package fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.ccg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.logging.Logger;

import fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.ccg.CCGBase.CCGResolvedObjects;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Annotation;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Corpus;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Layer;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.EvaluationContext;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.ResolverException;
import fr.inra.maiage.bibliome.alvisnlp.core.module.ModuleException;
import fr.inra.maiage.bibliome.alvisnlp.core.module.ProcessingContext;
import fr.inra.maiage.bibliome.alvisnlp.core.module.ProcessingException;
import fr.inra.maiage.bibliome.alvisnlp.core.module.TimerCategory;
import fr.inra.maiage.bibliome.alvisnlp.core.module.lib.AlvisNLPModule;
import fr.inra.maiage.bibliome.alvisnlp.core.module.lib.Param;
import fr.inra.maiage.bibliome.alvisnlp.core.module.lib.TimeThis;
import fr.inra.maiage.bibliome.util.files.ExecutableFile;
import fr.inra.maiage.bibliome.util.files.InputDirectory;
import fr.inra.maiage.bibliome.util.streams.FileSourceStream;
import fr.inra.maiage.bibliome.util.streams.FileTargetStream;
import fr.inra.maiage.bibliome.util.streams.SourceStream;
import fr.inra.maiage.bibliome.util.streams.TargetStream;

@AlvisNLPModule
public class CCGPosTagger extends CCGBase<CCGResolvedObjects> {
	private ExecutableFile executable;
	private InputDirectory model;
	private Boolean silent = false;
	private String internalEncoding = "UTF-8";
	private Boolean keepPreviousPos = false;
	
	@Override
	public void process(ProcessingContext<Corpus> ctx, Corpus corpus) throws ModuleException {
		try {
			Logger logger = getLogger(ctx);
			EvaluationContext evalCtx = new EvaluationContext(logger);
			List<List<Layer>> sentenceRuns = getSentences(logger, evalCtx, corpus);
			for (int run = 0; run < sentenceRuns.size(); ++run) {
				logger.info(String.format("run %d/%d", run+1, sentenceRuns.size())); 
				List<Layer> sentences = sentenceRuns.get(run);
				CCGPosTaggerExternal ext = new CCGPosTaggerExternal(this, ctx, run, getMaxLength(sentences));
				TargetStream target = new FileTargetStream(internalEncoding, ext.getInput());
				try (PrintStream out = target.getPrintStream()) {
					printSentences(ctx, out, sentences, false);
				}
				callExternal(ctx, "run-ccg", ext, internalEncoding, "ccg-pos.sh");
				SourceStream source = new FileSourceStream(internalEncoding, ext.getOutput());
				try (BufferedReader r = source.getBufferedReader()) {
					readSentences(ctx, r, sentences);
				}
			}
		}
		catch (IOException e) {
			rethrow(e);
		}
	}

	@Override
	protected CCGResolvedObjects createResolvedObjects(ProcessingContext<Corpus> ctx) throws ResolverException {
		return new CCGResolvedObjects(ctx, this);
	}

	private void readSentence(BufferedReader r, Layer sentence) throws IOException, ProcessingException {
		boolean reachedEOS = false;
		for (Annotation word : sentence) {
			if (word.getLastFeature(getFormFeatureName()).isEmpty())
				continue;
			if (reachedEOS)
				throw new ProcessingException("CCG sentence was too short");
			String pos = r.readLine();
			if (pos == null)
				throw new ProcessingException("CCG was short");
			if (pos.endsWith("\tEOS")) {
				reachedEOS = true;
				pos = pos.substring(0, pos.length() - 4);
			}
			if (keepPreviousPos && word.hasFeature(getPosFeatureName()))
				continue;
			word.addFeature(getPosFeatureName(), pos.intern());
		}
		if (!reachedEOS)
			throw new ProcessingException("CCG sentence was too long: " + sentence.getSentenceAnnotation());
	}
	
	@TimeThis(task="read-ccg-out", category=TimerCategory.COLLECT_DATA)
	protected void readSentences(@SuppressWarnings("unused") ProcessingContext<Corpus> ctx, BufferedReader r, List<Layer> sentences) throws ProcessingException, IOException {
		for (Layer sent : sentences)
			readSentence(r, sent);
	}
	
	@Param
	public ExecutableFile getExecutable() {
		return executable;
	}

	@Param
	public InputDirectory getModel() {
		return model;
	}

	@Param
	public Boolean getSilent() {
		return silent;
	}

	@Param
	public String getInternalEncoding() {
		return internalEncoding;
	}

	@Param
	public Boolean getKeepPreviousPos() {
		return keepPreviousPos;
	}

	public void setKeepPreviousPos(Boolean keepPreviousPos) {
		this.keepPreviousPos = keepPreviousPos;
	}

	public void setExecutable(ExecutableFile executable) {
		this.executable = executable;
	}

	public void setModel(InputDirectory model) {
		this.model = model;
	}

	public void setSilent(Boolean silent) {
		this.silent = silent;
	}

	public void setInternalEncoding(String internalEncoding) {
		this.internalEncoding = internalEncoding;
	}
}
