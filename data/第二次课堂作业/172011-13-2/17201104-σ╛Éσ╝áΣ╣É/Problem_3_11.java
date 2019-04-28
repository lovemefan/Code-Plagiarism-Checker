import java.util.Scanner;
public class Problem_3_11 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of month and year:");
        int month = input.nextInt();
        int year = input.nextInt();
        final String monthName[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        final int LeapmonthDay[] = {31,29,31,30,31,30,31,31,30,31,30,31};
        final int NormolmonthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (IsLeapYear(year)){
            System.out.println(monthName[month-1] + " " + year + " has " + LeapmonthDay[month-1] + " days");
        }
        else {
            System.out.println(monthName[month-1] + " " + year + " has " + NormolmonthDay[month-1] + " days");
        }
    }
    public static boolean IsLeapYear(int year){
        if (year % 4 == 0 && year % 100 != 0){
            return true;
        }
        if (year % 400 == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
