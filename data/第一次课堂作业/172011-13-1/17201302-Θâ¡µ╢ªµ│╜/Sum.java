import java.util.Scanner;
public class Sum {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number between 0 and 1000:");
		int num = input.nextInt();
		int a,b,c,d,sum;
		a = num/1000;
		b = (num-a*1000)/100;
		c = num%100/10;
		d = num%10;
		sum=a+b+c+d;
		System.out.println("The sum of the digits is "+sum);
	}
}
