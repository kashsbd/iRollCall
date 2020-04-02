package com.pk.util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
public class Student extends Person {
	@XmlElement
	private String rollno;
	@XmlElement
	private String year;
	@XmlElement
	private String room;
	@XmlElement
	private String rollcall;
	@XmlElement
	private String days;
	@XmlElement
	private String period;

	public Student(String sName, String sGender, String sPicPath, String sPhoneNo, String sAddress, String sRollNo,
			String sYear, String sRoom) {
		super(sName, sGender, sPicPath, sPhoneNo, sAddress);
		rollno = sRollNo;
		year = sYear;
		room = sRoom;
		rollcall = "0%";
		days = "0";
		period = "0";

	}

	public Student() {

	}

	public String getRollcall() {
		return rollcall;
	}

	public void setRollcall(String rollcall) {
		this.rollcall = rollcall;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void showInfo() {
		super.showInfo();
		System.out.print(rollno + " " + year + " " + room + " " + rollcall + " " + days + " " + period);

	}

}
