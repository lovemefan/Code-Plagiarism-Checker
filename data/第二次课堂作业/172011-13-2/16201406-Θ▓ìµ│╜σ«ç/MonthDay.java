import java.util.Scanner;

class MonthDay {
	public static void main(String[] args) {
		System.out.println("Please input year and month:");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		if((a % 4 == 0 && a % 100 !=0) || a % 400 == 0)
			switch(b) {
			case 1:System.out.println("Ju" + a +" has 31 days");break;
			case 2:System.out.println("Feb" + a +" has 28 days");break;
			case 3:System.out.println("Mar" + a +" has 31 days");break;
			case 4:System.out.println("April" + a +" has 30 days");break;
			case 5:System.out.println("May" + a +" has 31 days");break;
			case 6:System.out.println("June" + a +" has 30 days");break;
			case 7:System.out.println("July" + a +" has 31 days");break;
			case 8:System.out.println("Ath" + a +" has 31 days");break;
			case 9:System.out.println("Sep" + a +" has 31 days");break;
			case 10:System.out.println("Oct" + a +" has 31 days");break;
			case 11:System.out.println("Nov" + a +" has 30 days");break;
			case 12:System.out.println("Dec" + a +" has 31 days");break;
			}
		else
			switch(b) {
			case 1:System.out.println("Ju" + a +" has 31 days");break;
			case 2:System.out.println("Feb" + a +" has 29 days");break;
			case 3:System.out.println("Mar" + a +" has 31 days");break;
			case 4:System.out.println("April" + a +" has 30 days");break;
			case 5:System.out.println("May" + a +" has 31 days");break;
			case 6:System.out.println("June" + a +" has 30 days");break;
			case 7:System.out.println("July" + a +" has 31 days");break;
			case 8:System.out.println("Ath" + a +" has 31 days");break;
			case 9:System.out.println("Sep" + a +" has 31 days");break;
			case 10:System.out.println("Oct" + a +" has 31 days");break;
			case 11:System.out.println("Nov" + a +" has 30 days");break;
			case 12:System.out.println("Dec" + a +" has 31 days");break;
			
			}
			
		
		
		
	}
	

}
