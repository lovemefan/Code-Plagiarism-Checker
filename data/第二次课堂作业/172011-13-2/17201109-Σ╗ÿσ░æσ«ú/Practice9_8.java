public class Practice9_8 {
	public static void main(String[] args) {
		Fan f1 = new Fan();
		Fan f2 = new Fan();
		f1.setSpeed(3);
		f1.setRadius(10);
		f1.setColor("yellow");
		f1.seton(true);
		f2.setSpeed(2);
		f2.setRadius(5);
		f2.setColor("blue");
		f2.seton(false);
		System.out.println(f1.toString());
		System.out.println(f2.toString());
	}

}
class Fan{
	int SLOW = 1,MEDIUM = 2,FAST = 3;
	private int speed = 1;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	Fan(){
	}
	public int getSpeed() {
		return this.speed;
	}
	public boolean geton() {
		return this.on;
	}
	public double getRadius() {
		return this.radius;
	}
	public String getColor() {
		return this.color;
	}
	public void setSpeed(int speed) {
		this.speed =speed;
	}
	public void seton(boolean on) {
		this.on = on;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String toString() {
		if(on == true) {
			return "Speed: " + speed + "\n" + "Radius: " + radius + "\n" + "Color: " + color;
		}
		else{
			return "The fan is off" + "\n" + "Radius: " + radius + "\n" + "Color: " + color;
		}
	}
}
