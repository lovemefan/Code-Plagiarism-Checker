
public class Nine8 {
	public static void main(String[] args){
		
		int SLOW = 1;
		int MEDIUM = 2;
		int FAST = 3;
		
		Fan a1 = new Fan();
		Fan a2 = new Fan();
		
		double r1 = 10, r2 = 5;
		
		a1.setSpeed(FAST);
		a1.setRadius(r1);
		a1.setOn(true);
		a1.setColor("yellow");
		
		a2.setSpeed(MEDIUM);
		a2.setRadius(r2);
		a2.setOn(false);
		a2.setColor("blue");
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
	}

}
class Fan{
	
	private int speed = 1;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public void setOn(boolean a){
		this.on = a;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public String toString(){
		if (on == true)
			return(+speed +" " + color +" " + radius);
		else
			return("fan is off " + color + " " + radius);
	}
}