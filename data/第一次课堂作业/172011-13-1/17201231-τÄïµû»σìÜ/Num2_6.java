//by wang sibo 17201231
import java.util.Scanner;
public class Num2_6 {
	public static void main(String[] args){
		
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000��");
		int data=input.nextInt();//����һ������
		while (data>=1000|data<=0){
			System.out.print("Inter a number again between 0 and 1000:");
			data=input.nextInt();
		}//�ж��Ƿ���0��1000֮��
		
		int sum1,sum2,sum3,sum4;
		sum1=data/100;
		sum2=(data-sum1*100)/10;
		sum3=(data-sum1*100-sum2*10);
		sum4=sum1+sum2+sum3;
		//����
		
		System.out.print("The sum of the digits is"+sum4);//���
	}
}
