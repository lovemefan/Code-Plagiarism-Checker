import java.util.Scanner;
public class Test1 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Please input a int number between 0 to 1000");
		int x=input.nextInt();
		int m=x%10+x/10%10+x/100;
		System.out.println(m);
		if(input!=null){
			input.close();
		}
	}
}
