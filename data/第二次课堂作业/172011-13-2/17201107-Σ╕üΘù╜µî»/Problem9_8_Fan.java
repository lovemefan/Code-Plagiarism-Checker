package dmz;

public class Problem9_8_Fan {
	int SLOW;
	int MEDIUM;
	int FAST;
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	public static void main(String[] args) {//≤‚ ‘≥Ã–Ú
		Problem9_8_Fan Fan1 = new Problem9_8_Fan();
		Fan1.speed = Fan1.FAST;
		Fan1.radius = 10;
		Fan1.color = "yellow";
		Fan1.on = true;
		System.out.println(Fan1.toString(Fan1.on));
		Problem9_8_Fan Fan2 = new Problem9_8_Fan();
		Fan2.speed = Fan2.MEDIUM;
		Fan2.radius = 5;
		Fan2.color = "blue";
		Fan2.on = false;
		System.out.println(Fan2.toString(Fan2.on));
	}
	Problem9_8_Fan(){
		SLOW = 1;
		MEDIUM = 2;
		FAST = 3;
	}
	Problem9_8_Fan(int speed){
		this.speed = speed;
	}
	Problem9_8_Fan(boolean on){
		this.on = on;
	}
	Problem9_8_Fan(double radius){
		this.radius = radius;
	}
	Problem9_8_Fan(String color1){
		color = color1;
	}
	String toString(boolean on) {
		if(on) {
			return "The fan is on and speed is " + speed + ", color is " + color + ", radius is " + radius;
		}
		else {
			return "Fan is off " + "and color is " + color + ", radius is " + radius;
		}
	}

}
