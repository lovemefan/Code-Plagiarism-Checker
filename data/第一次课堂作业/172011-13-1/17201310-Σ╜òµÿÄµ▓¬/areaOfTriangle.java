import java.util.Scanner;

/**
 * 2.19 areaOfTriangle
 */
public class areaOfTriangle {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three points for a triangle:");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        double side1_2 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double side1_3 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double side2_3 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        double side = (side1_2 + side1_3 + side2_3) / 2.0;
        double area = Math.sqrt(side * (side - side1_2) * (side - side1_3) * (side - side2_3));
        System.out.printf("The area of triangle is %.1f\n" , area);
        input.close();
    }
}