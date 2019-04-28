package dazuoye;

public class floor {
	 private int aim=1;
	    private double time=0.0;

	    public floor(){
	    	
	    }
	    
	    public floor(int aim,double time){
	    	this.aim = aim;
	    	this.time = time;
	    }
	    
	    public double getTime() {
	        return time;
	    }

	    public void setTime(double time) {
	        this.time = time;
	    }

	    public int getAim() {
	        return aim;
	    }

	    public void setAim(int aim) {
	        this.aim = aim;
	    }
}
