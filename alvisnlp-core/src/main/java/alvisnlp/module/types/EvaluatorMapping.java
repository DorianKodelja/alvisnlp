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


package alvisnlp.module.types;

import java.util.LinkedHashMap;
import java.util.logging.Logger;

import alvisnlp.corpus.expressions.Evaluator;
import alvisnlp.module.ModuleException;
import alvisnlp.module.NameUsage;
import alvisnlp.module.NameUser;
import fr.inra.maiage.bibliome.util.Checkable;

public class EvaluatorMapping extends LinkedHashMap<String,Evaluator> implements Checkable, NameUser {
	private static final long serialVersionUID = 1L;

	public EvaluatorMapping() {
		super();
	}

	@Override
	public boolean check(Logger logger) {
		boolean result = true;
		for (Evaluator e : values())
			result = e.check(logger) && result;
		return result;
	}

	@Override
	public void collectUsedNames(NameUsage nameUsage, String defaultType) throws ModuleException {
		if (defaultType != null) {
			nameUsage.addNames(defaultType, keySet());
		}
		for (Evaluator e : values()) {
			e.collectUsedNames(nameUsage, defaultType);
		}
	}
}
