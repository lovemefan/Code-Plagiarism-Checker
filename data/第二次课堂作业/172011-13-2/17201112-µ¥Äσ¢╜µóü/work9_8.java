package assignments1;

public class work9_8 {
	public static void main(String[] args){
		Fan fan1 = new Fan();
		fan1.setSpeed(3);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.turnOn();
		System.out.println(fan1.toString());
		
		Fan fan2 = new Fan();
		fan2.setSpeed(2);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.turnOff();
		System.out.println(fan2.toString());
	}

}
class Fan{
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private int speed = SLOW;
	boolean on = false;
	private double radius = 5;
	String color ="blue";
	public Fan(){
	}
	void turnOn(){
		on = true;
	}
	void turnOff(){
		on = false;
	}
	public String toString(){
		if(on)
			return "speed: "+speed+" color: "+color+" radius: "+radius;
		else
			return "fan is off,"+" color: "+color+" radius: "+radius;
	}
	
	void setSpeed(int speed){
		this.speed = speed;
	}
	void setRadius(int radius){
		this.radius = radius;
	}
	void setColor(String color){
		this.color = color;
	}
}