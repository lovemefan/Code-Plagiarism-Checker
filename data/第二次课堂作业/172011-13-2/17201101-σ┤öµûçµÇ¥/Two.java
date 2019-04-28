package workTwo;

import java.util.Scanner;
public class Two {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("please enter year and month: ");
		
		int year=input.nextInt();
		int month=input.nextInt();
		boolean LeapYear=(year%4==0&&year%100!=0)||(year%400==0);
		
		switch(month-1){
		case 0:System.out.println("January "+year+" has 31 days");
		case 1:if(LeapYear){
			System.out.println(" February "+year+" has 29  days");
		}
		       else
		       System.out.println("February "+year+" has 28  days");
		break;
		
		case 2:System.out.println("Marth "+year+" has 31 days");break;
		case 3:System.out.println("April "+year+" has 30 days");break;
		case 4:System.out.println("May "+year+" has 31 days");break;
		case 5:System.out.println("June "+year+" has 30 days");break;
		case 6:System.out.println("July "+year+" has 31 days");break;
		case 7:System.out.println("August "+year+" has 31 days");break;
		case 8:System.out.println("September "+year+" has 30 days");break;
		case 9:System.out.println("October "+year+" has 31 days");break;
		case 10:System.out.println("November "+year+" has 30 days");break;
		case 11:System.out.println("December  "+year+" has 31 days");break;
		default:System.out.println("the month is wrong");
		}
		input.close();
	}

}
