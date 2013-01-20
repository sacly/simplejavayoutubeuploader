/*******************************************************************************
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: Dennis Fischer
 ******************************************************************************/
package org.chaosfisch.youtubeuploader.models;

import org.chaosfisch.util.EventBusUtil;
import org.chaosfisch.youtubeuploader.I18nHelper;
import org.chaosfisch.youtubeuploader.models.events.ModelPostRemovedEvent;
import org.chaosfisch.youtubeuploader.models.events.ModelPostSavedEvent;
import org.chaosfisch.youtubeuploader.models.events.ModelPreRemovedEvent;
import org.chaosfisch.youtubeuploader.models.events.ModelPreSavedEvent;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.common.Convert;

public class Account extends Model implements ModelEvents {
	public enum Type {
		YOUTUBE("enum.youtube"), FACEBOOK("enum.facebook"), TWITTER("enum.twitter"), GOOGLEPLUS("enum.googleplus");

		private final String	name;

		Type(final String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return I18nHelper.message(name);
		}
	}

	@Override
	public String toString() {
		if (!isFrozen()) {
			return getString("name");
		}
		return super.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object object) {

		if (object == null || !(object instanceof Account)) {
			return false;
		} else if (((Account) object).getUnfrozen().equals(getUnfrozen())) {
			return true;
		}
		return false;
	}

	public Long getUnfrozen() {
		return Convert.toLong(getAttributes().get("id"));
	}

	/*
	 * (non-Javadoc)
	 * @see org.javalite.activejdbc.CallbackSupport#beforeSave()
	 */
	@Override
	protected void beforeSave() {
		super.beforeSave();
		EventBusUtil.getInstance().post(new ModelPreSavedEvent(this));
	}

	/*
	 * (non-Javadoc)
	 * @see org.javalite.activejdbc.CallbackSupport#afterSave()
	 */
	@Override
	protected void afterSave() {
		super.afterSave();
		Base.commitTransaction();
		EventBusUtil.getInstance().post(new ModelPostSavedEvent(this));
	}

	/*
	 * (non-Javadoc)
	 * @see org.javalite.activejdbc.CallbackSupport#beforeDelete()
	 */
	@Override
	protected void beforeDelete() {
		super.beforeDelete();
		EventBusUtil.getInstance().post(new ModelPreRemovedEvent(this));
	}

	/*
	 * (non-Javadoc)
	 * @see org.javalite.activejdbc.CallbackSupport#afterDelete()
	 */
	@Override
	protected void afterDelete() {
		super.afterDelete();
		Base.commitTransaction();
		EventBusUtil.getInstance().post(new ModelPostRemovedEvent(this));
	}
}
