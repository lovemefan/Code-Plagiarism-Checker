package class1;

import java.util.Scanner;

public class question2 {
  public static void main(String[] args){
	  
	  Scanner input =new Scanner(System.in);
	  System.out.print("Enter the number of minutses: ");
	  int j=input.nextInt();
	  int k=j/525600;
	  //years
	  int l=j%525600;
	  int i=l/1440;
	  //days
	  System.out.print(j+"minutses is approximately "+k+"years and "+i+"days");
  }
}
