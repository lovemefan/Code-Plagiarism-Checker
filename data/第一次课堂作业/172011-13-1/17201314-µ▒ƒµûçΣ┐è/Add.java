import java.util.Scanner;

public class Add {
     public static void main(String[] args){
    	 Scanner input = new Scanner(System.in);
    	 int num = 0,flag=1;
    	 while(flag==1){
    	    System.out.print("Enter a number between 0 and 1000:");
    	    num = input.nextInt();
    	    if(num<0||num>=1000){
    	    	System.out.println("ERROR!");
    	    }
    	    else{
    	    	flag=0;
    	    }
    	 }
    	    int i=0,answer=0;
    	    while(num!=0){
    		     i=num%10;
    		     answer+=i;
    		     num=num/10;
       }
    	 System.out.println("The sum of the digits is "+answer);
 	    if(input!=null){
	    	input.close();
	    }
     }
}
