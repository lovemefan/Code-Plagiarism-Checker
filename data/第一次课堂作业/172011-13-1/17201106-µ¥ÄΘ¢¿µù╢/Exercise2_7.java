package 第一次课堂作业;
import java.util.Scanner;
public final class Exercise2_7 {
	 public static void main(String[] args){
		 Scanner input = new Scanner(System.in);
		 System.out.println("Enter the number of minutes:");
		 int minutes = input.nextInt();
		 int year =(int)(minutes /525600);
		 int day  = (minutes % 525600)/60/24;
		 System.out.println(minutes + "minutes is approximately" +year+ "years and" +day+"days" );
	 }
}
