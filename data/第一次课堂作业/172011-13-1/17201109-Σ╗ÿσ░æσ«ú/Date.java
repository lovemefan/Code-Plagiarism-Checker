import java.util.Scanner;
public class Date {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number of minutes:");
		Long min = input.nextLong();
		int year,day;
		year = (int) (min/(60*24*365));
		day = (int) (min%(60*24*365)/(60*24));
		System.out.print(min+" minutes is approximately "+year+" years and "+day+" days");
	}

}
