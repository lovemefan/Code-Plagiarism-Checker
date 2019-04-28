package project2;
import java.util.Scanner;
public class P3_11 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String Month[]= {"January","February","March","Apil","May","June","July","August","September","October","November","December"};
		int Days[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		System.out.print("Enter a month and years:");
		int month=input.nextInt();
		int years=input.nextInt();
		if(years%4==0&&years%100!=0||years%400==0) {
			Days[1]++;
		}
		
		System.out.println(Month[month-1]+" "+years+" has "+Days[month-1]+" days");
		input.close();

	}

}
