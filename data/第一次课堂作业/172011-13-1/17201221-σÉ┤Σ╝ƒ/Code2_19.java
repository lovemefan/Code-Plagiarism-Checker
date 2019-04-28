import java.util.Scanner;

public class Code2_19 {
	private static Scanner input;
	
	public static void main(String[] args){
		input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		float x1 = input.nextFloat();
		float y1 = input.nextFloat();
		float x2 = input.nextFloat();
		float y2 = input.nextFloat();
		float x3 = input.nextFloat();
		float y3 = input.nextFloat();
		float l1 = (float)Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5);
		float l2 = (float)Math.pow((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2),0.5);
		float l3 = (float)Math.pow((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3),0.5);
		float s = (l1+l2+l3)/2;
		float area = (float)Math.pow(s*(s-l1)*(s-l2)*(s-l3), 0.5);
		System.out.println("The area of the triangle is "+area);
	}

}
