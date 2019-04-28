package class2;

import java.util.Scanner;

public class question4 {
	public static void main(String[] args){		
		Scanner input =new Scanner(System.in);
		System.out.println("Enter circle's center x-, y-coordinates,and radius:");
		 
		 double cx1=input.nextDouble();
		 double cy1=input.nextDouble();
		 double cr1=input.nextDouble();
			System.out.println("Enter circle's center x-, y-coordinates,and radius:");
			 double cx2=input.nextDouble();
			 double cy2=input.nextDouble();
			 double cr2=input.nextDouble();

			  double j=Math.pow(cx2-cx1,2);
			  double i=Math.pow(cy2-cy1,2);
			  double k=Math.pow(i+j, 0.5);
              double l=Math.abs(cr2-cr1);
              double p=Math.abs(cy2+cy1);
              if(k<=l){
            	  System.out.println("circle2 is inside circle1");
              }
              else if(k<=p){
            	  System.out.println("circle2 is overlaps circle1");
              }
              else{
            	  System.out.println("circle2 does not overlaps circle1");
              }

  
	}

}
