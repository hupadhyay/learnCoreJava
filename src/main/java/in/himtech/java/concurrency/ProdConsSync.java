package in.himtech.java.concurrency;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdConsSync {

	public static void main(String[] args) {
		EventQueue queue = new  EventQueue();
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}
}

class EventQueue {
	Logger logger = Logger.getLogger("in.himtech.java.concurrency.EventQueue");
	private int max = 10;
	private Queue<Date> queue;

	public EventQueue() {
		queue = new LinkedList<>();
	}

	public synchronized Date getEventDate() throws InterruptedException {
		while (queue.isEmpty()) {
			logger.info("No event date available. Please wait!");
			wait();
		}
		Date date = queue.poll();
		logger.log(Level.INFO, "fetched event date is {0}. ", date);
		notifyAll();
		return date;
	}

	public synchronized void setEventDate(Date date) throws InterruptedException {
		while (queue.size() == max) {
			logger.info("Event queue is full. No room to insert new date event.");
			wait();
		}
		queue.offer(date);
		logger.info("event date is stored in event queue.");
		notifyAll();
	}
}

class Producer implements Runnable {
	Logger logger = Logger.getLogger("in.himtech.java.concurrency.Producer");
	private EventQueue eventQueue;

	public Producer(EventQueue eventQueue) {
		this.eventQueue = eventQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				eventQueue.setEventDate(new Date());
				TimeUnit.SECONDS.sleep(2);
			}
		} catch (InterruptedException exp) {
			logger.log(Level.WARNING, "Exception Message: {0}", exp.getMessage());
			Thread.currentThread().interrupt();
		}
	}
}

class Consumer implements Runnable {
	Logger logger = Logger.getLogger("in.himtech.java.concurrency.Consumer");
	private EventQueue eventQueue;

	public Consumer(EventQueue eventQueue) {
		this.eventQueue = eventQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				eventQueue.getEventDate();
				TimeUnit.SECONDS.sleep(5);
			}
		} catch (InterruptedException exp) {
			logger.log(Level.WARNING, "Exception Message: {0}", exp.getMessage());
			Thread.currentThread().interrupt();
		}
	}
}