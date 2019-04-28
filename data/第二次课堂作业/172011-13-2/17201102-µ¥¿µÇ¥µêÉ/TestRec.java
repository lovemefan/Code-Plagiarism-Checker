
public class TestRec {
  public static void main(String[] args){
	  RegularPolygon Rec1=new RegularPolygon();
	  RegularPolygon Rec2=new RegularPolygon(6,4);
	  RegularPolygon Rec3=new RegularPolygon(10,4,5.6,7.8);
	  System.out.println("The perimeter and the area of Rec1 is :"+Rec1.getPerimeter()+" "+Rec1.getArea());
	  System.out.println("The perimeter and the area of Rec1 is :"+Rec2.getPerimeter()+" "+Rec2.getArea());
	  
  }
}
