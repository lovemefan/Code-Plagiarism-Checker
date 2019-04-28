
public class Fan {
	public static final int SLOW=1;
	public static final int MEDIUM=2;
	public static final int FAST=3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius=5;
	private String color="bule";
	
	public int getSpeed(){
		return this.speed;
	}
	public boolean getOn(){
		return this.on;
	}
	
	public double getRadius(){
		return this.radius;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public void setOn(boolean on){
		this.on = on;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	public Fan(){
		
	}
	public String toString(){
		if (this.on==true){
			return this.speed + this.color + this.radius;
		}else{
			return "fan is off" + this.color + this.radius;
		}
	}
}
