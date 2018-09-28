package in.himtech.java.designpattern.behaviral;

import java.util.ArrayList;
import java.util.List;

/**
 * The observer design pattern is used where one object is get notified and take
 * some action when there is some changes/generate events in another object.
 * 
 * @author Himanshu
 *
 */
public class Observer {
	public static void main(String[] args) {
		Subject ws = new WeatherStation();
		ws.registerSubscriber(new NewsReport());
		ws.registerSubscriber(new WeatherReport());
		
		ws.changeTemperature(45.0f);
	}
}

interface Subject {
	void changeTemperature(float newTemperature);

	void registerSubscriber(Subscriber observer);

	void removeSubscriber(Subscriber observer);

	void notifySubscribers();
}

class WeatherStation implements Subject {

	private float temperature;
	private List<Subscriber> listSubscriber;

	public WeatherStation() {
		temperature = 25.0f;
		listSubscriber = new ArrayList<Subscriber>();
	}

	public void changeTemperature(float newTemperature) {
		temperature = newTemperature;
		notifySubscribers();
	}

	public void registerSubscriber(Subscriber observer) {
		listSubscriber.add(observer);
	}

	public void removeSubscriber(Subscriber observer) {
		listSubscriber.remove(observer);
	}

	public void notifySubscribers() {
		listSubscriber.forEach(subs -> subs.updateChange(temperature));
	}

}

interface Subscriber {
	void updateChange(float value);
}

class WeatherReport implements Subscriber {

	public void updateChange(float value) {
		System.out.println("Weather Report: Update Temperature is : " + value);
	}

}

class NewsReport implements Subscriber {

	public void updateChange(float value) {
		System.out.println("News Report: Update Temperature is : " + value);
	}

}
