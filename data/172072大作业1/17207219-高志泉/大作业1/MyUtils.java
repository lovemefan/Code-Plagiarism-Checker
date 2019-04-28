package ����ҵ1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class MyUtils {
    public static final int FORMAT_MAX_LENGTH = 500;// ���ʽ��󳤶�����
    public static final int RESULT_DECIMAL_MAX_LENGTH = 8;// ���С������󳤶�����
    public static final Map<Character, Integer> symLvMap = new HashMap<Character, Integer>();// �������ȼ�map
    static {
        symLvMap.put('=', 0);
        symLvMap.put('-', 1);
        symLvMap.put('+', 1);
        symLvMap.put('*', 2);
        symLvMap.put('/', 2);
        symLvMap.put('(', 3);
        symLvMap.put(')', 1);
        // symLvMap.put('^', 3);
        // symLvMap.put('%', 3);
    }

    
    public static boolean checkFormat(String str) {
        // У���Ƿ��ԡ�=����β
        if ('=' != str.charAt(str.length() - 1)) {
            return false;
        }
        // У�鿪ͷ�Ƿ�Ϊ���ֻ��ߡ�(��
        if (!(isCharNum(str.charAt(0)) || str.charAt(0) == '(')) {
            return false;
        }
        char c;
        // У��
        for (int i = 1; i < str.length() - 1; i++) {
            c = str.charAt(i);
            if (!isCorrectChar(c)) {// �ַ����Ϸ�
                return false;
            }
            if (!(isCharNum(c))) {
                if (c == '-' || c == '+' || c == '*' || c == '/') {
                    if (c == '-' && str.charAt(i - 1) == '(') {// 1*(-2+3)�����
                        continue;
                    }
                    if (!(isCharNum(str.charAt(i - 1)) || str.charAt(i - 1) == ')')) {// ������ǰһ���������ֻ��ߡ�����ʱ
                        return false;
                    }
                }
                if (c == '.') {
                    if (!isCharNum(str.charAt(i - 1)) || !isCharNum(str.charAt(i + 1))) {// У�顰.����ǰ���Ƿ�λ����
                        return false;
                    }
                }
            }
        }
        return isBracketCouple(str);// У�������Ƿ����
    }

 
    public static String change2StandardFormat(String str) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (i != 0 && c == '(' && (isCharNum(str.charAt(i - 1)) || str.charAt(i - 1) == ')')) {
                sb.append("*(");
                continue;
            }
            if (c == '-' && str.charAt(i - 1) == '(') {
                sb.append("0-");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    
    public static boolean isBracketCouple(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.removeLast();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    
    public static String formatResult(String str) {
        String[] ss = str.split("\\.");
        if (Integer.parseInt(ss[1]) == 0) {
            return ss[0];// ����
        }
        String s1 = new StringBuilder(ss[1]).reverse().toString();
        int start = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        return ss[0] + "." + new StringBuilder(s1.substring(start, s1.length())).reverse();
    }

    
    public static boolean isCorrectChar(Character c) {
        if (('0' <= c && c <= '9') || c == '-' || c == '+' || c == '*' || c == '/' || c == '(' || c == ')'
                || c == '.') {
            return true;
        }
        return false;
    }

    
    public static boolean isCharNum(Character c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;

    }

    
    public static double plus(double num1, double num2) {
        return num1 + num2;
    }

   
    public static double reduce(double num1, double num2) {
        return num1 - num2;
    }

    
    public static double multiply(double num1, double num2) {
        return num1 * num2;

    }

   
    public static double divide(double num1, double num2) {
        return num1 / num2;
    }
}

