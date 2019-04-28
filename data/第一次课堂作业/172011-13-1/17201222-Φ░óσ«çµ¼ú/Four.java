import java.util.Scanner;
public class Four {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
			System.out.print("Enter the number of minutes:");
				int minutes = input.nextInt();
					int year = minutes / (60 * 24 * 365);
						int day = minutes % (60 * 24 * 365) / (60 * 24);
							System.out.println(minutes + " minutes is " + year + "years and"
									+ day + "days");
		}

}
