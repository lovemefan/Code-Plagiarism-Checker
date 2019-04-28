package class2;
import java.util.Scanner;
public class quetion5 {
public static void main(String[] args){
	Rectangle  m1= new Rectangle(1, 1);
	System.out.println(" "+m1.height+" "+m1.width+" "+m1.getArea()+" "+m1.getPerimeter());
	Rectangle  m2= new Rectangle(4,40);
	System.out.println(" "+m2.height+" "+m2.width+" "+m2.getArea()+" "+m2.getPerimeter());
	Rectangle  m3= new Rectangle(3.5,35.9);
	System.out.println(" "+m3.height+" "+m3.width+" "+m3.getArea()+" "+m3.getPerimeter());

 }
}

class Rectangle{
		double width = 1;
		double height = 1;
	     Rectangle(double newWidth,double newHeight){
			this.width=newWidth;
			this.height=newHeight;
		}
		double getArea(){
			return width*height;
		}
		double getPerimeter(){
			return 2*(width+height);
		}
		void setRectangle(double newWidth,double newHeight){
			width=newWidth;
			height=newHeight;
		} 

	}

