/*
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

package org.chaosfisch.http;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

class ResponseImpl implements IResponse {

	private final HttpResponse response;
	private final IRequestUtil requestUtil;

	Logger logger = LoggerFactory.getLogger(ResponseImpl.class);
	private String content;

	@Inject
	public ResponseImpl(final IRequestUtil requestUtil, @Assisted final HttpResponse response) {
		this.requestUtil = requestUtil;
		this.response = response;
	}

	@Override
	public void close() {
		if (null != response && null != response.getEntity()) {
			EntityUtils.consumeQuietly(response.getEntity());
		}
	}

	@Override
	public int getStatusCode() {
		return response.getStatusLine().getStatusCode();
	}

	@Override
	public Header getHeader(final String header) {
		Preconditions.checkArgument(response.containsHeader(header), "Header doesn't exist: %s", header);
		return response.getFirstHeader(header);
	}

	@Override
	public String getContent() throws HttpIOException {

		if (null == content) {
			try {
				content = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
			} catch (ParseException | IOException e) {
				throw new HttpIOException(getStatusCode(), getCurrentUrl(), response.getStatusLine().toString());
			}
		}
		return content;
	}

	@Override
	public String getCurrentUrl() {
		final HttpUriRequest currentReq = (HttpUriRequest) requestUtil.getContext()
				.getAttribute(ExecutionContext.HTTP_REQUEST);
		final HttpHost currentHost = (HttpHost) requestUtil.getContext()
				.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
		return currentReq.getURI().isAbsolute() ?
			   currentReq.getURI().toString() :
			   currentHost.toURI() + currentReq.getURI();
	}

	@Override
	public void logDebug() {
		logger.info("---------------DEBUG HTTP----------------");
		logger.info("URL: " + getCurrentUrl());
		logger.info("STATUS: " + getStatusCode());
		try {
			logger.info("CONTENT " + getContent());
		} catch (HttpIOException e) {
			logger.info("NO CONTENT", e);
		}
		logger.info("STATUSLINE: " + response.getStatusLine());
		for (final Header header : response.getAllHeaders()) {
			logger.info("HEADER: " + header.getName() + '=' + header.getValue());
		}
		logger.info("---------------DEBUG HTTP----------------");
	}
}
