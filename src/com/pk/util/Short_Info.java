package com.pk.util;

public class Short_Info {

	private String firstCol; // Student:Roll Number , Teacher:Name
	private String secondCol; // Student:Name , Teacher:Department
	private String thirdCol; // Student:Need To Attend(days) , Teacher:Address
	private String fourthCol; // Student:Need To Attend(period) , Teacher:Phone
								// Number
	private String finalCol;// Student:OverallRollCall,Teacher
	private String temp;

	public Short_Info(Student stu) {
		this.firstCol = stu.getRollno();
		this.secondCol = stu.getpName();
		this.thirdCol = stu.getDays();
		this.fourthCol = stu.getPeriod();
		this.finalCol = stu.getRollcall();

	}

	public Short_Info(Teacher teac) {
		this.firstCol = teac.getpName();
		this.secondCol = teac.gettDepartment();
		this.thirdCol = teac.getpAddress();
		this.fourthCol = teac.getpPhoneNo();
	}

	public String getFirstCol() {
		return firstCol;
	}

	public void setFirstCol(String firstCol) {
		this.firstCol = firstCol;
	}

	public String getSecondCol() {
		return secondCol;
	}

	public void setSecondCol(String secondCol) {
		this.secondCol = secondCol;
	}

	public String getThirdCol() {
		return thirdCol;
	}

	public void setThirdCol(String thirdCol) {
		this.thirdCol = thirdCol;
	}

	public String getFourthCol() {
		return fourthCol;
	}

	public void setFourthCol(String fourthCol) {
		this.fourthCol = fourthCol;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Short_Info [firstCol=" + firstCol + ", secondCol=" + secondCol + ", thirdCol=" + thirdCol
				+ ", fourthCol=" + fourthCol + ",finalCol=" + finalCol + ", temp=" + temp + "]";
	}

}
