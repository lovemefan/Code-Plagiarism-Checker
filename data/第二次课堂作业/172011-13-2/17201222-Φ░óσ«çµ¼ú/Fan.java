package nice;

public class Fan {
	public static void main(String[] args){
		Fan fan1 = new Fan();
		fan1.turnOn();
		fan1.setSpeed(3);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		Fan fan2 = new Fan();
		fan2.setSpeed(2);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.turnOff();
		System.out.println(fan1.toString());
		System.out.println(fan2.toString());
	}
	int SLOW = 1;
	int MEDIUM = 2;
	int FAST = 3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	public Fan(){
		
	}
	public void turnOn(){
		on = true;
	}
	public void turnOff(){
		on = false;
	}
	public void setOn(boolean newOn){
		on = newOn;
	}
	public void setSpeed(int newSpeed){
		if(newSpeed >=1 && newSpeed <=3)
			speed = newSpeed;
	}
	public void setRadius(double newRadius){
		radius = newRadius;
	}
	public void setColor(String newColor){
		color = newColor;
	}
	public double getRadius(){
		return radius;
	}
	public int getSpeed(){
		return speed;
	}
	public String getColor(){
		return color;
	}
	public boolean getOn(){
		return on;
	}
	public  String toString(){
		if(on == true)
	     return "" + "speed is " + speed + " " + "color is " + color + " " + "radius is " + radius + " is on ";
		else
		 return "" + "fan is off" +" "+ "speed is " + speed + " " + "color is " + color + " " + "radius is " + radius;
				
	}
	
	
	}

