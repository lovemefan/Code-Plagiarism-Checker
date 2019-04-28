package work1015;

public class work9d9 {
	public static void main(String args[]){
		RegularPolygon reg1=new RegularPolygon();
		RegularPolygon reg2=new RegularPolygon(6,4);
		RegularPolygon reg3=new RegularPolygon(10,4,5.6,7.8);
		System.out.println("The first  Reg (per: "+reg1.getPerimeter()+" area:"+reg1.getArea()+")");
		System.out.println("The second Reg (per: "+reg2.getPerimeter()+" area:"+reg2.getArea()+")");
		System.out.println("The third  Reg (per: "+reg3.getPerimeter()+" area:"+reg3.getArea()+")");
	}
}
