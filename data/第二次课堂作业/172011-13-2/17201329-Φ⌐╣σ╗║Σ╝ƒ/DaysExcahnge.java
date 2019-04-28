
import java.util.Scanner;

public class DaysExcahnge {
	public static void main(String [] agrs ){
		int Year;
		int Month;
		int Day;
		int flag=0;
		while (true){
			System.out.println("Enter a year and a month:");
			Scanner input = new Scanner(System.in);
			Year = input.nextInt();
			Month = input.nextInt();
			if (Month<13&&Month>0)
				break;
		}
		if (Year%400==0){
			flag=1;
		}else if (Year%100==0){
			
		}else if (Year%4==0){
			flag=1;
		}
		if (flag==1){
			switch(Month){
			case 1:Day=31;System.out.println("January " + Year + " has " + Day + " days");break;
			case 2:Day=29;System.out.println("February " + Year + " has " + Day + " days");break;
			case 3:Day=31;System.out.println("March " + Year + " has " + Day + " days");break;
			case 4:Day=30;System.out.println("April " + Year + " has " + Day + " days");break;
			case 5:Day=31;System.out.println("Mars " + Year + " has " + Day + " days");break;
			case 6:Day=30;System.out.println("June " + Year + " has " + Day + " days");break;
			case 7:Day=31;System.out.println("July " + Year + " has " + Day + " days");break;
			case 8:Day=31;System.out.println("August " + Year + " has " + Day + " days");break;
			case 9:Day=30;System.out.println("September " + Year + " has " + Day + " days");break;
			case 10:Day=31;System.out.println("October " + Year + " has " + Day + " days");break;
			case 11:Day=30;System.out.println("November " + Year + " has " + Day + " days");break;
			case 12:Day=31;System.out.println("December " + Year + " has " + Day + " days");break;
			}
		}
		if (flag==0){
			switch(Month){
			case 1:Day=31;System.out.println("January " + Year + " has " + Day + " days");break;
			case 2:Day=28;System.out.println("February " + Year + " has " + Day + " days");break;
			case 3:Day=31;System.out.println("March " + Year + " has " + Day + " days");break;
			case 4:Day=30;System.out.println("April " + Year + " has " + Day + " days");break;
			case 5:Day=31;System.out.println("Mars " + Year + " has " + Day + " days");break;
			case 6:Day=30;System.out.println("June " + Year + " has " + Day + " days");break;
			case 7:Day=31;System.out.println("July " + Year + " has " + Day + " days");break;
			case 8:Day=31;System.out.println("August " + Year + " has " + Day + " days");break;
			case 9:Day=30;System.out.println("September " + Year + " has " + Day + " days");break;
			case 10:Day=31;System.out.println("October " + Year + " has " + Day + " days");break;
			case 11:Day=30;System.out.println("November " + Year + " has " + Day + " days");break;
			case 12:Day=31;System.out.println("December " + Year + " has " + Day + " days");break;
			}
		}
	}

}
