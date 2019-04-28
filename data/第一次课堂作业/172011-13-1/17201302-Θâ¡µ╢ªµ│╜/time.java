import java.util.Scanner;
public class time {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number of minutes:");
		int num = input.nextInt();
		int year,day;
		year = num/(365*24*60);
		day = num%(365*24*60)/(24*60);
		System.out.println(num+" minutes is approximately "+year+" years and "+day+" days");
	}
}
