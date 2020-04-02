
package com.pk.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Person {
	@XmlElement
	private String pName;
	@XmlElement
	private String pGender;
	@XmlElement
	private String pPicPath;
	@XmlElement
	private String pPhoneNo;
	@XmlElement
	private String pAddress;

	public Person(String pName, String pGender, String pPicPath, String pPhoneNo, String pAddress) {
		this.pName = pName;
		this.pGender = pGender;
		this.pPicPath = pPicPath;
		this.pPhoneNo = pPhoneNo;
		this.pAddress = pAddress;
	}

	public Person() {

	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpGender() {
		return pGender;
	}

	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	public String getpPicPath() {
		return pPicPath;
	}

	public void setpPicFile(String pPicPath) {
		this.pPicPath = pPicPath;
	}

	public String getpPhoneNo() {
		return pPhoneNo;
	}

	public void setpPhoneNo(String pPhoneNo) {
		this.pPhoneNo = pPhoneNo;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public void showInfo() {
		System.out.print(pName + " " + pGender + " " + pPicPath + " " + pPhoneNo + " " + pAddress + " ");
	}

}
