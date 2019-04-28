package calculators;


//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Set;
//import java.util.Iterator;
//import java.util.Stack.*;

//import java.util.Deque; 
//��׺ת��׺
public class Stack {
	private LinkStack<String> stack =new LinkStack<String>();//��׺ת��׺�õ���ջ
	private String infix;//�������׺���ʽ
	private String post="";//����õ��ĺ�׺���ʽ
	
	public Stack(LinkStack<String> stack,String infix){
		this.infix=infix;
		this.stack=stack;
	}
	
	public Stack(String infix){
		this.infix=infix;
	}
	
	public String getInfix(String number){
		this.infix=infix;
		return infix;
	}
	
	
//test 
	
	//���ջ��������
	public void getParent(){
		while(!stack.isEmpty()){
			String top =stack.pop();
			if(top.equals("(")){
				break;
			}
			else{
				post +=" "+top;
			}
		}
	}
	
	//������������ջ��
	public void getOperation(String str,int x ){
		while(!stack.isEmpty()){
			String top=stack.pop();
			if(top.equals("(")){
				stack.push(top);
				break;
			}
			else{
				int yy=compare(top);
				if(yy<x){
					stack.push(top);
					break;
				}
				else{
					post+=" "+top;
				}
			}
		}
		stack.push(str);
	}
	
	
	
	
	
	//�ж����ȼ�
	public int compare(String str){	
	//	if(fuhao.equals("+")||fuhao.equals("-")){
		int y=0;
	switch(str){
	case"+":y=1;break;
	case"-":y=1;break;
	case"*":y=2;break;
	case"/":y=2;break;
	default:y=0;break;
	}
	return y;	
	}
	
	//��׺���ʽת��׺���ʽ
	public void process(String infix){
		String[] strArr=PreDealInfix(infix).split(" ");
		for(int i=0;i<strArr.length;i++){
			String str = strArr[i];
			switch(str){
			case"+":getOperation(str,1);break;
			case"-":getOperation(str,1);break;
			case"*":getOperation(str,2);break;
			case"/":getOperation(str,2);break;
			case"(":stack.push(str);break;
			case")":getParent();break;
			default:
				post+=" "+str;
				break;
			}
		}
		while(!stack.isEmpty()){
			post+=" "+stack.pop();
		}
	}
	
	//�����׺���ʽ
	public String getPost(){
		return post.trim();
	}

	//����ո����ֵ������ֺͶ�λ����
public String PreDealInfix(String infix){
		String dealedInfix="";
		for(int i=0;i<infix.length()-1;i++){
			char first=infix.charAt(i);
			char next=infix.charAt(i+1);
			if(isDigital(first)&&isDigital(next)){
				dealedInfix +=first;
			}
			else{
					dealedInfix += first +" ";
				}
			
		}
	    dealedInfix +=infix.charAt(infix.length()-1);
	    return dealedInfix;
	}

//�ж����ֵĴ�С
private boolean isDigital(char num) {
	if(num >= '0' && num<='9'){
	return true;
	}
	else 
		return false;
}

	}

	
