
public class TestFan {

	public static void main(String[] args) {
		Fan a = new Fan(),b = new Fan();
		a.setSpeed(a.FAST);
		a.setRadius(10);
		a.setColor("yellow");
		a.setOn(true);
		
		b.setSpeed(b.MEDIUM);
		b.setRadius(5);
		b.setColor("blue");
		b.setOn(false);
		
		System.out.println("The first fan:" + a.toString());
		System.out.println("The second fan:" + b.toString());
	}
	
}
