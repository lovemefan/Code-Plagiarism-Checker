import java.util.Scanner;
public class Problem_3_29 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Circle1's x-, y-coordinates, and radius:");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double radius1 = input.nextDouble();
        System.out.println("Please enter Circle2's x-, y-coordinates, and radius:");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double radius2 = input.nextDouble();
        double dis = coorDis(x1,y1,x2,y2);
        double min = Math.abs(radius1-radius2);
        double max = radius1+radius2;
        if (dis <= min){
            if (radius1<radius2){
                System.out.println("Circle1 is inside Circle2");
            }
            else {
                System.out.println("Circle2 is inside Circle1");
            }
        }
        else if (dis <= max){
            System.out.println("Circle1 is overlaps Circle2");
        }
        else {
            System.out.println("Circle1 is not overlaps Circle2");
        }
    }
    public static double coorDis(double x1,double y1,double x2,double y2){
        double dis = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        return dis;
    }
}
