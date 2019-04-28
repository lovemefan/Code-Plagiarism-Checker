package nice;
import java.util.Scanner;
public class Lottery {
	public static void main(String[] args){
		int lottery = (int)(Math.random() * 1000);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (three digits):");
		int guess = input.nextInt();
	    int[] l=new int[3];
	    int[] g=new int[3];
		l[0] = lottery / 100;
		l[1] = (lottery % 100) / 10;
		l[2] = (lottery % 100) % 10;
		g[0] = guess / 100;
		g[1] = (guess % 100) / 10;
		g[2] = (guess % 100) % 10;
		int M=0,i,j,f=-1;
		for (i=0;i<3;i++){
			for (j=0;j<3;j++){
				if (g[i]==l[j]){
					M = M + 1000;
					g[i] = l[j] = f;
					 f = f - 1;
				               }
							 }
		                 }
			if (lottery==guess)
					M = 10000;
			System.out.print("The lottery number is " + lottery);
			System.out.print("You match $ " + M);

				}
					
		}
	
	


