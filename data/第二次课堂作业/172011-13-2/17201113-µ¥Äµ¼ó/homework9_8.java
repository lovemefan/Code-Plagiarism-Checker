package homework;

public class homework9_8 {
	public static void main(String[] args){
		             Fan fan1=new Fan(3,true,10,"yellow");
		             Fan fan2=new Fan(2,false,5,"blue");
		             System.out.println(fan1.toString());
		             System.out.println(fan2.toString());
		               
	}

}

class Fan{
	private int speed;
	private boolean on;
	private double radius;
	String color;
	int SLOW=1;
	int MEDIUM=2;
	int FAST=3;
	
	Fan(){
		speed=SLOW;
		on=false;
		radius=5;
		color="blue";
	}
	
	Fan(int newSpeed,boolean newOn,double newRadius,String newColor){
		speed=newSpeed;
		on=newOn;
		radius=newRadius;
		color=newColor;
	}
	
     public String toString(){
    	  if(on!=false){
    		  return "The fan's color is: "+color+", speed is: "+speed+", radius is: "+radius;
    		  
    		  }
    	  else{
    		  return "fan is off,and it's color is: "+color+", speed is: "+speed+", radius is "+radius;
    	  }
      }
    void  setFan(int newSpeed,boolean newOn,double newRadius,String newColor){
 		speed=newSpeed;
 		
 		on=newOn;
 		radius=newRadius;
 		color=newColor; 
}
}
