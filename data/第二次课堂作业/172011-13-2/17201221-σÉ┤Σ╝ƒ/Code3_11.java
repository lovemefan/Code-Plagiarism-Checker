import java.util.Scanner;

public class Code3_11 {
	private static Scanner scanner;

	public static void main(String[] args){
		scanner = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = scanner.nextInt();
		System.out.println("请输入月份：");
		int month = scanner.nextInt();
		int day = 0;
		switch(month){
		case 1:;
		case 3:;
		case 5:;
		case 7:;
		case 8:;
		case 10:;
		case 12:day = 31;
		break;
		case 4:;
		case 6:;
		case 9:;
		case 11:day=30;
		break;
		case 2:day = year%4 == 0?28:29;
		default:break;
		
		}
		System.out.println(year+"年"+month+"月共有"+day+"天");
	}

}
