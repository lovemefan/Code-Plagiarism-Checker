import java.util.Scanner;

//3.11
public class GetDaysOfAMonth {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a month and a year: ");
        int month = input.nextInt();
        int year = input.nextInt();
        String[] monthInWord = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        int[] daysOfAmonth = {31,28,29,30,31,30,31,31,30,31,30,31};
        if(isLeapYear(year))
            daysOfAmonth[1] += 1;
        System.out.println(monthInWord[month - 1] + " " + year + " has " + daysOfAmonth[month - 1] + " days");
        input.close();
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        return false;
    }
}