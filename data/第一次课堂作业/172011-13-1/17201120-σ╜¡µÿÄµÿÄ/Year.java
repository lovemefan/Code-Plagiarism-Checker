package year;

import java.util.Scanner;
public class Year {
	public static void main(String[] args){
		int i = 0;
		System.out.println("Enter the number of minutes:");
		Scanner input = new Scanner(System.in);
		i = input.nextInt();
		int j = i / 60 / 24 / 365;
		int k = i / 60 / 24 % 365;
		System.out.println(i +" minutes is approximately "+ +j +" years and "+ +k +" days");
	}

}
