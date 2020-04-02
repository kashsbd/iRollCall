package com.pk.backgroundservice;
import com.pk.util.Attendance;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;

public class AttendanceService extends Service<Void> {
	private TableView<Attendance> table;

	public AttendanceService(TableView<Attendance> table) {
		this.table = table;
	}

	@Override
	protected Task<Void> createTask() {
		return new AttendanceTask(table);
	}

}
