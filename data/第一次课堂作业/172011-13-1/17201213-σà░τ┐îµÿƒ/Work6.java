import java.util.Scanner;
public class Work6{
	public static void main(String[] args){
		int Sum=0,Num;
		Scanner input;
		input=new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		while(true){
			try{
			        Num=input.nextInt();
			}catch(Exception e){
				input=new Scanner(System.in);
				System.out.print("ERROR INPUT!\nEnter a number between 0 and 1000 again:");
				continue;
			}
			if(Num<0||Num>1000){
				input=new Scanner(System.in);
				System.out.print("ERROR INPUT!\nEnter a number between 0 and 1000 again:");
				continue;
			}
			break;
		}
		while(Num!=0){
			Sum+=(Num%10);
			Num=Num/10;
		}
		System.out.println("The sum of the digits is "+Sum);
	}
}
