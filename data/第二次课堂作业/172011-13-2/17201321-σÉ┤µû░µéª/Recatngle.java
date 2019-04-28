
public class Recatngle {
	public static void main(String[] arge){
		Recatngle r1 = new Recatngle(4,40);
		System.out.println("The Rectangel's width  is "+ r1.width+" height is "+r1.height+" area is "+r1.getAre()+" perimeter is "+r1.getPerimeter());
		Recatngle r2 = new Recatngle(3.5,35.9);
		System.out.println("The Rectangel's width  is "+ r2.width+" height is "+r2.height+" area is "+r2.getAre()+" perimeter is "+r2.getPerimeter());
	}
	double width,height;
	Recatngle(){
		width=1;
		height=1;
	}
	Recatngle(double newWidth,double newHeight){
		width = newWidth;
		height = newHeight;
	}
	double getAre(){
		return width*height;
	}
	double getPerimeter(){
		return (width+height)*2;
	}
}
