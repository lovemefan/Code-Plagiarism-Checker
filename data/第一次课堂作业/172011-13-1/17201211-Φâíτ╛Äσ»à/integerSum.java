package integerSum;

import java.util.Scanner;
public class integerSum {
	 public static void main(String[] args){
	     int number=0;
	     System.out.print("Enter a number between 0 and 1000: ");
	     Scanner input = new Scanner(System.in);
	     number=input.nextInt();
	     while(number<0||number>1000){
		     System.out.print("Enter a number between 0 and 1000: ");
		     number=input.nextInt();
	     }
	     int sum=0;
	     if(number==1000){
		     sum=1;
	     }else{
	     sum=number%10+(number/10)/10+(number/10)%10;
	     }
	     System.out.println("The sum of the digits is " + sum);
	 }
	
}
