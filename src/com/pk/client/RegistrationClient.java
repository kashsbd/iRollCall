package com.pk.client;

import java.io.File;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import com.pk.util.Teacher_Data;

public class RegistrationClient {
	private Client client;
	private Teacher_Data all;
	private String URL = "http://localhost:8080/iRollCall/rest/teachers/upload";

	public RegistrationClient(Teacher_Data all) {
		this.all = all;
		this.client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
	}

	public void uploadData() {
		FormDataMultiPart form = new FormDataMultiPart();
		FileDataBodyPart file = new FileDataBodyPart("image", new File(all.getTech().getpPicPath()));
		form.bodyPart(file);
		form.field("teachers", all, MediaType.APPLICATION_XML_TYPE);
		String result = client.target(URL).request(MediaType.APPLICATION_XML)
				.put(Entity.entity(form, form.getMediaType()), String.class);
		System.out.println(result);
	}
}
