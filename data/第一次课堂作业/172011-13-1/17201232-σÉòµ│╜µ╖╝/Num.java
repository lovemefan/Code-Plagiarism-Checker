import java.util.Scanner;

public class Num {
	public static void main(String[] args){
	
	System.out.println("Please enter a number between 0 and 1000 :");
	Scanner input = new Scanner(System.in);
	int number = input.nextInt();
	
	int last = number % 10;
    int remainingNumber = number / 10;
    int second = remainingNumber % 10;
    remainingNumber = remainingNumber / 10;
    int third = remainingNumber % 10;
    
    int toll = last + second + third;
    System.out.println("The sum of all digits in " + toll + '!');
	
	}
}
