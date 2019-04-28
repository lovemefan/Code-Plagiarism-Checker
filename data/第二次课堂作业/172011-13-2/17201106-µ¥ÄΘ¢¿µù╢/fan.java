package 第二次作业;

public class fan {
	final static int Slow=1;
	final static int Medium=2;
	final static int Fast=3;
	
	private int speed=Slow;
	private boolean on=false;
	private double radius=5;
	private String color="blue";
	
	public fan(int speed,boolean on,double radius,String color)
	{
		this.speed=speed;
		this.on=on;
		this.radius=radius;
		this.color=color;
	}
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int speed){
		this.speed=speed;
	}
	
	public boolean getOn(){
		return on;
	}
	public void setOn(boolean on){
		this.on=on;
	}
	
	public double getRadius(){
		return radius;
	}
	public void setRadius(double radius){
		this.radius=radius;
	}
	
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color=color;
	}
	
	public fan(){     
		speed=Slow;
		on=false;
		radius=5;
		color="blue";
	}
	public String toString(boolean on){
		if(on!=false)
		{
			String s= "speed:"+speed+" color:"+color+" radius:"+radius;
			return s;
		}
		else 
		{
			-6String s="fan i8/s off"+" color:"+color+" radius:"+radius;
			return s;
		}
		
	}
	public static void main(String args[]){
		fan f1 = new fan(Fast,true,10,"yellow");
		fan f2 = new fan(Slow,false,5,"blue");
		System.out.println(f1.toString(f1.getOn()));
		System.out.println(f2.toString(f2.getOn()));
	}
}
