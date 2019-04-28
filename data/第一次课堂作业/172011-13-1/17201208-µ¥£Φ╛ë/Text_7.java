import java.util.Scanner;
public class Text_7 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes :");
		long n = input.nextLong(),m = n;
		long year,day;
		n/=1440;
		year = n/365;
		day = n-(365*year);
		System.out.print(m + " minutes is approximately " + year + " years and " + day + " days");
	}
}
