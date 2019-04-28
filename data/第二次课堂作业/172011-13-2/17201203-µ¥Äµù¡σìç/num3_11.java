package ¿ÎÌÃ×÷Òµ;
import java.util.Scanner;
public class num3_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year,month;
		System.out.print("Enter the month and year:");
		month =input.nextInt();	
		year = input.nextInt();
		if( month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12){
			System.out.println(month + year + "has 31 days");
		}
			if (month == 4||month == 6||month == 9){
				System.out.println(month + year + "has 30 days");
			}
	  if (month == 2){
			if ((year%100!=0&&year%4==0)||year%400==0){
				System.out.println(month + year +" has 29 days");
			}
			else{
					System.out.println(month + year +" has 28 days");
				}
					
			}
	}
}
	
	
	