import java.util.*;
public class Fan {
       public final int SLOW=1,MEDIUM=2,FAST=3;
       private int speed=SLOW;
       private boolean on=false;
       private double radius=5;
       private String color="blue";
       Scanner input=new Scanner(System.in);
       public int getSpeed(){
    	   return speed;
       }
       public void setSpeed(int speed){
    	  this.speed=speed;
       }
       
       public boolean getOn(){
    	   return on;
       }
       public void isOn(boolean on){
    	  this.on=on;
       }
       
       public double getRadius(){
    	   return radius;
       }
       public void setRaidus(double radius){
    	  this.radius=radius;
       }
       
       public String getColor(){
    	   return color;
       }
       public void setColor(String color){
    	  this.color=color;
       }
       public Fan(){
    	   
       }
       public String toString(){
    	   String back;
    	   if (on==true){
    		   back="fan is on,the speed is "+speed+" color is "+color+", radius is "+radius;
    	   }
    	   else{
    		   back="fan is off,the color is "+color+", radius is "+radius;
    	   }
    	  return back;	   
       }
       
}
