import java.util.Scanner;
public class YearDay {

	public YearDay() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		long min=input.nextLong();
		long alldays=0;
		alldays=min/(60*24);
		long days=alldays%365;
		long years=alldays/365;
		System.out.println(min+"minutes is apporoximately "+years+" years"+" and "+days+" days");

	}

}
