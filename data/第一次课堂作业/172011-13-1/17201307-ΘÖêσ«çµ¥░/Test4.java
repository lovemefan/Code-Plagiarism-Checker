import java.util.Scanner;
public class Test4 {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		System.out.println("Enter three points for a triangle");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		double a=Math.pow(Math.pow((x2-x1),2)+Math.pow((y2-y1),2),0.5);
		double b=Math.pow(Math.pow((x2-x3),2)+Math.pow((y2-y3),2),0.5);
		double c=Math.pow(Math.pow((x3-x1),2)+Math.pow((y3-y1),2),0.5);
		double p=(a+b+c)/2;
		double s=Math.pow(p*(p-a)*(p-b)*(p-c),0.5);
		System.out.println("The area of the triangle "+s);
		if(input!=null){
			input.close();
		}
	}
}
