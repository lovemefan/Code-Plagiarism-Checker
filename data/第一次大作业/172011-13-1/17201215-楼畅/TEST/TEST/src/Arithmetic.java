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
    //������ʾ
    private static final String ERROR_ZERO = "DividedZero";
    
    //���һ���ַ����ǲ�������
    private static Pattern pattern = Pattern.compile("\\d+\\.?\\d?");
    
    //��������ȼ�
    private static Map<String, Integer> priority = new HashMap<>();
    static {
        priority.put("*", 2);
        priority.put("/", 2);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("", -1); //�������
    }
    
    //�滻���ʽ�е���������
    private static Map<String, String> replace = new HashMap<>();
    static {
        replace.put("��", "(");
        replace.put("��", ")");
    }
    
    //֧�ֵ������
    private static String[] operator = {"+", "-", "*", "/"};
    
    private static Stack<String> stack = new Stack<>();
    
    //������ʽ
    public static void main(String[] args) throws Exception {
    	java.io.File file1 = new java.io.File("����50������ʽ.txt");
    	Scanner input = new Scanner(file1);
    	
    	String[] F = new String[50];
    	for(int i = 0;i < 50;i++) {
    		F[i] = input.nextLine().replaceAll(" ", "");
    	}//����ȡ���ݷ�������
    	
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
    	}//���ݲ���
    	
    	FileOutputStream fos = new FileOutputStream("����ʽ���.txt"); 
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8"); 
    	
    	for(int i = 0;i < kkk;i++) {
    		String match1 = "[0-9\\+\\-\\(\\)\\*\\/]*";//�ж��ַ���ֻ��������������ţ����֣������������
    		String match2 = "(.*)[0-9]\\((.*)";//ȱ�ٲ�����:���������ȱ�ٲ�����
    		String match3 = "(.*)\\)[0-9](.*)";//ȱ�ٲ�����:�������ұ�ȱ�ٲ�����
    		String match4 = "(.*)\\([\\*+-/](.*)";//ȱ�ٲ�����:�������ұ�ȱ�ٲ�����
    		String match5 = "(.*)[\\*+-/]\\)(.*)";//ȱ�ٲ�����:���������ȱ�ٲ�����
    		String match6 = "(.*)\\(\\)(.*)";//������:�������ޱ��ʽ
    		String match7 = "(.*)[\\*+-/][\\*+-/](.*)";//�����ȱ�ٲ�����
    		
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
    			osw.write("\r\n#������ȱʧ");
    		}
    		if(x < y) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#������ȱʧ");
    		}
    		if(FF[i].matches(match1) == false) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#���зǷ��ַ�");
    		}
    		if(FF[i].matches(match2) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#���������ȱ�ٲ�����");
    		}
    		if(FF[i].matches(match3) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#�������ұ�ȱ�ٲ�����");
    		}
    		if(FF[i].matches(match4) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#�������ұ�ȱ�ٲ�����");
    		}
    		if(FF[i].matches(match5) == true) {
    			j = 1;
    			osw.write("\\r\\nERROR");
    			osw.write("\\r\\n#���������ȱ�ٲ�����");
    		}
    		if(FF[i].matches(match6) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#�������ޱ��ʽ");
    		}
    		if(FF[i].matches(match7) == true) {
    			j = 1;
    			osw.write("\r\nERROR");
    			osw.write("\r\n#�����ȱ�ٲ�����");
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
    

     //����׺���ʽת���ɺ�׺���ʽ
    private static String inffixToSuffix(String expression) {
        stack.clear();
        StringBuilder inffix = new StringBuilder(expression);
        StringBuilder suffix = new StringBuilder();
        String element = ""; // ��׺���ʽ�����ֻ��������
        String tmp = "";
        
        while (inffix.length() > 0) {
            element = popNextElement(inffix);
            
            if (isNum(element)) { // �����������
                suffix.append(element).append(" ");
            } else if (")".equals(element)) { // ��������������֮ǰ������ȫ����
                tmp = stack.pop();
                while (!"(".equals(tmp)) {
                    suffix.append(tmp).append(" ");
                    tmp = stack.pop();
                }
            } else if ("(".equals(element) || priority.get(element) >= priority.get(getTopOperator())) {
                stack.push(element);
            } else { // ���ȼ�С��ջ����������򵯳�
                tmp = stack.pop();
                suffix.append(tmp).append(" ").append(element).append(" ");
            } 
        }
        
        // ��ջ��ʣ�������������
        while (stack.size() > 0) {
            suffix.append(stack.pop()).append(" ");
        }
        
        return suffix.toString();
    }
    
    //���ݺ�׺���ʽ������
    private static String suffixToValue(String expression) {
        String[] suffix = expression.split(" ");
        stack.clear();        
        double num1 = 0, num2 = 0;
        String tmp = "";
        
        for (int i = 0; i < suffix.length; i++) {
            if (isNum(suffix[i])) { // ����
                stack.push(suffix[i]);
            } else{ // �ǲ�����
                num2 = Double.parseDouble(stack.pop());
                num1 = Double.parseDouble(stack.pop());
                tmp = calculate(num1, num2, suffix[i]);
                if (ERROR_ZERO.equals(tmp)) {
                    throw new ArithmeticException("����������Ϊ0");
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
            if (num2 == 0){ // ����Ϊ0
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
            // �����һ��ȡ���������֣���������
            while ( expression.length() >0 && isNum(c = expression.charAt(0))) {
                expression.deleteCharAt(0);
                result.append(c);
            }
        }
 
        return result.toString();
    }
}
