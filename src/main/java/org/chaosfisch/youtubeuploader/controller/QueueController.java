/*******************************************************************************
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: Dennis Fischer
 ******************************************************************************/
package org.chaosfisch.youtubeuploader.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.util.StringConverter;
import jfxtras.labs.dialogs.MonologFX;
import jfxtras.labs.dialogs.MonologFXButton;
import jfxtras.labs.scene.control.ListSpinner;
import jfxtras.labs.scene.control.ListSpinner.ArrowPosition;

import org.chaosfisch.util.ActiveCellValueFactory;
import org.chaosfisch.util.EventBusUtil;
import org.chaosfisch.util.RefresherUtil;
import org.chaosfisch.util.io.Throttle;
import org.chaosfisch.youtubeuploader.I18nHelper;
import org.chaosfisch.youtubeuploader.models.Account;
import org.chaosfisch.youtubeuploader.models.Upload;
import org.chaosfisch.youtubeuploader.models.events.ModelPostRemovedEvent;
import org.chaosfisch.youtubeuploader.models.events.ModelPostSavedEvent;
import org.chaosfisch.youtubeuploader.services.youtube.uploader.Uploader;
import org.chaosfisch.youtubeuploader.services.youtube.uploader.events.UploadAbortEvent;
import org.chaosfisch.youtubeuploader.services.youtube.uploader.events.UploadProgressEvent;
import org.chaosfisch.youtubeuploader.view.models.UploadViewModel;
import org.javalite.activejdbc.Model;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;

public class QueueController implements Initializable {

	@FXML// fx:id="actionOnFinish"
	private ChoiceBox<String>			actionOnFinish;

	@FXML// fx:id="columnAccount"
	private TableColumn<Upload, String>	columnAccount;

	@FXML// fx:id="columnActions"
	private TableColumn<Upload, Upload>	columnActions;

	@FXML// fx:id="columnCategory"
	private TableColumn<Upload, String>	columnCategory;

	@FXML// fx:id="columnId"
	private TableColumn<Upload, Number>	columnId;

	@FXML// fx:id="columnProgress"
	private TableColumn<Upload, Upload>	columnProgress;

	@FXML// fx:id="columnTitle"
	private TableColumn<Upload, String>	columnTitle;

	@FXML// fx:id="columnStarttime"
	private TableColumn<Upload, Object>	columnStarttime;

	@FXML// fx:id="queueActionsGridpane"
	private GridPane					queueActionsGridpane;

	@FXML// fx:id="queueTableview"
	private TableView<Model>			queueTableview;

	@FXML// fx:id="startQueue"
	private Button						startQueue;

	@FXML// fx:id="stopQueue"
	private Button						stopQueue;

	private final ListSpinner<Integer>	numberOfUploads	= new ListSpinner<Integer>(1, 5).withValue(1).withAlignment(Pos.CENTER_RIGHT)
																.withPostfix(" Upload(s)").withPrefix("max. ")
																.withArrowPosition(ArrowPosition.LEADING);
	private final ListSpinner<Integer>	uploadSpeed		= new ListSpinner<Integer>(0, 10000, 10).withValue(0)
																.withAlignment(Pos.CENTER_RIGHT).withArrowPosition(ArrowPosition.LEADING)
																.withPostfix(" kb/s").withEditable(true)
																.withStringConverter(new StringConverter<Integer>() {

																	@Override
																	public String toString(final Integer arg0) {
																		return arg0.toString();
																	}

																	@Override
																	public Integer fromString(final String string) {
																		try {
																			final Integer number = Integer.parseInt(string);
																			return number;
																		} catch (final NumberFormatException e) {
																			return uploadSpeed.getValue();
																		}
																	}
																});

	@Inject private Uploader			uploader;
	@Inject private Throttle			throttle;
	@Inject private UploadViewModel		uploadViewModel;
	@Inject private EventBus			eventBus;

	@Override
	// This method is called by the FXMLLoader when initialization is
	// complete
	public void initialize(final URL fxmlFileLocation, final ResourceBundle resources) {
		assert actionOnFinish != null : "fx:id=\"actionOnFinish\" was not injected: check your FXML file 'Queue.fxml'.";
		assert columnAccount != null : "fx:id=\"columnAccount\" was not injected: check your FXML file 'Queue.fxml'.";
		assert columnActions != null : "fx:id=\"columnActions\" was not injected: check your FXML file 'Queue.fxml'.";
		assert columnCategory != null : "fx:id=\"columnCategory\" was not injected: check your FXML file 'Queue.fxml'.";
		assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'Queue.fxml'.";
		assert columnProgress != null : "fx:id=\"columnProgress\" was not injected: check your FXML file 'Queue.fxml'.";
		assert columnTitle != null : "fx:id=\"columnTitle\" was not injected: check your FXML file 'Queue.fxml'.";
		assert queueTableview != null : "fx:id=\"queueTableview\" was not injected: check your FXML file 'Queue.fxml'.";
		assert startQueue != null : "fx:id=\"startQueue\" was not injected: check your FXML file 'Queue.fxml'.";
		assert stopQueue != null : "fx:id=\"stopQueue\" was not injected: check your FXML file 'Queue.fxml'.";
		assert columnStarttime != null : "fx:id=\"columnStarttime\" was not injected: check your FXML file 'Queue.fxml'.";
		assert queueActionsGridpane != null : "fx:id=\"queueActionsGridpane\" was not injected: check your FXML file 'Queue.fxml'.";

		// initialize your logic here: all @FXML variables will have been
		// injected

		queueActionsGridpane.add(numberOfUploads, 7, 1);
		queueActionsGridpane.add(uploadSpeed, 8, 1);

		columnId.setCellValueFactory(new ActiveCellValueFactory<Upload, Number>("id"));
		columnTitle.setCellValueFactory(new ActiveCellValueFactory<Upload, String>("title"));
		columnCategory.setCellValueFactory(new ActiveCellValueFactory<Upload, String>("category"));
		columnAccount.setCellValueFactory(new ActiveCellValueFactory<Upload, String>("name", Account.class));
		columnProgress.setCellValueFactory(new ActiveCellValueFactory<Upload, Upload>("this"));
		columnActions.setCellValueFactory(new ActiveCellValueFactory<Upload, Upload>("this"));
		columnActions.setMinWidth(260);
		columnActions.setPrefWidth(260);
		columnProgress.setMinWidth(230);
		columnProgress.setPrefWidth(230);
		columnStarttime.setCellValueFactory(new ActiveCellValueFactory<Upload, Object>("started"));
		columnStarttime.setCellFactory(new Callback<TableColumn<Upload, Object>, TableCell<Upload, Object>>() {

			@Override
			public TableCell<Upload, Object> call(final TableColumn<Upload, Object> param) {
				final TableCell<Upload, Object> cell = new TableCell<Upload, Object>() {

					@Override
					public void updateItem(final Object date, final boolean empty) {
						super.updateItem(date, empty);
						if (empty) {
							setGraphic(null);
							setContentDisplay(null);
						} else {
							if (date instanceof Date) {
								setText(new SimpleDateFormat("dd.MM.yyyy hh:mm").format((Date) date));
							} else if (date instanceof Timestamp) {
								setText(new SimpleDateFormat("dd.MM.yyyy hh:mm").format(((Timestamp) date).getTime()));
							}
						}
					}
				};
				return cell;
			}
		});

		columnProgress.setCellFactory(new Callback<TableColumn<Upload, Upload>, TableCell<Upload, Upload>>() {

			@Override
			public TableCell<Upload, Upload> call(final TableColumn<Upload, Upload> param) {
				final TableCell<Upload, Upload> cell = new TableCell<Upload, Upload>() {

					@Override
					public void updateItem(final Upload queue, final boolean empty) {
						super.updateItem(queue, empty);
						if (empty) {
							setGraphic(null);
							setContentDisplay(null);
						} else {
							final HBox hbox = new HBox(10);

							final ProgressIndicator progressIndicator = new ProgressIndicator(queue.getBoolean("archived") == true ? 100
									: 0);
							progressIndicator.setId("queue-" + queue.getLongId());

							final Label label = new Label("");
							label.setId("queue-text-" + queue.getLongId());
							if (queue.getBoolean("archived")) {
								label.setText("http://youtu.be/" + queue.getString("videoid"));
								label.setOnMouseClicked(new EventHandler<MouseEvent>() {

									@Override
									public void handle(final MouseEvent mouseEvent) {

										if (mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2
												&& Desktop.isDesktopSupported()) {
											try {
												Desktop.getDesktop().browse(new URI("http://youtu.be/" + queue.getString("videoid")));
											} catch (final URISyntaxException | IOException ignored) {}
										}

									}
								});
								progressIndicator.setProgress(100);
							} else if (queue.getBoolean("failed")) {

								label.setText(I18nHelper.message("queuetable.status.failed"));
								progressIndicator.setProgress(0);
							}
							hbox.getChildren().addAll(progressIndicator, label);
							setGraphic(hbox);
							setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
						}
					}
				};
				return cell;
			}
		});

		columnActions.setCellFactory(new Callback<TableColumn<Upload, Upload>, TableCell<Upload, Upload>>() {

			@Override
			public TableCell<Upload, Upload> call(final TableColumn<Upload, Upload> param) {
				final TableCell<Upload, Upload> cell = new TableCell<Upload, Upload>() {

					@Override
					public void updateItem(final Upload item, final boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setContentDisplay(null);
						} else {
							final Button btnRemove = new Button();
							btnRemove.setId("removeUpload");
							btnRemove.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(final ActionEvent event) {
									if (item == null || item.getBoolean("inprogress")) {
										return;
									}
									final MonologFX dialog = new MonologFX(MonologFX.Type.QUESTION);
									dialog.setTitleText(I18nHelper.message("dialog.removeupload.title"));
									dialog.setMessage(I18nHelper.message("dialog.removeupload.message"));
									final MonologFXButton yesButton = new MonologFXButton();
									yesButton.setType(MonologFXButton.Type.YES);
									yesButton.setLabel("Yes");
									final MonologFXButton noButton = new MonologFXButton();
									noButton.setType(MonologFXButton.Type.NO);
									noButton.setLabel("No");
									dialog.addButton(yesButton);
									dialog.addButton(noButton);
									if (item != null && dialog.showDialog() == MonologFXButton.Type.YES) {
										item.delete();
									}
								}
							});
							btnRemove.setDisable(item.getBoolean("inprogress"));

							final Button btnEdit = new Button();
							btnEdit.setId("editUpload");
							btnEdit.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(final ActionEvent event) {
									if (item == null || item.getBoolean("inprogress")) {
										return;
									}
									uploadViewModel.fromUpload(item);
								}

							});
							btnEdit.setDisable(item.getBoolean("inprogress") || item.getBoolean("archived"));

							final Button btnAbort = new Button(I18nHelper.message("button.abort"));
							btnAbort.setId("abortUpload");
							btnAbort.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(final ActionEvent arg0) {
									if (item == null || !item.getBoolean("inprogress")) {
										return;
									}
									final MonologFX dialog = new MonologFX(MonologFX.Type.QUESTION);
									dialog.setTitleText(I18nHelper.message("dialog.abortupload.title"));
									dialog.setMessage(I18nHelper.message("dialog.abortupload.message"));
									final MonologFXButton yesButton = new MonologFXButton();
									yesButton.setType(MonologFXButton.Type.YES);
									yesButton.setLabel("Yes");
									final MonologFXButton noButton = new MonologFXButton();
									noButton.setType(MonologFXButton.Type.NO);
									noButton.setLabel("No");
									dialog.addButton(yesButton);
									dialog.addButton(noButton);

									if (dialog.showDialog() == MonologFXButton.Type.YES) {
										eventBus.post(new UploadAbortEvent(item));
									}
								}
							});
							btnAbort.setDisable(!item.getBoolean("inprogress") || item.getBoolean("archived"));

							final ToggleButton btnPauseOnFinish = new ToggleButton();
							btnPauseOnFinish.setId("pauseOnFinishQueue");
							btnPauseOnFinish.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(final ActionEvent arg0) {
									item.setBoolean("pauseOnFinish", btnPauseOnFinish.selectedProperty().get());
									item.saveIt();
								}
							});
							btnPauseOnFinish.selectedProperty().set(item.getBoolean("pauseOnFinish"));

							final HBox hbox = new HBox(3d);
							hbox.getChildren().addAll(btnRemove, btnEdit, btnAbort, btnPauseOnFinish);
							setGraphic(hbox);
							setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
						}
					}
				};
				return cell;
			}

		});

		queueTableview.setItems(FXCollections.observableArrayList(Upload.findAll()));

		actionOnFinish.setItems(FXCollections.observableArrayList(new String[] { I18nHelper.message("queuefinishedlist.donothing"),
				I18nHelper.message("queuefinishedlist.closeapplication"), I18nHelper.message("queuefinishedlist.shutdown"),
				I18nHelper.message("queuefinishedlist.hibernate") }));
		actionOnFinish.getSelectionModel().selectFirst();

		// Bindings
		uploader.actionOnFinish.bind(actionOnFinish.getSelectionModel().selectedIndexProperty());
		startQueue.disableProperty().bind(uploader.inProgressProperty);
		stopQueue.disableProperty().bind(uploader.inProgressProperty.not());
		uploader.maxUploads.bind(numberOfUploads.valueProperty());
		throttle.maxBps.bind(uploadSpeed.valueProperty());

		queueTableview.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		EventBusUtil.getInstance().register(this);
	}

	@Subscribe
	public void onModelSaved(final ModelPostSavedEvent modelSavedEvent) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				if (modelSavedEvent.getModel() instanceof Upload) {
					if (!queueTableview.getItems().contains(modelSavedEvent.getModel())) {
						queueTableview.getItems().add(modelSavedEvent.getModel());
					} else {
						queueTableview.getItems().set(queueTableview.getItems().indexOf(modelSavedEvent.getModel()),
								modelSavedEvent.getModel());
						RefresherUtil.refresh(queueTableview, queueTableview.getItems());
					}
				}
			}
		});
	}

	@Subscribe
	public void onModelRemoved(final ModelPostRemovedEvent modelRemovedEvent) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				if (modelRemovedEvent.getModel() instanceof Upload) {
					queueTableview.getItems().remove(modelRemovedEvent.getModel());
				}
			}
		});
	}

	@Subscribe
	public void onProgress(final UploadProgressEvent uploadProgress) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				final ProgressIndicator progressIndicator = (ProgressIndicator) queueTableview.getScene().lookup(
						"#queue-" + uploadProgress.getQueue().getLongId());
				if (progressIndicator == null) {
					return;
				}
				progressIndicator.setProgress((double) uploadProgress.getTotalBytesUploaded() / (double) uploadProgress.getFileSize());

				final Label label = (Label) queueTableview.getScene().lookup("#queue-text-" + uploadProgress.getQueue().getLongId());
				label.setText(String.format(
						"Finished at: %s,\n %s/%s %s/s",
						calculateEta(uploadProgress.getFileSize() - uploadProgress.getTotalBytesUploaded(), uploadProgress.getDiffBytes()
								/ uploadProgress.getDiffTime() * 1000),
						humanReadableByteCount(uploadProgress.getTotalBytesUploaded(), true),
						humanReadableByteCount(uploadProgress.getFileSize(), true),
						humanReadableByteCount(uploadProgress.getDiffBytes() / uploadProgress.getDiffTime() * 1000, true)));
			}
		});
	}

	private String calculateEta(final long remainingBytes, final long speed) {
		return DateFormat.getInstance().format(new Date(System.currentTimeMillis() + 1000 * remainingBytes / speed));
	}

	// Handler for Button[fx:id="startQueue"] onAction
	public void startQueue(final ActionEvent event) {
		final MonologFX dialog = new MonologFX(MonologFX.Type.ACCEPT);
		dialog.setTitleText(I18nHelper.message("dialog.youtubetos.title"));
		dialog.setMessage(I18nHelper.message("dialog.youtubetos.message"));
		final MonologFXButton yesButton = new MonologFXButton();
		yesButton.setType(MonologFXButton.Type.YES);
		yesButton.setLabel("Yes");
		final MonologFXButton noButton = new MonologFXButton();
		noButton.setType(MonologFXButton.Type.NO);
		noButton.setLabel("No");
		dialog.addButton(yesButton);
		dialog.addButton(noButton);
		if (dialog.showDialog() == MonologFXButton.Type.YES) {
			uploader.start();
		}
	}

	// Handler for Button[fx:id="stopQueue"] onAction
	public void stopQueue(final ActionEvent event) {
		uploader.stop();
	}

	public static String humanReadableByteCount(final long bytes, final boolean si) {
		final int unit = si ? 1000 : 1024;
		if (bytes < unit) {
			return bytes + " B";
		}
		final int exp = (int) (Math.log(bytes) / Math.log(unit));
		final String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
}
