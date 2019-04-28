import java.util.Scanner;
public class NumberAdd {
    private static Scanner input;

	public static void main(String[] args) {
	    input = new Scanner(System.in);
	    System.out.print("Enter a number 0-1000:");
	    int number=input.nextInt();
	    //个位数求法
	    int a=number%10;
	    //求法十位数
	    int b=(number/10)%10;
	    int c=number/100;
	    int num=a+b+c;
	    System.out.println("The numberadd of"+a+""+b+""+c+"is"+num);
    }
}