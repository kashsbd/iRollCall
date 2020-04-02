package com.pk.timetable;

import java.io.Serializable;

public class Thur extends TimeTable implements Serializable {

	private static final long serialVersionUID = 1L;

	public Thur(String one, String two, String three, String four, String five, String six, String seven) {
		super("Thursday", one, two, three, four, five, six, seven);
	}

	public Thur() {

	}

}
