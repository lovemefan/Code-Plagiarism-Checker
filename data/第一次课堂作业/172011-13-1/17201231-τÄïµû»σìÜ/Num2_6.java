//by wang sibo 17201231
import java.util.Scanner;
public class Num2_6 {
	public static void main(String[] args){
		
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000：");
		int data=input.nextInt();//输入一个数字
		while (data>=1000|data<=0){
			System.out.print("Inter a number again between 0 and 1000:");
			data=input.nextInt();
		}//判断是否在0到1000之间
		
		int sum1,sum2,sum3,sum4;
		sum1=data/100;
		sum2=(data-sum1*100)/10;
		sum3=(data-sum1*100-sum2*10);
		sum4=sum1+sum2+sum3;
		//计算
		
		System.out.print("The sum of the digits is"+sum4);//输出
	}
}
