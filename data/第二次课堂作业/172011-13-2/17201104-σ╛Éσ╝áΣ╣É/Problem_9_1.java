import java.util.Scanner;
public class Problem_9_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Now you have two fans!");
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        rectangle1.setHeight(40);
        rectangle1.setWidth(4);
        rectangle2.setHeight(35.9);
        rectangle2.setWidth(3.5);
        System.out.println("The rectangle1's width is " + rectangle1.width +
                ", height is " + rectangle1.height +
                ", area is " + rectangle1.getArea() +
                " and perimeter is "+ rectangle1.getPerimeter());
        System.out.println("The rectangle2's width is " + rectangle2.width +
                ", height is " + rectangle2.height +
                ", area is " + rectangle2.getArea() +
                " and perimeter is "+ rectangle2.getPerimeter());
	}

}


class Rectangle {
    double width = 1;
    double height = 1;

    public Rectangle(){

    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return (width + height) * 2;
    }

}
