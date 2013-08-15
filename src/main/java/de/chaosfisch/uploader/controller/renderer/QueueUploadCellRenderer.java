/*
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

package de.chaosfisch.uploader.controller.renderer;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import de.chaosfisch.google.youtube.upload.IUploadService;
import de.chaosfisch.google.youtube.upload.Status;
import de.chaosfisch.google.youtube.upload.Upload;
import de.chaosfisch.google.youtube.upload.events.UploadJobProgressEvent;
import de.chaosfisch.uploader.controller.UploadController;
import de.chaosfisch.util.DesktopUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.util.Callback;
import jfxtras.labs.dialogs.MonologFXButton;

import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class QueueUploadCellRenderer implements Callback<ListView<Upload>, ListCell<Upload>> {

	@Inject
	private UploadController uploadController;
	@Inject
	private EventBus         eventBus;
	@Inject
	@Named("i18n-resources")
	private ResourceBundle   resources;
	@Inject
	private DesktopUtil      desktopUtil;
	@Inject
	private IUploadService   uploadService;

	@Override
	public ListCell<Upload> call(final ListView<Upload> arg0) {
		return new QueueUploadCell();
	}

	public class QueueUploadCell extends ListCell<Upload> {

		private Upload upload;
		private Parent progressNode;

		@Override
		protected void updateItem(final Upload item, final boolean empty) {
			super.updateItem(item, empty);
			if (null == item) {
				return;
			} else if (null == upload) {
				eventBus.register(this);
			}

			upload = item;
			final Status status = upload.getStatus();

			final Button btnRemove = ButtonBuilder.create()
					.styleClass("queueCellRemoveButton")
					.disable(status.isRunning())
					.onAction(new QueueCellRemoveButtonHandler(item))
					.build();
			final Button btnEdit = ButtonBuilder.create()
					.styleClass("queueCellEditButton")
					.disable(status.isArchived())
					.onAction(new QueueCellEditButtonHandler(item))
					.build();
			final Button btnAbort = ButtonBuilder.create()
					.text(resources.getString("button.abort"))
					.styleClass("queueCellAbortButton")
					.disable(!status.isRunning() || status.isArchived())
					.onAction(new QueueCellAbortButtonHandler(item))
					.build();
			final ToggleButton btnPauseOnFinish = ToggleButtonBuilder.create()
					.styleClass("queueCellPauseButton")
					.onAction(new QueueCellPauseButtonHandler(item))
					.selected(item.isPauseOnFinish())
					.tooltip(TooltipBuilder.create()
							.autoHide(true)
							.text(resources.getString("tooltip.queuecellpause"))
							.build())
					.build();

			if (status.isArchived()) {
				progressNode = HyperlinkBuilder.create()
						.id("queue-text-" + item.getId())
						.styleClass("queueCellHyperlink")
						.text("http://youtu.be/" + item.getVideoid())
						.prefWidth(500)
						.onAction(new QueueCellHyperlinkHandler(item))
						.build();
			} else if (status.isFailed()) {
				//FIXME STATUS MESSAGE MISSING
				final String statusMessage = ""; // resources.getString(item.getStatus().toLowerCase(Locale.getDefault()));

				progressNode = LabelBuilder.create()
						.text(statusMessage)
						.styleClass("queueCellFailedLabel")
						.prefWidth(500)
						.build();
			} else {
				progressNode = new ProgressNodeRenderer();
			}

			final Label uploadTitle = LabelBuilder.create()
					.text(item.getMetadata().getTitle())
					.styleClass("queueCellTitleLabel")
					.prefWidth(500)
					.build();
			final HBox containerTop = HBoxBuilder.create()
					.spacing(5)
					.styleClass("queueCellTopContainer")
					.children(uploadTitle, btnRemove, btnEdit, btnPauseOnFinish)
					.build();
			final HBox containerBottom = HBoxBuilder.create()
					.spacing(5)
					.styleClass("queueCellBottomContainer")
					.children(progressNode, btnAbort)
					.build();
			final VBox containerPane = VBoxBuilder.create()
					.children(containerTop, containerBottom)
					.styleClass("queueCellContainer")
					.spacing(5)
					.padding(new Insets(5))
					.build();

			setGraphic(containerPane);
		}

		@Subscribe
		public void onUploadProgress(final UploadJobProgressEvent uploadProgress) {

			if (!uploadProgress.getUpload().equals(upload)) {
				return;
			}
			if (progressNode instanceof ProgressNodeRenderer) {
				final long speed = uploadProgress.getDiffBytes() / (uploadProgress.getDiffTime() + 1) * 1000 + 1;

				final ProgressNodeRenderer renderer = (ProgressNodeRenderer) progressNode;
				renderer.setProgress((double) uploadProgress.getTotalBytesUploaded() / (double) uploadProgress.getFileSize());
				renderer.setEta(calculateEta(uploadProgress.getFileSize() - uploadProgress.getTotalBytesUploaded(), speed));
				renderer.setSpeed(humanReadableByteCount(speed) + "/s");
				renderer.setFinish(calculateFinish(uploadProgress.getFileSize() - uploadProgress.getTotalBytesUploaded(), speed));
				renderer.setBytes(humanReadableByteCount(uploadProgress.getTotalBytesUploaded()) + " / " + humanReadableByteCount(uploadProgress
						.getFileSize()));
			}

		}

		private String calculateFinish(final long remainingBytes, final long speed) {

			final long duration = 1000 * remainingBytes / speed + System.currentTimeMillis() + TimeZone.getDefault()
					.getOffset(System.currentTimeMillis());

			return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration) - TimeUnit.DAYS
					.toHours(TimeUnit.MILLISECONDS.toDays(duration)), TimeUnit.MILLISECONDS
					.toMinutes(duration) - TimeUnit.HOURS
					.toMinutes(TimeUnit.MILLISECONDS.toHours(duration)), TimeUnit.MILLISECONDS
					.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
		}

		private String calculateEta(final long remainingBytes, final long speed) {
			final long duration = 1000 * remainingBytes / speed;

			return String.format("%d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration), TimeUnit.MILLISECONDS
					.toMinutes(duration) - TimeUnit.HOURS
					.toMinutes(TimeUnit.MILLISECONDS.toHours(duration)), TimeUnit.MILLISECONDS
					.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
		}

		private String humanReadableByteCount(final long bytes) {
			final int unit = 1024;
			if (unit > bytes) {
				return bytes + " B";
			}
			final int exp = (int) (Math.log(bytes) / Math.log(unit));
			final String pre = String.valueOf("kMGTPE".charAt(exp - 1));
			return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
		}

		private class QueueCellRemoveButtonHandler implements EventHandler<ActionEvent> {
			private final Upload item;

			public QueueCellRemoveButtonHandler(final Upload item) {
				this.item = item;
			}

			@Override
			public void handle(final ActionEvent event) {
				if (item.getStatus().isRunning()) {
					return;
				}

				final ConfirmDialog dialog = new ConfirmDialog(resources.getString("dialog.removeupload.title"), resources
						.getString("dialog.removeupload.message"), resources);
				if (MonologFXButton.Type.YES == dialog.showDialog()) {
					uploadService.delete(upload);
				}
			}
		}

		private class QueueCellEditButtonHandler implements EventHandler<ActionEvent> {
			private final Upload item;

			public QueueCellEditButtonHandler(final Upload item) {
				this.item = item;
			}

			@Override
			public void handle(final ActionEvent event) {
				uploadController.fromUpload(item);
			}
		}

		private class QueueCellAbortButtonHandler implements EventHandler<ActionEvent> {

			private final Upload item;

			public QueueCellAbortButtonHandler(final Upload item) {
				this.item = item;
			}

			@Override
			public void handle(final ActionEvent arg0) {
				if (!item.getStatus().isRunning()) {
					return;
				}

				final ConfirmDialog dialog = new ConfirmDialog(resources.getString("dialog.abortupload.title"), resources
						.getString("dialog.abortupload.message"), resources);

				if (MonologFXButton.Type.YES == dialog.showDialog()) {
					uploadService.abort(item);
				}
			}
		}

		private class QueueCellPauseButtonHandler implements EventHandler<ActionEvent> {
			private final Upload item;

			public QueueCellPauseButtonHandler(final Upload item) {
				this.item = item;
			}

			@Override
			public void handle(final ActionEvent event) {
				final ToggleButton source = (ToggleButton) event.getSource();
				item.setPauseOnFinish(source.isSelected());

				uploadService.update(item);
			}
		}

		private class QueueCellHyperlinkHandler implements EventHandler<ActionEvent> {
			private final Upload item;

			public QueueCellHyperlinkHandler(final Upload item) {
				this.item = item;
			}

			@Override
			public void handle(final ActionEvent event) {
				final String url = "http://youtu.be/" + item.getVideoid();

				if (!desktopUtil.openBrowser(url)) {
					new URLOpenErrorDialog(url, resources);
				}
			}
		}
	}
}