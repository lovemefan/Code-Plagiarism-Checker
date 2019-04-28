package bIg_Homework;
import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;

public class Test01 {
	public static void main(String[] args) throws Exception{
		String expression = "";
		HashMap<String ,Integer> repeat = new HashMap<String ,Integer>();
		java.io.File file1 = new java.io.File("input.txt");
		java.io.File file2 = new java.io.File("output.txt");
		
		
		Scanner input = new Scanner(file1);
		java.io.PrintWriter output = new java.io.PrintWriter(file2);

		while (input.hasNext()) {                                        //�����ļ�ĩβΪֹ
			expression = input.next();
			
			if (repeat.containsKey(expression)){                         //����Ƿ���ֹ�
				continue;
			}
			else repeat.put(expression, 1);

			boolean is = check(expression,output);       
			
			if (is == false){                               //���Ϸ�,recode��¼���Ϸ�������
			
				continue;
			}

			Vector<String> temp = change(expression); // ����׺���ʽת����׺���ʽ������
			output.println(calculate(temp));      // ���������
		}
		
		input.close();
		output.close();
	}
	
	static public boolean check(String expression,java.io.PrintWriter output){           //����Ƿ�Ϸ�
		
		   //���������������֣�ö����++��+-��+*��+/�ȵȣ� �ܹ�4*4=16�����
			if (expression.matches(".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*")) {  		                                                       
				output.println("ERROR\n�������������");
				return false;              // ����+++ ---.
			}
			
			if (expression.matches(".*(\\)\\d|\\d\\().*")) {                 // ���ұ������ֵ����  ���� (��������ֵ����		
				output.println("ERROR\n)�ұ�ȱ����������� (���ȱ������� ");
				return false; 
			}
	
			if (expression.matches(".*(\\(\\)).*")) {                    	// ƥ�������			
				output.println("ERROR\n����()��Ϊ�գ�����Ч����");
				return false;
			}
			
			if (expression.matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")) {           //��������ߺ��������				
				output.println("ERROR\n)���ȱ��������");
				return false;
			}
			
			if (expression.matches(".*(\\(-|\\(\\+|\\(/|\\(\\*).*")) {            //�������ұ��������  
				output.println("ERROR\n(�ұ�ȱ��������");
				return false;
			}
			
			return true;                 // �����еĴ����ʽ����ƥ��ʱ������
	}
	
	static public Vector<String> change(String expression){
		
		 Vector<String> s = new Vector<String>();                  //�洢��׺���ʽ
	     String str[] = new String[100];                           //����ģ��ջ
	     int len = -1;                                             //ջ��Ԫ���±�
	        
	     String t = "",temp = "";                                   //��ʱԪ��
		
	    
		 for (int i = 0;i < expression.length();) {                //�ָ��ַ�
			 
           if (!Character.isDigit(expression.charAt(i))) {
        	   
               int flag = 0;
               
               if ((i == 0 || !Character.isDigit(expression.charAt(i-1))) && (expression.charAt(i)=='+' || expression.charAt(i)=='-') && (i == 0 || expression.charAt(i-1) != ')')){
                   if (expression.charAt(i) == '-') {
                	   
                       t=Character.toString(expression.charAt(i));
                   }
                   i++;
                   for (;i < expression.length(); i++){
                	   
                       if (!Character.isDigit(expression.charAt(i)) && expression.charAt(i) != '.')
                           break;
                       
                       t += Character.toString(expression.charAt(i));
                   }
                   flag = 1;
               }
               if (flag == 0){
            	   
                   t = Character.toString(expression.charAt(i));
                   i++;
               }
           }
           else{
        	   
               t = "";
               
               for (;i < expression.length(); i++){
                   if (!Character.isDigit(expression.charAt(i)) && expression.charAt(i) != '.')
                       break;                  
                   t += Character.toString(expression.charAt(i));
               }
           }
          
           if (Character.isDigit(t.charAt(0)) || t.length() > 1){      //����ÿ�����ת��׺����s��
               s.add(t);
           }
           else{
        	   
               if (t.equals(")")){
            	   
                   while (len > -1){
                       temp = str[len--];
                       
                       if (temp.equals("(")){
                           break;
                       }
                       s.add(temp);
                   }
               }
               else{
                   while (len > -1){
                       temp = str[len--];
                       if (temp.equals("(")){
                           str[++len] = "(";
                           break;
                       }
                
                       if (priority(temp) >= priority(t)){
                           s.add(temp);
                       }
                       else{
                       	str[++len] = temp;
                           break;
                       }
                   }
                   str[++len] = t;
               }
           }
       }
		 
       while (len > -1){                 //���Ŷ���ջ
    	   
           temp = str[len--];
           if (!(temp.equals("(") || temp.equals(")"))){
               s.add(temp);
           }
       }
       
       return s;
	}
	
	static public double calculate(Vector<String> s){             //�Ժ�׺���ʽ���м���
	    double num[] = new double [100];
	    int len = -1;
	 
        for (int i = 0;i < s.size(); i++){
        	
            if (s.get(i).length() > 1 || Character.isDigit(s.get(i).charAt(0))){    //��������� 
            	
                double nums = 0.0,mul = 1.0;
                
                for (int j = s.get(i).length()-1;j >= 0;j--){
                	
                    if (Character.isDigit(s.get(i).charAt(j))){
                    	
                        nums+=(s.get(i).charAt(j)-(int)('0'))*mul;
                        mul*=10;
                    }
                    else if (s.get(i).charAt(j) == '.'){
                        nums /= mul;
                        mul = 1.0;
                    }
                    else if (s.get(i).charAt(j) == '-'){
                        nums =- nums;
                    }
                }
                num[++len] = nums;
            }
            else{                                   //���ַ�����ջ��������Ԫ�ؽ��м���
            	
                double a,b,sums = 0.0;
                b = num[len--];
                a = num[len--];
                switch (s.get(i).charAt(0)){         //��Ӧ���ż��㷽ʽ
                    case '+':
                        sums = a + b;
                        break;
                    case '-':
                        sums = a-b;
                        break;
                    case '*':
                        sums = a*b;
                        break;
                    case '/':
                        if (b == 0){
                            System.out.print("ERROR");
                            System.exit(0);
                        }
                        sums = a/b;
                }
                num[++len] = sums;
            }
     }   
	 return num[0];
 }
	
	static public int priority(String t) // ���ط��ŵ����ȼ�
	{
		if (t.charAt(0) == '+')
			return 1;
		if (t.charAt(0) == '-')
			return 1;
		if (t.charAt(0) == '*')
			return 2;
		if (t.charAt(0) == '/')
			return 2;
		if (t.charAt(0) == '(')
			return 3;
		if (t.charAt(0) == ')')
			return 3;
		return 0;
	}
	
}
