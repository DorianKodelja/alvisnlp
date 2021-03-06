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


package fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.bionlpst;

import org.w3c.dom.Element;

import fr.inra.maiage.bibliome.alvisnlp.core.converters.ConverterException;
import fr.inra.maiage.bibliome.alvisnlp.core.converters.lib.AbstractParamConverter;
import fr.inra.maiage.bibliome.util.bionlpst.BioNLPSTException;
import fr.inra.maiage.bibliome.util.bionlpst.schema.DocumentSchema;

public class DocumentSchemaParamConverter extends AbstractParamConverter<DocumentSchema> {
	@Override
	protected DocumentSchema convertTrimmed(String stringValue) throws ConverterException {
		cannotConvertString(stringValue, "string conversion is not available for " + DocumentSchema.class.getCanonicalName());
		return null;
	}

	@Override
	protected DocumentSchema convertXML(Element xmlValue) throws ConverterException {
		try {
			return new DocumentSchema(xmlValue);
		}
		catch (BioNLPSTException e) {
			cannotConvertXML(xmlValue, e.getMessage());
			return null;
		}
	}
}
