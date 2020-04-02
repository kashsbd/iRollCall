package com.pk.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.pk.backgroundservice.AttendanceService;
import com.pk.backgroundservice.AttendanceTask;
import com.pk.rollcall.Main;
import com.pk.util.Attendance;
import com.pk.util.Temp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javafx.util.Duration;

public class HomeController implements Initializable {
	@FXML
	private Button btnFirst;
	@FXML
	private Button btnSecond;
	@FXML
	private Button btnThird;
	@FXML
	private Button btnFourth;
	@FXML
	private Button btnFinal;
	@FXML
	private Button btnRefresh;
	@FXML
	private ProgressIndicator indicator;
	@FXML
	private Region region;
	@FXML
	private StackPane indicatorPane;
	@FXML
	private TableView<Attendance> table;
	@FXML
	private TableColumn<Attendance, String> colPresent;
	@FXML
	private TableColumn<Attendance, String> colRoomNumber;
	@FXML
	private TableColumn<Attendance, String> colName;
	@FXML
	private TableColumn<Attendance, String> colPhNumber;
	@FXML
	private TableColumn<Attendance, String> colMajor;
	@FXML
	private Label hLabel;

	private AttendanceService service;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		createTableColumn();
		service = new AttendanceService(table);
		indicator.progressProperty().bind(service.progressProperty());
		region.visibleProperty().bind(service.runningProperty());
		indicator.visibleProperty().bind(service.runningProperty());

	}

	private void createTableColumn() {

		colPresent.setCellValueFactory(new PropertyValueFactory<>("come"));
		FillCellColor(colPresent);
		colRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colPhNumber.setCellValueFactory(new PropertyValueFactory<>("phNumber"));
		colMajor.setCellValueFactory(new PropertyValueFactory<>("major"));

	}

	private void FillCellColor(TableColumn<Attendance, String> col) {

		col.setCellFactory(new Callback<TableColumn<Attendance, String>, TableCell<Attendance, String>>() {

			@Override
			public TableCell<Attendance, String> call(TableColumn<Attendance, String> param) {

				return new TableCell<Attendance, String>() {

					@Override
					protected void updateItem(String item, boolean empty) {

						super.updateItem(item, empty);
						if (item == null) {
							return;
						} else if (item.equals("Present")) {
							this.setStyle("-fx-background-color:rgb(15,243,70) ");
							this.setText("Present");
						} else {
							this.setStyle("-fx-background-color:rgb(239,41,41)");
							this.setText("Not Present");
						}

					}

				};
			}
		});

	}

	@FXML
	private void ButtonClicked(ActionEvent e) {

		if (AttendanceTask.eventSource != null) {
			AttendanceTask.eventSource.close();
		}
		if (e.getSource() == btnFirst) {
			hLabel.setText("Home >> First Year");
			Temp.YEAR = "first";
			if (isConnected("first"))
				service.restart();
		} else if (e.getSource() == btnSecond) {
			hLabel.setText("Home >> Second Year");
			Temp.YEAR = "second";
			if (isConnected("second"))
				service.restart();
		} else if (e.getSource() == btnThird) {
			hLabel.setText("Home >> Third Year");
			Temp.YEAR = "third";
			if (isConnected("second"))
				service.restart();
		} else if (e.getSource() == btnFourth) {
			hLabel.setText("Home >> Fourth Year");
			Temp.YEAR = "fourth";
			if (isConnected("first"))
				service.restart();
		} else if (e.getSource() == btnFinal) {
			hLabel.setText("Home >> Final Year");
			Temp.YEAR = "final";
			if (isConnected("second"))
				service.restart();
		}

	}

	private boolean isConnected(String st) {
		HttpURLConnection connection = null;
		boolean temp = false;
		try {
			URL u = new URL("http://localhost:8080/iRollCall/rest/teachers/" + st);
			connection = (HttpURLConnection) u.openConnection();
			connection.setRequestMethod("HEAD");
			int code = connection.getResponseCode();
			if (code == 200) {
				temp = true;
			}
		} catch (IOException e) {
			if (table.getItems() != null)
				table.getItems().clear();
			showNotification();
		} finally {
			if (connection == null) {
				connection.disconnect();
			}
		}
		return temp;
	}

	public void showNotification() {
		Notifications.create().text("Please connect to the network.").title("Missing").owner(Main.getRoot())
				.hideAfter(Duration.seconds(2)).showWarning();
	}
}
