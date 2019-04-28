package TestFan;

public class TestFan {
	public static void main(String[] args){
		Fan fan1 = new Fan();
		fan1.setSpeed(3);
		fan1.setColor("yellow");
		fan1.setRadius(10);
		fan1.turnOn();
		fan1.ToString();
		
		Fan fan2 = new Fan();
		fan2.setSpeed(2);
		fan2.setColor("blue");
		fan2.setRadius(5);
		fan2.turnOff();
		fan2.ToString();
	}
static class Fan {	
//类中的静态方法不能直接调用动态类的方法及使用动态类的属性。只有将某个内部类修饰为静态类，然后才能够在静态类中调用该类的成员变量与成员方法	
	
	private final short SLOW = 1;
	private final short MEDIUM = 2;
	private final short FAST = 3;
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	
	Fan() {
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
	}
	public void setSpeed(int newSpeed){
		speed = newSpeed;
	}
	public int getSpeed(){
		return speed;
	}
	public void turnOn(){
		on = true;
	}
	public void turnOff(){
		on = false;
	}
	public void setRadius(double newRadius){
		radius = newRadius;
	}
	public double getRadius(){
		return radius;
	}
	public void setColor(String newColor){
		color = newColor;
	}
	public String getColor(){
		return color;
	}
	public void ToString(){
		if(on)
			System.out.println("Speed: "+ speed + " Color: " + color + " Radious: " + radius);
		else
			System.out.println("Fan is off");
	}
}
}
