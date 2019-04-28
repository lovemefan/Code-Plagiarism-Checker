package mayday001;

import java.util.Scanner;

public class Cir {
	public static void main(String[] args){
		double r1,r2,x1,y1,x2,y2 = 0;
		System.out.println("please input the two circles center x-,y-coordinates,and radius : ");
		Scanner input = new Scanner(System.in);
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		r1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		r2 = input.nextDouble();
		double distance = Math.pow(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2), 0.5);
		if(distance<=Math.abs(r1-r2)){
			System.out.println("Circle2 is inside circle1. ");	
		}
		else if(distance<=r1+r2){
			System.out.println("Circle2 overlaps circle1. ");
		}
		else{
			System.out.println("Circle2 dose not voerlaps circle1. ");
		}
	}
}
