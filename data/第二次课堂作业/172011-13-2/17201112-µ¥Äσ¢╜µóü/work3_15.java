package assignments1;

import java.util.Scanner;

public class work3_15 {
	public static void main(String[] args){
		System.out.println("Enter your lottery pick (three digits):");
		Scanner input = new Scanner(System.in);
		int guess = input.nextInt();
		int lottery = (int)(Math.random()*1000);
		int lotter[] = new int[3];
		int gues[] = new int[3];
		//lottery= 123;
		
		lotter[0] = lottery/100;
		lotter[1] = lottery%100/10;
		lotter[2] = lottery%10;
		gues[0] = guess/100;
		gues[1] = guess%100/10;
		gues[2] = guess%10;
		int flag=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(lotter[i]==gues[j])
					flag+=1;
			}
		}
		System.out.println("The lottery numer is "+lottery);
		
		if(gues[0]==lotter[0]&&gues[1]==lotter[1]&&gues[2]==lotter[2])
			System.out.println("Exact match: you win $10000");
		else if(flag!=0)
			System.out.println("Exact match: you win $"+flag*1000);
		else
			System.out.println("Sorry :no match");
	}

}
