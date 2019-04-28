package Hellowworld;
 
//子类
public class fish extends Animal {
	
	//子类中的构造函数父类中必需存在
	public fish(){
		
	}
	
	public fish(String name, int legNum) {
		super(name, legNum);
		// TODO Auto-generated constructor stub
		super.name = name;
		super.legNum = legNum;
	}
 
	//抽象类具体实现（多态）
	public void shout(){
		System.out.println(name+"\t\t"+legNum+"\t");
	}}
