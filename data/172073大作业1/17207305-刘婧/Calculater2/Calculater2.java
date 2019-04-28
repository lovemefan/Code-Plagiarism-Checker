package calculate2;

import java.util.Stack;
public class Calculater2 {

    private Stack<Character> charStack = new Stack<Character>();
    private Stack<Double> doubStack = new Stack<Double>();

    // 这是一个纠错方法
    private String Recount(String value) {
        char ch = 0;
        String reValue = "", newStr = "";
        int length = 0, index = 0, count = 0, i = 0;
        // 如果最后的那个数不是数字且也不是回括号，则截取掉
        if (value.length() > 0) {
            char last = value.charAt(value.length() - 1);
            if (!(last >= '0' && last <= '9') || last == '(') 
                value = value.substring(0, value.length() - 1);
        }
        // 修改(4+10-(6 ==>(4+10-(6))
        length = value.length();
        while (i < length) {
            ch = value.charAt(i);
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }
            if (ch >= '0' && ch <= '9') {
                newStr += ch;
            } else {
                if (count >= 0)
                    newStr += ch;
            }
            ++i;
           
        }
        while (count > 0) {
            newStr += ")";
            count--;
        }
        length = newStr.length();
        while (index != length) {
            ch = newStr.charAt(index);
            if (ch >= '0' && ch <= '9') {
                // 修改 10*(4(-5)8) ===> 10*(4*(-5)*8)
                if (index > 0)
                    if (newStr.charAt(index - 1) == ')')
                        reValue += "*";
                reValue += ch;
                if (index < length - 1) {
                    if (newStr.charAt(index + 1) == '(')
                        reValue += "*";
                }
            } else {
                // 修改 10-(5+5)(5+5) ===> 10-(5+5)*(5+5)
                if (index > 0)
                    if (ch == '(' && newStr.charAt(index - 1) == ')')
                        reValue += "*";
                // 针对 -(10/3)+3 ===> 0-(10/3)+3
                if (index == 0 && ch == '-')
                     reValue += "0";
                // 这里起到一个筛选掉其它字母的作用
                switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                case ')':
                case '.':
                case '^':
                    reValue += ch;
                    break;
                }
            }
            ++index;
        }
        // 判断第一个是否为'-'号
        if(reValue.charAt(0) == '-'){
            reValue = "0" + reValue;
        }
        // 以等于号作为结束标记
        return (reValue + "=");
    }

    private int isSwitch(char ch) {
        int number = 0;
        switch (ch) {
        case '+': number = 0; break;
        case '-': number = 1; break;
        case '*': number = 2; break;
        case '/': number = 3; break;
        case '(': number = 4; break;
        case ')': number = 5; break;
        case '^': number = 6; break;
        case '=': number = 7; break;
        }
        return number;
    }

    private char Judge(char One, char Two) {

        char[][] menu = { 
                { '>', '>', '<', '<', '<', '>', '<', '>' },
                { '>', '>', '<', '<', '<', '>', '<', '>' },
                { '>', '>', '>', '>', '<', '>', '<', '>' },
                { '>', '>', '>', '>', '<', '>', '<', '>' },
                { '<', '<', '<', '<', '<', 'K', '<', 'E' },
                { '<', '<', '<', '<', '<', '<', '<', 'E' },
                { '>', '>', '>', '>', '<', '>', '>', '>' },
                { '<', '<', '<', '<', '<', '<', '<', '=' }, };
        int x = 0, y = 0;
        x = isSwitch(One);
        y = isSwitch(Two);
        return menu[x][y];
    }

    // 栈计算
    private String AddStacks(String reValue) {
        char nowaday = 0, nextPop = 0, ch = 0;
        int length = reValue.length();
        double number = 0, temp = 0, decimal = 1, result = 0, One = 0, Two = 0;
        boolean flag = false, sflag = false, dflag = false, nflag = false, reckon;
        // 栈中以等于号作为开始标记
        charStack.push('=');
        int index = 0;
        while (index < length) {
            ch = reValue.charAt(index);
            while (ch >= '0' && ch <= '9' || ch == '.') {
                if (ch != '.') {
                    number = Double.parseDouble(String.valueOf(ch));
                    temp = (temp * 10) + number;
                    flag = true;
                    if (dflag)
                        decimal *= 10;
                } else
                    dflag = true;
                index++;
                ch = reValue.charAt(index);
            }
            /** -------------- + - * / ( ) ----------------- */
            reckon = true;
            if (flag == true) {
                // nflag 针对(-5+4) 的记录值
                // sflag 针对 -(5+4) 改为：(-5 + -4)
                if (nflag || sflag) {
                    if (nflag)
                        nflag = false;
                    temp = -temp;
                }
                // 小数点
                if (dflag) {
                    temp /= decimal;
                    dflag = false;
                    decimal = 1;
                }
                doubStack.push(temp);
                temp = 0;
                flag = false;
            }
            if (sflag && ch == ')')
                sflag = false;
            if (ch == '-') {
                char chs = reValue.charAt(index - 1);
                char chn = reValue.charAt(index + 1);
                if (chs == '+' || chs == '-' || chs == '*' || chs == '/'
                        || chs == '(') {
                    // 如果类似于这种 5*-(10+4) 遇到-符号后面是减号则
                    // 从-号后面的括号开始 依次转换为 5*(-10+-4)
                    if (chn == '(')
                        sflag = true;
                    else
                        nflag = true; // 针对 + - * / 后面的 - ，作为负数来处理
                    reckon = false;
                }
            }
            while (reckon) {
                nowaday = reValue.charAt(index);
                nextPop = charStack.pop();
                switch (Judge(nextPop, nowaday)) {
                case '>':
                    try {
                        Two = doubStack.pop();
                        One = doubStack.pop();
                    } catch (Exception e) {
                        return "ERROR";
                    }
                    switch (nextPop) {
                    case '+': result = One + Two; break;
                    case '-': result = One - Two; break;
                    case '*': result = One * Two; break;
                    case '/': result = One / Two; break;
                    case '^': result = Math.pow(One, Two); break;
                    }
                    doubStack.push(result);
                    break;
                case '<':
                    charStack.push(nextPop);
                    charStack.push(nowaday);
                    reckon = false;
                    break;
                case '=':
                    // 保留二位小数点
                    return (reValue + String.format("%g", doubStack.pop()));
                case 'K': // 开括号与回括号相撞，出栈的开括号不入栈并从回括号开始把符号往下移一位
                    ++index;
                    break;
                case 'E':
                    return ("ERROR");
                }
            }
            ++index;
        }
        return null;
    }

    /*
     * 调用公开的方法进行计算
     */
    public String getEventuate(String expression) {
      if(expression=="") {
   		  System.out.println("ERROR #表达式为空");
   	  }
   	  else if(expression.matches(".*(\\(\\))+.*")) {
   		  return("ERROR #表达式中有空括号");
   	  }
   	  else if(expression.matches(".*\\d\\(.*")) {
   		  System.out.println("ERROR #括号不匹配");
   	  }
   	  else if(expression.matches(".*\\)\\d.*")) {
   		  System.out.println("ERROR #括号不匹配");
   	  }
   	  else if(expression.matches(".*\\([\\+\\-\\*\\/].*")) {
   		  System.out.println("ERROR #运算符前无运算数");
   	  }
   	  else if(expression.matches(".*[\\+\\-\\*\\/]\\).*")) {
   		System.out.println("ERROR #运算符后无运算数");
   	  }
   	  else if(expression.matches(".*\\d\\(.*")) {
   		System.out.println("ERROR #小括号前无运算符且不为第一个字符");
   	  }
   	 else if(expression.matches(".*\\)\\d.*")) {
    		System.out.println("ERROR #小括号后无运算符且不为第一个字符");
    	  }
   	  else
        return AddStacks(Recount(expression.trim()));
	return expression;
    }
}
