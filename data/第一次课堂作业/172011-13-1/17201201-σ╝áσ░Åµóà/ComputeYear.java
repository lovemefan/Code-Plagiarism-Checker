import java.util.Scanner;

public class ComputeYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Please enter the number of minutes:");
		long day=0,year=0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		long min = input.nextLong();
		year=min/(60*24*365);
        day=(min/(60*24))%365;
        System.out.print(min+" minutes is approximately "+ year +" and " + day + " days");
	}

}
