import java.util.Scanner;

public class Class3_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        String[] p= {" ","January","February","March","April","May","June","July","August","September","October","November","December"};
        int[] q = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        int[] t = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        System.out.print("Please enter year and month:");
        int year=input.nextInt();
        int month=input.nextInt();
        if ((year%4==0&&year%100!=0)||year%400==0)
        {
        	System.out.println(p[month] + " " + year + " has " + q[month] + " days");
        }
        else
        {
        	System.out.println(p[month] + " " + year + " has " + t[month] + " days");
        }
	}
}
