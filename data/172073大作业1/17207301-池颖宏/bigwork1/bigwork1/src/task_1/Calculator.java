package task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//��������
public class Calculator {
	
	
	public static int Operator(char c)
	{
	    switch(c)
	    {
	        case '+': 
				return 0;
	        case '-': 
				return 1;
	        case '*': 
				return 2;
	        case '/': 
				return 3;
	        case '(': 
				return 4;
	        case ')':
				return 5;
	        default:  
				return -1;
	    }
	}
	
	// ���ַ���ת����List
	public static ArrayList<String> getList(String str){
		
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
	

	
	//����׺���ʽת��Ϊ��׺���ʽ
	public static ArrayList<String> InversePolandExpression(ArrayList<String> InOrderList){
		
		ArrayList<String> List = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();	//������ջ
		
	
	    
	    // ��������ȼ���
	    char[][] Prior ={   
	    	{'>','>','<','<','<','>','>'},	//'+'
	    	{'>','>','<','<','<','>','>'},	//'-'
	        {'>','>','>','>','<','>','>'},	//'*'
	        {'>','>','>','>','<','>','>'},	//'/'
	        {'<','<','<','<','<','=','0'},	//'('
	        {'>','>','>','>','0','>','>'},	//')'
	        {'<','<','<','<','<','0','='}	//��ջ
	    };
	    
	    int i=0;
	    int row=0;
	    int col=0;
	    while(i < InOrderList.size()) {
	    	
	    	if(Character.isDigit(InOrderList.get(i).charAt(0))) {
				List.add(InOrderList.get(i));
				i++;
			}
			else {
				
				row=6;	
				if(!stack.isEmpty())
					row = Operator(stack.peek().charAt(0));
				col = Operator(InOrderList.get(i).charAt(0));
					
				switch (Prior[row][col]) {
					
					case '<':	//ջ��Ԫ������Ȩ�� 
						stack.push(InOrderList.get(i)); 	
						i++;
						break;
					case '=':	//�����Ų�������һ�ַ� 
						stack.pop();
						i++;
						break;
					case '>': 	//ջ��Ԫ������Ȩ��
						List.add(stack.pop());
						break;  
				}
			}		
	    }	   
	    while(!stack.isEmpty()){
			
			List.add(stack.pop());
		}
	    
	    return List;		
	}
	
	// �����׺���ʽ
	public static double CalculatePolandExpression(ArrayList<String> PostOrder){
		
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
		
	//	Calculator calculate = new Calculator();
		FileOperate fo = new FileOperate();
			
		File F = new File("src\\Output");
		
		fo.writeFile(F);
	}

}

//У����
class Test{
	
	public static int Test0(String[] s,int i) {	//�ж��Ƿ�����ͬ������ 
		
		for(int j=i-1;j>=0;j--) {
				
			if(s[j].equals(s[i]))
				return 1;				
		}
		
		return 0;
	}
	
	public static int Test1(String s) {	//���ʽΪ��
		
		if(s.matches(""))
			return 1;
		
		return 0;
	}
	
	public static int Test2(String s) {	//���ʽ���п�����
		
		if(s.matches(".*[(][)].*"))
			return 1;
		
		return 0;
	}
	
	public static int Test3(String s) {	//���ʽ�����Ƿ��ַ�
		
		if(s.matches(".*[\\D&&[^+&&[^-&&[^*&&[^/&&[^(&&[^)]]]]]]].*"))
			return 1;
		
		return 0;
	}
	
	public static int Test4(String s) {	//���Ų�ƥ��
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			
			char c = s.charAt(i);
			if(c == '('){
				stack.push('(');
			}
			else if(c == ')'){
				
				if(!stack.isEmpty())
					stack.pop();
				else
					return 1;
			}
		}
		if(!stack.isEmpty())
			return 1;
		
		return 0;
	}
	
	public static int Test5(String s) {	//���������
		
		if(s.matches(".*[+[-[*[/]]]]{2}.*")) 
			return 1;
		
		return 0;
	}
	
	public static int Test6(String s) {	//�����ǰ��������
		
		if(s.matches(".*[\\D&&[^)]][+[-[*[/]]]].*") || s.matches("[+[-[*[/]]]].*"))
			return 1;
		
		return 0;
	}
	
	public static int Test7(String s) {	//���������������
		
		if(s.matches(".*[+[-[*[/]]]][\\D&&[^(]].*") || s.matches(".*[+[-[*[/]]]]"))
			return 1;
				
		return 0;
	}
	
	public static int Test8(String s) {	//���ŷǵ�һ���ַ���֮ǰ�������
		
		if(s.matches(".*[^+&&[^-&&[^*&&[^/&&[^(]]]]][(].*"))
			return 1;
		
		return 0;
	}
	
	public static int Test9(String s) {	//С���ź�������������ŷ����һ���ַ�
		
		if(s.matches(".*[)][^+&&[^-&&[^*&&[^/&&[^)]]]]].*"))
			return 1;
		
		return 0;
	}

}

//�ļ���
class FileOperate{
	
	public String[] readLine(File f) {

		ArrayList<String> arrString=new ArrayList<String>();
		
		try (Scanner input = new Scanner(f);){

			while(input.hasNextLine()) {

				arrString.add(input.nextLine());
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String[] str = arrString.toArray(new String[arrString.size()]);
		
		return str;
	}
	
	public void writeFile(File F) {

		try (PrintWriter output = new PrintWriter(F);){

			File f = new File("src\\Input");
			String[] s =readLine(f);
			double result=0;
			
			for(int i=0;i<s.length;i++) {
				
				s[i]=s[i].replace(" ", ""); 
				
				if(Test.Test0(s,i) == 0) {
				
					if(Test.Test1(s[i]) == 1)
						output.println("ERROR\n#���ʽΪ��");
					else if(Test.Test2(s[i]) == 1)
						output.println("ERROR\n#���ʽ���п�����");
					else if(Test.Test3(s[i]) == 1)
						output.println("ERROR\n#���ʽ�����Ƿ��ַ�");
					else if(Test.Test4(s[i]) == 1)
						output.println("ERROR\n#���Ų�ƥ��");
					else if(Test.Test5(s[i]) == 1)
						output.println("ERROR\n#���������");
					else if(Test.Test6(s[i]) == 1)
						output.println("ERROR\n#�����ǰ��������");
					else if(Test.Test7(s[i]) == 1)
						output.println("ERROR\n#���������������");
					else if(Test.Test8(s[i]) == 1)
						output.println("ERROR\n#���ŷǵ�һ���ַ���֮ǰ�������");
					else if(Test.Test9(s[i]) == 1)
						output.println("ERROR\n#С���ź�������������ŷ����һ���ַ�");
					else {
						
						ArrayList<String> Lista = Calculator.getList(s[i]);  //Stringת��ΪList
						ArrayList<String> Listb = Calculator.InversePolandExpression(Lista);   //��׺���׺
						result = Calculator.CalculatePolandExpression(Listb);   //����
						
						output.println(s[i]+"="+result);
					}
				}
				else {					
				}
			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} 

	}
}
