
public class Lever {
	private int pos;
	
	public Lever(){
		
	}
	
	public Lever(int pos){
		this.pos = pos;
	}
	
	public int getPos(){
		return pos;
	}
	
	public void upPos(){
		if(this.pos < 4){
			this.pos ++;
		}
	}
	
	public void downPos(){
		if(this.pos > 1){
			this.pos --;
		}
	}

}
