package ื๗าต;

public class TestFan{
	public static void main(String[] args){
		
		Fan fan1=new Fan();
		fan1.setSpeed(3);
		fan1.setRadius(10);
	
		fan1.setColor("blue");
		fan1.setOn(true);
		System.out.println(fan1.toString());
		
		Fan fan2=new Fan();
		fan2.setSpeed(2);
		fan2.setRadius(5);
		fan2.setColor("yellow");
		fan2.setOn(false);
		System.out.println(fan2.toString());
		
		
	}

}
class Fan{

	final int SLOW=1;
	final int MEDIUM=2;
	final int FAST=3;
	int speed=1;
	boolean on=false;
	double radius=5;
	String color="yellow";
	public String newColor;
    Fan(){
		
	}
    int getSpeed() {
    	return speed;
    	}
    boolean isOn() {
    	return on;
    	}

    double getRadius() {
    	return radius;
    	}
    
    public String getColor() {
    	return color;
    	}
	void setSpeed(int newSpeed){
		if(newSpeed==1||newSpeed==2||newSpeed==3)
			speed=newSpeed;
	
	}
	void setOn(boolean newOn){
		on=newOn;
	}
	void setRadius(double newRadius){
		radius=newRadius;
	}
    void setColor(String newColor){
		color=newColor;
	}
	public String toString(){
		if(on)
		return "fan's speed is "+speed+" color is "+color+" radius is "+radius;
		else
		return "fan is off and fan's color is "+color+" radius is "+radius;
			
	}
}
