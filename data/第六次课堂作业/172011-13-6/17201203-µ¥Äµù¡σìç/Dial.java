package homework;

public class Dial {
public int pos;
	
	public Dial(){
		
	}
	
	public Dial(int pos){
		this.pos = pos;		
	}
	
	public int getPos(){
		return this.pos;
	}
	
	public void upPos(){
		if(this.pos < 3){
			this.pos ++;
		}
	}
	
	public void downPos(){
		if(this.pos > 1){
			this.pos --;
		}
	}

}
