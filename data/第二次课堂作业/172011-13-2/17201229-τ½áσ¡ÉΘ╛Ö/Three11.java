import java.util.Scanner;
public class Three11 {

	public static void main(String[] args) {
		System.out.println("Please enter mouth and year");
		Scanner input = new Scanner(System.in);
		int mouth = input.nextInt();
		int year = input.nextInt();
		int d = year % 100;
		switch (mouth){
		
		    case 1:{
		    	System.out.println("Junuary " + year +" has 31 days");  break;}
		    case 3:{
		    	System.out.println("March " + year +" has 31 days");  break;}
		    case 5:{
		    	System.out.println("May " + year +" has 31 days");  break;}
		    case 7:{
		    	System.out.println("July " + year +" has 31 days");  break;}
		    case 8:{
		    	System.out.println("August " + year +" has 31 days");  break;}
		    case 10:{
		    	System.out.println("October " + year +" has 31 days");  break;}
		    case 12:{ 
		    	System.out.println("December " + year +" has 31 days");  break;}
		    
		    case 4:{
		    	System.out.println("April " + year +" has 30 days");  break;}
		    case 6:{
		    	System.out.println("June " + year +" has 30 days");  break;}
		    case 9:{
		    	System.out.println("Sepetember " + year +" has 30 days");  break;}
		    case 11:{
		    	System.out.println("November " + year +" has 30 days");  break;}
		    
		    case 2:{
		    	if(year % 4 > 0 || (d == 0 && (year/100)%4 > 0))
		    	    System.out.println("February " + year + " has 28 days");
		    	else 
		    		System.out.println("February " + year + " has 29 days");	 
		    }
		    }
		}
		
			

	}


