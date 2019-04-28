
public class Text_9_1{
	public static void main(String[] args){
		
		Rectangle R = new Rectangle();
		System.out.println(R.getArea() + " " + R.getPerimeter());
		R.setWidth(2.0);
		R.setHeight(2.0);
		System.out.print(R.getArea() + " " + R.getPerimeter());
	}
}
class Rectangle {
    double width = 1.0;
    double height = 1.0;

    Rectangle(){
    	
    }

    void setWidth(double width){
        this.width = width;
    }

    void setHeight(double height){
        this.height = height;
    }

    double getArea(){
        return width * height;
    }

    double getPerimeter(){
        return (width + height) * 2;
    }

}
