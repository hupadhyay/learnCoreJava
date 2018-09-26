package in.himtech.java.designpattern.creational;

/**
 * The factory design pattern is used to create various objects based on client input 
 * without exposing the creation logic to the client. 
 * This design pattern is also helped to track/logged/managed the created object.
 * @author Himanshu
 *
 */
public class Factory {
	
	public static void main(String[] args) {
		Shape shape = ShapeFactory.getShape("circle");
		shape.drawShape();
		
		shape = ShapeFactory.getShape("rectangle");
		shape.drawShape();
		
		shape = ShapeFactory.getShape("cylinder");
	}
	
}


interface Shape{
	void drawShape();
}

class Rectangle implements Shape{

	public void drawShape() {
		System.out.println("Drawing the ractangle object.");
	}
	
}

class Square implements Shape{

	public void drawShape() {
		System.out.println("Drawing the square object.");
	}
	
}

class Circle implements Shape{

	public void drawShape() {
		System.out.println("Drawing the circle object.");
	}
	
}

class ShapeFactory {
	
	public static Shape getShape(String shapeName) {
		
		if(shapeName.equalsIgnoreCase("circle")) {
			return new Circle();
		} else if(shapeName.equalsIgnoreCase("square")) {
			return new Square();
		} else if(shapeName.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		} else {
			throw new IllegalArgumentException("Shape object is not available.");
		}
		
	}
}
