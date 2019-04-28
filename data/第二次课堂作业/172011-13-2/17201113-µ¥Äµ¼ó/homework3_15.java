package homework;

import java.util.Scanner;

public class homework3_15 {
       public static void main(String[] args){
    	   int lottery=(int)(Math.random() * 1000);
    	   Scanner input=new Scanner(System.in);
    	   System.out.println("Enter your lottery pick(three digits):");
    	   int guess=input.nextInt();
    	   int l1=lottery/100;
    	   int l2=lottery/10%10;
    	   int l3=lottery%10;
    	   
    	   int g1=guess/100;
    	   int g2=guess/10%10;
    	   int g3=guess%10;
    	   System.out.println("The lottery number is: "+lottery);
    	   
    	   if(lottery==guess){
    		   System.out.println("Exact match: you win $10000");
    	   } 
    	   
    	   else if((l1==g1&&l2==g3&&l3==g2)||(l1==g2&&l2==g3&&l3==g1)||(l1==g2&&l2==g1&&l3==g3)||(l1==g3&&l2==g1&&l3==g2)||(l1==g3&&l2==g2&&l3==g1)){
    		   System.out.println("Match all digits: you win $3000");
    	   }
    	   
    	   else if(l1!=g1&&l1!=g2&&l1!=g3&&l2!=g1&&l2!=g2&&l2!=g3&&l3!=g1&&l3!=g2&&l3!=g3){
    		   System.out.println("Sorry,no match");
    	   }
    	   else{
    		   System.out.println("Match one or two digits: you win $1000");
    	   }
    	
    		  
    	   
       }
}
