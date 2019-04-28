import java.util.Scanner;

public class Code9_1 {
	private static Scanner input;

	public static void main(String[] args){
		input = new Scanner(System.in);
		System.out.print("请分别输入这个矩形的宽和高：");
		double w=input.nextDouble();
		double h=input.nextDouble();
		 Rectangle r=new Rectangle(w,h);
		 System.out.println("面积是"+r.getArea()+",周长是"+r.getPerimeter());
	}

}
