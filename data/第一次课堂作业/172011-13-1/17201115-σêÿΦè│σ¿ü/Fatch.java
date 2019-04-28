package dame;

import java.util.Scanner;

public class Fatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number from 0 to 1000");
    int x = input.nextInt();//输入整数
    if(x>0&&x<1000){
    	int unit = x%10;//个位
    	int decade = (x%100)/10;
    	int kilobit = x/1000;
    	int total = unit+decade+kilobit;
    	System.out.println("The sum of the digits is "+total);
     }
    else  
    	System.out.println("The number is mietake!");
	}

}
