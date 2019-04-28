import java.util.Scanner;
public class Count{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a.b.c:");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double r1,r2,flag1,flag2;
        flag1 = extracted(a, b, c);
        flag2 = Math.pow(flag1, 0.5);
        if(flag1 > 0){
            r1 = ((-1)*b + flag2)/2.0;
            r2 = ((-1)*b - flag2)/2.0;
            System.out.print("The question has two roots "+r1+ " and "+r2);
        }
        else if(flag1 < 0){
            System.out.println("The equation has no real roots");
        }    
        else{
            r1 = r2 = ((-1)*b/2.0*a);
            System.out.print("The equsation has one root "+r1);
        }           
    }

    private static double extracted(double a, double b, double c) {
        double flag1;
        flag1 = b * b - 4 * a * c;
        return flag1;
    }
}
