import java.util.Scanner;;
public class AllAdd {

	public AllAdd() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int num=input.nextInt();
		if(num<0||num>1000){
			System.out.print("Enter error!");
			return;
		}
		int[] a=new int[3];
		a[2]=num/100;
		a[1]=(num/10)%10;
		a[0]=num%10;
		int sum=a[0]+a[1]+a[2];
		System.out.println("The sum of the digits is"+sum);
	}

}
