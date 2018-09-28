package in.himtech.java.designpattern.structral;

/**
 * Adaptor design pattern helps two incompatible system to communicate each
 * others.
 * 
 * @author Himanshu
 *
 */
public class Adaptor {
	public static void main(String[] args) {
		AmericanPlug americanPlug = new IndoAmericanAdaptor(new IndianSocketImpl());
		System.out.println("Voltage: " + americanPlug.getVoltage());
		System.out.println("Current: " + americanPlug.getCurrent());
		System.out.println("phase: " + americanPlug.fromPhase());
	}
}

interface IndianSocket {
	double voltage();

	double current();

	String phase();
}

class IndianSocketImpl implements IndianSocket {

	public double voltage() {
		return 225.0;
	}

	public double current() {
		return 6.0;
	}

	public String phase() {
		return "main";
	}
}

interface AmericanPlug {
	double getVoltage();

	double getCurrent();

	String fromPhase();
}

class IndoAmericanAdaptor implements AmericanPlug {

	private IndianSocket indianSocket;

	public IndoAmericanAdaptor(IndianSocket socketImpl) {
		this.indianSocket = socketImpl;
	}

	public double getVoltage() {
		return indianSocket.voltage();
	}

	public double getCurrent() {
		return indianSocket.current();
	}

	public String fromPhase() {
		return indianSocket.phase();
	}

}
