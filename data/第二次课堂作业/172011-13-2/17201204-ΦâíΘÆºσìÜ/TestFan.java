
public class TestFan {
	public static void main(String[] args){
		Fan a1 = new Fan();
		a1.setSpeed(3);
		a1.setRadius(10);
		a1.setColor("yellow");
		a1.turnOn();
		a1.ToString();
			
		Fan a2 = new Fan();
		a2.setSpeed(2);
		a2.setColor("blue");
		a2.turnOff();
		a2.ToString();
		}
}
class Fan{
	 private final int SLOW = 1;
	 private final int MEDIUM = 2;
	 private final int FAST = 3;
	 private int speed;
	 private boolean on;
	 private double radius;
	 private String color;
	 Fan(){
		 speed = SLOW;
		 on = false;
		 radius = 5;
		 color = "blue";
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
	 public void setSpeed(int newSpeed){
		 speed = newSpeed;
	 }
	 public int getSpeed(){
		 return speed;
	 }
	 public void ToString(){
			if(on)
				System.out.println(speed + " " + color + " " + radius);
			else
				System.out.println("fan is off, color is: "+color+" radius is: "+radius);
		}
		
}
	

	
	
