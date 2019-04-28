
public class TestFan {

	//private static final int FAST = 0;
	//private static final int MEDIUM = 0;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		final int SLOW = 1;
	    final int MEDIUM = 2;
	    final int FAST = 3;
		Fan f1,f2;
		f1 = new Fan(FAST,10,"yellow",true);
		f2 = new Fan(MEDIUM,5,"blue",false);
        System.out.println(f1.toString());
        System.out.println(f2.toString());
	}

}
