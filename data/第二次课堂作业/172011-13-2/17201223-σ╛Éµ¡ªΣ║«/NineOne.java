package homework;
import java.util.Scanner;
public class NineOne {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("��ֱ�����������εĿ�͸ߣ�");
		double w=input.nextDouble();
		double h=input.nextDouble();
		 Rectangle r=new Rectangle(w,h);
		 System.out.println("�����"+r.getArea()+",�ܳ���"+r.getPerimeter());
	}

}
