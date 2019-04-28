package mayday001;

public class Fan {
	public static void main(String[] args) {
		newFan fan1,fan2;
		fan1 = new newFan();
		fan2 = new newFan();
		
		fan1.setSpeed(3);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.turnOn();
		fan1.ToString();		
		
		fan2.setSpeed(2);
		fan2.setColor("blue");
		fan2.turnOff();
		fan2.ToString();
	}
}

class newFan{
	private final int SLOW = 1;
	private final int MEDIUM = 2;
	private final int FAST = 3;
	private boolean on;
	private int speed;
	private double radius;
	private String color;
	newFan(){
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
	public void setColor(String newColor){
		color=newColor;
	}
	
	public String getColor(){
		return color;
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
			System.out.println("fan is off   "+color+" " + radius);
	}
	
}