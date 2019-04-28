class Fan {
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
	int getSpeed() {
		return speed;
	}
	void setSpeed(int newSpeed) {
		speed = newSpeed;
		
	}
	void turnOn() {
		on = true;
	}
	void turnOff() {
		on = false;
	}
	double getRadius() {
		return radius;
	}
	void setRadius(double newRadius) {
		radius = newRadius;
	}
	String getColor() {
		return color;
	}
	void setColor(String newColor) {
		color = newColor;
	}
	public void tostring() {
		if(on)
			System.out.println(speed + " , " + color + " , " + radius);
			else
				System.out.println("fan is off , " + color + " , " + radius );
		
	}
	public static void main(String[] args) {
		Fan t1 = new Fan();
		t1.setSpeed(3);
		t1.setRadius(10);
		t1.setColor("yellow");
		t1.turnOn();
		t1.tostring();
		
		Fan t2 = new Fan();
		t2.setSpeed(2);
		t2.setRadius(5);
		t2.setColor("blue");
		t2.turnOff();
		t2.tostring();
		
	}
	
	
	

}
