package in.himtech.java.concurrency;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdConsLock {
	public static void main(String[] args) {
		EventQueueLock queue = new EventQueueLock();
		new Thread(new ProducerLock(queue)).start();
		new Thread(new ConsumerLock(queue)).start();
	}
}

class EventQueueLock {
	Logger logger = Logger.getLogger("in.himtech.java.concurrency.EventQueue");
	private int max = 10;
	private Queue<Date> queue;
	private Lock lock;
	private Condition fullCondition;
	private Condition emptyCondition;

	public EventQueueLock() {
		queue = new LinkedList<>();
		lock = new ReentrantLock();
		fullCondition = lock.newCondition();
		emptyCondition = lock.newCondition();
	}

	public Date getEventDate() throws InterruptedException {
		lock.lock();
		while (queue.isEmpty()) {
			logger.info("No event date available. Please wait!");
			emptyCondition.await();
		}
		Date date = queue.poll();
		logger.log(Level.INFO, "fetched event date is {0}. ", date);
		fullCondition.signalAll();
		lock.unlock();
		return date;
	}

	public void setEventDate(Date date) throws InterruptedException {
		lock.lock();
		while (queue.size() == max) {
			logger.info("Event queue is full. No room to insert new date event.");
			fullCondition.await();
		}
		queue.offer(date);
		logger.info("event date is stored in event queue.");
		emptyCondition.signalAll();
		lock.unlock();
	}
}

class ProducerLock implements Runnable {
	Logger logger = Logger.getLogger("in.himtech.java.concurrency.Producer");
	private EventQueueLock eventQueue;

	public ProducerLock(EventQueueLock eventQueue) {
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

class ConsumerLock implements Runnable {
	Logger logger = Logger.getLogger("in.himtech.java.concurrency.Consumer");
	private EventQueueLock eventQueue;

	public ConsumerLock(EventQueueLock eventQueue) {
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
