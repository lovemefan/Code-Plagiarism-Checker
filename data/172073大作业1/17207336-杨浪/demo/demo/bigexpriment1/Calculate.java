package bigexpriment1;
import java.util.Stack;
public class Calculate {
	String s;
	Calculate(){
	}
	public	double qiuzhi(String s) {
		this.s=s;
		Stack<String> s1=new Stack<>();
		Stack<String> s2=new Stack<>();
		s1.push(null);
		 // 将算术表达式转换成字符数组
        char[] chars = s.toCharArray();
        // 循环遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                	  // 读取到左括号，直接压入S1栈

                    s1.push(chars[i] + "");
                    break;
                case ')':
                	// 若取出的字符是“)”，则将距离S1栈栈顶最近的“(”之间的运算符，逐个出栈，依次送入S2栈，此时抛弃“（”。

                    do {
                        s2.push(s1.pop());
                    } while (!s1.peek().equals("("));
                    s1.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                //  若取出的字符是运算符，则将该运算符与S1栈栈顶元素比较，
                    // 如果该运算符优先级(不包括括号运算符)大于S1栈栈顶运算符优先级，则将该运算符进S1栈，
                    // 否则，将S1栈的栈顶运算符弹出，送入S2栈中，直至S1栈栈顶运算符低于（不包括等于）该运算符优先级，
                    // 最后将该运算符送入S1栈。

                    if (map(chars[i])>map(s1.peek())) {
                        s1.push(chars[i] + "");
                    } else {
                        do {
                            s2.push(s1.pop());
                        } while (map(chars[i])<map(s1.peek()));
                        s1.push(chars[i] + "");
                    }
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                 // 处理俩位以上的数以及小数的读取
                    while (Character.isDigit(chars[i]) || chars[i] == '.') {// 若取出的字符是操作数，则分析出完整的运算数
                        sb.append(chars[i]);
                        if (i < chars.length - 1 && (Character.isDigit(chars[i + 1]) || chars[i + 1] == '.')) {
                            i++;
                        } else {
                            break;
                        }
                    }
                 // 该操作数直接送入S2栈
                    s2.push(sb.toString());
                    break;
            }
        }
        while(s1.peek()!=null) {
        	s2.push(s1.pop());//将所有操作符放入s2
        }
        Stack<String> stack=new Stack<>();
        Stack<String> optr=new Stack<>();
        while(!s2.empty()) {
        	stack.push(s2.pop());//逆序
        }
        while(!stack.empty()) {
        	String ops=stack.pop();
        	if(Character.isDigit(ops.charAt(0))) {
        		optr.push(ops);
        	}
        	else {
        		double a=Double.valueOf(optr.pop());
        		double b=Double.valueOf(optr.pop());
        		switch(ops) {
        		case "+":
        			optr.push(String.valueOf(a+b));
        			break;
        		case "-":
        			optr.push(String.valueOf(a-b));
        			break;
        		case "*":
        			optr.push(String.valueOf(a*b));
        			break;
        		case "/":
        			optr.push(String.valueOf(a/b));
        			break;
        		}
        	}
        }
       double result=Double.valueOf(optr.pop());
       return result;
	}
	public int map(String a) {
		if(a=="+")
			return 0;
		else if(a=="-")
			return 0;
		else if(a=="*")
			return 1;
		else if(a=="/")
			return 1;
		else if(a=="(")
			return -1;
		else
			return -1;
	}
	public int map(char a) {
		if(a=='+')
			return 0;
		else if(a=='-')
			return 0;
		else if(a=='*')
			return 1;
		else if(a=='/')
			return 1;
		else if(a=='(')
			return -1;
		else
			return -1;
	}
}

