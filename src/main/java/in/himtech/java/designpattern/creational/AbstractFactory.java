package in.himtech.java.designpattern.creational;

/**
 * AbstractFactory DP is one level up to Factory DP. It will produce a factory
 * object which is further used to generate an object of the particular type.
 * This is mainly used to select/create Theme and example of AbstractFactory is
 * UIManager in Java API.
 * 
 * @author Himanshu
 *
 */
public class AbstractFactory {
	
	public static void main(String[] args) {
		MathematicalOperations mo = MathemeticOperationFactory.getMathematicalOperationalFactory("arithmetic");
		Addition addition = mo.add();
		addition.add(4, 6);
	}
	
}

interface MathematicalOperations{
	Addition add();
	Substraction substract();
}

interface ArithmeticOperations extends MathematicalOperations{

}

interface AlgebraOperations extends MathematicalOperations{
	
}

interface GeometryOperations extends MathematicalOperations{
	
}

class ArithmethicOperationFactory implements ArithmeticOperations{

	public Addition add() {
		return new ArithmethicAddition();
	}

	public Substraction substract() {
		return new ArithmethicSubstraction();
	}
	
}

class AlgebraOperationFactory implements ArithmeticOperations{

	public Addition add() {
		return new AlgebricAddition();
	}

	public Substraction substract() {
		return new AlgebricSubstraction();
	}
	
}

class GeometryOperationFactory implements ArithmeticOperations{

	public Addition add() {
		return new GeometricAddition();
	}

	public Substraction substract() {
		return new GeometricSubstraction();
	}
	
}

class MathemeticOperationFactory {
	
	public static MathematicalOperations getMathematicalOperationalFactory(String factoryName) {
		
		if(factoryName.equalsIgnoreCase("arithmetic")) {
			return new ArithmethicOperationFactory();
		} else if(factoryName.equalsIgnoreCase("algebra")) {
			return new AlgebraOperationFactory();
		} else if(factoryName.equalsIgnoreCase("geometry")) {
			return new GeometryOperationFactory();
		} else {
			throw new IllegalArgumentException("Factory name doen't exists");
		}
		
	}
}

interface Addition{
	void add(int a, int b);
}

interface Substraction{
	void substract(int a, int b);
}

class ArithmethicAddition implements Addition{

	public void add(int a, int b) {
		System.out.printf("Peforming arithmethic add operation on %d and %d%n", a, b);
	}
	
}

class ArithmethicSubstraction implements Substraction{

	public void substract(int a, int b) {
		System.out.printf("Peforming arithmethic substract operation on %d and %d%n", a, b);
	}
	
}

class AlgebricAddition implements Addition{

	public void add(int a, int b) {
		System.out.printf("Peforming Algebric add operation on %d and %d%n", a, b);
	}
	
}

class AlgebricSubstraction implements Substraction{

	public void substract(int a, int b) {
		System.out.printf("Peforming Algebric substract operation on %d and %d%n", a, b);
	}
	
}

class GeometricAddition implements Addition{

	public void add(int a, int b) {
		System.out.printf("Peforming Geometric add operation on %d and %d%n", a, b);
	}
	
}

class GeometricSubstraction implements Substraction{

	public void substract(int a, int b) {
		System.out.printf("Peforming Geometric substract operation on %d and %d%n", a, b);
	}
	
}