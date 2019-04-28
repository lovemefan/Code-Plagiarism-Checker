import java.util.Scanner;

public class task27 {
   public static void main(String[] args){
	   System.out.println("Enter the number of minutes: ");
       Scanner input=new Scanner(System.in);
      long num=input.nextLong();
      long days=0;
      long years=0;
       years=num/60/24/365;
       days=num/60/24%365;
       System.out.println(num+" minutes is approximately "+years+" years and "+days+" days");
   }
}
