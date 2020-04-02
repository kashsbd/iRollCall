package com.pk.timetable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class TimeTable {
	@XmlElement
	private String the_Day;
	@XmlElement
	private String the_One;
	@XmlElement
	private String the_Two;
	@XmlElement
	private String the_Three;
	@XmlElement
	private String the_Four;
	@XmlElement
	private String the_Five;
	@XmlElement
	private String the_Six;
	@XmlElement
	private String the_Seven;

	public TimeTable(String the_Day, String the_One, String the_Two, String the_Three, String the_Four, String the_Five,
			String the_Six, String the_Seven) {
		this.the_Day = the_Day;
		this.the_One = the_One;
		this.the_Two = the_Two;
		this.the_Three = the_Three;
		this.the_Four = the_Four;
		this.the_Five = the_Five;
		this.the_Six = the_Six;
		this.the_Seven = the_Seven;
	}

	public TimeTable() {

	}

	public String getThe_Day() {
		return the_Day;
	}

	public void setThe_Day(String the_Day) {
		this.the_Day = the_Day;
	}

	public String getThe_One() {
		return the_One;
	}

	public void setThe_One(String the_One) {
		this.the_One = the_One;
	}

	public String getThe_Two() {
		return the_Two;
	}

	public void setThe_Two(String the_Two) {
		this.the_Two = the_Two;
	}

	public String getThe_Three() {
		return the_Three;
	}

	public void setThe_Three(String the_Three) {
		this.the_Three = the_Three;
	}

	public String getThe_Four() {
		return the_Four;
	}

	public void setThe_Four(String the_Four) {
		this.the_Four = the_Four;
	}

	public String getThe_Five() {
		return the_Five;
	}

	public void setThe_Five(String the_Five) {
		this.the_Five = the_Five;
	}

	public String getThe_Six() {
		return the_Six;
	}

	public void setThe_Six(String the_Six) {
		this.the_Six = the_Six;
	}

	public String getThe_Seven() {
		return the_Seven;
	}

	public void setThe_Seven(String the_Seven) {
		this.the_Seven = the_Seven;
	}

	public void showInfo() {
		System.out.println(the_Day + " " + the_One + " " + the_Two + " " + the_Three + " " + the_Four + " " + the_Five
				+ " " + the_Six + " " + the_Seven);
	}
}
