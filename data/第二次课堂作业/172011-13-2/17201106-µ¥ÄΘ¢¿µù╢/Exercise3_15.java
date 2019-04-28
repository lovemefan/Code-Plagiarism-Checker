package 第二次作业;
import java.util.Scanner;
public class Exercise3_15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	    int num = (int)(Math.random() * 900 + 100);
	    System.out.println("Enter your number: ");
	    int yournumber=input.nextInt();
	    int num1 = num / 100;
	    int num2 = num /10 % 10;
	    int num3 = num %10;
	    int yournumber1 = yournumber /100;
	    int yournumber2 = yournumber /10 % 10;
	    int yournumber3 = yournumber %10;
	    if(yournumber==num)
	       System.out.println("you win 10000dollars");	
	    else if(yournumber1==num1&&yournumber1==num2&&yournumber1==num3||
	    		yournumber2==num1&&yournumber2==num2&&yournumber2==num3||
	    		yournumber3==num1&&yournumber3==num2&&yournumber3==num3)
	       System.out.println("you win 1000dollars");   
	    else if((yournumber1==num1||yournumber2==num2||yournumber3==num3)&&
	    		(yournumber1==num2||yournumber2==num1||yournumber3==num3)&&
	    		(yournumber1==num1||yournumber2==num3||yournumber3==num2)&&
	    		(yournumber1==num3||yournumber2==num2||yournumber3==num1))
	       System.out.println(" you win 3000dollars");   
	    else
	       System.out.println(" you lost");
	}
}
