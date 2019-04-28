import java.util.*;
public class Rectangle {
    private double width=1,hight=1;
    Rectangle(){
    	
    }
    public void GiveValue(){
    	Scanner input=new Scanner(System.in);
    	width=input.nextDouble();
    	hight=input.nextDouble();
    }
    public double getWidth(){
    	return width;
    }
    public double getHight(){
    	return hight;
    }
    public double getArea(){
    	return width*hight;
    }
    public double getPerimeter(){
    	return (width+hight)*2;
    }
    
}
