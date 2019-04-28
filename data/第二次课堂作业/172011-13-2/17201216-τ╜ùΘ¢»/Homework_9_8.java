import java.util.Scanner;

public class Homework_9_8 {
	public static void main(String[] args) {
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		
		fan1.setSpeed(Fan.FAST);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		
		fan2.setSpeed(Fan.MEDIUM);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.setOn(false);
		
		System.out.println(fan1.toString());
		System.out.println(fan2.toString());
	}
}

class Fan {
	static int SLOW = 1;
	static int MEDIUM = 2;
	static int FAST = 3;
	private int speed = SLOW;
	boolean on = true;
	double radius = 5;
	String color = "blue";
	
	Fan() {
		
	}
	void setSpeed(int speed) {
		this.speed = speed;
	}
	void setOn(boolean on) {
		this.on = on;
	}
	void setRadius(double radius) {
		this.radius = radius;
	}
	void setColor(String color) {
		this.color = color;
	}
	int getSpeed() {
		return speed;
	}
	boolean getOn() {
		return on;
	}
	double getRadius() {
		return radius;
	} 
	String getColor() {
		return color;
	}
	public String toString() {
		String temp = "";
		if (on == true) {
			temp = "speed = " + speed + ", color = " + color + ", radius = " + radius;
		}
		else {
			temp = "fan is off";
		}
		
		return temp;
	}
}