package test;
import java.util.Scanner;

public class exe3_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m,y;
		String[] mouth= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		System.out.print("Enter the mouth and year:");
		m =input.nextInt();
		y = input.nextInt();
		if (m==1||m==3||m==5||m==7||m==8||m==10||m==12) {
			System.out.println(mouth[m-1]+ y+" has 31 days");
		}
		if (m==4||m==6||m==9||m==11) {
			System.out.println(mouth[m-1]+ y+" has 30 days");
		}
		if (m==2) {
			if ((y%100!=0&&y%4==0)||y%400==0) {//≈–∂œ «∑Ò «»ÚƒÍ
				System.out.println(mouth[m-1]+ y+" has 29 days");
			}
			else
				System.out.println(mouth[m-1]+ y+" has 28 days");
		}
	}

}
