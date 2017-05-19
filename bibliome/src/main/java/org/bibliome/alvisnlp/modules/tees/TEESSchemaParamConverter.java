package org.bibliome.alvisnlp.modules.tees;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import alvisnlp.converters.ConverterException;
import alvisnlp.converters.lib.Converter;
import alvisnlp.converters.lib.MapParamConverter;

@Converter(targetType=TEESSchema.class)
public class TEESSchemaParamConverter extends MapParamConverter<String,String[],TEESSchema> {
	public TEESSchemaParamConverter() {
		super();
	}
	
	@Override
	public Class<String> keysType() {
		return String.class;
	}

	@Override
	public Class<String[]> valuesType() {
		return String[].class;
	}

	@Override
	public TEESSchema newEmptyMap() {
		return new TEESSchema();
	}

	@Override
	public Element getXMLValue(Document doc, String tagName, Object value) throws ConverterException {
		return super.getXMLValue(doc, tagName, value);
	}

	@Override
	public String getStringValue(Object value) throws ConverterException {
		return super.getStringValue(value);
	}	
}
