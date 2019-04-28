import java.util.Arrays;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Arithmetic {
    //错误提示
    private static final String ERROR_ZERO = "DividedZero";
    
    //检测一个字符串是不是数字
    private static Pattern pattern = Pattern.compile("\\d+\\.?\\d?");
    
    //运算符优先级
    private static Map<String, Integer> priority = new HashMap<>();
    static {
        priority.put("*", 2);
        priority.put("/", 2);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("", -1); //无运算符
    }
    
    //替换表达式中的中文括号
    private static Map<String, String> replace = new HashMap<>();
    static {
        replace.put("（", "(");
        replace.put("）", ")");
    }
    
    //支持的运算符
    private static String[] operator = {"+", "-", "*", "/"};
    
    private static Stack<String> stack = new Stack<>();
    
    //计算算式
    public static void main(String[] args) throws Exception {
    	java.io.File file1 = new java.io.File("输入50个计算式.txt");
    	Scanner input = new Scanner(file1);
    	
    	String[] F = new String[50];
    	for(int i = 0;i < 50;i++) {
    		F[i] = input.nextLine().replaceAll(" ", "");
    	}//将读取数据放入数组
    	
    	input.close();
    	
    	String[] FF = new String[50];
    	int k = 0;
    	int kk = 0;
    	for(int i = 0;i < 50;i++) {
    		if(i > 0) {
    			kk = 0;
    			for(int j = 0;j < k;j++) {
    				if(F[i].equals(FF[j]) == true) {
    					kk = 1;
    				}
    			}
    		}
    		if(kk == 1) {
    			continue;
    		}
    		
    		FF[k] = F[i];
    		k++;
    	}
    	
    	int kkk = 0;
    	for(int i = 0;i < 50;i++) {
    		if(FF[i] == null) {
    			kkk = i;
    			break;
    		}
    		if(i == 50 - 1) {
    			kkk = i + 1;
    		}
    	}//数据查重
    	
    	FileOutputStream fos = new FileOutputStream("计算式结果.txt"); 
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8"); 
    	
    	for(int i = 0;i < kkk;i++) {
    		String match1 = "[0-9\\+\\-\\(\\)\\*\\/]*";//判断字符串只能由四则运算符号，数字，左右括号组成
    		String match2 = "(.*)[0-9]\\((.*)";//缺少操作符:左括号左边缺少操作符
    		String match3 = "(.*)\\)[0-9](.*)";//缺少操作符:右括号右边缺少操作符
    		String match4 = "(.*)\\([\\*+-/](.*)";//缺少操作数:左括号右边缺少操作数
    		String match5 = "(.*)[\\*+-/]\\)(.*)";//缺少操作数:右括号左边缺少操作数
    		String match6 = "(.*)\\(\\)(.*)";//空括号:括号内无表达式
    		String match7 = "(.*)[\\*+-/][\\*+-/](.*)";//运算符缺少操作数
    		
    		if(i == 0) {
    			osw.write(FF[i]);
    		}else {
    			osw.write("\r\n" + FF[i]);
    		}
    		
    		int j = 0;
    		int x = 0;
    		int y = 0;
    		String s = new String();
    		s = FF[i];
    		char[] sArr = s.toCharArray();
    		
    		for(int l = 0;l < sArr.length;l++) {
    			if(sArr[l] == '(') {
    				x++;
    			}
    			if(sArr[l] == ')') {
    				y++;
    			}
    		}
    		
    		if(x > y) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#右括号缺失");
    		}
    		if(x < y) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#左括号缺失");
    		}
    		if(FF[i].matches(match1) == false) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#含有非法字符");
    		}
    		if(FF[i].matches(match2) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#左括号左边缺少操作符");
    		}
    		if(FF[i].matches(match3) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#右括号右边缺少操作符");
    		}
    		if(FF[i].matches(match4) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#左括号右边缺少操作数");
    		}
    		if(FF[i].matches(match5) == true) {
    			j = 1;
    			osw.write("\\r\\nERROR");
    			osw.write("\\r\\n#右括号左边缺少操作数");
    		}
    		if(FF[i].matches(match6) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#括号内无表达式");
    		}
    		if(FF[i].matches(match7) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#运算符缺少操作数");
    		}
    		if(j == 0) {
    			String expression = FF[i];
    			osw.write(" = " + execute(expression));
    		}
    	}
    	
    	osw.flush();
        
    }
    
    public static String execute(String expression) {
        return suffixToValue(inffixToSuffix(trim(expression)));
    }
    
    private static String trim(String expression) {
        String result = expression.trim();
        for (Map.Entry<String, String> entry : replace.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }
        return result;
    }
    

     //将中缀表达式转换成后缀表达式
    private static String inffixToSuffix(String expression) {
        stack.clear();
        StringBuilder inffix = new StringBuilder(expression);
        StringBuilder suffix = new StringBuilder();
        String element = ""; // 中缀表达式的数字或者运算符
        String tmp = "";
        
        while (inffix.length() > 0) {
            element = popNextElement(inffix);
            
            if (isNum(element)) { // 是数字则输出
                suffix.append(element).append(" ");
            } else if (")".equals(element)) { // 右括号则将左括号之前的内容全弹出
                tmp = stack.pop();
                while (!"(".equals(tmp)) {
                    suffix.append(tmp).append(" ");
                    tmp = stack.pop();
                }
            } else if ("(".equals(element) || priority.get(element) >= priority.get(getTopOperator())) {
                stack.push(element);
            } else { // 优先级小于栈顶运算符，则弹出
                tmp = stack.pop();
                suffix.append(tmp).append(" ").append(element).append(" ");
            } 
        }
        
        // 把栈中剩余运算符都弹出
        while (stack.size() > 0) {
            suffix.append(stack.pop()).append(" ");
        }
        
        return suffix.toString();
    }
    
    //根据后缀表达式算出结果
    private static String suffixToValue(String expression) {
        String[] suffix = expression.split(" ");
        stack.clear();        
        double num1 = 0, num2 = 0;
        String tmp = "";
        
        for (int i = 0; i < suffix.length; i++) {
            if (isNum(suffix[i])) { // 数字
                stack.push(suffix[i]);
            } else{ // 是操作符
                num2 = Double.parseDouble(stack.pop());
                num1 = Double.parseDouble(stack.pop());
                tmp = calculate(num1, num2, suffix[i]);
                if (ERROR_ZERO.equals(tmp)) {
                    throw new ArithmeticException("被除数不能为0");
                } else {
                    stack.push(tmp);
                }
            }
        }
        
        return stack.pop();
    }
    
    private static String calculate(double num1, double num2, String operator) {
        double result = 0;
        switch (operator) {
        case "+":
            result = num1 + num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            if (num2 == 0){ // 除数为0
                return ERROR_ZERO;
            }
            result = 1.0 * num1 / num2;
            break;
        default:
            break;
        }
        return String.valueOf(result);
    }
    
    private static boolean isNum(char c) {
        if ( (c >= '0' && c <= '9') || c == '.' ) {
            return true;
        }
        return false;
    }
    
    private static boolean isNum(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
    
    private static String getTopOperator() {
        String tmp = "";
        for (int i = stack.size() - 1; i >= 0; i--) {
            tmp = stack.get(i);
            if ("(".equals(tmp)) {
                break;
            } else if (isOperator(tmp)) {
                return tmp;
            }
        }
        return "";
    }
    
    private static boolean isOperator(String str) {
        for (int i = 0; i < operator.length; i++) {
            if (operator[i].equals(str)) {
                return true;
            }
        }
        return false;
    }
    
    private static String popNextElement(StringBuilder expression) {
        StringBuilder result = new StringBuilder();
        char c = expression.charAt(0);
        expression.deleteCharAt(0);
        result.append(c);
        
        if (isNum(c)) {
            // 如果第一次取到的是数字，则继续检查
            while ( expression.length() >0 && isNum(c = expression.charAt(0))) {
                expression.deleteCharAt(0);
                result.append(c);
            }
        }
 
        return result.toString();
    }
}
