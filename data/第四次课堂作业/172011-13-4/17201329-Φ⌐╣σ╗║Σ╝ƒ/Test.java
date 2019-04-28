import java.util.*;
public class Test {
	public static void main(String [] args){
		System.out.println("enter three side of a triangle:");
		Scanner input = new Scanner(System.in);
		Triangle triangle = new Triangle(input.nextDouble(),input.nextDouble(),input.nextDouble());
		input.nextLine();
		System.out.println("enter a color:");
		String color = input.nextLine();
		System.out.println("if set the triangle to this color(true/false)");
		boolean is = input.hasNextBoolean();
		if (is){
			triangle.setColor(color);
		}
		System.out.println("Area: " + triangle.getArea() + 
							" perimeter: " + triangle.gerPerimeter() + 
							" color:" + triangle.getColor());
	}

}
