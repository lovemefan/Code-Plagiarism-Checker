import java.util.Scanner;

//3.1
public class SolveAnEquation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double detal = Math.pow(b, 2) - 4 * a * c;
        if(detal == 0.0)
        {
            double root = -b / (2 * a);            
            System.out.println("The equation has one root " + root);
        }
        else if(detal > 0)
        {
            double root1 = (-b + Math.sqrt(detal)) / (2 * a);
            double root2 = (-b - Math.sqrt(detal)) / (2 * a);
            System.out.println("The equation has two roots " +
                               String.format("%.6f", root1) + " and " +
                               String.format("%.6f", root2));
        }
        else
        {
          System.out.println("The equation has no real roots");
        }
        input.close();
    }
}