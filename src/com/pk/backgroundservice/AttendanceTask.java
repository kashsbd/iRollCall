package com.pk.backgroundservice;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.controlsfx.control.Notifications;
import org.glassfish.jersey.media.sse.EventSource;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import com.pk.rollcall.Main;
import com.pk.util.Attendance;
import com.pk.util.Temp;
import com.sun.nio.sctp.ShutdownNotification;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import javafx.util.Duration;

public class AttendanceTask extends Task<Void> {
	private TableView<Attendance> table;
	private Client client;
	private String URL = "http://localhost:8080/iRollCall/rest/teachers";

	private WebTarget target;
	public static EventSource eventSource;

	private GenericType<List<Attendance>> list;

	public AttendanceTask(TableView<Attendance> table) {
		this.table = table;
		client = ClientBuilder.newBuilder().register(SseFeature.class).build();
		list = new GenericType<List<Attendance>>() {
		};

	}

	@Override
	protected Void call() throws Exception {

		for (int i = 0; i < 400; i++) {
			updateProgress(i, 200);
			Thread.sleep(1);
		}

		switch (Temp.YEAR) {
		case "first":
			target = client.target(URL).path("first");
			eventSource = EventSource.target(target).build();
			eventSource.register(inboundEvent -> showDataToTable(inboundEvent), "first");
			eventSource.open();

			break;
		case "second":
			target = client.target(URL).path("second");
			eventSource = EventSource.target(target).build();
			eventSource.register(inboundEvent -> showDataToTable(inboundEvent), "second");
			eventSource.open();
			break;
		case "third":
			target = client.target(URL).path("third");
			eventSource = EventSource.target(target).build();
			eventSource.register(inboundEvent -> showDataToTable(inboundEvent), "third");
			eventSource.open();
			break;
		case "fourth":
			target = client.target(URL).path("fourth");
			eventSource = EventSource.target(target).build();
			eventSource.register(inboundEvent -> showDataToTable(inboundEvent), "fourth");
			eventSource.open();
			break;
		case "final":
			target = client.target(URL).path("final");
			eventSource = EventSource.target(target).build();
			eventSource.register(inboundEvent -> showDataToTable(inboundEvent), "final");
			eventSource.open();
			break;

		}

		return null;
	}

	private void showDataToTable(InboundEvent inboundEvent) {
		if (table.getItems() != null)
			table.getItems().clear();
		List<Attendance> all = inboundEvent.readData(list, MediaType.APPLICATION_XML_TYPE);
		Platform.runLater(() -> {
			table.getItems().addAll(all);
		});

	}

	public void showNotification() {
		Notifications.create().text("Please connect to the network.").title("Missing").owner(Main.getRoot())
				.hideAfter(Duration.seconds(2)).showWarning();
	}

}
