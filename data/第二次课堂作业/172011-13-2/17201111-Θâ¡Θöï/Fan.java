package exercise2;

public class Fan {
	public static void main(String[] args){
		int speed;
		boolean on;
		double radius;
		String color;
		int SLOW=1,MEDIUM=2,FAST=3;
		Fan fan1=new Fan();
		fan1.setData(FAST, true, 10, "yellow");
		System.out.println(fan1);
		Fan fan2=new Fan();
		fan2.setData(MEDIUM,true, 5, "blue");
		System.out.println(fan2);
	}
	int speed;
	boolean on;
	double radius;
	String color;
	int SLOW=1,MEDIUM=2,FAST=3;
	Fan(){
		int speed;
		speed=SLOW;
		boolean on=false;
		double radius=5;
		String color="blue";
	}
    void setData(int speed,boolean on,double radius,String color){
    	this.speed=speed;
    	this.on=on;
    	this.radius=radius;
    	this.color=color;
    }
    public String toString(){
    	if(this.on){
    		return "speed:"+this.speed+"\ncolor:"+this.color+"\nradius:"+this.radius;
    	}
    	else{
    		return "fan is off\n"+this.speed+"\ncolor:"+this.color+"\nradius:"+this.radius;
    	}
    }
}