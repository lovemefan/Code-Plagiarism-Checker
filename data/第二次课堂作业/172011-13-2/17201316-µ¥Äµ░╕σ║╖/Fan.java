
public class Fan {
	final static int SLOW = 1;
	final static int MEDIUM = 2;
	final static int FAST = 3;
	private int speed;
	private boolean on;
	private double radius;
	String color;
	
	Fan(){
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setSpeed(int newSpeed){
		this.speed = newSpeed;
	}
	
	public boolean getOn(){
		return on;
	}
	
	public void setOn(boolean newOn){
		this.on = newOn;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setRadius(double newRadius){
		this.radius = newRadius;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String newColor){
		this.color = newColor;
	}
	public String toString(){
		if(this.on == true){
			return speed + " " + color + " " + radius + "";
		}
		else {
			return "fan is off";
		}
	}
}
