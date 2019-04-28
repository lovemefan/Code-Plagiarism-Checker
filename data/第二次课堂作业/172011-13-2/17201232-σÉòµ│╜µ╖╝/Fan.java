
public class Fan {

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
			on =false;
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
				System.out.println("The fan speed is : " + speed + "  color is " + color + 
						"  radius is  " + radius);
			else
				System.out.println("fan is off");
		}
		
	


public static void main(String[] args){
	Fan fan1 = new Fan();
	fan1.setSpeed(3);
	fan1.setRadius(10);
	fan1.setColor("yellow");
	fan1.turnOn();
	fan1.ToString();
	
	Fan fan2 = new Fan();
	fan2.setSpeed(2);
	fan2.setColor("blue");
	fan2.turnOff();
	fan2.ToString();
}



}