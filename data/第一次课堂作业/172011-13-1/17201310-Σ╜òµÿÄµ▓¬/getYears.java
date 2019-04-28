import java.util.Scanner;

/**
 * title: 2.7 求出年数
 */
public class getYears {

    public static void main(String[] args) {
        final int A_YEAR = 24 * 60 * 365;
        final int A_DAY= 24 * 60;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of minutes:");
        int minutes = input.nextInt();
        System.out.println(
                minutes + " minutes is approximately " + minutes / A_YEAR + " minutes and " + minutes % A_YEAR / A_DAY + " days");
        input.close();
    }
}