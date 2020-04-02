package com.pk.util;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attendance")
public class Attendance implements Serializable {

	private static final long serialVersionUID = 1L;
	private String come;
	private String roomNo;
	private String name;
	private String phNumber;
	private String major;

	public Attendance(String come, String roomNo, String name, String phNumber, String major) {
		this.come = come;
		this.roomNo = roomNo;
		this.name = name;
		this.phNumber = phNumber;
		this.major = major;
	}

	public Attendance() {

	}

	public String getCome() {
		return come;
	}

	public void setCome(String come) {
		this.come = come;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
