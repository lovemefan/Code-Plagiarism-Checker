package ����ҵ01;

import java.util.Scanner;
import java.util.Stack;

import java.io.File;

public class Caculate {
	
	public static String converToPostfix(String expression)throws Exception{
		
		Stack<Character> st=new Stack<>();   //��ʼ��һ�������ջ
		String postfix=new String();   //���ڴ����׺���ʽ
		for(int i=0;expression!=null&&i<expression.length();i++){
			char c=expression.charAt(i);
			if(' '!=c){//Ϊ������
				if(isOpenParent(c)){
					st.push(c);
				}//Ϊ������
				else if(isCloseParent(c)){
					char ac=st.pop();
					while(!isOpenParent(ac)){
						postfix=postfix.concat(String.valueOf(ac));
						ac=st.pop();
					}
				}//Ϊ�����
				else  if(isOperator(c)){
					//����ջ�ǿգ�ȡ��ջ�����ȼ��ߵ�����������׺���ʽ
					if(!st.empty()){
						char ac=st.pop();
						//ջȡ�����ַ����ȼ���c��
						while(!st.isEmpty()&&priority(ac)>=priority(c)){
							postfix=postfix.concat(String.valueOf(ac));
							ac=st.pop();
						}//ջȡ�����ַ����ȼ���c�ͣ���ȡ�����ַ�������ջ
						if(ac!=' '){
							st.push(ac);
						}
					}st.push(c);    //��c��ջ
				}//Ϊ��������ֱ�Ӵ�����postfix��
				else {
					postfix=postfix.concat(String.valueOf(c));
				}
			}
		}//�����ʽ����ͽ�����ջpop������postfix
		while(!st.isEmpty()){
			postfix=postfix.concat(String.valueOf(st.pop()));
			
		}
		return postfix;
	}
	//�Ժ�׺���ʽ��������
	public static double numberCalculate(String postfix)throws Exception{
		
		Stack st=new Stack<>();//����һ��������ջ
		for(int i=0;postfix!=null&&i<postfix.length();i++){
			
			char c=postfix.charAt(i);
			//���Ϊ�����
			if(isOperator(c)&&!st.isEmpty()){
				double d2=Double.valueOf(st.pop().toString());
				double d1=Double.valueOf(st.pop().toString());
				double d3=0;
				if('+'==c){
					d3=d1+d2;
				}
				if('-'==c){
					d3=d1-d2;
				}
				if('/'==c){
					d3=d1/d2;
				}
				if('*'==c){
					d3=d1*d2;
				}
				//��������ѹ�������ջ��
				st.push(d3);
			}else{//Ϊ������ʱֱ��ѹ�������ջ
			st.push(c);}
		}
		return (double) st.pop();//����������
	}
	//�ж��ַ�Ϊ�����
	public static boolean isOperator(char c){
		if('+'==c||'-'==c||'/'==c||'*'==c){
			return true;
		}
		else {
			return false;
		}
	}
	//�ж��ַ�Ϊ������
	public static boolean isOpenParent(char c){
		return c=='(';
	}
	//�ж��ַ�Ϊ������
	public static boolean isCloseParent(char c){
		return c==')';
	}
	//�ж��㷨�����ȼ�
	public static int priority(char c){

		if(c=='/'||c=='*'){
			return 2;
		}
		else if(c=='-'||c=='+'){
			return 1;
		}
		else return 0;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			System.out.println("�����ڱ��ʽ�����ļ�������Ҫ����ı��ʽ");
			int num;
			System.out.println("����������������ʽ�����������س�����");
			Scanner input = new Scanner(System.in);
			num = input.nextInt();
			System.out.println("����������ʾ�ڼ������ļ��У�������Ч���뽫ֱ�����·���ʾ��Ч��������");
			System.out.println();
			Verify b = new Verify();
		
			FileOperation fo = new FileOperation();
			File f = new File("����ҵ01\\���ʽ����");	
			File f1 = new File("����ҵ01\\������");
			
			String []s = new String[num];
			s = fo.read(f,num);//������ʽ
			double []result = new double[num];//��������������
			for(int i=0;i<num;i++) {
				if(b.isTrue(s[i]) == true) {
				
				String postfix = converToPostfix(s[i]);//��׺���ʽתΪ��׺���ʽ
				result[i] = numberCalculate(postfix);//������
		//		System.out.println("���ʽ���Ϊ��"+result[i]);
				}
				else {
					s[i] = "����ı��ʽ��Ч";
				}
					
			}
				fo.write(f1,result,num,s);//���д���ļ�
 
	}
}
