package exercise;

public class Fan {
	public static void main (String[] args) {
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		
		fan1.setSpeed(3);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setStatus(true);
		fan2.setSpeed(2);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.setStatus(false);
		System.out.println("fan1: " + fan1.toString());
		System.out.println("fan2: " + fan2.toString());
	}
	
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	
	public Fan() {
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
	}
	public String toString() {
		String result;
		if (this.on == false)
			result = "The fan is off!";
		else {
			result = "Speed:" + this.speed + "  Radius:" + this.radius + "  Color:" + this.color;
		}
		return result;
	}
	public int getSpeed() {
		return speed;
	}
	public boolean getStatus() {
		return on;
	}
	public double getRadius() {
		return radius;
	}
	public String getColor() {
		return color;
	}
	
	public void setSpeed(int s) {
		switch(s) {
		case 1:
			this.speed = SLOW;
			break;
		case 2:
			this.speed = MEDIUM;
			break;
		case 3:
			this.speed = FAST;
		default :
			break;
		}
	}
	public void setStatus(boolean on) {
		this.on = on;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
