import java.util.Scanner;

public class $2_19 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter three points for a triangle:");
		
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
				
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();		
			
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		
		
		double ab_side1 = (x2-x1)*(x2-x1);
		double ab_side2 = (y2-y1)*(y2-y1);
		double ab1 = ab_side1 + ab_side2;
		double ab2 = Math.pow(ab1, 0.5);
		
		double ac_side1 = (x3-x1)*(x3-x1);
		double ac_side2 = (y3-y1)*(y3-y1);
		double ac1 = ac_side1 + ac_side2;
		double ac2 = Math.pow(ac1, 0.5);
		
		double bc_side1 = (x3-x2)*(x3-x2);
		double bc_side2 = (y3-y2)*(y3-y2);
		double bc1 = bc_side1 + bc_side2;
		double bc2 = Math.pow(bc1, 0.5);
		
		double s1=(ab2+ac2+bc2)/2;
		double s2=s1*(s1-ab2)*(s1-ac2)*(s1-bc2);
		double area=Math.pow(s2, 0.5);
		
		
		System.out.println("The area of the triangle is  "  + area);
		
		if (input !=null){
			input.close();
		}
	}

}
