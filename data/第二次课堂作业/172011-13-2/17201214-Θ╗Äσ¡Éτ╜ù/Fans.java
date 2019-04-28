import java.util.*;

public class Fans {
	final public static int SLOW = 1;
	final public static int MEDIUM = 2;
	final public static int FAST = 3;
	
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	
	String color = "blue";
	
	public Fans()
	{
		
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public boolean getOn()
	{
		return on;
	}
	
	public void setOn(boolean on)
	{
		this.on = on;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public String toString()
	{
		if(this.on==true)
		{
			return "Speed is: "+this.speed+" color is: "+this.color+" radius is: "+this.radius;
		}
		else
		{
			return "fans is off and color is: "+this.color+" radius is: "+this.radius;
				
		}
			
	}
	
	public static void main(String[] args)
	{
		Fans test1 = new Fans();
		Fans test2 = new Fans();
		
		test1.setSpeed(FAST);
		test1.setRadius(10);
		test1.setColor("yellow");
		test1.setOn(true);
		System.out.println(test1);
		System.out.println();
		
		test2.setSpeed(MEDIUM);
		test2.setRadius(5);
		test2.setColor("blue");
		test2.setOn(false);
		System.out.println(test2);
	}
	
}
