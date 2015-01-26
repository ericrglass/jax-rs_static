package com.github.jaxrs_static.jaxrs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

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

import com.github.jaxrs_static.bean.DeviceDetectionSession;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeviceDetectionSessionReaderWriter implements
		MessageBodyReader<DeviceDetectionSession>,
		MessageBodyWriter<DeviceDetectionSession> {

	@Override
	public long getSize(DeviceDetectionSession devDetSession, Class<?> type,
			Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return isJsonValid(type, mediaType);
	}

	@Override
	public void writeTo(DeviceDetectionSession devDetSession, Class<?> type,
			Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		if (entityStream == null) {
			return;
		}

		JsonObjectBuilder devDetSessionBuilder = Json.createObjectBuilder();

		if (devDetSession == null) {
			writeJson(entityStream, devDetSessionBuilder);
			return;
		}

		devDetSessionBuilder.add("isMobile", devDetSession.isMobile());
		devDetSessionBuilder.add("formFactor", devDetSession.getFormFactor());
		devDetSessionBuilder.add("completeDeviceName",
				devDetSession.getCompleteDeviceName());
		devDetSessionBuilder.add("isDesktop", devDetSession.isDesktop());
		devDetSessionBuilder.add("isApp", devDetSession.isApp());
		devDetSessionBuilder.add("isTablet", devDetSession.isTablet());
		devDetSessionBuilder.add("isSmartPhone", devDetSession.isSmartPhone());
		devDetSessionBuilder.add("isFeaturePhone",
				devDetSession.isFeaturePhone());
		devDetSessionBuilder.add("isSmartTv", devDetSession.isSmartTv());
		devDetSessionBuilder.add("isRobot", devDetSession.isRobot());
		devDetSessionBuilder.add("isOtherNonMobile",
				devDetSession.isOtherNonMobile());
		devDetSessionBuilder
				.add("isOtherMobile", devDetSession.isOtherMobile());
		devDetSessionBuilder
				.add("isHighDensity", devDetSession.isHighDensity());
		devDetSessionBuilder.add("isRetina", devDetSession.isRetina());
		devDetSessionBuilder.add("clientWidth", devDetSession.getClientWidth());
		devDetSessionBuilder.add("canResizeBrowserWindow",
				devDetSession.isCanResizeBrowserWindow());
		devDetSessionBuilder.add("orientation", devDetSession.getOrientation());
		devDetSessionBuilder.add("isLanscape", devDetSession.isLanscape());
		devDetSessionBuilder.add("isPortrait", devDetSession.isPortrait());
		devDetSessionBuilder.add("htmlClass", devDetSession.getHtmlClass());
		devDetSessionBuilder.add("isApplicationcacheAvailable",
				devDetSession.isApplicationcacheAvailable());
		devDetSessionBuilder.add("isAudioAvailable",
				devDetSession.isAudioAvailable());
		devDetSessionBuilder.add("isBackgroundsizeAvailable",
				devDetSession.isBackgroundsizeAvailable());
		devDetSessionBuilder.add("isBorderimageAvailable",
				devDetSession.isBorderimageAvailable());
		devDetSessionBuilder.add("isBorderradiusAvailable",
				devDetSession.isBorderradiusAvailable());
		devDetSessionBuilder.add("isBoxshadowAvailable",
				devDetSession.isBoxshadowAvailable());
		devDetSessionBuilder.add("isCanvasAvailable",
				devDetSession.isCanvasAvailable());
		devDetSessionBuilder.add("isCanvastextAvailable",
				devDetSession.isCanvastextAvailable());
		devDetSessionBuilder.add("isCssanimationsAvailable",
				devDetSession.isCssanimationsAvailable());
		devDetSessionBuilder.add("isCsscolumnsAvailable",
				devDetSession.isCsscolumnsAvailable());
		devDetSessionBuilder.add("isCssgradientsAvailable",
				devDetSession.isCssgradientsAvailable());
		devDetSessionBuilder.add("isCssreflectionsAvailable",
				devDetSession.isCssreflectionsAvailable());
		devDetSessionBuilder.add("isCsstransformsAvailable",
				devDetSession.isCsstransformsAvailable());
		devDetSessionBuilder.add("isCsstransforms3dAvailable",
				devDetSession.isCsstransforms3dAvailable());
		devDetSessionBuilder.add("isCsstransitionsAvailable",
				devDetSession.isCsstransitionsAvailable());
		devDetSessionBuilder.add("isDraganddropAvailable",
				devDetSession.isDraganddropAvailable());
		devDetSessionBuilder.add("isFlexboxAvailable",
				devDetSession.isFlexboxAvailable());
		devDetSessionBuilder.add("isFlexboxlegacyAvailable",
				devDetSession.isFlexboxlegacyAvailable());
		devDetSessionBuilder.add("isFontfaceAvailable",
				devDetSession.isFontfaceAvailable());
		devDetSessionBuilder.add("isGeneratedcontentAvailable",
				devDetSession.isGeneratedcontentAvailable());
		devDetSessionBuilder.add("isGeolocationAvailable",
				devDetSession.isGeolocationAvailable());
		devDetSessionBuilder.add("isHashchangeAvailable",
				devDetSession.isHashchangeAvailable());
		devDetSessionBuilder.add("isHistoryAvailable",
				devDetSession.isHistoryAvailable());
		devDetSessionBuilder.add("isHslaAvailable",
				devDetSession.isHslaAvailable());
		devDetSessionBuilder.add("isIndexeddbAvailable",
				devDetSession.isIndexeddbAvailable());
		devDetSessionBuilder.add("isInlinesvgAvailable",
				devDetSession.isInlinesvgAvailable());
		devDetSessionBuilder.add("isJavaScriptAvailable",
				devDetSession.isJavaScriptAvailable());
		devDetSessionBuilder.add("isLocalstorageAvailable",
				devDetSession.isLocalstorageAvailable());
		devDetSessionBuilder.add("isMultiplebgsAvailable",
				devDetSession.isMultiplebgsAvailable());
		devDetSessionBuilder.add("isOpacityAvailable",
				devDetSession.isOpacityAvailable());
		devDetSessionBuilder.add("isPostmessageAvailable",
				devDetSession.isPostmessageAvailable());
		devDetSessionBuilder.add("isRgbaAvailable",
				devDetSession.isRgbaAvailable());
		devDetSessionBuilder.add("isSessionstorageAvailable",
				devDetSession.isSessionstorageAvailable());
		devDetSessionBuilder.add("isSmilAvailable",
				devDetSession.isSmilAvailable());
		devDetSessionBuilder.add("isSvgAvailable",
				devDetSession.isSvgAvailable());
		devDetSessionBuilder.add("isSvgclippathsAvailable",
				devDetSession.isSvgclippathsAvailable());
		devDetSessionBuilder.add("isTextshadowAvailable",
				devDetSession.isTextshadowAvailable());
		devDetSessionBuilder.add("isTouchAvailable",
				devDetSession.isTouchAvailable());
		devDetSessionBuilder.add("isVideoAvailable",
				devDetSession.isVideoAvailable());
		devDetSessionBuilder.add("isWebglAvailable",
				devDetSession.isWebglAvailable());
		devDetSessionBuilder.add("isWebsocketsAvailable",
				devDetSession.isWebsocketsAvailable());
		devDetSessionBuilder.add("isWebsqldatabaseAvailable",
				devDetSession.isWebsqldatabaseAvailable());
		devDetSessionBuilder.add("isWebworkersAvailable",
				devDetSession.isWebworkersAvailable());
		writeJson(entityStream, devDetSessionBuilder);
	}

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return isJsonValid(type, mediaType);
	}

	@Override
	public DeviceDetectionSession readFrom(Class<DeviceDetectionSession> type,
			Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		DeviceDetectionSession devDetSession = new DeviceDetectionSession();

		if (entityStream == null) {
			return devDetSession;
		}

		JsonReader jsonReader = Json.createReader(entityStream);
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		entityStream.close();

		try {
			devDetSession.setMobile(jsonObject.getBoolean("isMobile"));
		} catch (Exception e) {
		}

		try {
			devDetSession.setFormFactor(jsonObject.getString("formFactor"));
		} catch (Exception e) {
		}

		try {
			devDetSession.setCompleteDeviceName(jsonObject
					.getString("completeDeviceName"));
		} catch (Exception e) {
		}

		try {
			devDetSession
					.setHighDensity(jsonObject.getBoolean("isHighDensity"));
		} catch (Exception e) {
		}

		try {
			devDetSession.setRetina(jsonObject.getBoolean("isRetina"));
		} catch (Exception e) {
		}

		try {
			devDetSession.setClientWidth(jsonObject.getInt("clientWidth"));
		} catch (Exception e) {
		}

		try {
			devDetSession.setCanResizeBrowserWindow(jsonObject
					.getBoolean("canResizeBrowserWindow"));
		} catch (Exception e) {
		}

		try {
			devDetSession.setOrientation(jsonObject.getString("orientation"));
		} catch (Exception e) {
		}

		try {
			devDetSession.setHtmlClass(jsonObject.getString("htmlClass"));
		} catch (Exception e) {
		}

		return devDetSession;
	}

	private boolean isJsonValid(Class<?> type, MediaType mediaType) {
		return ((type != null)
				&& DeviceDetectionSession.class.isAssignableFrom(type)
				&& (mediaType != null) && MediaType.APPLICATION_JSON_TYPE
				.getSubtype().equalsIgnoreCase(mediaType.getSubtype()));
	}

	private void writeJson(OutputStream entityStream,
			JsonObjectBuilder devDetSessionBuilder) {
		JsonObject entityJsonObject = devDetSessionBuilder.build();
		JsonWriter jsonWriter = Json.createWriter(entityStream);
		jsonWriter.writeObject(entityJsonObject);
		jsonWriter.close();
	}

}
