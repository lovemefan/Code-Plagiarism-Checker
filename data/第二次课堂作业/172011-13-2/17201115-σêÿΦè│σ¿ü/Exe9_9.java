package dame;

public class Exe9_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 RegularPolygon c1 = new  RegularPolygon();
		 System.out.println("The first regular polygon's perimeter is "+c1.getPerimeter()+" erae is "+c1.getArea()+"\n");
		 RegularPolygon c2 = new  RegularPolygon();
		 c2.RegularPolygon(6,4);
		 System.out.println("The sevond regular polygon's perimeter is "+c2.getPerimeter()+" erae is "+c2.getArea()+"\n");
		 RegularPolygon c3 = new  RegularPolygon();
		 c3.RegularPolygon(10, 4, 5.6, 7.8);
		 System.out.println("The third regular polygon's perimeter is "+c3.getPerimeter()+" erae is "+c3.getArea()+"\n");
	}

}
class RegularPolygon{
	private int n;
	private double side ;
	private double x;
	private double y;
	 RegularPolygon(){
		n = 3;
        side =1.0;
        x= 0;
		y= 0;
   }
    public void  RegularPolygon(int n,double side){
		this.n=n;
		this.side=side;
		x=0;
		y=0;
		
	}
	public void RegularPolygon(int n,double side,double x,double y){
		this.n=n;
		this.side=side;
		this.x=x;
		this.y=y;
	}
	
	public double getPerimeter(){//周长
		double Perimeter =side*n;
		return Perimeter;
	}
	public double getArea(){//面积
		double Area =(n*side*side)/4*(Math.tan(Math.PI/n));
		return Area;
	}
	//各项数据修改和查询
	public void setN(int n){
		this.n=n;
	}
	public int getN(){
		return n;
	}
	public void setSide(double side){
		this.side=side;
	}
	public double getSide(){
		return side;
	}
	public void setCenter(double x,double y){
		this.x=x;
		this.y=y;
	}
	public double getCenterx(){
		return x;
	}
	public double getCentery(){
		return y;
	}
}