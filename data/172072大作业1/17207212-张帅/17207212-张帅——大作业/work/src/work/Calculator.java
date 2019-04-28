package work;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Calculator {//��������
	
	public static ArrayList<String> getStringList(String str){//���ַ���ת��Ϊ����
		
		ArrayList<String> List = new ArrayList<String>();
		String num = "";
		
		for (int i = 0; i < str.length(); i++) {
			
			if(Character.isDigit(str.charAt(i))) {
				num = num + str.charAt(i);
			}
			else{
				if(num != ""){
					List.add(num);
				}	
				List.add(str.charAt(i) + "");
				num = "";						
			}
		}
		if(num != ""){
			List.add(num);
		}
		
		return List;
		
	}
	
	
	
	public static ArrayList<String> getPostOrder(ArrayList<String> InOrderList){//ʹ�����ݽṹ֪ʶ�����ʽת��Ϊ�沨��ʽ
		
		ArrayList<String> List = new ArrayList<String>();
		Stack<String> charStack = new Stack<String>();	//����������ջ
		
	    int i=0;
	    int row=0;
	    int col=0;
	    
	    
	    Comper com = new Comper();
	    while(i < InOrderList.size()) {
	    	
	    	if(Character.isDigit(InOrderList.get(i).charAt(0))) {
				List.add(InOrderList.get(i));
				i++;
			}
			else {
				
				row=6;	
				if(!charStack.isEmpty())
					row = Comper.Symbol(charStack.peek().charAt(0));
				col = Comper.Symbol(InOrderList.get(i).charAt(0));
					
				switch (com.symbol[row][col]) {
					
					case '<':	//��ջ����Ԫ��
						charStack.push(InOrderList.get(i)); 	
						i++;
						break;
					case '=':	//������
						charStack.pop();
						i++;
						break;
					case '>': 	//�Ƚ�ջ��Ԫ�����ȣ���ջ
						List.add(charStack.pop());
						break;  
				}
			}		
	    }	   
	    while(!charStack.isEmpty()){
			
			List.add(charStack.pop());
		}
	    
	    return List;		
	}
	
	
	public static double calculate(ArrayList<String> PostOrder){//�����沨��ʽ
			
		Stack<Double> stack = new Stack<Double>();
		
		for (int i = 0; i < PostOrder.size(); i++) {
			
			if(Character.isDigit(PostOrder.get(i).charAt(0)))
				stack.push(Double.parseDouble(PostOrder.get(i)));
			else {
				
				double b = (Double)stack.pop();
				double a = (Double)stack.pop();
				double result = 0;
				switch (PostOrder.get(i).charAt(0)) {
					case '+':
						result = a + b;
						break;
					case '-':
						result = a - b;
						break;
					case '*':
						result = a * b;
						break;
					case '/':
						result = a / b;
						break;
				}
				stack.push(result);
			}
		}
		
		return (Double)stack.pop();
	}
	
	public static void main(String[] args) {

		FileOperation fo = new FileOperation();
			
		File F = new File("src\\���");
		
		fo.writeFile(F);
	}

}

