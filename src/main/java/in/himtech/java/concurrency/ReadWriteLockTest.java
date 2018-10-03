package in.himtech.java.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
	public static void main(String[] args) {
		ShareMarket shareMarket = new ShareMarket();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				shareMarket.readIciciBond();
				shareMarket.readSbiBond();
			}
		}).start();

		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shareMarket.writeBondValue(750, 1500);

		}).start();
	}
}

class ShareMarket {
	private int iciciBond = 500;
	private int sbiBond = 900;

	private ReadWriteLock readWriteLock;

	public ShareMarket() {
		readWriteLock = new ReentrantReadWriteLock();
	}

	public int readIciciBond() {
		readWriteLock.readLock().lock();
		int value = iciciBond;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The value of ICICI bond is: " + value);
		readWriteLock.readLock().unlock();
		return value;
	}

	public int readSbiBond() {
		readWriteLock.readLock().lock();
		int value = sbiBond;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The value of SBI bond is: " + value);
		readWriteLock.readLock().unlock();
		return value;
	}

	public void writeBondValue(int iciciBond, int sbiBond) {
		readWriteLock.writeLock().lock();
		this.iciciBond = iciciBond;
		this.sbiBond = sbiBond;
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ICICIBond: " + iciciBond + ", SBIBond: " + sbiBond);
		readWriteLock.writeLock().unlock();
	}

}