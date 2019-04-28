package workTwo;

public class Fan {
  
	int SLOW=1;
	int MEDIUM=2;
	int FAST=3;
	
	private int speed=SLOW;
	private boolean on=false;
	private double radius=5;
	String color="blue";
	
	public Fan(){
		
	}
	
	public Fan(int speed,double radius,String color,boolean on){
		this.speed=speed;
		this.radius=radius;
		this.color=color;
		this.on=on;
	}
	public int gteSpeed(){
		return speed;
	}
	
	public boolean on(){
		return on;
	}
	
	public double radius(){
		return radius;
		
	}
	
	public String color(){
		return color;
		
	}
	public String toString(){
		if(on){
			return "speed is "+speed+" the color is "+color+"the radius is "+radius;
		}
		else{
			return "fan is off and color is "+color+" the radius is "+radius;
		}
		
	}
	
	 public static void main(String[] args){
		 Fan one,two;

		 one=new Fan(3,10,"yellow",true);
		 System.out.println(one.toString());
		 
		 two=new Fan(2,5,"blue",false);
		 System.out.println(two.toString());
	 }
			
}
