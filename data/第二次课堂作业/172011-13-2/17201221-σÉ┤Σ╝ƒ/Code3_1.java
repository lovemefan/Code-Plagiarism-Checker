import java.util.Scanner;

public class Code3_1 {
	private static Scanner in;

	public static void main(String[] args){
		System.out.println("Enter a,b,c:");
		in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		double x1,x2;
		int deta = b*b-4*a*c;
		if(deta==0){
			x1=x2=(-b)/(2*a);
			System.out.println("x1="+x1);
			System.out.println("x2="+x2);
		}else{
			double t=Math.sqrt(Math.abs(deta))/(2*a);
			if(deta>0){
				x1=(-b)/(2*a)+t;
				x2=(-b)/(2*a)-t;
				System.out.println("x1="+x1);
				System.out.println("x2="+x2);
			}else{
				x1=(-b)/(2*a);
				x2=(-b)/(2*a);
				System.out.println("x1="+x1+"+"+t+"*i");
				System.out.println("x2="+x2+"-"+t+"*i");
			}
		}
	}

}
