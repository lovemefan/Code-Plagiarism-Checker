package xuzhichao;

import java.util.Scanner;
public class task {
	public static void main(String[] args){
    	System.out.print("Enter a number between 0 and 1000:");
    	Scanner input = new Scanner(System.in);
    	int num = input.nextInt();
    	int a = num%10;
    	int b = num/10%10;
    	int c = num/100%10;
    	int d = num/1000;
    	int sum = a+b+c+d;
    	System.out.print("the sum of the digits is:" + sum);
    	if(input != null){
    		input.close();
    	}
    }
}
