package work;
import java.util.Scanner;

public class work2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes£º");
		int minutes = input.nextInt();
		int years = minutes/(365*24*60);
		int days = minutes/(24*60) - years*365;
		System.out.println("" + minutes +" minutes is approximately " + years + " years " + days + " days ");
	}

}
