import java.util.Scanner;

public class Code9_1 {
	private static Scanner input;

	public static void main(String[] args){
		input = new Scanner(System.in);
		System.out.print("��ֱ�����������εĿ�͸ߣ�");
		double w=input.nextDouble();
		double h=input.nextDouble();
		 Rectangle r=new Rectangle(w,h);
		 System.out.println("�����"+r.getArea()+",�ܳ���"+r.getPerimeter());
	}

}
