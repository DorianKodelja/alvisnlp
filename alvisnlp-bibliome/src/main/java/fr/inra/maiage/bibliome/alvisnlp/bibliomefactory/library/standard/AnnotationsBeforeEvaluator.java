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


package fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.library.standard;

import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Annotation;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.Layer;
import fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Evaluator;

final class AnnotationsBeforeEvaluator extends AbstractAnnotationSiblings {
	AnnotationsBeforeEvaluator(String layerName, boolean excludeSelf) {
		super(layerName, excludeSelf);
	}

	AnnotationsBeforeEvaluator(Evaluator layerNameEvaluator, boolean excludeSelf) {
		super(layerNameEvaluator, excludeSelf);
	}

	@Override
	protected Layer getAnnotations(Layer layer, Annotation a) {
		return layer.before(a.getStart());
	}
}