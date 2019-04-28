import java.util.Scanner;

public class Class3_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        int[] book = new int [10];
        int lottery = (int) (Math.random()*1000);
//        System.out.println(lottery);
        for (int i=0;i<=9;i++)
        {
        	book[i]=0;
        }
        int k=lottery;
        while (k>0)
        {
        	book[k%10]++;
        	k=k/10;
        }
        System.out.print("Enter your lottery pick (there digits): ");
        int guess = input.nextInt();
        if (guess==lottery)
        {
        	System.out.println("Exact match: you win $10,000");
        }
        else 
        {
        	k=guess;
        	int ans=0;
        	while (k>0)
        	{
        		if (book[k%10]!=0)
        		{
        			ans++;book[k%10]--;
        		}
        		k=k/10;
        	}
        	if (ans==3)
        		System.out.println("Match all digits:you win $3,000");
        	else if (ans!=0)
        	{
        		System.out.println("Match one or two digit:you win $1,000");
        	}
        	else if(ans==0)
        	{
        		System.out.println("Sorry, no match");
        	}
        }
	}
}
