package work;
import java.util.Scanner;
public class minute {
	public static void main(String[] arg){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		int min = input.nextInt();
		System.out.println(min + " minutes is approximately "+ min/525600 + " years and " + (min/1440)%365 + " days ");
	}
}
