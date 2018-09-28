package in.himtech.java.designpattern.behaviral;

import java.util.Random;

/**
 * The state design pattern defines the behavior of an object is changed on the
 * base of its state. The very good example of the state design pattern is the
 * State of Thread API or stats of Hibernate bean.
 * 
 * @author Himanshu
 *
 */
public class State {
	public static void main(String[] args) {
		H1BVisa h1b = new H1BVisa();
		h1b.sendForApproval();
	}
}

interface Emotional{
	void expressEmotion();
}

class HappyState implements Emotional{

	public void expressEmotion() {
		System.out.println("I am very happy. My visa got approved.");
	}
}

class SadState implements Emotional{

	public void expressEmotion() {
		System.out.println("I am very sad. My visa got denial.");
	}
}

class ConfuseState implements Emotional{

	public void expressEmotion() {
		System.out.println("I am confused. I got RFE.");
	}
}

class H1BVisa{
	private Random random = new Random();
	private Emotional emotional = null;
	
	public void sendForApproval() {
		String response = getResponseFromUSCIS();
		
		if(response.equalsIgnoreCase("approved")) {
			emotional = new HappyState();
			emotional.expressEmotion();
		} else if(response.equalsIgnoreCase("denial")) {
			emotional = new SadState();
			emotional.expressEmotion();
		} else {
			emotional = new ConfuseState();
			emotional.expressEmotion();
			System.out.println("send requested document and wait for reply.");
			sendForApproval();
		}
		
	}

	private String getResponseFromUSCIS() {
		int value = random.nextInt(3);
		if(value == 0) {
			return "approved";
		} else if(value == 1) {
			return "denial";
		} else {
			return "RFE";
		}
	}
}
