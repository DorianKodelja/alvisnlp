package fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.contes;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.SectionModule;
import fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.SectionModule.SectionResolvedObjects;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Annotation;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Corpus;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.DefaultNames;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Layer;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.NameType;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Section;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.EvaluationContext;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.ResolverException;
import fr.inra.maiage.bibliome.alvisnlp.core.module.ModuleException;
import fr.inra.maiage.bibliome.alvisnlp.core.module.ProcessingContext;
import fr.inra.maiage.bibliome.alvisnlp.core.module.lib.AlvisNLPModule;
import fr.inra.maiage.bibliome.alvisnlp.core.module.lib.Param;
import fr.inra.maiage.bibliome.util.Iterators;
import fr.inra.maiage.bibliome.util.files.InputDirectory;
import fr.inra.maiage.bibliome.util.files.InputFile;
import fr.inra.maiage.bibliome.util.files.OutputFile;

@AlvisNLPModule(beta=true)
public class ContesTrain extends SectionModule<SectionResolvedObjects> {
	private InputDirectory contesDir;
	private String tokenLayer = DefaultNames.getWordLayer();
	private String formFeature = Annotation.FORM_FEATURE_NAME;
	private String termLayer;
	private String conceptFeature;
	private InputFile ontology;
	private InputFile wordEmbeddings;
	private OutputFile regressionMatrix;
	
	@Override
	public void process(ProcessingContext<Corpus> ctx, Corpus corpus) throws ModuleException {
		Logger logger = getLogger(ctx);
		File tmpDir = getTempDir(ctx);
		ContesTrainExternal external = new ContesTrainExternal(this, logger, tmpDir);
		EvaluationContext evalCtx = new EvaluationContext(logger);
		try {
			external.createTermsFile(evalCtx, corpus);
			external.createAttributionsFile(evalCtx, corpus);
			callExternal(ctx, "contes-train", external);
		}
		catch (IOException e) {
			rethrow(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	JSONObject getTerms(EvaluationContext ctx, Corpus corpus) {
		JSONObject result = new JSONObject();
		for (Section sec : Iterators.loop(sectionIterator(ctx, corpus))) {
			Layer tokens = sec.getLayer(tokenLayer);
			for (Annotation term : sec.getLayer(termLayer)) {
				if (!term.hasFeature(conceptFeature)) {
					continue;
				}
				String id = term.getStringId();
				JSONArray termTokens = new JSONArray();
				for (Annotation t : tokens.between(term)) {
					String form = t.getLastFeature(formFeature);
					termTokens.add(form);
				}
				result.put(id, termTokens);
			}
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	JSONObject getAttributions(EvaluationContext ctx, Corpus corpus) {
		JSONObject result = new JSONObject();
		for (Section sec : Iterators.loop(sectionIterator(ctx, corpus))) {
			for (Annotation term : sec.getLayer(termLayer)) {
				if (!term.hasFeature(conceptFeature)) {
					continue;
				}
				String id = term.getStringId();
				JSONArray concepts = new JSONArray();
				concepts.addAll(term.getFeature(conceptFeature));
				result.put(id, concepts);
			}
		}
		return result;
	}

	@Override
	protected String[] addLayersToSectionFilter() {
		return new String[] { tokenLayer, termLayer };
	}

	@Override
	protected String[] addFeaturesToSectionFilter() {
		return null;
	}

	@Override
	protected SectionResolvedObjects createResolvedObjects(ProcessingContext<Corpus> ctx) throws ResolverException {
		return new SectionResolvedObjects(ctx, this);
	}

	@Param(nameType=NameType.LAYER)
	public String getTokenLayer() {
		return tokenLayer;
	}

	@Param(nameType=NameType.FEATURE)
	public String getFormFeature() {
		return formFeature;
	}

	@Param(nameType=NameType.LAYER)
	public String getTermLayer() {
		return termLayer;
	}

	@Param(nameType=NameType.FEATURE)
	public String getConceptFeature() {
		return conceptFeature;
	}

	@Param
	public InputFile getWordEmbeddings() {
		return wordEmbeddings;
	}

	@Param
	public InputDirectory getContesDir() {
		return contesDir;
	}

	@Param
	public InputFile getOntology() {
		return ontology;
	}

	@Param
	public OutputFile getRegressionMatrix() {
		return regressionMatrix;
	}

	public void setRegressionMatrix(OutputFile regressionMatrix) {
		this.regressionMatrix = regressionMatrix;
	}

	public void setOntology(InputFile ontology) {
		this.ontology = ontology;
	}

	public void setContesDir(InputDirectory contesDir) {
		this.contesDir = contesDir;
	}

	public void setTokenLayer(String tokenLayer) {
		this.tokenLayer = tokenLayer;
	}

	public void setFormFeature(String formFeature) {
		this.formFeature = formFeature;
	}

	public void setTermLayer(String termLayer) {
		this.termLayer = termLayer;
	}

	public void setConceptFeature(String conceptFeature) {
		this.conceptFeature = conceptFeature;
	}

	public void setWordEmbeddings(InputFile wordEmbeddings) {
		this.wordEmbeddings = wordEmbeddings;
	}
}