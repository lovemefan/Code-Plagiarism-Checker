import java.util.Scanner;
public class ninteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Enter three points for a triangle:");
        Scanner input = new Scanner(System.in);
        Double x1 = input.nextDouble();
        Double y1 = input.nextDouble();
        Double x2 = input.nextDouble();
        Double y2 = input.nextDouble();
        Double x3 = input.nextDouble();
        Double y3 = input.nextDouble();
        Double s1 = Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5);
        Double s2 = Math.pow((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1),0.5);
        Double s3 = Math.pow((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3),0.5);
        Double s = (s1+s2+s3)/2;
        Double area = Math.pow(s*(s-s1)*(s-s2)*(s-s3), 0.5);
        System.out.println("The area of the traigle is "+area);
	}

}
