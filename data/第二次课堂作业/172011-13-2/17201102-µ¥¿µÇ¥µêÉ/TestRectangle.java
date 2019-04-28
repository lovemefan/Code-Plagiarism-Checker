
public class TestRectangle {
  public static void main(String[] args){
	  Rectangle Rec1=new Rectangle();
	  Rectangle Rec2=new Rectangle();
	  System.out.println("Please enter the width and the hight of Rec1 : ");
	  Rec1.GiveValue();
	  System.out.println("The width and the hight of Rec1 are :"+Rec1.getWidth()+" "+Rec1.getHight());
	  System.out.println("The area of the Rec1 is : "+Rec1.getArea());
	  System.out.println("The perimeter of the Rec1 is: "+Rec1.getPerimeter());
	  
	  System.out.println("Please enter the width and the hight of Rec2 : ");
	  Rec2.GiveValue();
	  System.out.println("The width and the hight of Rec2 are :"+Rec2.getWidth()+" "+Rec2.getHight());
	  System.out.println("The area of the Rec2 is : "+Rec2.getArea());
	  System.out.println("The perimeter of the Rec2 is: "+Rec2.getPerimeter());
  }
}
