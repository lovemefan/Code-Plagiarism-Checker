import java.util.Scanner;

public class Test9_8 {
	public static void main (String[]args){
	Fan fan1 = new Fan();
	Fan fan2 = new Fan();
	Scanner input = new Scanner(System.in);
	System.out.println("Enter speed,state,radius and color of the fan1");
	System.out.println("speed:(1,2,3)");
	fan1.setSpeed(input.nextDouble());
	System.out.println("state:(true or false)");
	fan1.setOn(input.nextBoolean());
	System.out.println("radius:");
	fan1.setRadius(input.nextDouble());
	System.out.println("color:");
	fan1.setColor(input.next());
	System.out.println("Enter speed,state,radius and color of the fan2");
	System.out.println("speed:(1,2,3)");
	fan2.setSpeed(input.nextDouble());
	System.out.println("state:(true or false)");
	fan2.setOn(input.nextBoolean());
	System.out.println("radius:");
	fan2.setRadius(input.nextDouble());
	System.out.println("color:");
	fan2.setColor(input.next());
	System.out.println(fan1.toString()+fan2.toString()); 
	}
}
class Fan{
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private double speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	String color = "bule";
	Fan(){
		
	}
	void setSpeed(double speed){
		this.speed = speed;
	}
	void setOn(boolean on){
		this.on= on;
	}
	void setColor(String color){
		this.color = color;
	}
	void setRadius(double radius){
		this.radius = radius;
	}
	double getSpeed(double speed){
		return speed;
	}
	boolean getOn(boolean on){
		return on;
	}
	String getradius(String color){
		return color;
	}
	
	double getRaduis(double radius){
		return radius;
	}
	
	public String toString() {
		String infor1 = "the speed of fan is "+speed+"the color is "+color+"the radius is"+radius;
		String infor2 = "fan is off ,color is "+color+"radius is "+radius;
		if(on) 
			return infor1;
		else 
			return infor2;
	}
}
