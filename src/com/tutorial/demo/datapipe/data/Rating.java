package com.tutorial.demo.datapipe.data;

//It is a POJO
//It is a representation of rating in incoming data
public class Rating {
	private int rating;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [rating=" + rating + "]";
	}

}
