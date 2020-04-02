package com.pk.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.pk.client.StudentClient;
import com.pk.rollcall.Main;
import com.pk.util.SelectPicture;
import com.pk.util.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AddStudentController implements Initializable {
	@FXML
	private TextField sName;
	@FXML
	private RadioButton rdoMale;
	@FXML
	private RadioButton rdoFemale;
	@FXML
	private TextField sRollNo;
	@FXML
	private ChoiceBox<String> sYear;
	@FXML
	private ChoiceBox<String> sRoom;
	@FXML
	private TextField sPhoneNo;
	@FXML
	private TextArea sAddress;
	@FXML
	private TextField lySearch;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnCancel;
	@FXML
	private ImageView sImage;
	@FXML
	private TitledPane rtPane;
	@FXML
	private TitledPane ltPane;
	@FXML
	private ChoiceBox<String> lyYear;
	@FXML
	private ChoiceBox<String> lyRoom;
	@FXML
	private RadioButton lyRdoName;
	@FXML
	private RadioButton lyRdoRollNo;
	@FXML
	private Button lySearchBtn;
	@FXML
	private Button lyLoad;
	@FXML
	private Button lyClear;
	@FXML
	private ListView<String> lyListView;

	private String picPath = "";
	private File picFile;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rtPane.setCollapsible(false);
		ltPane.setCollapsible(false);
		rdoMale.setSelected(true);
		loadInformationToChoiceBox(sYear, sRoom, lyYear, lyRoom);

	}

	@FXML
	private void searchButtonClicked(ActionEvent e) {

	}

	@FXML
	private void loadButtonClicked(ActionEvent e) {

	}

	@FXML
	private void clearButtonClicked(ActionEvent e) {

	}

	@FXML
	private void lyRadioClicked(ActionEvent e) {
		if (e.getSource() == lyRdoName) {
			lySearch.clear();
			lySearch.requestFocus();
		} else {
			lySearch.setText("SR-");
			lySearch.requestFocus();
		}

	}

	private void loadInformationToChoiceBox(ChoiceBox<String> sYear2, ChoiceBox<String> sRoom2,
			ChoiceBox<String> lyYear2, ChoiceBox<String> lyRoom2) {
		sYear2.getItems().addAll("1-CST", "2-CS", "2-CT", "3-CS", "3-CT", "4-CS", "4-CT", "5-CS", "5-CT");
		sYear2.setValue(sYear.getItems().get(0));
		sRoom2.getItems().addAll("A", "B", "C", "D", "E", "F", "G");
		sRoom2.setValue(sRoom.getItems().get(0));
		lyYear2.getItems().addAll("1-CST", "2-CS", "2-CT", "3-CS", "3-CT", "4-CS", "4-CT", "5-CS", "5-CT");
		lyYear2.setValue(sYear.getItems().get(0));
		lyRoom2.getItems().addAll("A", "B", "C", "D", "E", "F", "G");
		lyRoom2.setValue(sRoom.getItems().get(0));

	}

	@FXML
	public void ButtonClicked(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if (checkStudentInfo()) {
				addStudentInfo();
			}
		} else {
			cancelIt();
		}

	}

	private void addStudentInfo() {
		String gender = "Male";
		if (rdoMale.isSelected()) {
			gender = "Male";
		} else
			gender = "Female";

		Student student = new Student(sName.getText(), gender, picPath, sPhoneNo.getText(), sAddress.getText(),
				sRollNo.getText(), sYear.getValue(), sRoom.getValue());
		StudentClient client = new StudentClient(student);
		student.showInfo();
		client.uploadData();
	}

	private boolean checkStudentInfo() {
		Boolean check = true;
		if (picPath.equals("")) {
			showNotification("Please Select Picture !");
			check = false;
		} else if (sName.getText().equals("")) {
			showNotification("Please Fill Name !");
			sName.requestFocus();
			check = false;
		} else if (sRollNo.getText().equals("")) {
			showNotification("Please Fill Roll Number !");
			sRollNo.requestFocus();
			check = false;
		} else if (!sRollNo.getText().startsWith("SR-")) {
			showNotification("Roll Number Should Start With SR-xxx", "Information");
			sRollNo.requestFocus();
			check = false;
		} else if (sPhoneNo.getText().equals("")) {
			showNotification("Please Fill Phone Number !");
			sPhoneNo.requestFocus();
			check = false;
		} else if (!sPhoneNo.getText().startsWith("+959")) {
			showNotification("Phone Number Should Start With +959");
			sPhoneNo.requestFocus();
			check = false;
		} else if (sAddress.getText().equals("")) {
			showNotification("Please Fill Address !");
			sAddress.requestFocus();
			check = false;
		}
		return check;
	}

	private void cancelIt() {
		picPath = "";
		sImage.setImage(new Image("images/default.png"));
		sName.setText("");
		rdoMale.setSelected(true);
		sRollNo.setText("");
		sYear.setValue(sYear.getItems().get(0));
		sRoom.setValue(sRoom.getItems().get(0));
		sPhoneNo.setText("");
		sAddress.setText("");

	}

	@FXML
	private void showFileChooser() {
		picFile = SelectPicture.show();
		if (picFile != null) {
			picPath = picFile.getPath();
			sImage.setImage(new Image(picFile.toURI().toString()));

		}
	}

	private void showNotification(String msg) {
		Notifications.create().text(msg).title("Missing").owner(Main.getRoot()).hideAfter(Duration.seconds(2))
				.showWarning();
	}

	private void showNotification(String msg, String title) {
		Notifications.create().text(msg).title(title).owner(Main.getRoot()).hideAfter(Duration.seconds(3))
				.showInformation();
	}

}
