package Sum;//2.6

import java.util.Scanner; 

public class Sum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a  number between 0 and 1000");
		int number = input.nextInt();
		while(number<0||number>1000) {
			System.out.println("Enter a  number between 0 and 1000");
			number = input.nextInt();
		}
		int unitsDigit = 0,tensDigit = 0,hundredsDigit = 0,thousandDigit = 0;
		thousandDigit = number / 1000;
		hundredsDigit = (number % 1000) / 100;
		tensDigit = (number % 100) / 10;
		unitsDigit = (number % 10);
		int sum = unitsDigit + tensDigit + hundredsDigit + thousandDigit;
		System.out.println("The sum of digits is " + sum);
		if(input != null) {
			input.close();
		}
	}

}
