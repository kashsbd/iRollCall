package com.pk.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Teacher extends Person {
	@XmlElement
	private String tDepartment;
	@XmlElement
	private String tLoginName;
	@XmlElement
	private String tPassword;

	public Teacher(String pName, String pGender, String pPicPath, String pPhoneNo, String pAddress, String tDepartment,
			String tLoginName, String tPassword) {
		super(pName, pGender, pPicPath, pPhoneNo, pAddress);
		this.tDepartment = tDepartment;
		this.tLoginName = tLoginName;
		this.tPassword = tPassword;

	}

	public Teacher() {

	}

	public String gettDepartment() {
		return tDepartment;
	}

	public void settDepartment(String tDepartment) {
		this.tDepartment = tDepartment;
	}

	public String gettLoginName() {
		return tLoginName;
	}

	public void settLoginName(String tLoginName) {
		this.tLoginName = tLoginName;
	}

	public String gettPassword() {
		return tPassword;
	}

	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public void showInfo() {
		super.showInfo();
		System.out.print(tLoginName + " " + tPassword);

	}

}
