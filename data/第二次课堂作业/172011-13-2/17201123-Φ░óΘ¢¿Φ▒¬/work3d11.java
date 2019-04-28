package work1015;

import java.util.Scanner;
public class work3d11 {
	public static void main(String args[]){
		Scanner enter=new Scanner(System.in);
		
		int day[]=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
		String mon[]=new String[]{" ","January","February","March","April","May","June","July","August","September","October","November","December"};
		
		System.out.println("Plz enter the month and the year :");
		int month,year;
		month=enter.nextInt();
		year=enter.nextInt();
		
		int flag=0;
		if(year%4==0&&year%100!=0||year%400==0)
		{
			flag=1;
		}
		if(flag==1)
		{
			day[2]++;
		}
		System.out.println(mon[month]+" "+year+" has "+day[month]+" days");
	}
	
}
