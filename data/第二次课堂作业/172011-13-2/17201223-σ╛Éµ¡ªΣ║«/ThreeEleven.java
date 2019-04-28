package homework;

import java.util.Scanner;

public class ThreeEleven {
	public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.print("Enter year:");
	int year=input.nextInt();
	System.out.print("Enter month:");
	int month=input.nextInt();
	int day;
	if (((year%4==0&&year%100!=0)||(year%400==0))&&(month==2)){
		day=29;
	}
	else if (month==2)
		day=28;
	else if (month==1||month==3||month==5||month==7||month==8||month==10||month==12)
		day=31;
	else
		day=30;
	System.out.println(year+"."+ month +" has "+ day +" days.");
	
	}

}
