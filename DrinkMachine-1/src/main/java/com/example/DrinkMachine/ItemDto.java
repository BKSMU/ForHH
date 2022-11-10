package com.example.DrinkMachine;

import java.util.Date;

public class ItemDto {
	private String dtoName;
	private int dtoUnitPrice;
	private int dtoCount;
	private int dtoIsPr;
	private Date dtoRecordDate;

	public String getDtoName() {
		return dtoName;
	}

	public void setDtoName(String dtoName) {
		this.dtoName = dtoName;
	}

	public int getDtoUnitPrice() {
		return dtoUnitPrice;
	}

	public void setDtoUnitPrice(int dtoUnitPrice) {
		this.dtoUnitPrice = dtoUnitPrice;
	}

	public int getDtoCount() {
		return dtoCount;
	}

	public void setDtoCount(int dtoCount) {
		this.dtoCount = dtoCount;
	}

	public int getDtoIsPr() {
		return dtoIsPr;
	}

	public void setDtoIsPr(int dtoIsPr) {
		this.dtoIsPr = dtoIsPr;
	}

	public Date getDtoRecordDate() {
		return dtoRecordDate;
	}

	public void setDtoRecordDate(Date dtoRecordDate) {
		this.dtoRecordDate = dtoRecordDate;
	}

}
