package secondQuestion;

import java.util.Scanner;
public class SecondQuestion {
	 public static void main(String[] args){
		int minutes=0;
		int years=0;
		int days=0;
		 System.out.println("please enter the number of minutes:");
	   	 Scanner input =new Scanner(System.in);
	   	 minutes=input.nextInt();
	   	 years=minutes/525600;
	   	 days=(minutes%52600)/1440;
	   	 System.out.println(+minutes+"is approximate"+ years + "years and" + days + "days");
	   	 input.close();
	 }

}
