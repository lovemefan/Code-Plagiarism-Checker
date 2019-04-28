package Lesson_2;

public class TestMain//测试用类
{
	public static void main(String[] args) {
		Rectangle r1;//创造一个类的引用
		r1=new Rectangle();//实例化
		System.out.println(r1.getArea()+" "+r1.getPerimeter());
		
		Stock s1;
		s1=new Stock();
		System.out.println(s1.name+" "+s1.symbol);
		
		Fan f1;
		f1=new Fan();
		f1.speed=f1.setSpeed(3);
		System.out.println(f1.color+" "+f1.speed+" "+f1.toString());
		
		RegularPolygon r2;
		r2=new RegularPolygon(4,1,1,1);
		System.out.println(r2.n+" "+r2.side+" "+r2.getArea()+" "+r2.getPerimeter());
		
	}
}
