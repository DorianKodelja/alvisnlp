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


package org.bibliome.alvisnlp.converters;

import alvisnlp.converters.ConverterException;
import alvisnlp.converters.lib.Converter;
import alvisnlp.converters.lib.SimpleParamConverter;
import fr.inra.maiage.bibliome.util.Strings;

@Converter(targetType = Boolean.class)
public class BooleanParamConverter extends SimpleParamConverter<Boolean> {
    @Override
    public Boolean convertTrimmed(String stringValue) throws ConverterException {
        try {
            return stringValue.isEmpty() || Strings.getBoolean(stringValue);
        }
        catch (IllegalArgumentException iae) {
            cannotConvertString(stringValue, "");
            return null;
        }
    }

    @Override
    public String[] getAlternateAttributes() {
        return null;
    }
}
