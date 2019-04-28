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

		while (input.hasNext()) {                                        //读到文件末尾为止
			expression = input.next();
			
			if (repeat.containsKey(expression)){                         //检查是否出现过
				continue;
			}
			else repeat.put(expression, 1);

			boolean is = check(expression,output);       
			
			if (is == false){                               //不合法,recode记录不合法的类型
			
				continue;
			}

			Vector<String> temp = change(expression); // 将中缀表达式转化后缀表达式并接受
			output.println(calculate(temp));      // 输出计算结果
		}
		
		input.close();
		output.close();
	}
	
	static public boolean check(String expression,java.io.PrintWriter output){           //检查是否合法
		
		   //检查运算符连续出现，枚举了++、+-、+*、+/等等， 总共4*4=16种情况
			if (expression.matches(".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*")) {  		                                                       
				output.println("ERROR\n运算符连续出现");
				return false;              // 比如+++ ---.
			}
			
			if (expression.matches(".*(\\)\\d|\\d\\().*")) {                 // ）右边是数字的情况  或者 (左边是数字的情况		
				output.println("ERROR\n)右边缺少运算符，或 (左边缺少运算符 ");
				return false; 
			}
	
			if (expression.matches(".*(\\(\\)).*")) {                    	// 匹配空括号			
				output.println("ERROR\n存在()内为空，即无效括号");
				return false;
			}
			
			if (expression.matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")) {           //右括号左边含有运算符				
				output.println("ERROR\n)左边缺少运算数");
				return false;
			}
			
			if (expression.matches(".*(\\(-|\\(\\+|\\(/|\\(\\*).*")) {            //左括号右边有运算符  
				output.println("ERROR\n(右边缺少运算数");
				return false;
			}
			
			return true;                 // 当所有的错误格式都不匹配时就是真
	}
	
	static public Vector<String> change(String expression){
		
		 Vector<String> s = new Vector<String>();                  //存储后缀表达式
	     String str[] = new String[100];                           //数组模拟栈
	     int len = -1;                                             //栈顶元素下标
	        
	     String t = "",temp = "";                                   //临时元素
		
	    
		 for (int i = 0;i < expression.length();) {                //分割字符
			 
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
          
           if (Character.isDigit(t.charAt(0)) || t.length() > 1){      //区分每种情况转后缀存入s中
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
		 
       while (len > -1){                 //符号都出栈
    	   
           temp = str[len--];
           if (!(temp.equals("(") || temp.equals(")"))){
               s.add(temp);
           }
       }
       
       return s;
	}
	
	static public double calculate(Vector<String> s){             //对后缀表达式进行计算
	    double num[] = new double [100];
	    int len = -1;
	 
        for (int i = 0;i < s.size(); i++){
        	
            if (s.get(i).length() > 1 || Character.isDigit(s.get(i).charAt(0))){    //如果是数字 
            	
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
            else{                                   //是字符，从栈里面跳出元素进行计算
            	
                double a,b,sums = 0.0;
                b = num[len--];
                a = num[len--];
                switch (s.get(i).charAt(0)){         //对应符号计算方式
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
	
	static public int priority(String t) // 返回符号的优先级
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
