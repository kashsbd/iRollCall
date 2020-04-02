package com.pk.rollcall;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.pk.controller.AddStudentController;
import com.pk.controller.HomeController;
import com.pk.controller.ViewInformationController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AppMain implements Initializable {

	@FXML
	private Label lHome;

	@FXML
	private Label lRegistration;

	@FXML
	private Label lAddStudent;

	@FXML
	private Label lViewInformation;

	@FXML
	private Label lSettings;
	@FXML
	private VBox vboxHome;
	@FXML
	private VBox vboxRegistration;
	@FXML
	private VBox vboxAddStudent;
	@FXML
	private VBox vboxViewInformation;
	@FXML
	private VBox vboxSetting;

	private VBox temp;

	@FXML
	private BorderPane borderPane = Main.getRoot();

	@FXML
	private void mouseClicked(MouseEvent e) throws IOException {
		if (temp != null) {
			temp.setStyle("-fx-background-color:rgb(0,128,128);");
			temp.getChildren().get(0).setStyle("-fx-text-fill:white");
			temp.getChildren().get(1).setStyle("-fx-text-fill:white");
		}

		if (e.getSource() == vboxHome) {
			vboxHome.setStyle("-fx-background-color:white;");
			vboxHome.getChildren().get(0).setStyle("-fx-text-fill:rgb(0,128,128)");
			vboxHome.getChildren().get(1).setStyle("-fx-text-fill:rgb(0,128,128)");
			temp = vboxHome;
			// load fxml
			VBox homePane = (VBox) FXMLLoader.load(getClass().getResource("Home.fxml"));
			homePane.setId("home");
			borderPane.setCenter(homePane);
		}
		if (e.getSource() == vboxRegistration) {
			vboxRegistration.setStyle("-fx-background-color:white;");
			vboxRegistration.getChildren().get(0).setStyle("-fx-text-fill:rgb(0,128,128)");
			vboxRegistration.getChildren().get(1).setStyle("-fx-text-fill:rgb(0,128,128)");
			temp = vboxRegistration;
			// load fxml
			VBox registrationPane = (VBox) FXMLLoader.load(getClass().getResource("Registration.fxml"));
			registrationPane.setId("reg");
			borderPane.setCenter(registrationPane);
		}
		if (e.getSource() == vboxAddStudent) {
			vboxAddStudent.setStyle("-fx-background-color:white;");
			vboxAddStudent.getChildren().get(0).setStyle("-fx-text-fill:rgb(0,128,128)");
			vboxAddStudent.getChildren().get(1).setStyle("-fx-text-fill:rgb(0,128,128)");
			temp = vboxAddStudent;
			// load fxml
			VBox viewinformationPane = (VBox) FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
			viewinformationPane.setId("info");
			borderPane.setCenter(viewinformationPane);
		}
		if (e.getSource() == vboxViewInformation) {
			vboxViewInformation.setStyle("-fx-background-color:white;");
			vboxViewInformation.getChildren().get(0).setStyle("-fx-text-fill:rgb(0,128,128)");
			vboxViewInformation.getChildren().get(1).setStyle("-fx-text-fill:rgb(0,128,128)");
			temp = vboxViewInformation;
			// load fxml
			VBox addstudentPane = (VBox) FXMLLoader.load(getClass().getResource("ViewInformation.fxml"));
			addstudentPane.setId("stu");
			borderPane.setCenter(addstudentPane);
		}
		if (e.getSource() == vboxSetting) {
			vboxSetting.setStyle("-fx-background-color:white;");
			vboxSetting.getChildren().get(0).setStyle("-fx-text-fill:rgb(0,128,128)");
			vboxSetting.getChildren().get(1).setStyle("-fx-text-fill:rgb(0,128,128)");
			temp = vboxSetting;
			// load fxml
			// VBox settingPane = (VBox)
			// FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
			// settingPane.setId("setting");
			// borderPane.setCenter(settingPane);
			borderPane.setCenter(null);
			System.out.println("Loaded Settings Fxml.");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lHome.setText("\uf015");
		lRegistration.setText("\uf1ea");
		lAddStudent.setText("\uf234");
		lViewInformation.setText("\uf0c0");
		lSettings.setText("\uf085");

	}

}
