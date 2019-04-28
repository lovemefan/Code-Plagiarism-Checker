package class2;
import java.util.Scanner;
public class question3 {
	public static void main(String[] args){		
		int x=(int)(Math.random()*1000);
		 //123
		 //System.out.println(x);
		System.out.println(" Enter a number :");
		 Scanner input =new Scanner(System.in);
		 int a=input.nextInt();
		 //456

		 int number1=a%10;
			//6
			int number4=a/10;
			//45
			int number3=number4%10;
			//5
			int number2=number4/10;
			//4
			 int number11=x%10;
				//3
				int number14=x/10;
				//12
				int number13=number14%10;
				//2
				int number12=number14/10;
				//1
				if(a==x){
					System.out.println("you win $10,000");
					System.out.println("The lottery number is"+x);
				}
				else if(number1==number11&&number2==number13&&number3==number12||number1==number12&&number2==number11&&number3==number13||number1==number12&&number2==number13&&number3==number11||number1==number13&&number2==number11&&number3==number12||number1==number13&&number2==number12&&number3==number11){
				System.out.println("you win $3,000");	
				System.out.println("The lottery number is"+x);
				}

				else if(number1==number11||number1==number12||number1==number13||number2==number11||number2==number12||number2==number13||number3==number11||number3==number12||number3==number13){
				System.out.println("you win $1,000");
				System.out.println("The lottery number is"+x);
				}
				else{
					System.out.println("you lost!");
					System.out.println("The lottery number is"+x);
				}
			
}
}