
public class FanTest2 {
	public static final int SLOW = 1;
	public static final int MEDIUM = 2;
	public static final int FAST = 3;
	private int speed = MEDIUM;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	public int getSpeed(){
		return speed;
	}
	
	public boolean getCondition(){
		return on;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public String getColor(){
		return color;
	}
	public String toString(boolean on, String color, double radius, int speed){
		if (on == false){
			String s = "fan is off,its color is " + color + " and its radius is " + radius;
			return s;
		}
		else{
			String s ="fan's speed is " + speed + " color is " + color + " and radius is " + radius;
			return s;
			
		}
	}
}
