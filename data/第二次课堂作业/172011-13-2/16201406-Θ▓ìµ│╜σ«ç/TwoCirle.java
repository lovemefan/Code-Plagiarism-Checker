import java.util.Scanner;

class TwoCirle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter circle1's center x-,y-coordinates,and radius:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double r1 = input.nextDouble();
		System.out.println("Enter circle2's center x-,y-coordinates,and radius:");
		double c = input.nextDouble();
		double d = input.nextDouble();
		double r2 = input.nextDouble();
		
		double e = (a-c)*(a-c)+(b-d)*(b-d);
		double f = Math.pow(e, 0.5);
		if(f<=Math.abs(r1-r2))
			System.out.println("circle2 is inside circle1");
		else if(f<=r1+r2)
			System.out.println("circle2 is overlaps circle1");
		else if(f>r1+r2)
			System.out.println("circle2 does not overlap circle1");


	}
	
	
	
	
	
	

}
