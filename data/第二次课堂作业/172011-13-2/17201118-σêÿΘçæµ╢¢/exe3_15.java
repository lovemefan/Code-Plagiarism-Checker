package test;
import java.util.Scanner;

public class exe3_15 {
	    public static void main(String[] args) {
	     Scanner input = new Scanner(System.in);
	     int num = (int)(Math.random() * 900+100);  //产生一个三位的随机数
	     System.out.print("Enter your num: ");
	     int date = input.nextInt();
	     //获取每一位上的数字
	     int num1 = num / 100;
	     int num2 = num / 10 %10;
	     int num3 =num %10;
	     int date1 = date / 100;
	     int date2 = date / 10 % 10;
	     int date3 = date % 10;
	     System.out.println("The number is :" + num);
	     if(date == num){
	         System.out.println(" you win $10,000");
	     }
	     else if(date1 == num1 && date2 == num3 && date3 == num2||
	    		 date1 == num2 && date2 == num1 && date3 == num3||
	    		 date1 == num2 && date2 == num3 && date3 == num1||
	    		 date1 == num3 && date2 == num1 && date3 == num2||
	    		 date1 == num3 && date2 == num2 && date3 == num1)
	         System.out.println(" you win $3,000");
	     else  if(date1 == num1 || date1 == num2 || date1 == num3||
	    		  date2 == num1 || date2 == num2 || date2 == num3||
	    		  date3 == num1 || date3 == num2 || date3 == num3)
	         System.out.println(" you win $1,000");
	     else 
	         System.out.println("Sorry,no match");
	    }
	}


