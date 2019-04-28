package Hellowworld;
 
public class fish_1 extends Animal implements Terrestrlal{
	
	public fish_1(){
		
	}
	
	public fish_1(String name, int legNum) {
		super(name, legNum);
		// TODO Auto-generated constructor stub
		super.name = name;
		super.legNum = legNum;
	}
 
	public void shout(){
			System.out.println(name+"\t\t"+legNum+"\t");	
	}
}