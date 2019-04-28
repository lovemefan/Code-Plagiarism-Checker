package dame;

import java.util.Scanner;

public class Day {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println("Enter year and month:");
     Scanner input = new Scanner(System.in);
     int year = input.nextInt();
     int month = input.nextInt();
     if((year%4==0&&year%100!=0)||year%400==0){//≈–∂œ «∑ÒÕ˛»ÚƒÍ
    	 if(month==1) System.out.println("January "+year+" has 31 days.");
    	 if(month==2) System.out.println("February "+year+" has 29 days.");
    	 if(month==3) System.out.println("March "+year+" has 31 days.");
    	 if(month==4) System.out.println("April "+year+" has 30 days.");
    	 if(month==5) System.out.println("May "+year+" has 31 days.");
    	 if(month==6) System.out.println("June "+year+" has 30 days."); 
    	 if(month==7) System.out.println("July "+year+" has 31 days.");
    	 if(month==8) System.out.println("Augst "+year+" has 31 days.");
    	 if(month==9) System.out.println("September "+year+" has 30 days.");
    	 if(month==10)System.out.println("October "+year+" has 31 days.");
    	 if(month==11)System.out.println("November "+year+" has 30 days.");
    	 if(month==12)System.out.println("December "+year+" has 31 days.");
      }
     else{
    	 if(month==1) System.out.println("January "+year+" has 31 days.");
    	 if(month==2) System.out.println("February "+year+" has 28 days.");
    	 if(month==3) System.out.println("March "+year+" has 31 days.");
    	 if(month==4) System.out.println("April "+year+" has 30 days.");
    	 if(month==5) System.out.println("May "+year+" has 31 days.");
    	 if(month==6) System.out.println("June "+year+" has 30 days."); 
    	 if(month==7) System.out.println("July "+year+" has 31 days.");
    	 if(month==8) System.out.println("Augst "+year+" has 31 days.");
    	 if(month==9) System.out.println("September "+year+" has 30 days.");
    	 if(month==10)System.out.println("October "+year+" has 31 days.");
    	 if(month==11)System.out.println("November "+year+" has 30 days.");
    	 if(month==12)System.out.println("December "+year+" has 31 days.");
     }
	}

}
