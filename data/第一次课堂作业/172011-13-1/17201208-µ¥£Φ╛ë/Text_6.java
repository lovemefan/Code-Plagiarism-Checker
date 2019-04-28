import java.util.Scanner;
public class Text_6 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000: ");
		int n = input.nextInt();
		int[] arr = new int[10];
		int len = 0;
		while(n!=0){
			arr[++len] = n%10;
			n/=10;
		}
		int sum = 0;
		for(int i=1;i<=len;i++)
			sum+=arr[i];
		System.out.print("The sum of the digits is " + sum);
	}
}
