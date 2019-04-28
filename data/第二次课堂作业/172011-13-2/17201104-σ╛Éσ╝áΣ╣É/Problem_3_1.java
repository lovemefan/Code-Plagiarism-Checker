import java.util.Scanner;
public class Problem_3_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a ,b and c :");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double delta = discriminant(a,b,c);
        if (delta < 0){
            System.out.println("The equation has no real roots");
        }
        else if (delta == 0){
            double root = -b / (2 * a);
            System.out.println("The equation has one root " + root);
        }
        else {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("The equation has two roots " + root1 +  " and " + root2);
        }
    }
    public static double discriminant(double a,double b,double c){
        double delta = Math.pow(b,2) - 4 * a * c;
        return delta;
    }
}
