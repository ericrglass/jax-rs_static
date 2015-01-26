package com.github.jaxrs_static.jaxrs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.github.jaxrs_static.bean.DeviceDetectionSession;

@Path(DeviceDetectionResource.PATH)
public class DeviceDetectionResource {

	public static final String PATH = "/deviceDetection";

	@Context
	protected HttpServletRequest request;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public DeviceDetectionSession view() {
		DeviceDetectionSession devDetSession = null;
		HttpSession session = request.getSession();

		if ((session != null)
				&& (session.getAttribute(DeviceDetectionSession.NAME) instanceof DeviceDetectionSession)) {
			devDetSession = (DeviceDetectionSession) session
					.getAttribute(DeviceDetectionSession.NAME);
		}

		if (devDetSession == null) {
			devDetSession = new DeviceDetectionSession();
		}

		return devDetSession;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(DeviceDetectionSession devDetSession) {
		if (devDetSession == null) {
			return;
		}

		HttpSession session = request.getSession();

		if (session != null) {
			session.setAttribute(DeviceDetectionSession.NAME, devDetSession);
		}
	}

}
