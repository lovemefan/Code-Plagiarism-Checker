package 第一次课堂作业;
import java.util.Scanner;
public class Exercise2_6 {
    public static void main(String[] args){
    	Scanner input = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 1000:");
        int number = input.nextInt();
        int remainingNumber = (int)(number / 10);
        int numberOfones = number % 10;
        int numberOftens = remainingNumber % 10;
        int numberOfhundreds = (int)(remainingNumber / 10);
        int a = numberOfones + numberOftens +numberOfhundreds;
        System.out.println("The sum of the digits is" +a);     
    }
}
