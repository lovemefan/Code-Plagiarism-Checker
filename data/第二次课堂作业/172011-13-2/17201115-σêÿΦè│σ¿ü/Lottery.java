package dame;

import java.util.Scanner;

public class Lottery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int result = (int)(Math.random()*1000);//���������1-1000
     Scanner input = new Scanner(System.in);
     
     int a1 = result/100;
     int b1 = result%100/10;
     int c1 = result%10;
     
     System.out.println("Enter your  lottery pick(three digits):");
     int x = input.nextInt();
     
     int a = x/100;        //��λ
     int b = x%100/10;    //ʮλ
     int c = x%10;       //��λ
     
     System.out.println("The lottery number is "+result);
     if(x==result){
    	 System.out.println("Exact match : you win $10000.");
     }
     else if((a==c1&&b==b1&&c==a1)||(a==c1&&b==a1&&c==b1)||(a==a1&&b==c1&&c==b1)||(a==b1&&b==a1&&c==c1)||(a==b1&&b==c1&&c==a1)){
    	 System.out.println("Exact match : you win $3000.");
     }
    	 else if(a==a1||a==b1||a==c1||b==c1||b==b1||b==a1||c==a1||c==b1||c==c1){
    	 System.out.println("Exact match : you win $1000");	 
    	 }
    	 else System.out.println("Sorry no match.");
      
	}

}
