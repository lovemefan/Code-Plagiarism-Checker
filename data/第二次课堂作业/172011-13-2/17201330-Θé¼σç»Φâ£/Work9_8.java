package lab2;

public class Work9_8 implements speedLeval{

	public static void main(String[] args) {
		Fan fan1 = new Fan();
		fan1.setSpeed(FAST);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		Fan fan2 = new Fan();
		fan2.setSpeed(MEDIUM);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.setOn(false);
		System.out.println("fan1: \n" +fan1.toString());
        System.out.println("fan2: \n" + fan2.toString());

	}

}

interface speedLeval{
	int SLOW = 1;
    int MEDIUM = 2;
    int FAST = 3;
}

class Fan implements speedLeval{
	private int speed = SLOW;
	private boolean on = false;
	private  double radius = 5;
    String color = "blue";
    
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean geton() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Fan(){
		
	}
	
	public String toString(){
		if (on) {
			return "speed: " + speed + "\ncolor: " + color + "\nradius: " + radius;
		}
		else {
			return "fan is off" + "\ncolor: " + color + "\nradius: " + radius;
		}
	}
	
}
