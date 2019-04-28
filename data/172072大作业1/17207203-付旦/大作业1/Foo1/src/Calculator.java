import java.util.*;
import java.io.*;

public class Calculator {

		   public static void main(String[] args) throws IOException{
			   
		        java.io.File FileRead = new java.io.File("input");
		        if(!FileRead.exists()){
		            System.out.println("File don't exists!");
		            System.exit(1); //程序退出
		        }
		        Check str = new Check();
		        Scanner input = new Scanner(FileRead);
		        java.io.PrintWriter FileWrite = new java.io.PrintWriter(new File("output"));

		        Set<String> set = new HashSet<String>();
		        while(input.hasNext()){
		            str.expression = input.nextLine();
		            str.expression = str.expression.replaceAll("\\s", "");//忽略空格

		            double result = 0;
		            if(!set.add(str.expression))    //忽略已经出现过的表达式
		                continue;
		            if(str.checkit() == 0 && str.BracktMatcher()){
		                Stack<String> stack = operate(str.expression);
		                result = solve(stack);

		                FileWrite.println(str.expression + "=" + String.valueOf(result));

		                
		            }
		            else{
		                FileWrite.println("ERROR");
		                FileWrite.println("#" + str.OutError());

		            }
		        }
		        input.close();
		        FileWrite.close();
		    }

		   // 文件输出标准为UTF-8
		    public static BufferedWriter createFileWriter(String name) throws FileNotFoundException, UnsupportedEncodingException {
		        FileOutputStream outputStream = new FileOutputStream(name);
		        OutputStreamWriter outputWriter = new OutputStreamWriter(outputStream, "utf-8");
		        BufferedWriter writer = new BufferedWriter(outputWriter);
		        return writer;
		    }  

		    // 比较优先级大小
		    public static boolean rank(char a, char b){	
		        boolean flag = false;
		        if((a == '+'||a == '-')&&(b == '*' || b == '/'))
		            flag = true;
		        else if(r(a, b))
		            flag = true;
		        return flag;
		    }
		    static boolean r(char a, char b){
		        if (a == b ||(a == '+' && b == '-')||(a == '-' && b == '+')||(a == '*' && b == '/')||(a == '/' && b == '*'))
		            return true;
		        else return false;
		    }

		  //进行运算
		    public static double solve(Stack<String> stack){
		        Stack<String> result = new Stack<String>();
		        Collections.reverse(stack);
		        String firstnum, secondnum, currentnum;
		        while(!stack.empty()){
		            currentnum = stack.pop();
		            if(!isOperator(currentnum.charAt(0))){
		                result.push(currentnum);
		            }
		            else
		            {
		                secondnum = result.pop();
		                firstnum = result.pop();
		                double temp = calculate(firstnum, secondnum, currentnum.charAt(0));
		                result.push(String.valueOf(temp));
		            }
		        }
		        return Double.valueOf(result.pop());
		    }

		    // 将中缀表达式转为后缀表达式，返回后缀表达式
		    static Stack<String> stack1 = new Stack<String>();
		    static Stack<Character> stack2 = new Stack<Character>();
		    private static Stack<String> operate(String Expression){    //中缀转后缀表达式
		        stack2.push('!');//运算符栈底放入'!'作为最低优先级符号
		        char[] Array = Expression.toCharArray();
		        int index = 0, count = 0;//index为当前位置，count为连续数字出现的长度
		        char current, top;//current为当前字符，top为栈顶字符
		        for(int j = 0; j < Array.length; j++){
		            current = Array[j];
		            if(isOperator(current))
		            {
		                if(count > 0)
		                {
		                    NewPUsh(Array, index, count);//将前一个数字压入结果栈
		                }
		                top = stack2.peek();//取操作符栈顶元素
		                operatorSolve(Array, index, count, current, top);
		                count = 0;
		                index = j+1;
		            }
		            else
		                count++;
		        }
		        if(count > 1 || (count == 1 && !isOperator(Array[index]))){
		            NewPUsh(Array, index, count);
		        }
		        while(stack2.peek()!='!'){
		            PUsh(Array, index, count);
		        }
		        return stack1;
		    }
		    private static void operatorSolve(char[] Array, int index, int count, char current, char top){
		        if(current == ')')//出现右括号则将运算符栈中元素移到结果栈中，直至遇到左括号
		        {
		            while(stack2.peek() != '('){
		                PUsh(Array, index, count);
		            }
		            stack2.pop();
		        }
		        else
		        {
		            while(current != '(' && stack2.peek()!='!' && rank(current, top))
		            {
		                PUsh(Array, index, count);//将优先级低的栈顶元素转移到结果栈中
		                top = stack2.peek();
		            }
		            stack2.push(current);
		        }
		    }
		    private static void PUsh(char[] Array, int index, int count){
		        String element = String.valueOf(stack2.pop());
		        stack1.push(element);
		    }
		    private static void NewPUsh(char[] Array, int index, int count){
		        String element = new String(Array, index, count);
		        stack1.push(element);
		    }

		    
		    // 判断是否为运算符

		    private static boolean isOperator(char c) {
		        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' ||c == ')';
		    }

		    
		    //四则运算操作

		    private static double calculate(String firstnum, String secondnum, char ch){
		        double result;
		        switch (ch){
		            case '+':   result = Double.valueOf(firstnum) + Double.valueOf(secondnum); break;
		            case '-':   result = Double.valueOf(firstnum) - Double.valueOf(secondnum); break;
		            case '*':   result = Double.valueOf(firstnum) * Double.valueOf(secondnum); break;
		            case '/':   result = Double.valueOf(firstnum) / Double.valueOf(secondnum); break;
		            default:    result = 0;
		        }
		        return result;
		    }
		}
