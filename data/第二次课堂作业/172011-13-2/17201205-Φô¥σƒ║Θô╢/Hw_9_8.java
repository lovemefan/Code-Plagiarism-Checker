package HW;

import java.util.Scanner;

public class Hw_9_8 {
	
		public static void main (String[] atgs){
			final int SLOW = 1;
			final int MEDIUM = 2;
			final int FAST = 3;
		Scanner input = new Scanner (System.in);
		Fan fan1 = new Fan(FAST,true,10,"yellow");
		Fan fan2 = new Fan(MEDIUM,false,15,"blue");
		fan1.toString( fan1 );
		fan2.toString( fan2 );
	}
}

class Fan  {
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius  = 5 ;
	private String color = "blue";
	
	Fan (){
		int speed = SLOW;
		boolean on = false;
		double radius  = 5 ;
		String color = "blue";
	}

		
	 Fan (int speed,boolean on,double radius,String color) {
		this.speed = speed;
		this.on = on;
		this.radius  = radius ;
		this.color = color;
	}
	
	void toString (Fan fan1) {
		
		if (fan1.on == false)
		System.out.println("The fan is off " + fan1.color + " " + fan1.radius );
		else
		System.out.println(fan1.speed+ " " + fan1.color + " " + fan1.radius );;	
		
		
	}
}