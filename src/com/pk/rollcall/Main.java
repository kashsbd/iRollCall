package com.pk.rollcall;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	public static BorderPane temp;

	public static BorderPane getRoot() {
		return temp;
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("AppMain.fxml"));
			temp = root;
			VBox center = (VBox) FXMLLoader.load(getClass().getResource("Home.fxml"));
			root.setCenter(center);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
