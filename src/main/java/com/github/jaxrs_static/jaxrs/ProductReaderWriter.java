package com.github.jaxrs_static.jaxrs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.github.jaxrs_static.bean.Product;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductReaderWriter implements MessageBodyReader<Product>,
		MessageBodyWriter<Product> {

	@Override
	public long getSize(Product product, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return isJsonValid(type, mediaType);
	}

	@Override
	public void writeTo(Product product, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		if (entityStream == null) {
			return;
		}

		JsonObjectBuilder productBuilder = Json.createObjectBuilder();

		if (product == null) {
			writeJson(entityStream, productBuilder);
			return;
		}

		productBuilder.add("id", product.getId());
		productBuilder.add("code", nullToEmpty(product.getCode()));
		productBuilder
				.add("description", nullToEmpty(product.getDescription()));
		productBuilder.add("color", nullToEmpty(product.getColor()));
		productBuilder.add("cost", getRoundedDown(product.getCost(), 2));
		productBuilder
				.add("quantity", getRoundedDown(product.getQuantity(), 2));
		writeJson(entityStream, productBuilder);
	}

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return isJsonValid(type, mediaType);
	}

	@Override
	public Product readFrom(Class<Product> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		Product product = new Product();

		if (entityStream == null) {
			return product;
		}

		JsonReader jsonReader = Json.createReader(entityStream);
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		entityStream.close();

		if (jsonObject == null) {
			return product;
		}

		try {
			product.setId(jsonObject.getInt("id"));
		} catch (Exception e) {
		}

		try {
			product.setCode(jsonObject.getString("code"));
		} catch (Exception e) {
		}

		try {
			product.setDescription(jsonObject.getString("description"));
		} catch (Exception e) {
		}

		try {
			product.setColor(jsonObject.getString("color"));
		} catch (Exception e) {
		}

		try {
			product.setCost(jsonObject.getJsonNumber("cost").bigDecimalValue());
		} catch (Exception e) {
		}

		try {
			product.setQuantity(jsonObject.getJsonNumber("quantity")
					.bigDecimalValue());
		} catch (Exception e) {
		}

		return product;
	}

	private boolean isJsonValid(Class<?> type, MediaType mediaType) {
		return ((type != null) && Product.class.isAssignableFrom(type)
				&& (mediaType != null) && MediaType.APPLICATION_JSON_TYPE
				.getSubtype().equalsIgnoreCase(mediaType.getSubtype()));
	}

	private void writeJson(OutputStream entityStream,
			JsonObjectBuilder productBuilder) {
		JsonObject entityJsonObject = productBuilder.build();
		JsonWriter jsonWriter = Json.createWriter(entityStream);
		jsonWriter.writeObject(entityJsonObject);
		jsonWriter.close();
	}

	private String nullToEmpty(String value) {
		if (value == null) {
			return "";
		}

		return value;
	}

	private BigDecimal getRoundedDown(BigDecimal value, int digits) {
		if (value == null) {
			return new BigDecimal(0);
		}

		return value.setScale(digits, RoundingMode.DOWN);
	}

}
