package kkk;

public class Qingqiu {
	
	private String string;
	private int floor;
	Qingqiu(){
		
	}
	
	Qingqiu(String string,int floor){
		this.string = string;
		this.floor=floor;
	}
	
	public String getString(){
			return string;
	}
	
	
	public void getC(){
		String s = this.string.substring(1, this.string.length() - 1);
		Diaodu d = new Diaodu(s,this.floor);
		d.C();
	}
}
	


