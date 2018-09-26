package in.himtech.java.designpattern.creational;

/**
 * A prototype design pattern is used to create duplicate/copy/clone of an
 * existing object. This design pattern is used when creating the new object is
 * costly and cloning of an object is performance boots. There is two type of
 * cloning:
 * <li>
 * <ol>
 * Shallow Cloning
 * </ol>
 * <ol>
 * Deep Cloning
 * </ol>
 * </li>
 * 
 * In shallow cloning, the cloned object and original object share the same
 * referenced object. In deep cloning, the cloned object have their
 * separate copy of the referenced object.
 * 
 * @author Himanshu
 *
 */
public class Prototype {

	public static void main(String[] args) {
		Prototype prototype = new Prototype();
		prototype.prototypeDPDemo();
	}

	private void prototypeDPDemo() {
		Employee emp = new Employee("Himanshu", 32);
		System.out.println("Original Object: " + emp);
		try {
			Employee clonnedEmp = (Employee)emp.clone();
			System.out.println("Clonned Object: " + clonnedEmp);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			System.out.println("Clonned not supported!");
		}
	}

	class Employee implements Cloneable{
		private String name;
		private int age;

		public Employee(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			
			return super.clone();
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", age=" + age + "]";
		}

	}
}
