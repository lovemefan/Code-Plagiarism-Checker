import java.util.Scanner;

public class Year {
    public static void main(String[] args){
    	long number=0,years=0,days=0;
        System.out.print("Enter the number of minutes: "); 	
        Scanner input = new Scanner(System.in);
        number=input.nextLong();
        years=number/(365*24*60);
        days=(number-years*365*24*60)/(24*60);
        System.out.println(number + " minutes is approximately " + years + " years " + " and " + days + " days " );
    }
}
