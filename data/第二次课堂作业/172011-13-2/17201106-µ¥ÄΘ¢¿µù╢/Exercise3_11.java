package 第二次作业;
import java.util.Scanner;
public class Exercise3_11 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String[] month= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		int year,m;
		System.out.println("Enter a year and  month");
		year=input.nextInt();
		m=input.nextInt();
		if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){
			System.out.println(month[m-1]+year+" has 31 days");
		}
        if(m==4||m==6||m==9||m==11){
        	System.out.println(month[m-1] +year+" has 30 days");
        }
        if (m==2) {
        	if ((year%100!=0&&year%4==0)||year%400==0) {
        		System.out.println(month[m-1]+year+" has 29 days");
        	}
        	else
        		System.out.println(month[m-1] +year+"has 28 days");
        }      
	}
}
