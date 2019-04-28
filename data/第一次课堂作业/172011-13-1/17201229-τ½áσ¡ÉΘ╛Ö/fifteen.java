import java.util.Scanner;
public class fifteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Enter x1 and y1:");
        Scanner input = new Scanner(System.in);
        Double x1 = input.nextDouble();
        Double y1 = input.nextDouble();
        System.out.println("Enter x2 and y2£º");
        Double x2 = input.nextDouble();
        Double y2 = input.nextDouble();
        Double dis = Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5);
        System.out.println("The distance between two points is "+dis);
	}

}

