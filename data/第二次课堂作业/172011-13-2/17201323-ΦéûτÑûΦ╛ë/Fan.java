package work;

public class Fan {
	private final short SLOW = 1;
	private final short MEDIUM = 2;
	private final short FAST = 3;
	private int speed;
	private double radius;
	private boolean on;
	private String color;
	Fan(){
		color = "blue";
		radius = 5;
		speed = SLOW;
		on = false;
	}
	public void turnOff(){
		on = false;
	}
	public void turnon(){
		on = true;
	}
	public void setRadius(double newRadius){
		radius = newRadius;
	}
	public double getRadius(){
		return radius;
	}
	public void setSpeed(int newSpeed){
	    speed = newSpeed;
	}
	public int getSpeed(){
		return speed;
	}
	public void setColor(String newColor){
		color = newColor;
	}
	public String getColor(){
		return color;
	}
	public void ToString(){
		if (on)
			System.out.println( "speed: " + speed + "color: " + color + "radiius: "+ radius);
		else
			System.out.println("fan is off");
	}

}
