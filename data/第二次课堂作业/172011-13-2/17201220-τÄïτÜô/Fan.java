package three;

public class Fan {
	final short SLOW = 1;
	final short MEDIUM = 2;
	final short FAST = 3;
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	Fan(){
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
	}
	
	public void turnOn(){
		on = true;
	}
	public void turnOff(){
		on =false;
	}
	public void setRadius(double newRadius){
		radius = newRadius;
	}
	public double getRadius(){
		return radius;
	}
	public void setColor(String newColor){
		color = newColor;
	}
	public String getColor(){
		return color;
	}
	public void setSpeed(int newSpeed){
		speed = newSpeed;
	}
	public int getSpeed(){
		return speed;
	}
	public String toString(){
		if (on){
			System.out.println("speed is " + speed + ". color is " + color + ". radius is " + radius);
		}
		else{
			System.out.println("fan is off" + ". speed is " + speed + ". color is " + color + ". radius is " + radius);
		}
		return null;
	}
	
}