package homework;

public class Nine_9 {
     public static void main(String[] args){
    	 RegularPolygon c1=new RegularPolygon();
    	 RegularPolygon c2=new RegularPolygon(6,4);
    	 RegularPolygon c3=new RegularPolygon(10,4,5.6,7.8);     
    	 System.out.println("area:"+c1.getArea()+ " getPerimeter:"+c1.getPerimeter());
     
     System.out.println("area:"+c2.getArea()+ " getPerimeter:"+c2.getPerimeter());
     System.out.println("area:"+c3.getArea()+ " getPerimeter:"+c3.getPerimeter());
     }
}
