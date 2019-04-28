package classtest;

import java.util.Scanner;

public class test3_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter month and year:");
		int month = input.nextInt();
		int year = input.nextInt();
		int days = 0;
		if(month <= 0 && month >12){
			System.out.print("Please a month between 1 and 12!");
			month = input.nextInt();
		}
		if(year % 4 == 0 && year % 100 != 0){
			if(month == 2)
				days = 29;
			else if(month ==1 || month ==3 || month ==5 || month ==7 || month ==8 || month ==10 || month == 12)
				days =31;
			else
				days =30;
		}
		else{
			if(month == 2)
				days =28;
			else if(month == 1 || month ==3 || month ==5 || month ==7 || month ==8 || month ==10 || month == 12)
				days =31;
			else
				days =30;		
		}
        switch(month){
        case 1: System.out.println("January "+ year + "has "+ days + "days");
                break;
        case 2: System.out.println("February "+ year + "has "+ days + "days");
                break;
        case 3: System.out.println("March "+ year + "has "+ days + "days");
                break;
        case 4: System.out.println("April "+ year + "has "+ days + "days");
                break;
        case 5: System.out.println("May "+ year + "has "+ days + "days");
                break;
        case 6: System.out.println("June "+ year + "has "+ days + "days");
                break;
        case 7: System.out.println("July "+ year + "has "+ days + "days");
                break;
        case 8: System.out.println("Aguest "+ year + "has "+ days + "days");
                break;
        case 9: System.out.println("September "+ year + "has "+ days + "days");
                break;
        case 10: System.out.println("October "+ year + "has "+ days + "days");
                 break;
        case 11: System.out.println("November "+ year + "has "+ days + "days");
                 break;
        case 12: System.out.println("December "+ year + "has "+ days + "days");
                 break;
        }
        if(input != null) {
			input.close();
		}	
	}
}
