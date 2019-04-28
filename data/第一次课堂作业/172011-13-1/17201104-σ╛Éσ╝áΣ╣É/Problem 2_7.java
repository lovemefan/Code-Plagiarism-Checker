import java.util.Scanner;
public class Problem_2_7 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number of minutes:");
        long min = input.nextLong();
        long days = min / 1440;
        long years = days / 365;
        days -= years * 365;
        System.out.println(min + " minutes is approximately " + years + " years and " + days + " days.");
    }
}
