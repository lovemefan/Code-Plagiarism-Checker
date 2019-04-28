package exercise2;
import java.util.Scanner;
public class exercise3_11 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the year and month:");
		int year=input.nextInt();
		int month=input.nextInt();
		String[] English={"January","February","March","April","May","June","July","August","September","October","November","December"};
		int[] Days1={30,28,31,30,31,30,31,31,30,31,30,31,30,31};
		int[] Days2={30,29,31,30,31,30,31,31,30,31,30,31,30,31};
		if((year%4==0&&year%100!=0)||(year%400==0)){
			System.out.println(English[month-1]+" "+year+" has "+Days1[month-1]+" days");
		}
		else{
			System.out.println(English[month-1]+" "+year+" has "+Days2[month-1]+" days");
		}
	}

}
