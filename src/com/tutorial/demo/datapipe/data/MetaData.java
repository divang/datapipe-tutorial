package com.tutorial.demo.datapipe.data;

//POJO of Metadata
public class MetaData {
	private String region;
	private String country;

	public String getRegion() {
		return region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "MetaData [region=" + region + ", country=" + country + "]";
	}

}
