package test2;

public class TestFan {
	public static void main(String[] args){
		final int SLOW = 1;
		final int MIDIUM = 2;
		final int FAST = 3;
		Fan F1 = new Fan();
		Fan F2 = new Fan();
		F1.setColor("yellow");
		F1.setOn(true);
		F1.setRadius(10);
		F1.setSpeed(FAST);
		F2.setColor("blue");
		F2.setOn(false);
		F2.setRadius(5);
		F2.setSpeed(MIDIUM);
		System.out.println("The first fan's properties are " + F1.toString());
		System.out.println("The first fan's properties are " + F2.toString());
	}
}
