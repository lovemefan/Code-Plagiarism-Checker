package Hellowworld;
 
//����
public abstract class Animal {
	
	//��Ա����
	String name;
	int legNum;
	
	//��ķ�װ
	public String getName() {
		return name;
	}
 
	public int getLegNum() {
		return legNum;
	}
	
	//���캯��
	public Animal(){
		
	}
	public Animal(String name , int legNum){
		
	}
	
	//��Ա�����������ࣩ
	public abstract void shout();}

