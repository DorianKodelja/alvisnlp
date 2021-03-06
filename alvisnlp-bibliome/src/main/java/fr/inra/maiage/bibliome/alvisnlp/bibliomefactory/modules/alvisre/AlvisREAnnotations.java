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


package fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.alvisre;

import java.io.PrintStream;

import fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.alvisre.AlvisREAnnotations.ResolvedAlvisREAnnotation;

import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Element;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.EvaluationContext;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Evaluator;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.LibraryResolver;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Resolvable;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.ResolverException;
import fr.inra.maiage.bibliome.alvisnlp.core.module.ModuleException;
import fr.inra.maiage.bibliome.alvisnlp.core.module.NameUsage;
import fr.inra.maiage.bibliome.alvisnlp.core.module.NameUser;
import fr.inra.maiage.bibliome.util.Iterators;

abstract class AlvisREAnnotations<T extends ResolvedAlvisREAnnotation> implements Resolvable<T> {
	private final Expression items;
	private final Expression type;

	protected AlvisREAnnotations(Expression items, Expression type) {
		super();
		this.items = items;
		this.type = type;
	}

	protected static abstract class ResolvedAlvisREAnnotation implements NameUser {
		private final Evaluator items;
		private final Evaluator type;

		protected ResolvedAlvisREAnnotation(LibraryResolver resolver, AlvisREAnnotations<?> annots) throws ResolverException {
			this.items = annots.items.resolveExpressions(resolver);
			this.type = annots.type.resolveExpressions(resolver);
		}

		@Override
		public void collectUsedNames(NameUsage nameUsage, String defaultType) throws ModuleException {
			items.collectUsedNames(nameUsage, defaultType);
			type.collectUsedNames(nameUsage, defaultType);
		}

		public void printLines(PrintStream out, SectionsMerger merger, EvaluationContext ctx, String forceType) {
			for (Element t : Iterators.loop(items.evaluateElements(ctx, merger.getSection()))) {
				printLine(out, merger, ctx, t, forceType);
			}
		}
		
		protected abstract String addElement(SectionsMerger merger, Element elt);
		
		public void addElements(SectionsMerger merger, EvaluationContext ctx, Element elt) {
			for (Element e : Iterators.loop(items.evaluateElements(ctx, elt))) {
				addElement(merger, e);
			}
		}

		private void printLine(PrintStream out, SectionsMerger merger, EvaluationContext ctx, Element elt, String forceType) {
			String id = merger.getId(elt);
			String type = forceType == null ? this.type.evaluateString(ctx, elt) : forceType;
			out.format("%s\t%s", id, type);
			printInfo(out, merger, ctx, elt);
			out.println();
		}

		protected abstract void printInfo(PrintStream out, SectionsMerger merger, EvaluationContext ctx, Element elt);
	}
}
