/*
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

package org.chaosfisch.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class SystemException extends Exception {

	private static final long serialVersionUID = 1L;

	public static SystemException wrap(final Throwable exception, final ErrorCode errorCode) {
		if (exception instanceof SystemException) {
			final SystemException se = (SystemException) exception;
			if (errorCode != null && errorCode != se.getErrorCode()) {
				return new SystemException(exception.getMessage(), exception, errorCode);
			}
			return se;
		} else {
			return new SystemException(exception.getMessage(), exception, errorCode);
		}
	}

	public static SystemException wrap(final Throwable exception) {
		return wrap(exception, null);
	}

	private ErrorCode errorCode;
	private final Map<String, Object> properties = new TreeMap<>();

	public SystemException(final ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public SystemException(final String message, final ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public SystemException(final Throwable cause, final ErrorCode errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	private SystemException(final String message, final Throwable cause, final ErrorCode errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public SystemException setErrorCode(final ErrorCode errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(final String name) {
		return (T) properties.get(name);
	}

	public SystemException set(final String name, final Object value) {
		properties.put(name, value);
		return this;
	}

	@Override
	public void printStackTrace(final PrintStream s) {
		try (PrintWriter writer = new PrintWriter(s)) {
			printStackTrace(writer);
		}
	}

	@Override
	public void printStackTrace(final PrintWriter s) {
		s.println(this);
		s.println("\t-------------------------------");
		if (errorCode != null) {
			s.println("\t" + errorCode + ":" + errorCode.getClass().getName());
		}
		for (final String key : properties.keySet()) {
			s.println("\t" + key + "=[" + properties.get(key) + "]");
		}
		s.println("\t-------------------------------");
		final StackTraceElement[] trace = getStackTrace();
		for (final StackTraceElement element : trace) {
			s.println("\tat " + element);
		}

		final Throwable ourCause = getCause();
		if (ourCause != null) {
			ourCause.printStackTrace(s);
		}
		s.flush();
	}

}