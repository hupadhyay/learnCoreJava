package in.himtech.java.designpattern.creational;

import in.himtech.java.designpattern.creational.Computer.ComputerBuilder;

/**
 * Builder design pattern is used for creating of complex object in various
 * steps. A good example of builder design pattern in java API is StringBuilder
 * and StringBuffer.
 * 
 * @author Himanshu
 *
 */
public class Builder {
	public static void main(String[] args) {
		ComputerBuilder compBuilder = new Computer.ComputerBuilder();
		Computer computer = compBuilder.configureRam().configureHdd().configureProcessor().configureGraphics()
				.installOS().build();
		System.out.println(computer);
	}
}

class Computer {

	private String ram;
	private String hdd;
	private String graphics;
	private String processor;
	private OperatingSystem os;

	private Computer() {

	}

	public static class ComputerBuilder {
		private Computer computer = null;

		public ComputerBuilder() {
			computer = new Computer();
		}

		public ComputerBuilder configureRam() {
			computer.ram = "8 GB";
			return this;
		}

		public ComputerBuilder configureHdd() {
			computer.hdd = "2 TB";
			return this;
		}

		public ComputerBuilder configureProcessor() {
			computer.processor = "I9 3rd Generation";
			return this;
		}

		public ComputerBuilder configureGraphics() {
			computer.graphics = "NVIDIA 2 GB";
			return this;
		}

		public ComputerBuilder installOS() {
			computer.os = new OperatingSystem("window 10 Pro", "window");
			return this;
		}

		public Computer build() {
			return computer;
		}
	}

	@Override
	public String toString() {
		return "Computer [ram=" + ram + ", hdd=" + hdd + ", graphics=" + graphics + ", processor=" + processor + ", os="
				+ os + "]";
	}

}

class OperatingSystem {

	private String osName;
	private String osType;

	public OperatingSystem(String osName, String osType) {
		super();
		this.osName = osName;
		this.osType = osType;
	}

	@Override
	public String toString() {
		return "OperatingSystem [osName=" + osName + ", osType=" + osType + "]";
	}
}
