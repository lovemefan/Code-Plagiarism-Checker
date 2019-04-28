package xuzhichao;

import java.util.Scanner;
public class task1 {
	public static void main(String[] args){
		System.out.print("Enter the number of minutes:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int a = num/(60*24*365);
		int b = (num/(60*24))-(a*365);
		System.out.println(num + " minutes is approximately " + a + " and " + b);
		if(input != null){
    		input.close();
		}	
	}
}
