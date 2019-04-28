
public class TestFan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		fan1.setSpend(3);
		fan1.setRadiouos(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		fan2.setSpend(2);
		System.out.println(fan1.toString());
		System.out.println(fan2.toString());
	}

}

class Fan{
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private int spend;
	private boolean on;
	private double radious;
	String  color;
	Fan(){
		spend = SLOW;
		on = false;
		radious = 5;
		color = "blue";
	}
	
	int getSpend() {
		return spend;
	}
	void setSpend(int newSpend) {
		spend = newSpend;
	}
	
	boolean getOn() {
		return on;
	}
	void setOn(boolean newOn) {
		on = newOn;
	}
	
	double getRadious() {
		return radious;
	}
	void setRadiouos(double newRadious) {
		radious = newRadious;
	}
	
	String getColor() {
		return color;
	}
	void setColor(String newColor) {
		color = newColor;
	}
	public String toString() {
		if(on) {
			String s = (spend + "") + (radious + "") + color;
			return s;
		}
		else{
			String s = "fan is off" + (radious + "") + color;
			return s;
		}
	}
}