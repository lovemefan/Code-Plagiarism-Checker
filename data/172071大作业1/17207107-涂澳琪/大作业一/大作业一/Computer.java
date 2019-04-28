package ����ҵһ;
import java.util.Stack;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Computer{ 
	
	private Stack<Character> priStack=new Stack<Character>(); //������ջ
	private Stack<Integer> numStack=new Stack<Integer>(); //������ջ

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		int k;//��ʾ��k�����ʽ
		String str;
		Computer computer=new Computer();//ʵ������Computer
		FileOperation fileOperation=new FileOperation();//ʵ������FileOperation
		File expression=new File("src//expression");
		File result=new File("src//result");
		k=fileOperation.readFile1(expression);//��ȡ�ļ�expression���õ����ʽ
		
		//ˢ��result�ļ�
		try (PrintWriter output = new PrintWriter(result);){					
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<k;i++){
			str=fileOperation.temp[i];
			//�ж�str�Ƿ������ȷ���ʽ
			if(computer.judge(str)){//str������ȷ���ʽ
				t=computer.caculate(str);//������ʽ���ý����ֵ��t
				fileOperation.writerFile(result,str,t);//�����ʽ����ֵ���д���ļ�result			
				fileOperation.readFile2(result);//��ȡ�ļ�result
			}
		}			
	}
	
	//�ж�str�Ƿ������ȷ���ʽ
	public boolean judge(String str){
		String temp1="";
		String temp2="";
		String temp="Null";
		int k=0;//��ʾС����(�ĸ���
		int m=0;//��ʾС����)�ĸ���
		if( str.compareTo(temp)==0 ){
			System.out.println("ERROR #���ʽΪ��");
			return false;
		}
		temp1=str.substring(0,1);
		if((temp1.matches("[\\+\\-\\*\\/]"))){
			System.out.println("ERROR #�����ǰ��������");
			return false;
		}
		//�ж������ַ����Ƿ񺬷Ƿ��ַ�	
		for(int i=0;i<str.length()-1;i++){
			temp1=str.substring(i, i+1);
			if(!temp1.matches("[[0-9]\\+\\-\\*\\/\\(\\)]")){
				System.out.println("ERROR #���ʽ�к��Ƿ��ַ�");
				return false;
			}
		}
		//�жϱ��ʽ����������
		for(int i=0;i<str.length()-1;i++){
			temp1=str.substring(i,i+1);
			temp2=str.substring(i+1,i+2);
			if(temp1.matches("\\(")&&temp2.matches("\\)")){
				System.out.println("ERROR #���ʽ���п�����");
				return false;
			}
			else if( (temp1.matches("[\\+\\-\\*\\/]")) &&temp2.matches("[\\+\\-\\*\\/]") ){
				System.out.println("ERROR #���������");
				return false;
			}
			else if((!temp1.matches("[[0-9]\\)]")) && (temp2.matches("[\\+\\-\\*\\/]"))){
				if(!temp1.matches("[0-9]")){
				System.out.println("ERROR #�����ǰ��������");
				return false;
				}
			}
			else if((temp2.matches("\\(")) && (!temp1.matches("[\\+\\-\\*\\/]")) && (i!=0)){
				System.out.println("ERROR #���ŷǵ�һ���ַ���֮ǰ�������");
				return false;
			}
			else if((temp1.matches("[\\+\\-\\*\\/]")) && (!temp2.matches("[[0-9]\\(]"))){
				if(!temp2.matches("[0-9]")){
				System.out.println("ERROR #���������������");
				return false;
				}
			}
			else if((temp1.matches("\\)")) && (!temp2.matches("[\\+\\-\\*\\/]")) && (i!=(str.length()-2))){
				System.out.println("ERROR #С���ź�������������ŷ����һ���ַ�");
				return false;
			}
		}
		
		//�ж������Ƿ�ƥ��
		for(int i=0;i<str.length();i++){
			temp1=str.substring(i,i+1);
			if( (temp.matches("\\(")) ){
				k++;
			}
			else if(temp.matches("\\)")){
				m++;
			}
		}
		if(k!=m){
			System.out.println("ERROR	#���Ų�ƥ��");
			return false;
		}
		
		return true;
	}
	//���б��ʽ��ֵ
	public int caculate(String str){
		String temp;//������ʱ��Ŷ�ȡ���ַ�
		StringBuilder tempNum=new StringBuilder();//������ʱ��������ַ���
		StringBuilder string=new StringBuilder().append(str);//�������棬���Ч��
		int result = 0;// ������
		for(int i=0;i<string.length();i++) {
			temp = string.substring(i, i+1);//���ν�ȡ�ַ������ַ�
			// �ж�temp�ǲ��������ǲ�����,��Ϊ������ʱ
			if (!isNum(temp)) {
				//��ʱ��tenpNum�ڼ�Ϊ��Ҫ����������ȡ������ѹջ�������tempNum				
				if (!"".equals( tempNum.toString())) {
					int num = Integer.parseInt(tempNum.toString());
					numStack.push(num);
					tempNum.delete(0, tempNum.length());//���tempNum
				}	
				// �жϵ�ǰ�������ջ��Ԫ�����ȼ�����С�ڻ���ڣ�ȡ��Ԫ�أ����м���(��Ϊ���ȼ�����С��ջ��Ԫ�أ���С�ڵڶ���Ԫ�صȵȣ���Ҫ��ѭ���ж�)
				while (!compare(temp.charAt(0)) && (!priStack.empty())) {
					int a = (int) numStack.pop();// �ڶ���������
					int b = (int) numStack.pop();// ��һ��������
					char ope = priStack.pop();
					switch (ope) {
					// ����ǼӺŻ��߼��ţ���
					case '+':
						result = b + a;
						// ������������������ջ
						numStack.push(result);
						break;
					case '-':
						result = b - a;
						// ������������������ջ
						numStack.push(result);
						break;
					case '*':
						result = b * a;
						// ������������������ջ
						numStack.push(result);
						break;
					case '/':
						result = b / a;
						// ������������������ջ
						numStack.push(result);
						break;
					}
				}
				//������󣬽���ǰ�������ţ����������ջ
				//���ߵ�ǰ���������ջ��Ԫ�����ȼ���ֱ�ӷ��������ջ
				if (temp.charAt(0) != '=') {
					priStack.push(temp.charAt(0));
					if (temp.charAt(0) == ')') {// ��ջ��Ϊ'('������ǰԪ��Ϊ')'ʱ�����������������꣬ȥ������
						priStack.pop();
						priStack.pop();
					}
				}
			} 
			// ��Ϊ�ǲ�����ʱ�����֣�
			else{
				tempNum = tempNum.append(temp);// ����������һλ���ӵ��Զ���������(�����Ǹ�λ����ʱ��)
			}
		}
		return result;
	}
	
	// �жϴ�����ַ��ǲ���0-9������
	private boolean isNum(String temp) {
		return temp.matches("[0-9]");
	}
		
	//�Ƚϵ�ǰ��������ջ��Ԫ�ز��������ȼ��������ջ��Ԫ�����ȼ��ߣ��򷵻�true�����ڻ���ڷ���false 
	private boolean compare(char str) {
		if (priStack.empty()) {
			// ��Ϊ��ʱ����Ȼ ��ǰ���ȼ���ͣ����ظ�
			return true;
		}	
		char last = (char) priStack.lastElement();//ȡ��ջ��Ԫ�ز���ջ���ȼ�һ
		if (last == '(') {// ���ջ��Ϊ'('��Ȼ�����ȼ���ͣ�')'������Ϊջ����
			return true;
		}
		switch (str) {
		case '=':
			return false;// ������
		case '(':
			return true;// '('���ȼ����,��Ȼ����true
		case ')':
			return false;// ')'���ȼ����
		case '*': {
			// '*/'���ȼ�ֻ��'+-'��
			if (last == '+' || last == '-')
				return true;
			else
				return false;
			}
		case '/': {
			if (last == '+' || last == '-')
				return true;
			else
				return false;
		}
		// '+-'Ϊ��ͣ�һֱ����false
		case '+':
			return false;
		case '-':
			return false;
		}
		return true;
	}	
}

//�ļ�����
class FileOperation{
	FileOperation(){}
	String temp[]=new String[50];
	//��ȡ�ļ�expression
	int readFile1(File expression){
		int i=0;
		try (Scanner input = new Scanner(expression);){
			while(input.hasNextLine()) {
				String s = input.nextLine();//��ȡ�ļ���һ������
				temp[i]=s;
				i++;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	//д�ļ�result
	public void writerFile(File result,String str,int t) {
		try (FileWriter fileWriter=new FileWriter(result,true);){
			fileWriter.write(str+t+"\n");	
			fileWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	//��ȡ�ļ�result,ÿ�ζ�ȡ��ֻ��ȡ���һ��
	void readFile2(File result){
		String line=null;
		try(Scanner input = new Scanner(result);){
			while(input.hasNextLine() && (line=input.nextLine())!=null){
				if(!input.hasNextLine()){
					System.out.println(line);
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}