
public class FanMain {

	public static void main(String[] args) {
		Fan fan1 = new Fan();
		fan1.setSpeed(fan1.FAST);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		System.out.println(fan1.toString());
		
		Fan fan2 = new Fan();
		fan2.setSpeed(fan2.MEDIUM);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.setOn(false);
		System.out.println(fan2.toString());
	}

}


class Fan{
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
	public int getSpeed() {
		return speed;
	}
	
	public boolean getOn() {
		return on;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public String getColor() {
		return color;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		String str1 = "color is " + color + ", raduis is " + radius;
		String str = "";
		if(on) {
			str = "speed is " + speed + ", ";
		}
		str += str1;
		return str;
	}
}