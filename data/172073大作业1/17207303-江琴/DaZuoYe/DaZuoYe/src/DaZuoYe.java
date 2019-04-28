

import java.util.*;

import java.io.*;
import java.util.regex.Pattern;

public class DaZuoYe{
    public static void main(String[] args){
        String inputFile = "inp.txt";
        String outputFile = "outp.txt";
        //输入输出文件 
        BufferedReader inp = null;
        BufferedWriter outp = null;
        String[] strs = new String[100000];
        //记录之前的表达式 
        int cnt = 0;
        try {
            inp = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
            outp = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile),"UTF-8"));
            String str = null;
            while ((str = inp.readLine()) != null) {
                //从文件读取一行表达式 
                String result = "";
                for(int i = 0; i < cnt; ++i){
                    if(str.equals(strs[i])){
                        result = "ERROR #相同字符串";
                    }
                }
                boolean nullstr = true;
                for(int i = 0; i < str.length(); ++i){
                    if(str.charAt(i) != ' '){
                        //判断是否全为空格 
                        nullstr = false;
                    }
                }
                if(nullstr){
                    result = "ERROR #表达式为空";
                }
                boolean nullstr2 = false;
                for(int j = 0; j < str.length(); ++j){
                    if(str.charAt(j) == '('&&str.charAt(j+1) == ')'){
                        //判断是否全为空格 
                        nullstr2 = true;
                    }
                }
                if(nullstr2){
                    result = "ERROR #表达式中有空括号";
                }
                if(result.length() == 0){
                    strs[cnt++] = str;
                    int status = check(str);
                    //判断括号匹配,非法字符,运算是否合法 
                    if(status == 1){
                        result = "ERROR #括号不匹配";
                    }else if(status == 2) {
                        result = "ERROR #表达式中包含非法字符";
                    }else if(status == 3){
                        result = "ERROR #括号非第一个字符且之前无运算数";
                    }else if(status == 4) {
                    	result = "ERROR #小括号后无运算数,括号非最后一个字符";
                    }else if(status == 5) {
                    	result = "ERROR #运算符连续";
                    }else{
                        	Calc cc = new Calc();
                        	String ret = cc.calc(str);
                        	//如果返回的结果为#,就说明中途有除数为0的地方 
                        	if(ret == "#"){
                        		result = "ERROR #除数为0";
                        	}else{
                            result = str + ret;
                        }
                    }
                }
                outp.write(result);
                outp.newLine();
            }
            outp.flush();
            inp.close();
            outp.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean isSim(char c){
        //判断是否为运算符 
        if(c == '+' || c == '-' || c == '*' || c == '/'){
            return true;
        }
        return false;
    }

    private static int check(String str) {
        for(int i = 1; i < str.length(); ++i){
           //if( isSim(str.charAt(i)) && isSim(str.charAt(i-1)) ){
                //检查连续运算符 
             //   return 3;
            //}
            if(str.charAt(i) == '(' && i > 0 && !isSim(str.charAt(i-1))){
                //检查左括号 
                return 3;
            }
            if(str.charAt(i) == ')' && i != str.length() - 1 && !isSim(str.charAt(i+1))){
                //检查右括号 
                return 4;
            }
            if( isSim(str.charAt(i)) && isSim(str.charAt(i-1)) ){
                //检查连续运算符 
                return 5;
            }
        }
    
        int L = 0;
        for(int i = 0; i < str.length(); ++i){
            //检查括号匹配 
            if(str.charAt(i) == '('){
                L++;
            }else  if(str.charAt(i) == ')'){
                L--;
                if(L < 0){
                    return 1;
                }
            }
        }
        if(L != 0){
            return 1;
        }
        String pattern = "[0-9+\\-*/()=\\s+]*";
        //正则表达式判断表达式合法 
        boolean isMatch = Pattern.matches(pattern, str);
        if(!isMatch){
            return 2;
        }
        return 0;
    }
}

class Calc{
    public String calc(String numStr) {
        numStr += '=';
        Stack<Double> numberStack = new Stack<Double>();
        Stack<Character> symbolStack = new Stack<Character>();
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if(ch == ' ')continue;
            //每次读取一个字符 
            if (ch >= '0' && ch <= '9') {
                //如果是数字则转化为数字 
                temp.append(ch);
            } else {
                String tempStr = temp.toString();
                if (!tempStr.isEmpty()) {
                    long num = Long.parseLong(tempStr);
                    numberStack.push((double)num);
                    temp = new StringBuffer();
                }
                //否则先读取数字,然后根据运算符优先级计算 
                while (!symbolStack.empty() && !comparePri(ch,symbolStack)) {
                    double b = numberStack.pop();
                    double a = numberStack.pop();
                    switch ((char) symbolStack.pop()) {
                        case '+':
                            numberStack.push(a + b);
                            break;
                        case '-':
                            numberStack.push(a - b);
                            break;
                        case '*':
                            numberStack.push(a * b);
                            break;
                        case '/':
                            //如果是除法需要检查分母为0 
                            if(b == 0){ return "#"; }
                            numberStack.push(a / b);
                            break;
                        default:
                            break;
                    }
                }
                //将计算结果放入栈中 
                if (ch != '=') {
                    symbolStack.push(new Character(ch));
                    if (ch == ')') {
                        symbolStack.pop();
                        symbolStack.pop();
                    }
                }
                //遇到=时得到结果 
            }
        }
        double ret = numberStack.pop();
        return Double.toString(ret);
    }

    private boolean comparePri(char symbol, Stack<Character> symbolStack) {
        //用于比较运算符的优先级 
        if (symbolStack.empty()) {
            return true;
        }

        char top = (char) symbolStack.peek();
        if (top == '(') {
            return true;
        }
        switch (symbol) {
            case '(':
                return true;
            case '*': {
                if (top == '+' || top == '-')
                    return true;
                else
                    return false;
            }
            case '/': {
                if (top == '+' || top == '-')
                    return true;
                else
                    return false;
            }
            case '+':
                return false;
            case '-':
                return false;
            case ')':
                return false;
            case '=':
                return false;
            default:
                break;
        }
        return true;
    }
}


