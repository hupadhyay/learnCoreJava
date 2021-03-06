package in.himtech.java.designpattern.behaviral;

/**
 * In strategy design pattern, The class or object change its behavior at
 * runtime based on the data/scenario. The best example to this pattern is that
 * we have a set of sorting algorithms. Some algorithm works best when dataset
 * is small and some are works good when the dataset is large and some are on
 * other scenario.
 * 
 * @author Himanshu
 *
 */
public class Strategy {
	public static void main(String[] args) {
		CalculationWork calWork = new CalculationWork();
		calWork.doInvestmentCalculation();
	}
}

interface MathematicalStrategy{
	double executeOperation(double x, double y);
}

class ArithmeticalStrategy implements MathematicalStrategy{

	@Override
	public double executeOperation(double x, double y) {
		System.out.println("Arithmetical Operation");
		return x + y;
	}
	
}

class AlgebricalStrategy implements MathematicalStrategy{

	@Override
	public double executeOperation(double x, double y) {
		System.out.println("Algebric Operation");
		return  x + y;
	}
	
}

class GeometricalStrategy implements MathematicalStrategy{

	@Override
	public double executeOperation(double x, double y) {
		System.out.println("Geometrical Operation");
		return x + y;
	}
	
}

class CalculationWork{
	
	private MathematicalStrategy mathStrategy;
	
	
	public void doInvestmentCalculation() {
		mathStrategy = new ArithmeticalStrategy();
		mathStrategy.executeOperation(4, 9);
		
		mathStrategy = new AlgebricalStrategy();
		mathStrategy.executeOperation(4, 9);
		
		mathStrategy = new GeometricalStrategy();
		mathStrategy.executeOperation(4, 9);
	}
	
}
