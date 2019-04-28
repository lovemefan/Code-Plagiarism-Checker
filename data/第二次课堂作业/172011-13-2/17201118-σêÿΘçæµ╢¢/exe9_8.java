package test;

public class exe9_8 {
	public static void main(String[] args) {
		Fan f1,f2;
		f1 = new Fan();
		f2 = new Fan();
		
		f1.setSpeed(3);
		f1.setRadius(10);
		f1.setColor("yellow");
		f1.turnOn();
		f1.ToString();		
		
		f2.setSpeed(2);
		f2.setColor("blue");
		f2.turnOff();
		f2.ToString();
	}
}


class Fan{
	private final short SLOW = 1;
	private final short MEDIUM = 2;
	private final short FAST = 3;
	private boolean on;
	private int speed;
	private double radius;
	private String color;
	Fan(){
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
	}
	
	public void turnOn(){
		on=true;
	}
	public void turnOff(){
		on=false;
	}
	public void setRadius(double newRadius){
		radius=newRadius;
	}
	public double getRadius(){
		return radius;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String newColor){
		color=newColor;
	}
	
	public void setSpeed(int newSpeed){
		speed=newSpeed;
	}
	public int getSpeed(){
		return speed;
	}
	public void ToString(){
		if(on)
			System.out.println(speed+" "+color+" "+radius);
		else
			System.out.println("fan is off");
	}
	
}


