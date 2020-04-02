package com.pk.backgroundservice;

import com.pk.util.Short_Info;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class SearchService extends Service<ObservableList<Short_Info>> {

	@Override
	protected Task<ObservableList<Short_Info>> createTask() {
		// TODO Auto-generated method stub
		return new SearchTask();
	}

}
