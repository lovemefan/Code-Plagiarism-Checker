
public class Work99 {
	public static void main(String[] args){
		RegularPolygon reg1 = new RegularPolygon();
		RegularPolygon reg2 = new RegularPolygon(6,4);
		RegularPolygon reg3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println("One of Perimeter is " + reg1.getPerimeter() + ",area is " + reg1.getArea());
		System.out.println("Two of Perimeter is " + reg2.getPerimeter() + ",area is " + reg2.getArea());
		System.out.println("Three of Perimeter is " + reg3.getPerimeter() + ",area is " + reg3.getArea());
	}
}
