package com.tutorial.demo.datapipe.executors;

import com.tutorial.demo.datapipe.data.MetaData;
import com.tutorial.demo.datapipe.data.Rating;
import com.tutorial.demo.datapipe.data.VoiceData;

public class KafkaDummyProducer extends Thread {

	FeedbackExecutor feedbackExecutor;

	public KafkaDummyProducer(FeedbackExecutor feedbackExecutor) {
		super("[ KafkaDummyProducerThread ]");
		// Hold the execuotor information
		this.feedbackExecutor = feedbackExecutor;
	}

	public void run() {
		int i = 0;
		boolean produceBestRating = true;
		while (true) {
			VoiceData data = new VoiceData();
			data.setCallerId("CallId-" + i);
			i = i + 1; // i++

			Rating rating = new Rating();
			if (produceBestRating) {
				rating.setRating(3);
				produceBestRating = false;
			} else {
				rating.setRating(1);
				produceBestRating = true;
			}
			data.setRating(rating);

			MetaData metaData = new MetaData();
			metaData.setCountry("US");
			metaData.setRegion("east");
			data.setMetaData(metaData);

			System.out.println(Thread.currentThread().getName() + " Kafka producer is sending the data: "
					+ data.getCallerId() + " rating " + data.getRating().getRating());
			// Sending data to Feedback executor
			feedbackExecutor.senddata(data);

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

}
