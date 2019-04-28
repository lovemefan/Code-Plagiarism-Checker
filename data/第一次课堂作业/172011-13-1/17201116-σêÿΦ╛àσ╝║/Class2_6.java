import java.util.Scanner;

public class Class2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 1000:");
        n=input.nextInt();
        int t=0;
        while (n>0)
        {
        	t+=n%10;
        	n=n/10;
        }
        System.out.println("The sum of the digits is "+t);
	}
}
