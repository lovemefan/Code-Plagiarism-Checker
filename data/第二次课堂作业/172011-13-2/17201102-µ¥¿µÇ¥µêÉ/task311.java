import java.util.*;
public class task311 {
   public static int IsLeapYear(int year){
	   if(year%400==0||year%4==0&&year%100!=0)
		   return 1;
	   else{
		   return 0;
	   }
   }
	public static void main(String[] args){
		String[] str = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	   int year=0,month=0;
	   System.out.println("Please enter the value of the month and year: ");
	   Scanner input=new Scanner(System.in);
	   month=input.nextInt();
	   year=input.nextInt();
	   if (IsLeapYear(year)==1){
		   if (month==2)
			   System.out.println(str[1]+" "+year+" has "+29+" days");
		   else if (month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			   System.out.println(str[month-1]+" "+year+" has "+31+" days");
		   else
			   System.out.println(str[month-1]+" "+year+" has "+30+" days");
		   	  
	   }
	  else{
		  if (month==2)
			   System.out.println(str[1]+" "+year+" has "+28+" days");
		   else if (month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			   System.out.println(str[month-1]+" "+year+" has "+31+" days");
		   else
			   System.out.println(str[month-1]+" "+year+" has "+30+" days");
	  }
		  
   }
}
