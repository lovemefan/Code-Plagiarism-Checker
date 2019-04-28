package text;
import java.util.*;


public class Time {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入一个分钟数：");
		int minutes=input.nextInt();
		int days=(int)minutes/(60*24);
		int years=days/365;
		int remainingDays=days%365;
		System.out.println(minutes+"分钟是"+years+"年"+remainingDays+"天");
	}

}
