/*
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

package de.chaosfisch.uploader.cli;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import de.chaosfisch.uploader.cli.controller.AccountController;
import de.chaosfisch.uploader.cli.controller.Controller;

public class CLIModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ICLIUtil.class).to(CLIUtil.class);

		final Multibinder<Controller> controllerMultibinder = Multibinder.newSetBinder(binder(), Controller.class);
		controllerMultibinder.addBinding().to(AccountController.class);
	}
}
