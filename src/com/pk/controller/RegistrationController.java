package com.pk.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.pk.client.RegistrationClient;
import com.pk.rollcall.Main;
import com.pk.timetable.Fri;
import com.pk.timetable.Mon;
import com.pk.timetable.Thur;
import com.pk.timetable.TimeTable;
import com.pk.timetable.Tue;
import com.pk.timetable.Wed;
import com.pk.util.SelectPicture;
import com.pk.util.Teacher;
import com.pk.util.Teacher_Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class RegistrationController implements Initializable {
	@FXML
	private Button btnSubmit;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtPhoneNumber;
	@FXML
	private TextArea txtAddress;
	@FXML
	private RadioButton rdoMale;
	@FXML
	private RadioButton rdoFemale;
	@FXML
	private ChoiceBox<String> choice;
	@FXML
	private ImageView image;
	@FXML
	private TitledPane ltPane;
	@FXML
	private TitledPane rtPane;

	@FXML
	private TextField mon1;

	@FXML
	private TextField mon2;

	@FXML
	private TextField mon3;

	@FXML
	private TextField mon4;

	@FXML
	private TextField mon5;

	@FXML
	private TextField mon6;

	@FXML
	private TextField mon7;

	@FXML
	private TextField tue1;

	@FXML
	private TextField tue2;

	@FXML
	private TextField tue3;

	@FXML
	private TextField tue4;

	@FXML
	private TextField tue5;

	@FXML
	private TextField tue6;

	@FXML
	private TextField tue7;

	@FXML
	private TextField wed1;

	@FXML
	private TextField wed2;

	@FXML
	private TextField wed3;

	@FXML
	private TextField wed4;

	@FXML
	private TextField wed5;

	@FXML
	private TextField wed6;

	@FXML
	private TextField wed7;

	@FXML
	private TextField thur1;

	@FXML
	private TextField thur2;

	@FXML
	private TextField thur3;

	@FXML
	private TextField thur4;

	@FXML
	private TextField thur5;

	@FXML
	private TextField thur6;

	@FXML
	private TextField thur7;

	@FXML
	private TextField fri1;

	@FXML
	private TextField fri2;

	@FXML
	private TextField fri3;

	@FXML
	private TextField fri4;

	@FXML
	private TextField fri5;

	@FXML
	private TextField fri6;

	@FXML
	private TextField fri7;
	@FXML
	private GridPane gridPane;

	private Mon mon;
	private Tue tue;
	private Wed wed;
	private Thur thur;
	private Fri fri;
	private Teacher_Data allData;
	private String picPath = "";
	private File picFile;
	private ObservableList<TimeTable> days;

	@FXML
	public void buttonClick(ActionEvent e) {
		if (e.getSource() == btnSubmit) {
			if (checkInfo()) {

				allData = getInfo();
				RegistrationClient hi = new RegistrationClient(allData);
				hi.uploadData();

			}
		} else {
			cancelIt();
		}
	}

	private Teacher_Data getInfo() {
		String gender = "Male";
		if (rdoMale.isSelected()) {
			gender = "Male";
		} else
			gender = "Female";

		Teacher teacher = new Teacher(txtName.getText(), gender, picPath, txtPhoneNumber.getText(),
				txtAddress.getText(), choice.getValue(), txtName.getText(), txtPhoneNumber.getText());
		mon = new Mon(mon1.getText(), mon2.getText(), mon3.getText(), mon4.getText(), mon5.getText(), mon6.getText(),
				mon7.getText());
		tue = new Tue(tue1.getText(), tue2.getText(), tue3.getText(), tue4.getText(), tue5.getText(), tue6.getText(),
				tue7.getText());
		wed = new Wed(wed1.getText(), wed2.getText(), wed3.getText(), wed4.getText(), wed5.getText(), wed6.getText(),
				wed7.getText());
		thur = new Thur(thur1.getText(), thur2.getText(), thur3.getText(), thur4.getText(), thur5.getText(),
				thur6.getText(), thur7.getText());
		fri = new Fri(fri1.getText(), fri2.getText(), fri3.getText(), fri4.getText(), fri5.getText(), fri6.getText(),
				fri7.getText());
		days = FXCollections.observableArrayList(mon, tue, wed, thur, fri);

		return new Teacher_Data(days, teacher);

	}

	private Boolean checkInfo() {
		Boolean check = true;
		if (picPath.equals("")) {
			showNotification("Please Select Picture !");
			check = false;
		} else if (txtName.getText().equals("")) {
			showNotification("Please Fill Name !");
			txtName.requestFocus();
			check = false;
		} else if (txtPhoneNumber.getText().equals("")) {
			showNotification("Please Fill PhoneNumber !");
			txtPhoneNumber.requestFocus();
			check = false;
		} else if (!txtPhoneNumber.getText().startsWith("+959")) {
			showNotification("Phone Number should start with +959 !");
			txtPhoneNumber.requestFocus();
			check = false;
		} else if (txtAddress.getText().equals("")) {
			showNotification("Please Fill Address !");
			txtAddress.requestFocus();
			check = false;
		} else if (checkMon()) {
			showNotification("Please Fill Complete Data at Monday");
			check = false;
		} else if (checkTue()) {
			showNotification("Please Fill Complete Data at Tuesday");
			check = false;
		} else if (checkWed()) {
			showNotification("Please Fill Complete Data at Wednesday");
			check = false;
		} else if (checkThur()) {
			showNotification("Please Fill Complete Data at Thursday");
			check = false;
		} else if (checkFri()) {
			showNotification("Please Fill Complete Data at Friday");
			check = false;
		}
		return check;
	}

	private boolean checkFri() {
		return ((equalNull(fri1) || equalNull(fri2) || equalNull(fri3) || equalNull(fri4) || equalNull(fri5)
				|| equalNull(fri6) || equalNull(fri7)));
	}

	private boolean checkThur() {
		return ((equalNull(thur1) || equalNull(thur2) || equalNull(thur3) || equalNull(thur4) || equalNull(thur5)
				|| equalNull(thur6) || equalNull(thur7)));
	}

	private boolean checkWed() {
		return ((equalNull(wed1) || equalNull(wed2) || equalNull(wed3) || equalNull(wed4) || equalNull(wed5)
				|| equalNull(wed6) || equalNull(wed7)));
	}

	private boolean checkTue() {
		return ((equalNull(tue1) || equalNull(tue2) || equalNull(tue3) || equalNull(tue4) || equalNull(tue5)
				|| equalNull(tue6) || equalNull(tue7)));
	}

	private boolean checkMon() {
		return ((equalNull(mon1) || equalNull(mon2) || equalNull(mon3) || equalNull(mon4) || equalNull(mon5)
				|| equalNull(mon6) || equalNull(mon7)));
	}

	private Boolean equalNull(TextField value) {
		if (value.getText().equals("")) {
			value.requestFocus();
			return true;
		} else
			return false;
	}

	private void cancelIt() {
		picPath = "";
		image.setImage(new Image("images/default.png"));
		txtName.setText("");
		rdoMale.setSelected(true);
		choice.setValue(choice.getItems().get(0));
		txtPhoneNumber.setText("");
		txtAddress.setText("");
		ObservableList<Node> allNode = gridPane.getChildren();
		for (Node node : allNode) {
			if (node instanceof TextField) {
				((TextField) node).clear();
			}
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ltPane.setCollapsible(false);
		rtPane.setCollapsible(false);

		loadChoiceBoxData();
		rdoMale.setSelected(true);

	}

	private void loadChoiceBoxData() {
		choice.getItems().addAll("Software Department", "Hardware Department", "Application Department",
				"Math Department", "English Department");
		choice.setValue(choice.getItems().get(0));

	}

	@FXML
	private void selectPicture() {
		picFile = SelectPicture.show();
		if (picFile != null) {
			picPath = picFile.getPath();
			image.setImage(new Image(picFile.toURI().toString()));

		}
	}

	private void showNotification(String msg) {
		Notifications.create().text(msg).title("Missing").owner(Main.getRoot()).hideAfter(Duration.seconds(2))
				.showWarning();
	}

}
