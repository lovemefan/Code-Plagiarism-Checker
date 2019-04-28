package work1015;
	
public class Fan {

	final static int SLOW=1;
	final static int MEDIUM=2;
	final static int FAST=3;
	private int speed=SLOW;
	private boolean on=false;
	private double radius=5;
	private String color="blue";
	
	public int getSpeed(){//四组访问函数与修改函数
		return speed;
	}
	public void setSpeed(int speed){//1
		this.speed=speed;
	}
	public boolean getOn(){
		return on;
	}
	public void setOn(boolean on){//2
		this.on=on;
	}
	public double getRadius(){
		return radius;
	}
	public void setRadius(double radius){//3
		this.radius=radius;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){//4
		this.color=color;
	}
	
	public Fan(){      //一个创建默认风扇的无参构造方法
		speed=SLOW;
		on=false;
		radius=5;
		color="blue";
	}
	public String toString(boolean on){//返回描述电扇的字符串
		if(on!=false)
		{
			String s= "speed:"+speed+" color:"+color+" radius:"+radius;
			return s;
		}
		else 
		{
			String s="fan is off"+" color:"+color+" radius:"+radius;
			return s;
		}
		
	}
	/*
	public static void main(String args[]){
		Fan fan=new Fan();
		fan.setSpeed(FAST);
		fan.setRadius(10);
		fan.setColor("yellow");
		fan.setOn(true);
		
		Fan fan2=new Fan();
		fan2.setSpeed(MEDIUM);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.setOn(false);
		
		System.out.println(fan.toString(fan.getOn()));
		System.out.println(fan2.toString(fan2.getOn()));
	}*/
}



