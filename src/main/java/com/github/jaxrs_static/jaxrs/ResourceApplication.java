package com.github.jaxrs_static.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(ResourceApplication.PATH)
public class ResourceApplication extends Application {

	public static final String PATH = "resource";

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> jaxrsClasses = new HashSet<Class<?>>();

		// JAX-RS Resources
		jaxrsClasses.add(DeviceDetectionResource.class);

		// JAX-RS Providers, MessageBodyWriters, and MessageBodyReaders
		jaxrsClasses.add(DeviceDetectionSessionReaderWriter.class);

		return jaxrsClasses;
	}

}
