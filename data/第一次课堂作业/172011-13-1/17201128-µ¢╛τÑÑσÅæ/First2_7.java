package HomeWork;
import java.util.Scanner;
public class First2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int min,year,day;
		System.out.println("Enter the number of minutes:");
		Scanner input =new Scanner(System.in);
		int min=input.nextInt();
		int day=min / 60 / 24;
		int year=day / 365;
		day=day % 365;
		System.out.println(min+" minutes is approximately "+year+" year and "+day+" days" );

	}

}
