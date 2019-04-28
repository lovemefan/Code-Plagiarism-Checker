import java.util.Scanner;
public class TwoSeven {
	public static void main(String[] args){
		double year,day;
		System.out.print("Enter the number of minutes:");
		Scanner input =new Scanner(System.in);
		int min=input.nextInt();
		day=min/1440;
		year=day/365;
		System.out.println(min+" minutes is approximately "+year+" years and "+day+" days");
	}
}
