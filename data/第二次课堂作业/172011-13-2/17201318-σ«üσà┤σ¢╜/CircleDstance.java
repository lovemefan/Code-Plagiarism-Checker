import java.util.Scanner;

public class CircleDstance {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		try{
			System.out.print("Enter circle's center x-, y-coordinates, "
					 + "and radius: ");
			float x1 = input.nextFloat();
			float y1 = input.nextFloat();
			float radius1 = input.nextFloat();
			System.out.print("Enter circle's center x-, y-coordinates, "
					 + "and radius: ");
			float x2 = input.nextFloat();
			float y2 = input.nextFloat();
			float radius2 = input.nextFloat();
			if(Math.pow(Math.pow(x1-x2, 2) + Math.pow(y1-y2,2), 0.5)
					<= Math.abs(radius1-radius2)){
				System.out.println("circle2 is inside circle1");
			}
			else if(Math.pow(Math.pow(x1-x2, 2) + Math.pow(y1-y2,2), 0.5)
					<= radius1+radius2){
				System.out.println("circle2 overlaps circle1");
			}
			else if(Math.pow(Math.pow(x1-x2, 2) + Math.pow(y1-y2,2), 0.5)
					> radius1+radius2){
				System.out.println("circle2 not overlaps circle1");
			}
		}
		finally{
			input.close();
		}
		
	}

}
