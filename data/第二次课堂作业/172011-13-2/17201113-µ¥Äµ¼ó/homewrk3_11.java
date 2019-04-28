package homework;

import java.util.Scanner;

public class homewrk3_11{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		String[] months={"January","Febuary","March","April","May","June","JUly","August","September","October","November","December"};
		
		System.out.println("Please input the years and months:");
		int year=input.nextInt();
		int month=input.nextInt();
		int day=0;
		
		if((year%4==0&&year%100!=0)||(year%400==0)){
			if(month==2){
				day=29;
			}
		}
		
		else{
			if(month==2){
				day=28;
			}
				
			else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
				day=31;
			}
			
			else{
				day=30;
			}
		}
		System.out.println(months[month-1]+" "+year+" has "+day+" days");
		
	}
}
