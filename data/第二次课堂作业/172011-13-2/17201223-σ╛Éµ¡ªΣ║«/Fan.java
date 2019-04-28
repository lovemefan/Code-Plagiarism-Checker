package homework;

public class Fan {
	private int speed;
	private boolean on;
	private double radius;
	String color;
	public Fan(){
		speed=1;
		on=false;
		radius=5;
		color="bule";
	}
	public void setspeed(int speed){
		this.speed=speed;
	}
	public void seton(boolean on){
		this.on=on;
	}
	public void setradius(double radius){
		this.radius=radius;
	}
	public void setcolor(String color){
		this.color=color;
	}
	public String toString(){
		String zu;
		String a="fan is off",b=" ";
		if (on==true)
		 zu=""+speed+b+color+b+radius;
		else
		zu=""+a+b+color+b+radius;
		return zu;
		
	}

}

