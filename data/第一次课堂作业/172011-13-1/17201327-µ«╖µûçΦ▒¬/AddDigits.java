import java.util.Scanner;

public class AddDigits {

	public static void main(String[] args) {
		System.out.print("Enter a number between 0 and 100:");
		int num;
		Scanner input = new Scanner(System.in);
		while (true) {
			//���������û�����
			num = input.nextInt();
			//�ж��Ƿ�������ȷ����
			if (num > 0 && num < 1000) {
				break;
			}
			else {
				System.out.print("Number is invalid\nPlease enter a number between 0 and 100: ");
			}
		}
		int unit = num % 10;
		int decade = num % 100 / 10;
		int hundreds = num / 100;
		System.out.println("The sum of the digits is " + (unit + decade + hundreds));
	}
	
}
