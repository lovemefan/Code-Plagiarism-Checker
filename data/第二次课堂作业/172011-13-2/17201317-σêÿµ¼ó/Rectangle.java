package work;

public class Rectangle {
	
		double width=1,height=1;
		Rectangle(){
			width=height=1;
		}
		Rectangle(double newWidth,double newHeight){
			width=newWidth;
			height=newHeight;
		}
		double getArea(){
			return width*height;
		}
		double getPerimeter(){
			return 2*(width+height);
		}
		public void setWidth(double width){
			this.width = width;
		}
	}

