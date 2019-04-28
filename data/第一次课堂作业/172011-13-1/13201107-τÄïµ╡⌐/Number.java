package text;
import java.util.*;


public class Number {
	public void run(int number){
		if(number > 1000){
			System.out.println("输入数字大于1000！");
			System.exit(0);
		}
		int [] a= new int[3];
		a[0]=number%10;
		a[1]=(number/10)%10;
		a[2]=number/100;		
		int total = 0;
		total = a[0] + a[1] + a[2];
		System.out.println("你输入的数字是：" + number );
		System.out.println("它的各位数之和是：" + total);
	}
	public static void main(String args[]){
		Number num = new Number();
		System.out.println("请输入一个1000以内的数");
		Scanner reader=new Scanner(System.in);
		int number = reader.nextInt();
		num.run(number);
	}
}


