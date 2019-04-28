package work;

import java.util.Scanner;

public class work4 {
		public static void main(String[] args){
			double x1,y1,x2,y2,x3,y3;
			
			System.out.println("Enter three points for a teiangle");
			
			Scanner input  = new Scanner(System.in);
			
			x1 = input.nextDouble();
			y1 = input.nextDouble();
			x2 = input.nextDouble();
			y2 = input.nextDouble();
			x3 = input.nextDouble();
			y3 = input.nextDouble();
			
			double line1,line2,line3;
			
			line1=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
			line1=Math.pow(line1, 0.5);
			
			line2=(x3-x1)*(x3-x1)+(y3-y1)*(y3-y1);
			line2=Math.pow(line2, 0.5);
			
			line3=(x3-x2)*(x3-x2)+(y3-y2)*(y3-y2);
			line3=Math.pow(line3, 0.5);
			
			double s,area;
			
			s=(line1+line2+line3)/2;
			
			area=s*(s-line1)*(s-line2)*(s-line3);
			area=Math.pow(area, 0.5);
			
			area = (double)Math.round(area*100)/100;
			
			System.out.println("The area of hte triangle is " + area);
			
		}
		
}
