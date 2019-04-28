package Lesson_2;
import java.util.Scanner;
public class DaysOfMonth//某年某月有几天
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("please Enter Years");
		int year=input.nextInt();//接受年份
		System.out.println("please Enter Month");
		int month=input.nextInt();//接受月份
		String[] monthName= {"January","February","March","April","April","June","July","August","September","October","November","December"};
		//将月份转化为英文输出
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			System.out.println(monthName[month]+" of "+year+" has 31 days");
		}
		else if(month==2) {
			if(Define(year)==1) {
				System.out.println(monthName[month]+" of "+year+" has 29 days");
			}//闰年
			else {
				System.out.println(monthName[month]+" of "+year+" has 28 days");
			}//平年
		}
		else {
			System.out.println(monthName[month]+" of "+year+" has 30 days");
		}
	}
	public static int Define(int x) {
		if((x%400==0)||(x%100!=0&&x%4==0)) {
			return 1;
		}//判断是闰年还是平年
		return -1;
	}
}
