
public class MainFan {
	public static void main(String[] args){
		Fan f1;
		FanTest f2;
		FanTest2 f3;
		f1 = new Fan();
		f2 = new FanTest();
		f3 = new FanTest2();
		f1.setCondition(true);
		f1.setColor("black");
		System.out.println(f1.toString(f1.getCondition(), f1.getColor(), f1.getRadius(), f1.getSpeed()));
		System.out.println(f2.toString(f2.getCondition(), f2.getColor(), f2.getRadius(), f2.getSpeed()));
		System.out.println(f1.toString(f3.getCondition(), f3.getColor(), f3.getRadius(), f3.getSpeed()));
	}
}
