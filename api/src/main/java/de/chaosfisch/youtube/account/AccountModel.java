/**************************************************************************************************
 * Copyright (c) 2014 Dennis Fischer.                                                             *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Public License v3.0+                             *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/gpl.html                                                           *
 *                                                                                                *
 * Contributors: Dennis Fischer                                                                   *
 **************************************************************************************************/

/**
 * This class is generated by jOOQ
 */
package de.chaosfisch.youtube.account;

import de.chaosfisch.data.account.AccountType;
import de.chaosfisch.data.account.cookies.CookieDTO;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import org.jetbrains.annotations.NotNull;

public class AccountModel implements Comparable<AccountModel> {

	private final SimpleStringProperty              youtubeId    = new SimpleStringProperty();
	private final SimpleStringProperty              name         = new SimpleStringProperty();
	private final SimpleStringProperty              email        = new SimpleStringProperty();
	private final SimpleStringProperty              refreshToken = new SimpleStringProperty();
	private final SimpleObjectProperty<AccountType> type         = new SimpleObjectProperty<>();
	private final SimpleSetProperty<CookieDTO>      cookies      = new SimpleSetProperty<>(FXCollections.observableSet());
	private final SimpleListProperty<String>        fields       = new SimpleListProperty<>(FXCollections.observableArrayList());

	public ObservableList<String> getFields() {
		return fields.get();
	}

	public void setFields(final ObservableList<String> fields) {
		this.fields.set(fields);
	}

	public SimpleListProperty<String> fieldsProperty() {
		return fields;
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(final String email) {
		this.email.set(email);
	}

	public SimpleStringProperty emailProperty() {
		return email;
	}

	public String getYoutubeId() {
		return youtubeId.get();
	}

	public void setYoutubeId(final String youtubeId) {
		this.youtubeId.set(youtubeId);
	}

	public SimpleStringProperty youtubeIdProperty() {
		return youtubeId;
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}

	public String getRefreshToken() {
		return refreshToken.get();
	}

	public void setRefreshToken(final String refreshToken) {
		this.refreshToken.set(refreshToken);
	}

	public SimpleStringProperty refreshTokenProperty() {
		return refreshToken;
	}

	public AccountType getType() {
		return type.get();
	}

	public void setType(final AccountType type) {
		this.type.set(type);
	}

	public SimpleObjectProperty<AccountType> typeProperty() {
		return type;
	}

	public ObservableSet<CookieDTO> getCookies() {
		return cookies.get();
	}

	public void setCookies(final ObservableSet<CookieDTO> cookies) {
		this.cookies.set(cookies);
	}

	public SimpleSetProperty<CookieDTO> cookiesProperty() {
		return cookies;
	}

	public String getName() {
		return name.get();
	}

	public void setName(final String name) {
		this.name.set(name);
	}

	@Override
	public int compareTo(@NotNull final AccountModel o) {
		if (0 > name.get()
					.compareTo(o.name.get())) {
			return -1;
		} else if (0 < name.get()
						   .compareTo(o.name.get())) {
			return 1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		return youtubeId.get()
						.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AccountModel)) {
			return false;
		}
		final AccountModel that = (AccountModel) obj;
		return youtubeId.get()
						.equals(that.youtubeId.get());
	}

	@Override
	public String toString() {
		return getName();
	}
}
