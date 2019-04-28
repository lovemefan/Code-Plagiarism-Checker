package project2;
import java.util.Scanner;
public class P3_15 {

	public static void main(String[] args) {		Scanner input=new Scanner(System.in);
		int num=(int)(Math.random()*1000);
		int NUM=num;
		System.out.print("Please enter a three whole digit:");
		int number=input.nextInt();
		int Num[]=new int[3];
		int Number[]=new int[3];
		int i,j;
		for(i=0;i<3;i++) {
			Num[i]=num%10;
			num=num/10;
			Number[i]=number%10;
			number=number/10;
		}
		int count=0;
		int count2=0;
	    for(i=0;i<3;i++) {
	    	for(j=0;j<3;j++) {
	    		if(Num[i]==Number[j]){
	    			count++;
	    			Number[j]=-1;
	    			if(i==j) {
	    				count2++;
	    			}
	    			break;
	    		}	    		
	    	}
	    }
	    System.out.println("The right number is: "+NUM);
	    if(count2==3) {
	    	System.out.println("You win 10000 dollars");
	    }
	    else{
	    	System.out.println("you win "+count*1000+" dollars");
	    }
		input.close();

	}

}
