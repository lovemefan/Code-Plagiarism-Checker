
public class Fan {

	public static void main(String[] args) {
		Fan fan1 = new Fan();
		fan1.setFan(3, true, 10, "yellow");
		System.out.println(fan1.toString());
		Fan fan2 = new Fan();
		fan2.setFan(2, false, 5, "blue");
		System.out.println(fan2.toString());
	}
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private int speed;
	private boolean on;
	private double radius;
	String color;
	public Fan(){
		this.speed = SLOW;
		this.on = false;
		this.radius = 5;
		this.color = "blue";
	}
	
	public void setFan(int newSpeed, boolean newOn, double newRadius, String newColor){
		this.speed = newSpeed;
		this.on = newOn;
		this.radius = newRadius;
		this.color = newColor;
	}
	public String toString(){
		String value;
		if (this.on){
			value = "The fan speed is " + this.speed + "\t" +
					"the color is " + this.color + "\t" +
			        "the radius is " + this.radius;}
		else{ 
			value = "fan is off" + "\t\t" +
		             "the color is " + this.color + "\t" +
		             "the radius is " + this.radius;}
		return value;
	}
	

}
