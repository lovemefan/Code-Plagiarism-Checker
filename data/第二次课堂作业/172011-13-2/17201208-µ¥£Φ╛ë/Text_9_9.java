
public class Text_9_9 {
	 public static void main(String[] args) {
		RegularPolygon r1 = new RegularPolygon();
    	RegularPolygon r2 = new RegularPolygon(6,4);
    	RegularPolygon r3 = new RegularPolygon(10,4,5.6,7.8);
    	System.out.println(r1.getPerimeter() +" " +  r1.getArea());
    	System.out.println(r2.getPerimeter() + " " + r2.getArea());
    	System.out.println(r3.getPerimeter() + " " + r3.getArea());
	 }
}
class RegularPolygon{
    int n = 3;
    double side = 1;
    double x = 0;
    double y = 0;

   RegularPolygon(){

   }

    RegularPolygon(int n,double side){
        this.n = n;
        this.side = side;
    }

    RegularPolygon(int n,double side,double x,double y){
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }
    double getPerimeter(){
        return side * n;
    }

    double getArea(){
        return (n * side) / (4 * Math.tan(Math.PI / n));
    }
}