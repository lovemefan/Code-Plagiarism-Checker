import java.util.Scanner;

public class Code2_15 {
	private static Scanner input;
	
	public static void main(String[] args){
		input = new Scanner(System.in);
		System.out.print("Enter x1 and y1:");
		float x1 = input.nextFloat();
		float y1 = input.nextFloat();
		System.out.print("Enter x2 and y2:");
		float x2 = input.nextFloat();
		float y2 = input.nextFloat();
		float result = (float) Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5);
		System.out.println("The distance between the two points is "+result);
		
	}

}