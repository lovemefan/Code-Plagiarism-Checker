import java.util.Scanner;
public class Sum {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int num = input.nextInt();
		int a,b,c;
	    while(num<=0||num>=1000){
	    	System.out.print("ERROR! Please input again:");
	    	num = input.nextInt();
	    }
	    a=num%10;
	    b=num/10%10;
	    c=num/10/10%10;
	    System.out.print("The sum of the digits is " + (a+b+c));
	}
}
