/*
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

package org.chaosfisch.util;

import org.chaosfisch.exceptions.ErrorCode;

public enum LogfileCode implements ErrorCode {
	IO_ERROR(701);

	private final int number;

	private LogfileCode(final int number) {
		this.number = number;
	}

	@Override
	public int getNumber() {
		return number;
	}

}