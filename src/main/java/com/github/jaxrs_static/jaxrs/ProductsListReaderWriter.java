package com.github.jaxrs_static.jaxrs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
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
import com.github.jaxrs_static.bean.ProductsList;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductsListReaderWriter implements
		MessageBodyReader<ProductsList>, MessageBodyWriter<ProductsList> {

	@Override
	public long getSize(ProductsList productsList, Class<?> type,
			Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return isJsonValid(type, mediaType);
	}

	@Override
	public void writeTo(ProductsList productsList, Class<?> type,
			Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		if (entityStream == null) {
			return;
		}

		JsonArrayBuilder productsListBuilder = Json.createArrayBuilder();

		if ((productsList == null) || (productsList.size() == 0)) {
			writeJson(entityStream, productsListBuilder);
			return;
		}

		for (Product product : productsList) {
			if (product == null) {
				continue;
			}

			JsonObjectBuilder productBuilder = Json.createObjectBuilder();
			productBuilder.add("id", product.getId());
			productBuilder.add("code", nullToEmpty(product.getCode()));
			productBuilder.add("description",
					nullToEmpty(product.getDescription()));
			productBuilder.add("color", nullToEmpty(product.getColor()));
			productBuilder.add("cost", getRoundedDown(product.getCost(), 2));
			productBuilder.add("quantity",
					getRoundedDown(product.getQuantity(), 2));
			productsListBuilder.add(productBuilder);
		}

		writeJson(entityStream, productsListBuilder);
	}

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return isJsonValid(type, mediaType);
	}

	@Override
	public ProductsList readFrom(Class<ProductsList> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		ProductsList productsList = new ProductsList();

		if (entityStream == null) {
			return productsList;
		}

		JsonReader jsonReader = Json.createReader(entityStream);
		JsonArray jsonArray = jsonReader.readArray();
		jsonReader.close();
		entityStream.close();

		if ((jsonArray == null) || jsonArray.isEmpty()) {
			return productsList;
		}

		Iterator<JsonValue> jsonIter = jsonArray.iterator();

		while (jsonIter.hasNext()) {
			JsonValue jsonValue = jsonIter.next();

			if (!(jsonValue instanceof JsonObject)) {
				continue;
			}

			JsonObject jsonObject = (JsonObject) jsonValue;
			Product product = new Product();

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
				product.setCost(jsonObject.getJsonNumber("cost")
						.bigDecimalValue());
			} catch (Exception e) {
			}

			try {
				product.setQuantity(jsonObject.getJsonNumber("quantity")
						.bigDecimalValue());
			} catch (Exception e) {
			}

			productsList.add(product);
		}

		return productsList;
	}

	private boolean isJsonValid(Class<?> type, MediaType mediaType) {
		return ((type != null) && ProductsList.class.isAssignableFrom(type)
				&& (mediaType != null) && MediaType.APPLICATION_JSON_TYPE
				.getSubtype().equalsIgnoreCase(mediaType.getSubtype()));
	}

	private void writeJson(OutputStream entityStream,
			JsonArrayBuilder productsListBuilder) {
		JsonArray entityJsonArray = productsListBuilder.build();
		JsonWriter jsonWriter = Json.createWriter(entityStream);
		jsonWriter.writeArray(entityJsonArray);
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
