package work1015;

import java.util.Scanner;
public class work3d15 {
	public static void main(String args[]){
		Scanner enter=new Scanner(System.in);
		
		int lottery=(int)(Math.random()*1000);
		int lot1,lot2,lot3;
		lot1=lottery/100;
		lot2=(lottery-lot1*100)/10;
		lot3=lottery%10;
		System.out.println("The lottery is:"+lottery+" "+lot1+" "+lot2+" "+lot3);
		
		System.out.println("Enter your lottery pick (three digits):");
		int guest;
		guest=enter.nextInt();
		int gue1,gue2,gue3;
		gue1=guest/100;
		gue2=(guest-gue1*100)/10;
		gue3=guest%10;
		//System.out.println(gue1+" "+gue2+" "+gue3);
		
		int flag[]=new int[]{0,0,0,0,0,0,0,0,0,0,0};
		
		flag[lot1]++;
		flag[lot2]++;
		flag[lot3]++;
		flag[gue1]--;
		flag[gue2]--;
		flag[gue3]--;
		if(gue1==lot1&&gue2==lot2&&gue3==lot3)
		{
			System.out.println("Exact match: you win $10,000");
		}
		else 
		{
			int flag0=0;
			for(int i=0;i<=9;i++)
			{
				if(flag[i]!=0)
					{
						flag0=1;
						break;
					}
			}
			if(flag0==0)
			{
				System.out.println("Match all digits: you win $3,000");
			}
			else 
			{
				String dig[]=new String[]{"one","two"};
				for(int i=0;i<=9;i++)//time 只能为1 or 2
				{
					flag[i]=-1;
				}
				flag[lot1]=1;
				flag[lot2]=1;
				flag[lot3]=1;
				flag[gue1]=0;
				flag[gue2]=0;
				flag[gue3]=0;
				int time=0;
				for(int i=0;i<=9;i++)//time 只能为1 or 2
				{
					if(flag[i]==1)time++;
				}
				if(time!=3)
				{
					int t=2-time;
					System.out.println("Match "+dig[t]+" digit: you win $"+(3-time)+",000");
				}
				else System.out.println("Sorry, no match");
			}
		}
	}
}
