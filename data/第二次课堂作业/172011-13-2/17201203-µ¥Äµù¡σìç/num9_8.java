package ¿ÎÌÃ×÷Òµ;

public class num9_8 {
	public static void main(String[] args) {
		Fan a,b;
		a = new Fan();
		b = new Fan();
		
		a.setSpeed(3);
		a.setRadius(10);
		a.setColor("yellow");
		a.turnOn();
		a.ToString();		
		
		b.setSpeed(2);
		b.setColor("blue");
		b.turnOff();
		b.ToString();
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



