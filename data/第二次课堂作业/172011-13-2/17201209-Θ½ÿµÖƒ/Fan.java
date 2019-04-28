
public class Fan {
    public static void main(String[] args){
	    Fan fan1 = new Fan();
	    fan1.setSpeed(FAST);
	    fan1.setOn(true);
	    fan1.setRadius(10);
	    fan1.setColor("yellow");
	    
	    Fan fan2 = new Fan();
	    fan2.setSpeed(MEDIUM);
	    fan2.setOn(false);
	    fan2.setRadius(5);
	    fan2.setColor("blue");
	    System.out.println( "fan1 is "+ fan1.toString());
        System.out.println( "fan2 is "+ fan2.toString());
	    }
	    final static int SLOW = 1;
	    final static int MEDIUM = 2;
	    final static int FAST = 3;
	    private int speed = SLOW;
	    private boolean on = false;
	    private double radius = 5;
	    private String color = "blue";
		public int getSpeed(){
			return speed;
		}
		public void setSpeed(int speed){
			this.speed = speed;
		}
		public boolean isOn(){
			return on;
		}
		public void setOn(boolean on){
			this.on = on;
		}
		public double getRadius(){
			return radius;
		}
		public void setRadius(double radius){
			this.radius = radius;
		}
		public String getColor(){
			return color;
		}
		public void setColor(String color){
			this.color = color;
		}
		public Fan(){
			speed = SLOW;  
			on = false;
			radius = 5;
			color = "blue";
		}
		public String toString(){
			if(on == true)
				 return "Fan speed: "+this.getSpeed()+" Fan color: "+this.getColor()+" Fan radius: "+this.getRadius();
		else
			return "fan is off,Fan color£º"+this.getColor()+" Fan radius: "+this.getRadius();
		}
	}
	