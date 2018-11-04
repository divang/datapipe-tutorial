package com.tutorial.demo.datapipe.data;

// POJO
// Composite class which also hold the referenc of MetaData and Rating
public class VoiceData {

	private String callerId;
	private MetaData metaData;
	private Rating rating;

	public String getCallerId() {
		return callerId;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public Rating getRating() {
		return rating;
	}

	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	@Override
	public String toString() {
		return "VoiceData [callerId=" + callerId + ", metaData=" + metaData + ", rating=" + rating + "]";
	}

}
