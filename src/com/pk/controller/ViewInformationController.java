package com.pk.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.pk.backgroundservice.SearchService;
import com.pk.dialog.DetailInformationDialog;
import com.pk.rollcall.Main;
import com.pk.util.Short_Info;
import com.pk.util.Temp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class ViewInformationController implements Initializable {
	@FXML
	private RadioButton rdoStudent;
	@FXML
	private RadioButton rdoTeacher;
	@FXML
	private ChoiceBox<String> year;
	@FXML
	private ChoiceBox<String> room;
	@FXML
	private ChoiceBox<String> department;
	@FXML
	private Button btnSearch;
	@FXML
	private RadioButton rdoByName;
	@FXML
	private RadioButton rdoByNum;
	@FXML
	private VBox depaBox;
	@FXML
	private VBox yearBox;
	@FXML
	private VBox roomBox;
	@FXML
	private TextField txtSearch;
	@FXML
	private TableView<Short_Info> table;
	@FXML
	private TableColumn<Short_Info, String> colRollNo;
	@FXML
	private TableColumn<Short_Info, String> colName;
	@FXML
	private TableColumn<Short_Info, String> colDay;
	@FXML
	private TableColumn<Short_Info, String> colPeriod;
	@FXML
	private TableColumn<Short_Info, String> colRollCall;
	@FXML
	private ProgressIndicator indicator;
	@FXML
	private Region region;
	@FXML
	private MenuItem itemView;
	@FXML
	private MenuItem itemUpdate;

	private Boolean studentRadioClick = true;
	private Boolean teacherRadioClick = false;
	final SearchService service = new SearchService();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// for binding between indicator and table
		indicator.progressProperty().bind(service.progressProperty());
		region.visibleProperty().bind(service.runningProperty());
		indicator.visibleProperty().bind(service.runningProperty());
		table.itemsProperty().bind(service.valueProperty());

		rdoStudent.setSelected(true);
		depaBox.setDisable(true);
		year.getItems().addAll("1-CST", "2-CS", "2-CT", "3-CS", "3-CT", "4-CS", "4-CT", "5-CS", "5-CT");
		year.setValue(year.getItems().get(0));
		room.getItems().addAll("A", "B", "C", "D", "E", "F", "G");
		room.setValue(room.getItems().get(0));
		department.getItems().addAll("Software Department", "Hardware Department", "Application Department",
				"Math Department", "English Department");
		department.setValue(department.getItems().get(0));

	}

	@FXML
	private void searchButtonClicked(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			showToTable();
		}

	}

	@FXML
	private void ContextMenuClicked(ActionEvent e) {

		Short_Info data = table.getSelectionModel().getSelectedItem();
		DetailInformationDialog detail;
		if (data != null) {
			if (e.getSource() == itemView)
				if (studentRadioClick)
					detail = new DetailInformationDialog();
				else
					detail = new DetailInformationDialog();
			else
				System.out.print("Showing Update Window");

		} else {
			ShowNotification("There is no row !");
			detail = new DetailInformationDialog();
		}

	}

	private void showToTable() {
		colRollNo.setCellValueFactory(new PropertyValueFactory<>("firstCol"));
		colName.setCellValueFactory(new PropertyValueFactory<>("secondCol"));
		colDay.setCellValueFactory(new PropertyValueFactory<>("thirdCol"));
		colPeriod.setCellValueFactory(new PropertyValueFactory<>("fourthCol"));
		colRollCall.setCellValueFactory(new PropertyValueFactory<>("finalCol"));

		if (studentRadioClick) {
			Temp.student = true;
			service.restart();
		} else {
			Temp.student = false;
			service.restart();
		}

	}

	@FXML
	private void RadioButtonSelected(ActionEvent e) {
		if (e.getSource() == rdoStudent) {
			// change tablecolumn's name
			colRollNo.setPrefWidth(100);
			colRollNo.setText("Roll Number");
			colName.setPrefWidth(159);
			colName.setText("Name");
			colDay.setPrefWidth(104);
			colDay.setText("Need To\rAttend(days)");
			colPeriod.setPrefWidth(129);
			colPeriod.setText("Need To\rAttend(periods)");
			colPeriod.setPrefWidth(163);
			colRollCall.setVisible(true);
			colRollCall.setText("Overall RollCall");

			txtSearch.setText("");
			studentRadioClick = true;
			teacherRadioClick = false;
			depaBox.setDisable(true);
			yearBox.setDisable(false);
			roomBox.setDisable(false);
			rdoByNum.setDisable(false);
			rdoByName.setSelected(false);
			rdoByNum.setSelected(false);
			txtSearch.setDisable(true);
			if (table.getItems() != null) {
				table.getItems().clear();
			}

		} else if (e.getSource() == rdoTeacher) {
			// change tablecolumn's name
			colRollNo.setPrefWidth(164);
			colRollNo.setText("Name");
			colName.setPrefWidth(159);
			colName.setText("Department");
			colDay.setPrefWidth(170);
			colDay.setText("Address");
			colPeriod.setPrefWidth(164);
			colPeriod.setText("Phone Number");

			colRollCall.setVisible(false);
			txtSearch.setText("");
			teacherRadioClick = true;
			studentRadioClick = false;
			yearBox.setDisable(true);
			roomBox.setDisable(true);
			depaBox.setDisable(false);
			rdoByNum.setDisable(true);
			rdoByNum.setSelected(false);
			rdoByName.setSelected(false);
			txtSearch.setDisable(true);
			if (table.getItems() != null) {
				table.getItems().clear();
			}

		} else if (e.getSource() == rdoByName) {
			txtSearch.setDisable(false);
			txtSearch.setText("");
			txtSearch.requestFocus();
		} else if (e.getSource() == rdoByNum) {
			txtSearch.setDisable(false);
			txtSearch.setText("SR-");
			txtSearch.requestFocus();

		}

	}

	private void ShowNotification(String msg) {
		Notifications.create().text(msg).title("Error").owner(Main.getRoot()).hideAfter(Duration.seconds(2))
				.showError();
	}

}
