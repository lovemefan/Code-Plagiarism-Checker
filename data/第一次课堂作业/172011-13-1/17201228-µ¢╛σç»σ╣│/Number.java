package HelloWorld;
import java.util.Scanner;

   public class Number{
   public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.print("Enter a number between 0 and 1000:");
	int digits,d1,d2,d3,sum;
	digits=input.nextInt();
	d1=digits%1000/100;
	d2=digits%100/10;
	d3=digits%10;
	sum=d1+d2+d3; 
	System.out.printf("The sum of the digits is"+sum);
   }
}
