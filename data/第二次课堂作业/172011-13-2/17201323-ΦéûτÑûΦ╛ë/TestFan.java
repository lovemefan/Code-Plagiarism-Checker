package work;

public class TestFan {
	public static void main(String[] args){
		Fan fan1 = new Fan();
		fan1.setSpeed(3);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.turnon();
		fan1.ToString();
		
		Fan fan2 = new Fan();
		fan2.setSpeed(2);
		fan2.setColor("blue");
		fan2.turnOff();
		fan2.ToString();
	}

}
