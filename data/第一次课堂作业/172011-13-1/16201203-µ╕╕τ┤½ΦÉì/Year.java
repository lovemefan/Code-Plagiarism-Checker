package onetime;
import java.util.Scanner;
public class Year {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the time zone offset to GMT:");
		long minute=scan.nextLong();
		int years=(int)(minute/525600);
		int days=(int)((minute-years*525600)/1440);
		System.out.println(minute+"minutes is approximately "+years+" years and "+days+" days");
	}

}
