/*
 * Copyright (c) 2014 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

package de.chaosfisch.google.account.events;

import de.chaosfisch.google.account.Account;

public class AccountRemoved {
	private final Account account;

	public AccountRemoved(final Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}
}
