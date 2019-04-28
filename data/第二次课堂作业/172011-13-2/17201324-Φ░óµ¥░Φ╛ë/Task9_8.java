package task;

public class Task9_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fan a=new Fan();
		Fan b=new Fan();
		a.setSpeed(a.FAST);
		a.setRadius(10);
		a.setColor("yellow");
		a.setOn(true);
		b.setOn(false);
		b.setColor("blue");
		b.setRadius(5);
		b.setSpeed(a.MEDIUM);//变量的调用也要用.
		System.out.println(a.toString());
		System.out.println(b.toString());
	}

}
class Fan{
	final int SLOW=1;
	final int MEDIUM=2;
    final int  FAST=3;
	private int speed=SLOW;
	private boolean on=false;
	private double radius=5;
	String color="blue";
	public Fan() {
		
	}
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	public void setOn(boolean on) {
		this.on=on;
	}
	public void setRadius(double radius) {
		this.radius=radius;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public int getSpeed() {
		return speed;
	}
	public boolean getOn() {
		return on;
	}
	public double getRadius() {
		return radius;
	}
	public String getColor() {
		return color;
	}
	public String toString() {
		if (on) {
			return "The speed is "+speed+" radius is "+radius+" color is "+color;
		}else {
			return "fan is off";
		}
	}
}