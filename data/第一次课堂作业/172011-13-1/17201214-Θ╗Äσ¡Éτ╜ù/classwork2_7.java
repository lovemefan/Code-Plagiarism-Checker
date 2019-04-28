package helloworld;
import java.util.*;

public class classwork2_7 {
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of minute:");
		int minute = input.nextInt();
		
		int day = (minute/60)/24;
		int year = day/365;
		int days =day%year;
		
		System.out.println(minute+" minute is approximately "+year+" years and "+days+" days");
		
	}
}
