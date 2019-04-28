package test1;
import java.util.Scanner;

public class test2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of minutes:");
		long minute = input.nextLong();
		long day = minute / 720;
		long year = day / 365;
		System.out.println(minute + " minutes is approximately " + year + " years " + " and " + day +"days.");
	}
}
