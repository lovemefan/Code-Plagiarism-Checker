import java.util.Scanner;
public class Problem_2_19 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter three points for the triangle:");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double a = dis(x1,y1,x2,y2);
        double b = dis(x1,y1,x3,y3);
        double c = dis(x2,y2,x3,y3);
        double s = (a + b +c) / 2;
        double area = Math.pow(s * (s-a) * (s-b) * (s-c),0.5);
        System.out.printf("The area of the triangle is %.2f",area);//精确至小数点后两位
    }
    public static double dis(double x1,double y1,double x2,double y2){
        double a = Math.pow(Math.pow(x2-x1,2)+Math.pow(y2-y1,2),0.5);
        return a;
    }
}
