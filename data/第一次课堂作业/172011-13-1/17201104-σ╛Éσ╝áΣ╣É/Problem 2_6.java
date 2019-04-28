import java.util.Scanner;
public class Problem_2_6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
	System.out.println("Please enter a number between 0 and 1000:");
        int num = input.nextInt();
        int a = num % 10;
        int b = num / 10 % 10;
        int c = num / 100;
	System.out.print("The sum of digits is ");
        System.out.println(a+b+c);
    }
}
