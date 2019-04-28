package class2;
import java.util.Scanner;
public class question2 {
	public static void main(String[] args){
		System.out.println(" Enter a month and a year :");
		 Scanner input =new Scanner(System.in);
		 int a=input.nextInt();
		 int b=input.nextInt();
		 switch(a){
		 case 1:System.out.println("January "+b+" has "+31+"days");break;
		 case 2:if(b%4==0){
		        System.out.println("February"+b+" has "+29+"days");break;
		 }
		 else if(b%4!=0){
			    System.out.println("February"+b+" has "+28+"days");break;
		 }
		 case 3:System.out.println("March"+b+" has "+31+"days");break;
		 
		 case 4:System.out.println("April "+b+" has "+30+"days");break;
		 case 5:System.out.println("May "+b+" has "+31+"days");break;
		 case 6:System.out.println("June "+b+" has "+30+"days");break;
		 case 7:System.out.println("July "+b+" has "+31+"days");break;
		 case 8:System.out.println("August "+b+" has "+31+"days");break;
		 case 9:System.out.println("September "+b+" has "+30+"days");break;
		 case 10:System.out.println("October "+b+" has "+31+"days");break;
		 case 11:System.out.println("November "+b+" has "+30+"days");break;
		 case 12:System.out.println("December "+b+" has "+31+"days");break;
		 }
	}
}
