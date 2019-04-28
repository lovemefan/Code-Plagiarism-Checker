import java.util.Scanner;
public class Class9_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		FAN f1 = new FAN(3,true,10,"yellow");
		FAN f2 =new FAN(2,false,5,"bule");
		f1.tostring();
		f2.tostring();
	}
}
class FAN{
	public final int SLOW=1,MEDIUM=2,FAST=3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	FAN()
	{}
	FAN (int speed,boolean on,double radius,String color)
	{
		this.speed=speed;
		this.on=on;
		this.radius=radius;
		this.color=color;
	}
	void modifyspeed(int speed)
	{
		this.speed=speed;
	}
	void modifyon(boolean on)
	{
		this.on=on;
	}
	void modifycolor(String color)
	{
		this.color=color;
	}
	void modifyradius(double radius)
	{
		this.radius=radius;
	}
	void tostring()
	{
//		String s="";
		if (on==true)
		{
			System.out.print("speed is ");
			if (speed == 1)
			   System.out.print("SLOW");
			else if (speed == 2)
				System.out.print("MEDIUM");
			else 
				System.out.print("FAST");
			System.out.println(" color is " + color + " and radius is " + radius);
		}
		else if (on == false)
		{
			System.out.println("fan is off color is " + color + " and radius is " + radius);
		}
//		return s;
	}
}