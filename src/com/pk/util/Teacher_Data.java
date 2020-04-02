package com.pk.util;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pk.timetable.TimeTable;

@XmlRootElement
public class Teacher_Data {

	private List<TimeTable> list;
	private Teacher tech;

	public Teacher_Data(List<TimeTable> list, Teacher tech) {
		this.list = list;
		this.tech = tech;
	}

	public Teacher_Data() {

	}

	@XmlElement(name = "TimeTable")
	public List<TimeTable> getList() {
		return list;
	}

	public void setList(List<TimeTable> list) {
		this.list = list;
	}

	@XmlElement(name = "Teacher")
	public Teacher getTech() {
		return tech;
	}

	public void setTech(Teacher tech) {
		this.tech = tech;
	}

	public void showAll() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).showInfo();
		}
		tech.showInfo();
	}

}
