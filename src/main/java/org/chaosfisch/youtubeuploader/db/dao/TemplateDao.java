/*******************************************************************************
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: Dennis Fischer
 ******************************************************************************/
package org.chaosfisch.youtubeuploader.db.dao;

import org.jooq.impl.Executor;

import com.google.inject.Inject;

public class TemplateDao extends org.chaosfisch.youtubeuploader.db.generated.tables.daos.TemplateDao {

	private final Executor	create;

	@Inject
	public TemplateDao(final Executor create) {
		super(create);
		this.create = create;
	}

}
