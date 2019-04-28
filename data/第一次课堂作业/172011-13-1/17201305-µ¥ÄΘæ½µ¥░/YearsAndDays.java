import java.util.Scanner;
public class YearsAndDays//输入分钟计算年份和天数-2.7
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a number of minutes:");
		long minutes=input.nextLong();//输入分钟
		
		long days=((minutes/60)/24)%365;//求天数
		long years=((minutes/60)/24)/365;//求年份
		
		System.out.println(minutes+" minutes is approximately "+years+" years and "+days+" days");
	}
}
