package ����ҵ;

import java.util.Scanner;
import java.util.Stack;

import java.io.File;

public class CalculateExperssion {
	
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
				}
				else  if(isOperator(c)){//Ϊ�����
					
					if(!st.empty()){//����ջ�ǿգ�ȡ��ջ�����ȼ��ߵ�����������׺���ʽ
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
				}
				else {//Ϊ��������ֱ�Ӵ�����postfix��
					postfix=postfix.concat(String.valueOf(c));
				}
			}
		}
		while(!st.isEmpty()){//�����ʽ����ͽ�����ջpop������postfix
			postfix=postfix.concat(String.valueOf(st.pop()));
			
		}
		return postfix;
	}
	
	public static double numberCalculate(String postfix)throws Exception{//�Ժ�׺���ʽ��������
		
		Stack st=new Stack<>();//����һ��������ջ
		for(int i=0;postfix!=null&&i<postfix.length();i++){
			
			char c=postfix.charAt(i);
			if(isOperator(c)&&!st.isEmpty()){//���Ϊ�����
				double num1=Double.valueOf(st.pop().toString());
				double num2=Double.valueOf(st.pop().toString());
				double num3=0;
				if('+'==c){
					num3=num1+num2;
				}
				if('-'==c){
					num3=num1-num2;
				}
				if('/'==c){
					num3=num1/num2;
				}
				if('*'==c){
					num3=num1*num2;
				}
				//��������ѹ�������ջ��
				st.push(num3);
			}else{//Ϊ������ʱֱ��ѹ�������ջ
			st.push(c);}
		}
		return (double) st.pop();//����������
	}
	
	public static boolean isOperator(char c){//�ж��ַ�Ϊ�����
		if('+'==c||'-'==c||'/'==c||'*'==c){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isOpenParent(char c){//�ж��ַ�Ϊ������
		return c=='(';
	}
	
	public static boolean isCloseParent(char c){//�ж��ַ�Ϊ������
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
			System.out.println("����������ʾ�ڼ������ļ���");
			System.out.println();
			YanZhen b = new YanZhen();
		
			FileOperation fo = new FileOperation();
			File f = new File("����ҵ\\���ʽ����");	
			File f1 = new File("����ҵ\\������");
			
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

