/*
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

package de.chaosfisch.uploader.command;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import de.chaosfisch.google.account.Account;
import de.chaosfisch.google.youtube.playlist.Playlist;
import de.chaosfisch.uploader.template.ITemplateService;
import de.chaosfisch.uploader.template.Template;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

public class UpdateTemplateCommand extends Service<Void> {

	@Inject
	private ITemplateService templateService;

	public Template       template;
	public Account        account;
	public List<Playlist> playlists;

	@Override
	protected Task<Void> createTask() {
		return new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				Preconditions.checkNotNull(template);

				if (null != account) {
					template.setAccount(account);
				}

				template.setPlaylists(playlists);
				templateService.update(template);
				return null;
			}
		};
	}
}
