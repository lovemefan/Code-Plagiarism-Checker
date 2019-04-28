package Hellowworld;
 
//父类
public abstract class Animal {
	
	//成员属性
	String name;
	int legNum;
	
	//类的封装
	public String getName() {
		return name;
	}
 
	public int getLegNum() {
		return legNum;
	}
	
	//构造函数
	public Animal(){
		
	}
	public Animal(String name , int legNum){
		
	}
	
	//成员方法（抽象类）
	public abstract void shout();}

