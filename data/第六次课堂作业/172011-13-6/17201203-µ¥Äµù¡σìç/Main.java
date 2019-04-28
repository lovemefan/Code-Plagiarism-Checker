package homework;
import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		Lever l = new Lever(1);
		Dial d = new Dial(1);
		Brush b = new Brush(0);
		Agent a = new Agent();
		
		int choice = 0;
		
		while(true){
			menu();
			choice = input.nextInt();
			switch(choice){
			case 1:
				l.upPos();				
				break;
			case 2:
				l.downPos();
				break;
			case 3:
				d.upPos();
				break;
			case 4:
				d.downPos();
				break;
			default:
				System.exit(0);
				break;
			}
			a.dealSpeed(l, d, b);
			
			System.out.println("Lever's pos:" + l.getPos());
			System.out.println("Dial's pos:" + d.getPos());
			System.out.println("Brush's speed:" + b.getSpeed());
				
		}
	}
	
	private static void menu()
	{
		System.out.println("please input your choice:");
		System.out.println("1:Lever up");
		System.out.println("2:Lever down");
		System.out.println("3:Dial up");
		System.out.println("4:Dial down");
		System.out.println("0:exit");
	}

}
