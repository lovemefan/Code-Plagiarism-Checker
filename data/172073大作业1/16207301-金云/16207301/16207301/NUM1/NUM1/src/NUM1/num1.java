package NUM1;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import javax.script.*;

public class num1 {

	    static boolean isNumber(String str) {
		Pattern pattern = Pattern.compile("([1-9]\\d*\\.\\d+|0\\.\\d*[1-9]\\d*|[1-9]\\d*|0)$"); // �����ж�����&С��,
													  
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
		    return false;
		}
		return true;
	    }

	    private static boolean getNumberStringFromList(List<Character> list) {
		if (list != null) {
		    StringBuffer stringBuffer = new StringBuffer();
		    for (Character character : list) {
			stringBuffer.append(character);
		    }
		    boolean result = isNumber(stringBuffer.toString());

		    if (!result) {
			System.out.println("error type: digit ->" + stringBuffer.toString());
		    }
		    // System.out.println(result);
		    return result;
		}
		System.out.println(".");
		return false;
	    }

	    static boolean checkExpression(String expression) {
		expression = expression.replaceAll(" ", "");
		if ("".equals(expression) || expression.indexOf("()") != -1)
		    return false;
		Set<Character> operate_set = new HashSet<>();
		operate_set.add('-');
		operate_set.add('+');
		operate_set.add('*');
		operate_set.add('/');
		char[] arr = expression.toCharArray();
		int len = arr.length;
		int checkNum = 0;
		List<Character> digit_list = new ArrayList<>();
		@SuppressWarnings("unused")
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < len; i++) {
		    if (Character.isDigit(arr[i]) || arr[i] == '.')
			digit_list.add(arr[i]);
		    else {
			if (digit_list.size() > 0) {
			    boolean result = getNumberStringFromList(digit_list);
			    if (result)
				digit_list.clear();
			    else
				return false;
			}
			if (arr[i] == '+' || arr[i] == '*' || arr[i] == '/') {
			    if (i == 0 || i == (len - 1) || operate_set.contains(arr[i + 1]) || arr[i + 1] == ')')
				return false;
			} else if (arr[i] == '-') {
			    if (i == (len - 1) || operate_set.contains(arr[i + 1]) || arr[i + 1] == ')')
				return false;
			} else if (arr[i] == '(') {
			    checkNum++;
			    if (i == (len - 1) || arr[i + 1] == '+' || arr[i + 1] == '*' || arr[i + 1] == '/'
				    || arr[i + 1] == ')' || (i != 0 && Character.isDigit(arr[i - 1])))
				return false;
			} else if (arr[i] == ')') {
			    checkNum--;
			    if (i == 0 || (i < (len - 1) && arr[i + 1] == '(')
				    || (i != len - 1 && Character.isDigit(arr[i + 1])) || checkNum < 0)
				return false;
			} else
			    return false;
		    }
		}
		if (digit_list.size() > 0) {
		    boolean result = getNumberStringFromList(digit_list);
		    if (result)
			digit_list.clear();
		    else
			return false;
		}
		if (checkNum != 0)
		    return false;
		return true;
	    }

	    public static void main(String[] args) throws Throwable {
		//////////////////////////////////////////////////////////// ����JavaScript������
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("js");
		//////////////////////////////////////////////////////////// �ļ���
		Scanner sc = new Scanner(new File("E:/num1.txt"));
		FileOutputStream output = new FileOutputStream("E:/num2.txt");
		PrintStream print = new PrintStream(output);
		//////////////////////////////////////////////////////////// ����
		String str = "", result;
		int status;
		//////////////////////////////////////////////////////////// ����
		while (sc.hasNextLine()) {
		    str = sc.nextLine();
		    // �жϱ��ʽ�Ƿ���ȷ
		    status = !checkExpression(str) ? -1 : 0;
		    try { // ��str�еı��ʽת��Ϊ�����������ַ�����ʽ���浽result��
			if (status == -1)
			    throw new Exception();
			result = se.eval(str).toString();
			print.println(str + "=" + result);
		    } catch (Exception e) {
			print.println("ERROR");
			print.println("#所对应的错误输入内容!\t");
		    }
		}
		sc.close();
		print.close();
	    }
	}