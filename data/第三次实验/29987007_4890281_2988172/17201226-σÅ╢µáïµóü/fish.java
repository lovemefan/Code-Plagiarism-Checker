package Hellowworld;
 
//����
public class fish extends Animal {
	
	//�����еĹ��캯�������б������
	public fish(){
		
	}
	
	public fish(String name, int legNum) {
		super(name, legNum);
		// TODO Auto-generated constructor stub
		super.name = name;
		super.legNum = legNum;
	}
 
	//���������ʵ�֣���̬��
	public void shout(){
		System.out.println(name+"\t\t"+legNum+"\t");
	}}
