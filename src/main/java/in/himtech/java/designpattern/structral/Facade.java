package in.himtech.java.designpattern.structral;

/**
 * Facade design pattern hide the complexities of the system and provide an easy
 * interface to client. The client use this interface to control the system.
 * 
 * @author Himanshu
 *
 */
public class Facade {
	public static void main(String[] args) {
		Car car = new Car();
		car.start();
		car.run();
		car.changeEvent();
		car.stop();
	}
}

class Engine{
	public void startEngine() {
		System.out.println("Engine has started.");
	}
	
	public void stopEngine() {
		System.out.println("Engine has stopped.");
	}
	
	public void runEngine() {
		System.out.println("Engine is running.");
	}
}

class AC{
	public void startAC() {
		System.out.println("AC has started.");
	}
	
	public void stopAC() {
		System.out.println("AC has stopped.");
	}
	
	public void runAC() {
		System.out.println("AC is running.");
	}
	
	public void changeTemp() {
		System.out.println("Temperatre has been changed");
	}
}

class MusicSystem{
	public void startMusicSystem() {
		System.out.println("MusicSystem has started.");
	}
	
	public void stopMusicSystem() {
		System.out.println("MusicSystem has stopped.");
	}
	
	public void runMusicSystem() {
		System.out.println("MusicSystem is running.");
	}
	
	public void changeVolume() {
		System.out.println("Volume has been changed");
	}
}

class Car{
	Engine engine = null;
	AC ac =  null;
	MusicSystem ms = null;
	
	public Car() {
		engine = new Engine();
		ac = new AC();
		ms = new MusicSystem();
	}
	
	public void start() {
		engine.startEngine();
		ac.startAC();
		ms.startMusicSystem();
	}
	
	public void stop() {
		engine.stopEngine();
		ac.stopAC();
		ms.stopMusicSystem();
	}
	
	public void run() {
		engine.runEngine();
		ac.runAC();
		ms.runMusicSystem();
	}
	
	public void changeEvent() {
		ac.changeTemp();
		ms.changeVolume();
	}
}
