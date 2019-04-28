package fan;

public class Fan {
	public static void main(String[] args){
		Fan fan1 = new Fan(3,true,10,"yellow");
		System.out.println(fan1.toString());
		Fan fan2 = new Fan(2,false,5,"blue");
		System.out.println(fan2.toString());
	}
	
	private int speed;
	private boolean on;
	private double radius;
	String color, speeds;
	
	Fan(){
		speed = 1;
		on = false;
		radius = 5;
		color = "blue";
	}
	
	Fan(int newSpeed,boolean newOn,double newRadius,String newColor){
		this.speed = newSpeed;
		this.on = newOn;
		this.radius = newRadius;
		this.color = newColor;
	}
	
	void getFan(){
		System.out.println("The fan is\n" + speeds + "\n" + on + "\n" + radius + "\n" + color);
	}
	
	void setFan(int newSpeed,boolean newOn,double newRadius,String newColor){
		this.speed = newSpeed;
		this.on = newOn;
		this.radius = newRadius;
		this.color = newColor;
	}
	
	public String toString(){
		String fan = null;
		if (on == true)
			fan = speed + " " + radius + " " + color;
		else if (on == false)
			fan = " fan is off " + radius +  " " + color;
		return fan;
	}
	
}
