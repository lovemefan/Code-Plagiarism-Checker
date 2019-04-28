import java.util.Scanner;
public class Work7{
	public static void main(String[] args){
		int Year=0,Num,Day;
		Scanner input;
		input=new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		while(true){
			try{
			        Num=input.nextInt();
			}catch(Exception e){
				input=new Scanner(System.in);
				System.out.print("ERROR INPUT!\nEnter the number of minutes again:");
				continue;
			}
			if(Num<0)
			{

				input=new Scanner(System.in);
				System.out.print("ERROR INPUT!\nEnter the number of minutes again:");
				continue;
			}
			break;
		}
		Day=Num/(60*24);
		Year=Day/365;
		Day=Day%365;
		System.out.println(Num+ " minutes is approximately "+Year+" years and "+Day+" days");
	}
}
