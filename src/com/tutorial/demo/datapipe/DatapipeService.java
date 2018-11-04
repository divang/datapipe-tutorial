package com.tutorial.demo.datapipe;

import com.tutorial.demo.datapipe.executors.ActivityDummyExecutor;
import com.tutorial.demo.datapipe.executors.FeedbackExecutor;
import com.tutorial.demo.datapipe.executors.KafkaDummyProducer;

// Entry Class which will start all threads

public class DatapipeService {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " Datapipe is staring ...");

		// TODO write business logic over here.

		// Dummy Down stream Processor
		// Final get the best rating Voice data
		ActivityDummyExecutor activityDummyExecutor = new ActivityDummyExecutor();
		activityDummyExecutor.start();

		// Intermediate Processor which has the actual bussines logic. It filter
		// out the low rating voice data
		FeedbackExecutor feedbackExecutor = new FeedbackExecutor(activityDummyExecutor);
		feedbackExecutor.start();

		// Dummy Data Producer which producing the Voice data
		KafkaDummyProducer kafkaDummyProducer = new KafkaDummyProducer(feedbackExecutor);
		kafkaDummyProducer.start();

		System.out.println(Thread.currentThread().getName() + " Datapipe has started.");
	}
}
