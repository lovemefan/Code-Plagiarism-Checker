package HelloWorld;

  import java.util.Scanner;
  
 public class YearsDays {
 public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.print("Enter the number of minutes:");
	int minutes=input.nextInt();
	int years=minutes/(60*24*365);
	int days=minutes/(60*24);
	System.out.println(minutes+"mintues is approximately"+years+"years and"+days+"days");
	
 }
}
