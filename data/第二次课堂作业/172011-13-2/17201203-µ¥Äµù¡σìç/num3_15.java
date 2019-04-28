package ¿ÎÌÃ×÷Òµ;
import java.util.Scanner;
public class num3_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = (int)( Math.random() * 900+100);
		System.out.print("Enter your numbers");
		int num1,num2,num3,a;
		a = input.nextInt();
		num1 = num / 100;
	    num2 = num / 10 %10;
	    num3 =num %10;
	    int a1,a2,a3;
	    a1 = a / 100;
	    a2 = a / 10 % 10;
	    a3 = a % 10;
	    if(a == num ){
	    	System.out.print("You win 10000 dollers");
	    }
	    else if(a1 == num1 && a2 == num3 && a3 == num2||
	    		 a1 == num2 && a2 == num1 && a3 == num3||
	    		 a1 == num2 && a2 == num3 && a3 == num1||
	    		 a1 == num3 && a2 == num1 && a3 == num2||
	    		 a1 == num3 && a2 == num2 && a3 == num1){
	    	System.out.print("You win 3000 dollers");
	    }
	    else if(a1 == num1|| a2 == num2|| a3 ==num3){
	    	System.out.print("You win 1000 dollers");
	    }
	    else{
	    	System.out.print("You win 0 dollers");
	    }
	}

}
