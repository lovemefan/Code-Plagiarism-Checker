import java.util.Scanner;

public class Code3_15 {
	private static Scanner input;

	public static void main(String[] args){
		input = new Scanner(System.in);
		int number = (int)(Math.random()*900+100);
		System.out.println("������һ����λ������");
		int guess = input.nextInt();
		int number1 = number%10;
		int number2 = (number/10)%10;
		int number3 = number/100;
		int guess1 = guess%10;
		int guess2 = (guess/10)%10;
		int guess3 = guess/100;
		System.out.println("��Ʊ�������ǣ�"+number);
		if(guess==number){
			System.out.println("��ϲ����10000��Ԫ��");
		}else if(guess1==number2&&guess2==number3&&guess3==number1||guess1==number3&&guess2==number1&&guess3==number2){
			System.out.println("��ϲ����3000��Ԫ��");
		}else if(guess1==number1||guess1==number2||guess1==number3||guess2==number1||guess2==number2||guess2==number3||guess3==number1||guess3==number2||guess3==number3){
			System.out.println("��ϲ����1000��Ԫ��");
		}else{
			System.out.println("лл�ݹˣ�");
		}
			
	}

}
