package in.himtech.java.designpattern.behaviral;
/**
 * Encapsulation of Command into an object is called command pattern.
 * @author Himanshu
 *
 */
public class CommandPattern {
	public static void main(String[] args) {
		Light light = new Light();
		Command lightOn = new LightOnCommand(light);
		Command lightOff = new LightOffCommand(light);
		
		RemoteControl remote = new RemoteControl();
		remote.setCommand(lightOn);
		remote.pressButton();
		
		remote.setCommand(lightOff);
		remote.pressButton();
	}
}

interface Command{
	void execute();
}

class LightOnCommand implements Command{
	private Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.lightOn();
	}
	
}

class LightOffCommand implements Command{
	private Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.lightOff();
	}
	
}

class Light{
	
	public void lightOn() {
		System.out.println("Light is ON");
	}

	public void lightOff() {
		System.out.println("Light is OFF");
	}
	
}

class RemoteControl{
	private Command command;
	
	void setCommand(Command command) {
		this.command = command;
	}
	
	void pressButton() {
		command.execute();
	}
}


