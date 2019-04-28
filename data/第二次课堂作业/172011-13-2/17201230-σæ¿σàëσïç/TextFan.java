package homework;

public class TextFan {
	public static void main(String[] args){
		Fan fan1=new Fan();
		fan1.toString();
		Fan fan2=new Fan();
		fan2.toString();
}
public class Fan{
	int SLOW=1;
	int MEDIUM=2;
	int FAST=3;
	private int speed=1;
	boolean on=false;
	double radius=5;
	String color="blue";
	public Fan( int newspeed,boolean newon,double newradius,String newcolor){
		speed=newspeed;
		on=newon;
		radius=newradius;
		color=newcolor;
	}
	public String  toString(){
	String string1=speed+" "+radius+" "+color;
	String string2="fan is off "+color+" "+radius;
		if(on==true)
			return string1;
			else
				return string2;
	}
	void setFan(int newspeed,boolean newon,double newradius,String newcolor){
		speed=newspeed;
		on=newon;
		radius=newradius;
		color=newcolor;
	}
 }
}