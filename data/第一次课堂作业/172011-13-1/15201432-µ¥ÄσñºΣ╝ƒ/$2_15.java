import java.util.Scanner;

public class $2_15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter x1 and y1:");
		
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		
		System.out.println("Enter x2 and y2:");
		
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		double numberx = (x2-x1)*(x2-x1);
		double numbery = (y2-y1)*(y2-y1);
		double sum1 = numberx+numbery;
		double sum2 = Math.pow(sum1, 0.5);
		System.out.println("The distance between the two points is  " + sum2 );
		
		if (input !=null){
			input.close();
		}
	}

}
