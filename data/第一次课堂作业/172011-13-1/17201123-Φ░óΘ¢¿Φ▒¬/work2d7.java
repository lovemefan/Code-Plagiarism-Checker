package work;

import java.util.Scanner;
public class work2d7 {
	public static void main(String args[]){
		System.out.println("plz enter a minu:");
		
		Scanner enter = new Scanner(System.in);
		int n= enter.nextInt();
		int daym=24*60;
		int year=365;
		
		System.out.println(n+"minutes is approximately "+(n/daym)/year+"years and "+ (n/daym)%year+" days");
		
	}
}
