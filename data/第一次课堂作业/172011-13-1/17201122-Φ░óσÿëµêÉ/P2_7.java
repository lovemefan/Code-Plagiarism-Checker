package project;
import java.util.Scanner;
public class P2_7 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		int min=input.nextInt();
		int years,days;
		days=min/60/24;
        years=days/365;
        days=days%365;
        System.out.println(min+" minutes is approximately "+years+" years and "+days+" days");
        input.close();
	}

}
