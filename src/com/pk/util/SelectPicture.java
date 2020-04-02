package com.pk.util;

import java.io.File;


import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class SelectPicture {

	public static File show() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Image File ");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg"));
		File selectedFile = fileChooser.showOpenDialog(null);
		return selectedFile;

	}
}
