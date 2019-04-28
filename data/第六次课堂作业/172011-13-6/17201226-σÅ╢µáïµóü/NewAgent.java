package Hellowworld;


public class NewAgent {
	private java.util.Date dateCreated;
	private boolean filled;
	public NewAgent(){
		dateCreated=new java.util.Date();
	}
	public NewAgent(boolean filled){
		dateCreated=new java.util.Date();
		this.filled=filled;
	}

public boolean isFilled(){
	return filled;
}
public void setFilled(boolean filled){
	this.filled=filled;
}
		
	}
		 
	
