import java.util.Scanner;

public class $2_7 {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter a number of minutes:");
	
	long minutes = input.nextInt();
	long day = minutes / (60*24);
	long year = day / 365;

	System.out.println(minutes+"minutes is approximately "+year+"year and "+day+"days");
	
	if (input !=null){
		input.close();
	}
}

}
