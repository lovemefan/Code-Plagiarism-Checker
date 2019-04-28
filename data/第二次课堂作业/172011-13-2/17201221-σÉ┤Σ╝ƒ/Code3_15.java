import java.util.Scanner;

public class Code3_15 {
	private static Scanner input;

	public static void main(String[] args){
		input = new Scanner(System.in);
		int number = (int)(Math.random()*900+100);
		System.out.println("请输入一个三位整数：");
		int guess = input.nextInt();
		int number1 = number%10;
		int number2 = (number/10)%10;
		int number3 = number/100;
		int guess1 = guess%10;
		int guess2 = (guess/10)%10;
		int guess3 = guess/100;
		System.out.println("彩票的数字是："+number);
		if(guess==number){
			System.out.println("恭喜你获得10000美元！");
		}else if(guess1==number2&&guess2==number3&&guess3==number1||guess1==number3&&guess2==number1&&guess3==number2){
			System.out.println("恭喜你获得3000美元！");
		}else if(guess1==number1||guess1==number2||guess1==number3||guess2==number1||guess2==number2||guess2==number3||guess3==number1||guess3==number2||guess3==number3){
			System.out.println("恭喜你获得1000美元！");
		}else{
			System.out.println("谢谢惠顾！");
		}
			
	}

}
