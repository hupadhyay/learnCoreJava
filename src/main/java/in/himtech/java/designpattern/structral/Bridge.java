package in.himtech.java.designpattern.structral;

/**
 * The bridge design pattern is used to decouple the abstraction from its
 * implementation so that the two can vary independently.
 * 
 * @author Himanshu
 *
 */
public class Bridge {

	public static void main(String[] args) {
		ColorBox natraj = new Natraj();
		ColorBox camiline = new Camiline();
		
		Shape rectangle = new Rectangle(natraj);
		rectangle.makeShape();
		rectangle.colorShape();
		
		Shape circle = new Circle(camiline);
		circle.makeShape();
		circle.colorShape();
	}
}

interface ColorBox {
	void pickColor();

	void useColor();
}

class Camiline implements ColorBox {

	public void pickColor() {
		System.out.println("Picking of color from Camiline color box.");
	}

	public void useColor() {
		System.out.println("Using of color from Camiline color box.");
	}
}

class Natraj implements ColorBox {

	public void pickColor() {
		System.out.println("Picking of color from Natraj color box.");
	}

	public void useColor() {
		System.out.println("Using of color from Natraj color box.");
	}
}

interface Shape {
	void makeShape();

	void colorShape();
}

class Rectangle implements Shape {

	private ColorBox colorBox;

	public Rectangle(ColorBox colorBox) {
		this.colorBox = colorBox;
	}

	public void makeShape() {
		System.out.println("Drawing of rectangular shape.");
	}

	public void colorShape() {
		colorBox.pickColor();
		colorBox.useColor();
	}

}

class Circle implements Shape {

	private ColorBox colorBox;

	public Circle(ColorBox colorBox) {
		this.colorBox = colorBox;
	}

	public void makeShape() {
		System.out.println("Picking of color from Natraj color box.");
	}

	public void colorShape() {
		colorBox.pickColor();
		colorBox.useColor();
	}

}
