package Lesson_2;

public class Fan//风扇类
{
	final int SLOW=1,MEDIUM=2,FAST=3;
	int speed=SLOW;
	boolean on=false;
	double radius=5;
	String color="blue";
	
	public Fan(){
		
	}//默认风扇无参构造方法
	
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
	}//四个访问器
	
	public int setSpeed(int speed) {
		this.speed=speed;
		return speed;
	}
	
	public boolean setOn(boolean on) {
		this.on=on;
		return on;
	}
	
	public double setRadius(double radius) {
		this.radius=radius;
		return radius;
	}
	
	public String setColor(String color) {
		this.color=color;
		return color;
	}//四个修改器
	
	public String toString() {
		String result;
		if(on) {
			result=""+speed+" "+color+" "+radius;
			return result;
		}
		result="fan is off"+" "+color+" "+radius;
		return result;
	}//返回一串字符串
}
