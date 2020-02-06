package com.psl.files;

import java.io.Serializable;

public class Address {
	private int streetCode;
	private String cityName;

	public Address() {
	}

	
	public Address(int streetCode, String cityName) {
		super();
		this.streetCode = streetCode;
		this.cityName = cityName;
	}


	public int getStreetCode() {
		return streetCode;
	}


	public void setStreetCode(int streetCode) {
		this.streetCode = streetCode;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	@Override
	public String toString() {

		return streetCode + "\t" + cityName;
	}

}
