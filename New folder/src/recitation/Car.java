package recitation;

public class Car {
	private String name;
	private int velocity;
		
	public Car(String name, int velocity) {
		this.name = name;
		this.velocity = velocity;
	}
	
	@Override
	public String toString() {
		return "name: " + name + " -- velocity: " + Integer.toString(velocity);
	}
}
