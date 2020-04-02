package com.pk.controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class DetailDialogController implements Initializable {

	@FXML
	private Label stuName;

	@FXML
	private TitledPane tPane1;

	@FXML
	private ImageView dImage;

	@FXML
	private TextField dName;

	@FXML
	private TextField dGender;

	@FXML
	private TextField dRollNo;

	@FXML
	private TextField dYear;

	@FXML
	private TextField dRoom;

	@FXML
	private TextField dPhoneNo;

	@FXML
	private TextArea dAddress;

	@FXML
	private TitledPane tPane2;

	@FXML
	private BarChart<String, Integer> barChart;

	@FXML
	private CategoryAxis xAxis;

	@FXML
	private Button dButton;

	private ObservableList<String> monthNames = FXCollections.observableArrayList();
	private String[] months = { "December", "January", "February", "March", "May", "June", "July", "Auguest",
			"September", "Overall  RollCall" };

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tPane1.setCollapsible(false);
		tPane2.setCollapsible(false);

		monthNames.setAll(Arrays.asList(months));
		xAxis.setCategories(monthNames);
		XYChart.Series<String, Integer> series = createData();
		barChart.getData().add(series);

	}

	private Series<String, Integer> createData() {
		Glow glow = new Glow(0.8);
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		XYChart.Data<String, Integer> decData = new XYChart.Data<>(months[0], 60);
		XYChart.Data<String, Integer> janData = new XYChart.Data<>(months[1], 80);
		XYChart.Data<String, Integer> febData = new XYChart.Data<>(months[2], 30);
		XYChart.Data<String, Integer> marData = new XYChart.Data<>(months[3], 75);
		XYChart.Data<String, Integer> mayData = new XYChart.Data<>(months[4], 60);
		XYChart.Data<String, Integer> junData = new XYChart.Data<>(months[5], 90);
		XYChart.Data<String, Integer> julData = new XYChart.Data<>(months[6], 75);
		XYChart.Data<String, Integer> augData = new XYChart.Data<>(months[7], 80);
		XYChart.Data<String, Integer> sepData = new XYChart.Data<>(months[8], 90);
		XYChart.Data<String, Integer> overallData = new XYChart.Data<>(months[9], 75);
		series.getData().addAll(decData, janData, febData, marData, mayData, junData, julData, augData, sepData,
				overallData);
		showText(series);
		return series;
	}

	void showText(Series<String, Integer> series) {

		for (Data<String, Integer> data : series.getData()) {
			data.nodeProperty().addListener((l, o, n) -> {
				final Node node = data.getNode();
				final Text text = new Text(data.getYValue() + "%");
				node.parentProperty().addListener((ll, oo, nn) -> {
					Group group = (Group) nn.getParent();
					group.getChildren().add(text);
				});
				node.boundsInParentProperty().addListener((lll, ooo, nnn) -> {
					text.setLayoutX(Math.round(nnn.getMaxX() + 35));
					text.setLayoutY(Math.round(nnn.getMinY() - text.prefHeight(-1) * 0.1));
				});
			});

		}
	}
}