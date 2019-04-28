
public class TestFan {
	public static void main(String[] args) {
		Fan f1 = new Fan();
		Fan f2 = new Fan();
		
		f1.setspeed(3);
		f1.seton(true);
		f1.setradius(10);
		f1.color = "yellow";
		
		f2.setspeed(2);
		f2.seton(false);
		f2.setradius(5);
		f2.color = "blue";
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
	}

}

class Fan {
	private int speed = 1;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(on == true) {
			return speed + " ," + color + " ," + radius;
		}else {
			return "fan is off ," + color + " , " + radius;
		}
	}
	
	public void setspeed(int speed) {
		this.speed = speed;
	}
	public void seton(boolean on) {
		this.on = on;
	}
	public void setradius(double radius) {
		this.radius = radius;
	}
}