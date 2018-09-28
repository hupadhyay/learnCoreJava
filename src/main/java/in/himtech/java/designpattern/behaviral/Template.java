package in.himtech.java.designpattern.behaviral;

/**
 * The template pattern is used for defining a ways/templates to achieve some
 * functionality. It allow subclass to override/re-define some of its methods to
 * accomplished the task.
 * 
 * @author Himanshu
 *
 */
public class Template {
	public static void main(String[] args) {
		FoodTemplate foodTemplate = new Tea();
		foodTemplate.haveIt();
		
		foodTemplate = new Dinner();
		foodTemplate.haveIt();
	}

}

abstract class FoodTemplate{
	
	abstract void prepare();
	
	abstract void cook();
	
	abstract void serve();
	
	abstract void consume();
	
	public void haveIt() {
		prepare();
		cook();
		serve();
		consume();
	}
	
}

class Tea extends FoodTemplate{

	@Override
	void prepare() {
		System.out.println("pour water, tea leaf, milk and sugar");
	}

	@Override
	void cook() {
		System.out.println("boil it for 15 mins");
	}

	@Override
	void serve() {
		System.out.println("pour it into Cup.");
	}

	@Override
	void consume() {
		System.out.println("Drink it!");
	}
	
}

class Dinner extends FoodTemplate{

	@Override
	void prepare() {
		System.out.println("Prepare dinner: rice, pulse, curry and salad");
	}

	@Override
	void cook() {
		System.out.println("Cook rice, pulse, curry and cut salad");
	}

	@Override
	void serve() {
		System.out.println("Serve the dinner");
	}

	@Override
	void consume() {
		System.out.println("take the dinner");
	}
	
}
