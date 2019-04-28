package work;

public class Fan {
	final int SLOW=1,MEDIUM=2,FAST=3;
	private int speed=SLOW;
	private boolean on=false;
	private double radius=5;
	private  String color="blue";
	public String s;
    public void setSpeed(int speed){
    	this.speed=speed;
    }
    public void setOn(boolean on){
    	this.on=on;
    }
    public void setRadius(double radius){
    	this.radius=radius;
    }
    public void setColor(String color){
    	this.color=color;
    }
	public int getSpeed(){
		return speed;
	}
	public boolean getOn(){
		return on;
	}
	public double getRadius(){
		return radius;
	}
	public String getColor(){
		return color;
	}
    public Fan(){
    	
    }
    public String toString(){
    	if(on==false){
    		s="fan is off " + color + " " +radius;
    	}
    	else if(on==true){
    		s=speed + " "+ color  + " "+ radius;
    	}
    	return s;
    }
}
