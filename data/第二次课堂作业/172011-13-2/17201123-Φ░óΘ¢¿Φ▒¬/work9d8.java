package work1015;

public class work9d8 {
	final static int SLOW=1;
	final static int MEDIUM=2;
	final static int FAST=3;
	
	public static void main(String args[]){
		Fan fan=new Fan();
		fan.setSpeed(FAST);
		fan.setRadius(10);
		fan.setColor("yellow");
		fan.setOn(true);
		
		Fan fan2=new Fan();
		fan2.setSpeed(MEDIUM);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.setOn(false);
		
		System.out.println(fan.toString(fan.getOn()));
		System.out.println(fan2.toString(fan2.getOn()));
	}
}
