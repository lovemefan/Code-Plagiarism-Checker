import java.util.Scanner;
public class DaySum {
	private static Scanner input;
	
    public static void main(String[] args) {
	input=new Scanner(System.in);
	System.out.print("Enter month,year:");
	int month=input.nextInt();
	int year=input.nextInt();
	//int day=0;注释中的只能显示出3而不能显示March
	if(year%400==0||(year%4==0&&year%100!=0)){
		/*if(month==2)
			day=29;
		else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			day=31;
		else 
			day=30;*/
		switch(month){
		    case 1:
		    	System.out.println("January "+ year + " has 31 days ");
		        break;
	        case 2:
		    	System.out.println("February "+ year + " has 29 days ");
		        break;
		    case 3:
			    System.out.println("March "+ year + " has 31 days ");
			    break;
			case 4:
			    System.out.println("April "+ year + " has 30 days ");
			    break;
			   
			 case 5:
			      System.out.println("May "+ year + " has 31 days ");
			      break;
		     case 6:
			      System.out.println("June "+ year + " has 30 days ");
			      break;
			 case 7:
				  System.out.println("July "+ year + " has 31 days ");
				  break;
			 case 8:
				  System.out.println("August"+ year + " has 31 days ");
				  break;  
			 case 9:
				  System.out.println("September"+ year + " has 30 days ");
				  break;
			 case 10:
				  System.out.println("October "+ year + " has 31 days ");
				  break;
			 case 11:
				  System.out.println("November "+ year + " has 30 days ");
				  break;
			 case 12:
				  System.out.println("December"+ year + " has 31 days ");
				  break;  
		}
		

		//System.out.println("month "+month+" year "+ year+" has "+day+" days");
	}
	
	else{
		switch(month){
	    case 1:
	    	System.out.println("January "+ year + " has 31 days ");
	        break;
        case 2:
	    	System.out.println("February "+ year + " has 28 days ");
	        break;
	    case 3:
		    System.out.println("March "+ year + " has 31 days ");
		    break;
		case 4:
		    System.out.println("April "+ year + " has 30 days ");
		    break;
		   
		 case 5:
		      System.out.println("May "+ year + " has 31 days ");
		      break;
	     case 6:
		      System.out.println("June "+ year + " has 30 days ");
		      break;
		 case 7:
			  System.out.println("July "+ year + " has 31 days ");
			  break;
		 case 8:
			  System.out.println("August"+ year + " has 31 days ");
			  break;  
		 case 9:
			  System.out.println("September"+ year + " has 30 days ");
			  break;
		 case 10:
			  System.out.println("October "+ year + " has 31 days ");
			  break;
		 case 11:
			  System.out.println("November "+ year + " has 30 days ");
			  break;
		 case 12:
			  System.out.println("December"+ year + " has 31 days ");
			  break;  
	}
	
	
		/*if(month==2)
			day=28;
		else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			day=31;
		else 
			day=30;
		
		//System.out.println("month "+month+" year "+ year+" has "+day+" days");
	}	
	System.out.println("month "+month+" year "+ year+" has "+day+" days");*/
}
}
}