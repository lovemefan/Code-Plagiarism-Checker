import java.util.Scanner;

public class day {
	public static void main(String[] args){
	System.out.print("Enter a year and a month :") ;  
	Scanner input = new Scanner(System.in);
	int year = input.nextInt();
	int month = input.nextInt();
	boolean isLeapYear	= (year %4 == 0 && year%100 != 0) || (year % 400 == 0);
	int i = 0;
	if(isLeapYear == true){
		switch(month){
		 case 1 : i=31;break;
		 case 2 : i=29;break;
		 case 3 : i=31;break;
		 case 4 : i=30;break;
		 case 5 : i=31;break;
		 case 6 : i=30;break;
		 case 7 : i=31;break;
		 case 8 : i=31;break;
		 case 9 : i=30;break;
		 case 10 : i=31;break;
		 case 11 : i=30;break;
		 case 12 : i=31;break;
		}
	}
	else{
	
		switch(month){
		 case 1 : i=31;break;
		 case 2 : i=29;break;
		 case 3 : i=31;break;
		 case 4 : i=30;break;
		 case 5 : i=31;break;
		 case 6 : i=30;break;
		 case 7 : i=31;break;
		 case 8 : i=31;break;
		 case 9 : i=30;break;
		 case 10 : i=31;break;
		 case 11 : i=30;break;
		 case 12 : i=31;break;
	}
		
	}
	System.out.print(year + " 年 " + month + " 月 有" + i + "天" ) ;  
	}
}
