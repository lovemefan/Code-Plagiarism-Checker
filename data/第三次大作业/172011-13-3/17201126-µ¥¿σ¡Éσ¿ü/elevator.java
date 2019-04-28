package dazuoye;

	public class elevator {
	    private int floor=1;
	    private String direction = null;
	    private double time=0.0;


	    public elevator(){
	    	
	    }
	    
	    public elevator(int aim,String direction,double time){
	    	this.floor = aim;
	    	this.direction = direction;
	    	this.time = time;
	    }
	    public double getTime() {
	        return time;
	    }

	    public void setTime(double time) {
	        this.time = time;
	    }

	    public int getfloor() {
	        return floor;
	    }

	    public void setfloor(int aim) {
	        this.floor = aim;
	    }

	    public String getType() {
	        return direction;
	    }

	    public void setType(String direction) {
	        this.direction = direction;
	    }
}
