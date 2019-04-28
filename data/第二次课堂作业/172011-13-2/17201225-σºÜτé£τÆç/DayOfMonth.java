import java.util.Scanner;
public class DayOfMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input  =new Scanner(System.in);
		System.out.print("Enter the year:");
		int year = input.nextInt();
		System.out.print("Enter the month:");
		int month = input.nextInt();
		int day;
		if (((year%4 == 0&&year%100!=0)||(year%400==0))&&(month==2)){
			day=29;
		}
		else if (month==2)
			day=28;
		else if (month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			day=31;
		else
			day=30;
		System.out.println(year + "年"+ month +"月有"+ day +"天");
		}

	}

