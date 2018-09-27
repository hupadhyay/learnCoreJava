package in.himtech.java.designpattern.structral;

/**
 * In decorator design pattern, User add new capabilities to the existing object
 * without altering/changing of its structure or state.
 * 
 * @author Himanshu
 *
 */
public class Deocrator {

	public static void main(String[] args) {

		Coffee coffee = new MilkDecorator(new SugarDecorator(new CoffeeDecorator(new AmericanCoffee())));
		System.out.println("Cost: " + (coffee.getCost() - coffee.getTax()));
		System.out.println("Ingredients: " + coffee.getIngredients());
		
		coffee = new MilkDecorator(new SugarDecorator(new CoffeeDecorator(new IndianCoffee())));
		System.out.println("Cost: " + (coffee.getCost() - coffee.getTax()));
		System.out.println("Ingredients: " + coffee.getIngredients());
		
		
		coffee = new MilkDecorator(new CoffeeDecorator(new IndianCoffee()));
		System.out.println("Cost: " + (coffee.getCost() - coffee.getTax()));
		System.out.println("Ingredients: " + coffee.getIngredients());
		
	}

}

abstract class Coffee {
	public abstract double getCost();

	public abstract String getIngredients();

	public double getTax() {
		return 0.1 * getCost();
	}
}

class AmericanCoffee extends Coffee {

	@Override
	public double getCost() {
		return 5.0;
	}

	@Override
	public String getIngredients() {
		return "	coffee power, water";
	}

}

class IndianCoffee extends Coffee {

	@Override
	public double getCost() {
		return 15.0;
	}

	@Override
	public String getIngredients() {
		return "coffee power, water, mashala";
	}

}

class CoffeeDecorator extends Coffee {
	private Coffee coffee;

	public CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double getCost() {
		return coffee.getCost();
	}

	@Override
	public String getIngredients() {
		return coffee.getIngredients();
	}

}

class SugarDecorator extends CoffeeDecorator {
	private CoffeeDecorator coffeeDecorator;

	public SugarDecorator(CoffeeDecorator coffeeDecorator) {
		super(coffeeDecorator);
		this.coffeeDecorator = coffeeDecorator;
	}

	@Override
	public double getCost() {
		return coffeeDecorator.getCost() + 2.0;
	}

	@Override
	public String getIngredients() {
		return coffeeDecorator.getIngredients() + ", sugar";
	}

}

class MilkDecorator extends CoffeeDecorator {
	private CoffeeDecorator coffeeDecorator;

	public MilkDecorator(CoffeeDecorator coffeeDecorator) {
		super(coffeeDecorator);
		this.coffeeDecorator = coffeeDecorator;
	}

	@Override
	public double getCost() {
		return coffeeDecorator.getCost() + 3.0;
	}

	@Override
	public String getIngredients() {
		return coffeeDecorator.getIngredients() + ", milk";
	}
}
