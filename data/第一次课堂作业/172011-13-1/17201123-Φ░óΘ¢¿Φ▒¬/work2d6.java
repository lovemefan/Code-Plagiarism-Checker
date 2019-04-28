package work;

import java.util.Scanner;
public class work2d6 {
	public static void main(String args[]){
		System.out.println("plz enter a num(0-999):");
		
		Scanner enter = new Scanner(System.in);
		int n= enter.nextInt();
		
		int sum=0;
		if(n>=100)
		{
			int t=n;
			sum+=t/100;
			t=t%100;
			sum+=t/10;
			t=t%10;
			sum+=t;
		}
		else if(n>=10&&n<100)
		{
			int t=n;
			sum+=t/10;
			t=t%10;
			sum+=t;
		}
		else sum=n;
		
		System.out.println(sum);
	}
}
