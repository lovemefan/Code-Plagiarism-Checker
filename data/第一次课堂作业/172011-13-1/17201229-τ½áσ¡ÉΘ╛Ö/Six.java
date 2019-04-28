import java.util.Scanner;
public class Six {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        System.out.println("Enter a number between 0 and 1000");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int sum;
        sum = a/100+(a/10)%10+a%10;
        System.out.println("The sum of the digits is "+sum);
        }

}