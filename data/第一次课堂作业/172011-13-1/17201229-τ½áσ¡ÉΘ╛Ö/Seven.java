import java.util.Scanner;
public class Seven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of minutes:");
        int min =input.nextInt();
        int days = (min/1440)%365;
        int year = (min/1440)/365;
        System.out.println(min + " minutes is approximately " + year + " years and " + days + " days");
	}

}
