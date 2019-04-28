import java.util.Scanner;

public class SeparateBy {
	public static void main(String[] args) {
		System.out.print("Enter a number between 0 and 1000:");
		Scanner input=new Scanner(System.in);
		int number=input.nextInt();
		int sum;
		if(number<=9){
			sum=number;
		}
		else if(number<=99){
			int number1=number%10;
			int number2=number/10;
			sum=number1+number2;
			
		}
		else{
			int number1=number%10;
			int number2=number/10%10;
			int number3=number/100;
			sum=number1+number2+number3;
		}
			

		System.out.println("The sum of the digits is"+sum);
		
	}

}
