//by wang sibo 17201231
import java.util.Scanner;
public class Minute2_7 {
	public static void main (String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a number of minutes: ");
		int minutes=input.nextInt();
		while (minutes<0){
			System.out.print("Enter a numbe of minutes again: ");
			minutes=input.nextInt();
		}//判断输入是否正确
		
		int year,day;
		day=0;
		year=minutes/525600;
		if (year>0){
			day=(minutes-year*525600)/1440;
		}
		else{
			day=minutes/1440;
		}
		//计算过程
		
		System.out.println(minutes+" minutes is approximately "+year+
				" years and "+day+" days");
	}//输出
}
