package com.pk.backgroundservice;

import com.pk.util.Short_Info;
import com.pk.util.Temp;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class SearchTask extends Task<ObservableList<Short_Info>> {

	@Override
	protected ObservableList<Short_Info> call() throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < 400; i++) {
			updateProgress(i, 200);
			Thread.sleep(5);
		}
		if (Temp.student) {
			return null;
		} else
			return null;
	}

}
