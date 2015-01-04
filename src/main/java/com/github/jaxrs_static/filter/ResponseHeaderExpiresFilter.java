package com.github.jaxrs_static.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ResponseHeaderExpiresFilter implements Filter {

	private static final String PARAMETER_EXPIRES_YEARS = "ExpiresYears";
	private static final String PARAMETER_EXPIRES_MONTHS = "ExpiresMonths";
	private static final String PARAMETER_EXPIRES_DAYS = "ExpiresDays";

	private Integer years = 1;
	private Integer months = 0;
	private Integer days = 0;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		if (years > 0) {
			cal.add(Calendar.YEAR, years);
		}

		if (months > 0) {
			cal.add(Calendar.MONTH, months);
		}

		if (days > 0) {
			cal.add(Calendar.DAY_OF_YEAR, days);
		}

		Date expDate = cal.getTime();
		String expireAt = null;

		try {
			String pattern = "EEE, dd MMM yyyy HH:mm:ss z";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			expireAt = sdf.format(expDate);
		} catch (Throwable th) {
			expireAt = null;
			throw new RuntimeException(th);
		}

		if (response instanceof HttpServletResponse) {
			HttpServletResponse sr = (HttpServletResponse) response;

			if (expireAt != null) {
				sr.setHeader("Expires", expireAt);
			}

			String maxAgeDirective = "max-age="
					+ ((expDate.getTime() - System.currentTimeMillis()) / 1000);
			sr.setHeader("Cache-Control", maxAgeDirective);
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String yearsStr = filterConfig
				.getInitParameter(PARAMETER_EXPIRES_YEARS);

		if ((yearsStr != null) && (yearsStr.length() > 0)) {
			try {
				years = Integer.parseInt(yearsStr);
			} catch (NumberFormatException e) {
				years = 0;
			}
		}

		String monthsStr = filterConfig
				.getInitParameter(PARAMETER_EXPIRES_MONTHS);

		if ((monthsStr != null) && (monthsStr.length() > 0)) {
			try {
				months = Integer.parseInt(monthsStr);
			} catch (NumberFormatException e) {
				months = 0;
			}
		}

		String daysStr = filterConfig.getInitParameter(PARAMETER_EXPIRES_DAYS);

		if ((daysStr != null) && (daysStr.length() > 0)) {
			try {
				days = Integer.parseInt(daysStr);
			} catch (NumberFormatException e) {
				days = 0;
			}
		}

		if ((years < 1) && (months < 1) && (days < 1)) {
			years = 1;
		}
	}

}
