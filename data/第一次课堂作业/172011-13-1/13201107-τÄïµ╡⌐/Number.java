package text;
import java.util.*;


public class Number {
	public void run(int number){
		if(number > 1000){
			System.out.println("�������ִ���1000��");
			System.exit(0);
		}
		int [] a= new int[3];
		a[0]=number%10;
		a[1]=(number/10)%10;
		a[2]=number/100;		
		int total = 0;
		total = a[0] + a[1] + a[2];
		System.out.println("������������ǣ�" + number );
		System.out.println("���ĸ�λ��֮���ǣ�" + total);
	}
	public static void main(String args[]){
		Number num = new Number();
		System.out.println("������һ��1000���ڵ���");
		Scanner reader=new Scanner(System.in);
		int number = reader.nextInt();
		num.run(number);
	}
}


