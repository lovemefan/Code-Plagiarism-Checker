package work;

public class C9_8 {
	
	public static void main(String[] args){
	       Fan f1 = new Fan();
	       f1.setSpeed(3);
	       f1.setColor("yellow");
	       f1.setRadius(10);
	       f1.setOn(true);
	     Fan f2 = new Fan();
	     f2.setColor("blue");
	     f2.setOn(false);
	     f2.setRadius(5);
	     System.out.println(f1.toString());
	     System.out.println(f2.toString());
	     
	}
	

		final int SLOW = 1, MEDIUM = 2, FAST = 3;
		private int speed;
		private boolean on ;
		private double radius ;
		String color ;
		
	   public void Fan(){
		 speed = SLOW;
		 on = false;
		radius=5;
		 color="blue";
	}
	  public void Fan(int speed , String color ,double radius){
		     this.speed = speed;
		     this.color = color;
		     this.radius = radius;
	}
	
	int getSpeed(){
		return speed;
	}
	String getColor(){
		return color;
	}
	double getRadius(){
		return radius;
	}
		void setSpeed(int newSpeed){
			speed = newSpeed;
		}
		void setColor(String  newColor){
			color = newColor;
		}
		void setRadius(double newRadius){
			radius = newRadius;
		}
	
	public String toString() {
		if(on==true){
			return "  " + speed +"  "+color+"  "+radius;
		}
		else{
			return " fan is off " +color+ "  "+radius;
		}
	}
	}

	

