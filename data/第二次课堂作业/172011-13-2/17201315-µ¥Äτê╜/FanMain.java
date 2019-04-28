package Fan;//9.8

public class FanMain {
	public static void main(String[] args) {
		Fan f1,f2;
		f1 = new Fan();
		f2 = new Fan();
		f1.setOn(true);
		f1.setSpeed(3);
		f1.setRadius(10);
		f1.setColor("yellow");
		f2.setOn(false);
		f2.setSpeed(2);
		f2.setRadius(5);
		f2.setColor("blue");
		System.out.println(f1.toString());
		System.out.println(f2.toString());
	}
}
