import java.util.Scanner;
public class TwoSix {
	public static void main(String[] args){
		int b,c,d,sum;
		Scanner input =new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int a=input.nextInt();
		b=a%10;
		c=(a/10)%10;
		d=(a/100);
		sum=b+c+d;
		System.out.println("The sum of the digits is "+sum);
	}

}
