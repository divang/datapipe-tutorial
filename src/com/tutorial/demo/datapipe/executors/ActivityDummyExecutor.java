package com.tutorial.demo.datapipe.executors;

import com.tutorial.demo.datapipe.data.VoiceData;

public class ActivityDummyExecutor extends Thread {

	VoiceData bestFeedback;

	void sendBestFeedbackData(VoiceData bestFeedback) {
		this.bestFeedback = bestFeedback;
	}

	public ActivityDummyExecutor() {
		super("[ ActivityDummyExecutorThread ]");
	}

	public void run() {
		while (true) {
			if (bestFeedback != null) {
				System.out.println(Thread.currentThread().getName() + " Best feedback found "
						+ bestFeedback.getCallerId() + " rating " + bestFeedback.getRating().getRating());
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	};
}
