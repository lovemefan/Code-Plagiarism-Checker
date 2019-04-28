package Zuoye;

public class Rctangle{

public static void main(String[] args){
	rctangle juxing=new rctangle();
	System.out.println("The area of rctangle is:"+juxing.getarea());
}
}
		class rctangle {
		double width;
		double height;
		rctangle(){
			width=1;
			height=1;
		}
		rctangle(double newwidth,double newheight){
			width=newwidth;
			height=newheight;
		}
		double getarea(){
			return width*height;
		}
		}
	

