package work;
import java.util.Scanner;

public class work2 {
    public static void main(String[] args){
    	int year=0,m=0,n=0,j=0;
    	if((year%4==0&&year%100!=0)||year%400==0){
    		m=1;
    	}
    	else{
    		m=0;
    	}
    	int[] month={31,28+m,31,30,31,30,31,31,30,31,30,31};
    	System.out.println("please input year and month ");
    	while(j==0){
    	Scanner input =new Scanner(System.in);
    	year=input.nextInt();
    	n=input.nextInt();
    	if(n>0&&n<13){
    		j=1;
    	}
    	else{
    		System.out.println("Error! please once again");
    	}
    		
    	}
    	System.out.println(n+"th of "+ year+ " has " + month[n-1] + " days");
    	
    	
    }
}
