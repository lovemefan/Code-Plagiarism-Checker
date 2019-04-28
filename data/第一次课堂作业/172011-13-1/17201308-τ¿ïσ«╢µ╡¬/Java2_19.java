import java.util.Scanner;
public class Java2_19 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle£º");
double x1 = input.nextDouble();
double y1 = input.nextDouble();
double x2 = input.nextDouble();
double y2 = input.nextDouble();
double x3 = input.nextDouble();
double y3 = input.nextDouble();
double a = Math.pow(x1-x2,2);
double b = Math.pow(y1-y2,2);
double bian1 = Math.pow(a+b,0.5);
double c = Math.pow(x1-x3,2);
double d = Math.pow(y1-y3, 2);
double bian2 = Math.pow(c+d,0.5);
double e = Math.pow(x2-x3, 2);
double f = Math.pow(y2-y3,2);
double bian3 =Math.pow(e+f, 0.5);
double s = (bian1+bian2+bian3)/2;
double area = Math.pow(s*(s-bian1)*(s-bian2)*(s-bian3), 0.5);
	System .out.println("The area of the triangle is" + area);
	
	}


}
