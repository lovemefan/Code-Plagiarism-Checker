package 大作业1;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.*;
public class ExpressionEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		infile F1 =new infile();//把表达式输入到文件test1
		resultfile F2 = new resultfile();//把结果输入到文件test2
		F1.creatfile();
		F2.writerfile();
	}

}
class Calculater{
	  Stack<Integer> OPTR = new Stack<>();
	  Stack<Character> OPND = new Stack<>();
	  String str;

	  public int calculate(String str) {
	        String[] str1 = strToExpressionArr(str);
	        return calculate(str1);
	    }
//把表达式转换为数组
private static String[] strToExpressionArr(String str) {
	  ArrayList<String> list = new ArrayList<>();
	  for(int i = 0; i < str.length(); i++) {
    		if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                 str = str.substring(0, i) +
                  " " + str.charAt(i) + " " +
                 str.substring(i + 1, str.length());
                 i += 2;
        }
	}
     Scanner scan = new Scanner(str);
     while (scan.hasNext()) {
        list.add(scan.next());
    }
     scan.close();
     return list.toArray(new String[list.size()]);
}

//计算算术表达式
private  int calculate(String[] expression) {
    for (int i = 0; i < expression.length; i++) {
    	 String ele = expression[i];//如果是数字，进入操作数栈
         if (isOPTR(ele)) {
             OPTR.push(new Integer(ele));
        }
        //以下是符号
        //遇到加减号，把栈顶的符号都处理完，直到遇到（左括号和栈空情况，最后把提取到的符号压入栈
         else if (ele.charAt(0) == '+' || ele.charAt(0) == '-') {
            while (!OPND.isEmpty() && OPND.peek() != '(') {
                int b = OPTR.pop();
                int a = OPTR.pop();
                OPTR.push(getAnswer(a, OPND.pop(), b));
            }

            if (!OPND.isEmpty() && OPND.peek() == '(')
                OPND.pop();

            OPND.push(ele.charAt(0));
        }
        //遇到乘除号，把前面的乘除号处理完，最后把提取到的符号压入栈
        else if (ele.charAt(0) == '*' || ele.charAt(0) == '/') {
            while (!OPND.isEmpty() && OPND.peek() != '(' &&
                    OPND.peek() != '+' && OPND.peek() != '-') {
                int b = OPTR.pop();
                int a = OPTR.pop();
                OPTR.push(getAnswer(a, OPND.pop(), b));
            }

            if (!OPND.isEmpty() && OPND.peek() == '(')
                OPND.pop();

            OPND.push(ele.charAt(0));
        }
        //遇到左括号，只进栈
        else if (ele.charAt(0) == '(') {
            OPND.push(ele.charAt(0));
        }
        //遇到右括号，只处理栈顶全部符号
        else if (ele.charAt(0) == ')') {
            while (!OPND.isEmpty() && OPND.peek() != '(') {
                int b = OPTR.pop();
                int a = OPTR.pop();
                OPTR.push(getAnswer(a, OPND.pop(), b));
            }

            if (!OPND.isEmpty() && OPND.peek() == '(')
                OPND.pop();
        }
    }
    //最后没有以右括号结尾的表达式还得另外把剩下的符号处理完
    if (!OPND.isEmpty()) {
        int b = OPTR.pop();
        int a = OPTR.pop();
        OPTR.push(getAnswer(a, OPND.pop(), b));
    }
    return OPTR.peek();
}
//判断是否数字
private static boolean isOPTR(String s) {
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) < '0' || s.charAt(i) > '9')
            return false;
    }
    return true;
}
//四则运算
private static int getAnswer(int a, char operator, int b) {
    switch (operator) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return a / b;
    }
    return 0;
}
}
class infile {
	void creatfile() {
		String s;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入表达式，以#结束");
		File file = new File("src\\test1");
		if(file.exists()) {
				file.deleteOnExit();
			}else {
				try {
						file.createNewFile();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		s=input.next();  
		try{
		
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			while(!s.equals("#")){
        	
				bw.write(s+"\r\n");
				bw.flush();
				s=input.next();
				
			}
			System.out.println("输入结束");
			System.out.println("注：结果请在src下的test2查看，表达式请在src下的test1查看");
			input.close();
			bw.close();
			fw.close();
			}catch(Exception e){
				e.printStackTrace(); 
			}
}
}
	
class resultfile {
	void writerfile() {
		Calculater a = new Calculater();
		File file = new File("src\\test1");
		File file1 = new File("src\\test2");
	    try{
	    	FileReader fr = new FileReader(file);
	        BufferedReader bf=new BufferedReader(fr);
	        String s1 = null;
	        int result = 0;
	        FileWriter out = new FileWriter(file1);
	        while((s1 = bf.readLine())!=null){	        			        	
	            String s2 = s1.replaceAll(" ","");//去除表达式中的空格（中间及首尾）	        	
	        	judge p = new judge(s2);
	        	if(p.error1()==false) {
		        	out.write("ERROR\r\n");
		        	out.write("#表达式中有其他字符\r\n");
		        	continue;
		        }	
	        	if(p.error2()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中含有空括号\r\n");
	        		continue;
	        	}
	        	if(p.error3()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中有连在一起的两个运算符\r\n");
	        		continue;
	        	}
	        	if(p.error4()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式以运算符开头\r\n");
	        		continue;	        		
	        	}
	        	if(p.error5()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中左括号后有运算符\r\n");
	        		continue;
	        	}
	        	if(p.error6()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中左括号后有运算符\r\n");
	        		continue;
	        	}
	        	if(p.error7()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中左括号前不是运算符\r\n");
	        		continue;
	        	}
	        	if(p.error8()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中右括号后不是运算符\r\n");
	        		continue;
	        	}
	        	if(p.error9()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式以运算符结束\r\n");
	        		continue;
	        	}
	        	if(p.error10()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式括号对不匹配\r\n");
	        		continue;
	        	}	
	        	result = a.calculate(s2);
	        	//result = equation.Change(s2);
	        	out.write(s2+"="+result+"\r\n");
	        }
	        out.close();
	        bf.close();
	        fr.close();
	    }catch(Exception e){
	        e.printStackTrace(); 
	    }
	}
}
//判断不满足计算表达式格式，如果不满足则返回true，反之返回false
class judge {

	private String str; // 需要验证的表达式
	private boolean b; // 表达式是否错误
	
	public judge(String str) {
		this.str = str;
		this.b = true;
	}
	public String getExpression() {
		return str;
	}
	public boolean getb() {
		return b;
	}
	// 匹配是否有其他字符
	public boolean error1() {
		String string = "[^0-9\\+\\-\\*\\/\\(\\)]";	
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配是否有空括号
	public boolean error2() {
		String string = ".*\\(\\).*";		
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {		
			b = false;
		}
		return b;
	}

	// 匹配是否有两个连在一起的运算符
	public boolean error3() {
		String string = ".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式是否以运算符开头
	public boolean error4() {
		String string = "^[\\+\\-\\*\\/\\)]";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式中左括号后有运算符
	public boolean error5() {
		String string = ".*\\([\\+\\*\\/].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式中右括号前有运算符
	public boolean error6() {
		String string = ".*[\\+\\-\\*\\/]\\).*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式中左括号前不是运算符
	public boolean error7() {
		String string = ".*[^\\+\\-\\*\\/\\(]\\(.*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式中右括号后不是运算符
	public boolean error8() {
		String string = ".*\\)[^\\+\\-\\*\\/\\)].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式以运算符结束
	public boolean error9() {
		String string = "[\\+\\-\\*\\/]$";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配括号个数，如果对则返回false，反之返回true
	public boolean error10() {
		int num1 = 0; // 记录(的个数
		int num2 = 0; // 记录)的个数
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				num1++;
			}
			if (c == ')') {
				num2++;
			}
		}
		if (num1 != num2) {
			b = false;
		}
		return b;
	}		
	
}





