import java.util.Scanner;

public class Seatwork3 {
	public static final int N1 = 5;
	public static final int N2 = 3;
	public static final int N3 = 4;
	public static void main(String[] args){
		System.out.println("Enter three-digit integer");
		int number = 0;
		Scanner input = new Scanner(System.in);
		number = input.nextInt();
		int number1 = 0, number2 = 0, number3 = 0;
		number1 = number / 100;
		number2 = (number % 100) / 10;
		number3 = number % 10;
		int tag = 0;
		if (number1 == 5 || number1 == 3 || number1 == 4 || number2 == 5 || number2 == 3 || number2 ==4 || 
				number3 == 5 || number3 == 4 || number3 == 3){
			tag = 1;
		}
		if (number1 == N1 && number2 == N2 && number3 == N3){
			System.out.println("You win 10000 dollars");
		}
		else if ((number == 543) || (number == 354) || (number == 345) || (number == 435) || (number == 453) ){
			System.out.println("You win 3000 dollars");
		}
		else if (tag == 1){
			System.out.println("You win 1000 dollars");
		}
	}
}
