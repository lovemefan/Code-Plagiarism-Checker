
import java.util.Scanner;

public class ReadNum {
	public static void main(String[] args){
		int randNum;
		System.out.println("Enter a number between 0-1000:");
		while (true){
			Scanner input = new Scanner(System.in);
			randNum=input.nextInt();
			if (randNum<1000&&randNum>0)
				break;
			System.out.println("Error,enter again:");
		}
		int num1=randNum/100;
		int num2=(randNum-num1*100)/10;
		int num3=randNum-num1*100-num2*10;
		int sum=num1+num2+num3;
		System.out.println("The sum of the digits:"+ sum);
	}

}
