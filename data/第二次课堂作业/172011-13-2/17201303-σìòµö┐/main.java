
public class main {
	public static void main(String[] args){
		homework r1;
		r1 = new homework();
		r1.setheight(4);
		r1.setwidth(40);
		homework r2;
		r2 = new homework();
		r2.setheight(3.5);
		r2.setwidth(35.9);
		System.out.println(r1.getArea());
		System.out.println(r1.getPerimeter());
		System.out.println(r2.getArea());
		System.out.println(r2.getPerimeter());
	}
}
