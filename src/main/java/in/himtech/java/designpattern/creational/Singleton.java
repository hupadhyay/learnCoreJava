package in.himtech.java.designpattern.creational;

/**
 * The singleton design pattern is used when we want to maintain a single instance of an object in the whole application. 
 * There is two type of singleton instance
 * <li>
 * 	<ul>Satic Singleton</ul>
 * 	<ul>Dynamic Singleton</ul>
 * </li>
 * In a static singleton, we have a class which has all static methods i.e. java.lang.Math.
 * In a dynamic singleton, we have a factory method which is responsible for maintaining the single instance of the class.
 * We have another good approach of using an inner class. With this approach, we can achieve lazy loading and thread safety 
 * in a very novice way. 
 * In this example, we are achieving the singleton using the inner class technique.
 * 
 * @author Himanshu
 *
 */
public class Singleton {
	
	private Singleton() {
		//TODO: code to instantiate an instance.
	}
	
	public static Singleton getInstance() {
		return SingleInstance.instance;
	}
	
	private static class SingleInstance {
		private static Singleton instance = new Singleton();
	}

}
