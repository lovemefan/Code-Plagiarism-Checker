package Lesson_2;
import java.util.Scanner;

public class CaiPiao//彩票游戏
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		int a=(int)(Math.random()*10);
		int b=(int)(Math.random()*10);
		int c=(int)(Math.random()*10);//产生三个随机数
		
		System.out.println("please Enter your first guess");
		int g1=input.nextInt();
		int g2=input.nextInt();
		int g3=input.nextInt();//接受三个猜数
		
		if(g1==a&&g2==b&&g3==c) {//顺序全队
			System.out.println("first prise!");
		}
		else if(g1==a&&g2==c&&g3==b||g1==b&&g2==a&&g3==c||g1==b&&g2==c&&g3==a||g1==c&&g2==b&&g3==a||g1==c&&g2==a&&g3==b) {
			System.out.println("second prise!");//数字全有但顺序不对
		}
		else if(g1==a||g1==b||g1==c||g2==a||g2==b||g2==c||g3==a||g3==b||g3==c){
			System.out.println("threth prise!");//只猜对一个数字
		}
		else {
			System.out.println("sorry! you lose!");
		}//没猜对一个数字
	}
}
