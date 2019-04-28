import java.util.Scanner;
public class Text_3_15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int randnum = (int)(Math.random()*899)+100;
		//System.out.println(randnum);
		int[] a = new int[10];
		int[] b = new int[10];
		int numa = 0,numb = 0;
		System.out.print("Please input a number(100-999) ");
		int num = input.nextInt();
		while(randnum != 0&&num != 0){
			a[++numa] = randnum%10;
			randnum /= 10;
			b[++numb] = num%10;
			num /= 10;
		}
		int flag = 1;
		for(int i = 3;i>=1;i--){
				if(a[i]!=b[i])
					flag = 0;
		}
		if(flag == 1)
			System.out.print(10000);
		else{
			flag = 1;
		int flagl = 0;
		int[] vis = new int[10];
		for(int  i = 1;i <= 4;i++)
			vis[i] = 1;
		for(int i = 3;i >= 1;i--){
			for(int j = 3;j>=1;j--){
				if(b[i]==a[j]&&vis[j]==1){
					vis[j] =0;
					flagl ++;
					break;
				}
			}
		}
		System.out.printf("%d",flagl*1000);
		}
	}
}
