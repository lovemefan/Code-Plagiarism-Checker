package project2;

public class P9_8 {

	public static void main(String[] args) {
		Fan fan1=new Fan();
		Fan fan2=new Fan();
		fan1.setSpeed(3);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		fan2.setSpeed(2);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.setOn(false);
	System.out.println("fan1 is: "+fan1.toString()+"\n"+"fan2 is: "+fan2.toString());
	

	}

}
class Fan{
	final int SLOW=1;
	final int MEDIUM=2;
	final int FAST=3;
	private int speed=SLOW;
	private boolean on=false;
	private double radius=5;
	String color="blue";
	//访问器
	public int getSpeed() {
		return speed;
	}
	public boolean getOn() {
		return on;
	}
	public double getRadius() {
		return radius;
	}
	String getColor() {
		return color;
	}
	//修改器
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	public void setOn(boolean on) {
		this.on=on;
	}
	public void setRadius(double radius) {
	    this.radius=radius;
	}
	void setColor(String color) {
		this.color=color;
	}
	//构造默认风扇
	Fan(){

	}
	//描述风扇状态的方法
	public String toString() {
		String str;
		if(on==true) {
			str=getSpeed()+" "+getColor()+" "+getRadius();
		}
		else {
			str="fan is off "+getColor()+" "+getRadius();
		}
		return str;
		}
}