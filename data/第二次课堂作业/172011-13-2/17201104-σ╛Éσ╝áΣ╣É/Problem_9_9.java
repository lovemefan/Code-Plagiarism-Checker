import java.util.Scanner;
public class Problem_9_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Now you have two fans!");
        RegularPolygon r1 = new RegularPolygon();
        RegularPolygon r2 = new RegularPolygon(6,4);
        RegularPolygon r3 = new RegularPolygon(10,4,5.6,7.8);
        System.out.println("The regular polygon1's perimeter is " + r1.getPerimeter() +
                " and it's area is " + r1.getArea());
        System.out.println("The regular polygon2's perimeter is " + r2.getPerimeter() +
                " and it's area is " + r2.getArea());
        System.out.println("The regular polygon3's perimeter is " + r3.getPerimeter() +
                " and it's area is " + r3.getArea());
	}
}

class RegularPolygon{
    int n = 3;
    double side = 1;
    double x = 0;
    double y = 0;

    public RegularPolygon(){

    }

    public RegularPolygon(int n,double side){
        this.n = n;
        this.side = side;
    }

    public RegularPolygon(int n,double side,double x,double y){
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public int getN(){
        return n;
    }

    public double getSide(){
        return side;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void changeN(int n){
        if (n >= 3)
            this.n = n;
    }

    public void changeSide(double side){
        if (side > 0)
            this.side = side;
    }

    public void changeX(double x){
        this.x = x;
    }

    public void changeY(double y){
        this.y = y;
    }

    public double getPerimeter(){
        return side * n;
    }

    public double getArea(){
        return (n * side) / (4 * Math.tan(Math.PI / n));
    }
}


