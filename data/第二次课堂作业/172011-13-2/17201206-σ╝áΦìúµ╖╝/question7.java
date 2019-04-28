package class2;

public class question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fan m1=new fan(3,true,10,"yelow");
		System.out.println(m1.speed+" "+m1.radius+" "+m1.color);
		fan m2=new fan(2,false,5,"blue");
		System.out.println(" fan is off "+m2.radius+" "+m2.color);

	}
}
    class fan{
    	int speed=1;
    	boolean on=false;
    	double radius=5;
    	String color="blue";
    	fan(int newSpeed,boolean newOn,double newRadius,String newColor){
    		this.speed=newSpeed;
    		this.on=newOn;
    		this.radius=newRadius;
    		this.color=newColor;
    	}
    	    void toString(int newSpeed,boolean newOn,double newRadius,String newColor){
    		if(newOn==false){
    			System.out.println("fan is off"+newRadius+newColor);
    		return;
    		}
    		else
    			System.out.println(newSpeed+newRadius+newColor);
    		return;
    		
   }
    }
    


