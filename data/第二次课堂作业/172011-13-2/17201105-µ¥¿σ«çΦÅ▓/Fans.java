
package yangyufei;
public class Fans {
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

	static class Fan {
		private final short SLOW = 1;
		private final short MEDIUM = 2;
		private final short FAST = 3;
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
		public void setRadius(double Radius){
			radius = Radius;
		}
		public double getRadius(){
			return radius;
		}
		public void setColor(String Color){
			color = Color;
		}
		public String getColor(){
			return color;
		}
		public void setSpeed(int Speed){
			speed = Speed;
		}
		public int getSpeed(){
			return speed;
		}
		public void ToString(){
			if(on)
				System.out.println(speed + " " + color + " " + radius);
			else
				System.out.println("fan is off");
		}
	}
}
