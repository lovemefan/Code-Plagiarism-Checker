package classtest;

import java.util.Scanner;

public class test9_8 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Fan fan = new Fan();
		System.out.println("fan is off   " + fan.color + "   " + fan.getRadius());
		System.out.print("Do you want to turn on the fan ?");
		fan.setOn(input.nextBoolean());
		System.out.print("Please adjust the speed,color,radius:");
		fan.setSpeed(input.nextInt());
		fan.setColor(input.next());
		fan.setRadius(input.nextDouble());
		System.out.println(fan.toString());
		if(input != null) {
			input.close();
		}
	}
}

class Fan {
	public int SLOW, MEDIUM, FAST;
	private int speed;
	private boolean on;
	private double radius;
	public String color;
public Fan() {
	SLOW = 1;
	MEDIUM = 2;
	FAST = 3;
	speed = SLOW;
	on = false;
	radius = 5;
	color = "blue";
   }
    public void setOn(boolean on){
    	this.on = on;
    }
    public void setSpeed(int speed){
    	this.speed = speed;
    }
    public void setColor(String color){
    	this.color = color;
    }
    public double getRadius(){
    	return radius;
    }
    public void setRadius(double radius){
    	this.radius = radius;
    }
    public String toString(){
    	if(on == true)
    		return "speed: "+speed + ",radius: " + radius + ", color: " + color + "";
    	else
    		return "fan is off   color: "+ color + ",radius: " + radius + "";
    }
}

  