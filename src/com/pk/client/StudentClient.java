package com.pk.client;

import java.io.File;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import com.pk.util.Student;

public class StudentClient {
	private Client client;
	private Student student;
	private String URL = "http://localhost:8080/iRollCall/rest/students/upload";

	public StudentClient(Student student) {
		client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
		this.student = student;
	}

	public void uploadData() {
		FormDataMultiPart form = new FormDataMultiPart();
		FileDataBodyPart file = new FileDataBodyPart("image", new File(student.getpPicPath()));
		form.bodyPart(file);
		form.field("students", student, MediaType.APPLICATION_XML_TYPE);
		String result = client.target(URL).request(MediaType.APPLICATION_XML)
				.put(Entity.entity(form, form.getMediaType()), String.class);
		System.out.println(result);
	}
}
