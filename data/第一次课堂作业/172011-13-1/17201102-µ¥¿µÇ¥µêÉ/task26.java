import java.util.Scanner;
public class task26 {
	   public static void main(String[] args){
		   System.out.println("Enter a number between 0 and 1000:");
	       Scanner input=new Scanner(System.in);
	       int num=input.nextInt();
	       int sum=0;
	       while (num>0){
	    	   sum+=num%10;
	    	   num/=10;
	       }
	       System.out.println("The sum of the digits is:"+sum);
	   }
}
