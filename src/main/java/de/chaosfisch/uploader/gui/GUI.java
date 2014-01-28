/*
 * Copyright (c) 2014 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

package de.chaosfisch.uploader.gui;


import dagger.ObjectGraph;
import de.chaosfisch.util.FXMLView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.dialog.Dialogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.lang.reflect.Field;

public class GUI extends Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(GUI.class);

	@Override
	public void init() throws Exception {
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
			LOGGER.error("Uncaught exception occured", e);
			Platform.runLater(() -> {
				Dialogs.create().owner(null)
						.title("Exception occured!")
						.masthead("Exception message is shown below")
						.showException(e);
			});
		});
	}

	@Override
	public void start(final Stage stage) throws Exception {
		final ObjectGraph objectGraph = ObjectGraph.create(new GUIModule());
		FXMLView.setControllerFactory(getControllerFactory(objectGraph));

		final FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(objectGraph::get);
		loader.setLocation(getClass().getResource("/de/chaosfisch/uploader/gui/main/main.fxml"));

		final Parent root = loader.load();
		final Scene scene = new Scene(root, 1000, 500);
		scene.getStylesheets().add(getClass().getResource("/de/chaosfisch/uploader/gui/style.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("JavaFX Memory Visualizer");
		stage.show();
	}

	private Callback<Class<?>, Object> getControllerFactory(final ObjectGraph objectGraph) {
		return aClass -> {
			boolean inject = false;
			if (0 < aClass.getDeclaredAnnotationsByType(Inject.class).length) {
				inject = true;
			} else {
				final Field[] fields = aClass.getDeclaredFields();
				for (final Field field : fields) {
					if (0 < field.getDeclaredAnnotationsByType(Inject.class).length) {
						inject = true;
						break;
					}
				}
			}
			try {
				return inject ? objectGraph.get(aClass) : aClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				return null;
			}
		};
	}
}
