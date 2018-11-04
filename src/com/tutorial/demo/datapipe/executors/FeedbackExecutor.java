package com.tutorial.demo.datapipe.executors;

import com.tutorial.demo.datapipe.data.VoiceData;

public class FeedbackExecutor extends Thread {

	VoiceData incomingData;
	ActivityDummyExecutor activityDummyExecutor;

	public FeedbackExecutor(ActivityDummyExecutor activityDummyExecutor) {
		super("[ FeedbackExecutorThread ]");
		this.activityDummyExecutor = activityDummyExecutor;
	}

	public void senddata(VoiceData incomingData) {
		this.incomingData = incomingData;
	}

	@Override
	public void run() {

		while (true) {
			if (incomingData != null) {
				System.out.println(Thread.currentThread().getName() + "Data received: " + incomingData.getCallerId()
						+ " rating " + incomingData.getRating().getRating());
				if (incomingData.getRating().getRating() == 3) {
					System.out.println(
							Thread.currentThread().getName() + "Sending this data to next down stream processor: "
									+ incomingData.getCallerId() + " rating " + incomingData.getRating().getRating());

					activityDummyExecutor.sendBestFeedbackData(incomingData);
				} else {
					System.out.println(
							Thread.currentThread().getName() + "Drop this data for next down stream processor: "
									+ incomingData.getCallerId() + " rating " + incomingData.getRating().getRating());

				}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
