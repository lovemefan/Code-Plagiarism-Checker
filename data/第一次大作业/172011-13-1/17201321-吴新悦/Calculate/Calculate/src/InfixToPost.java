import java.util.Scanner;
public class InfixToPost {
    private Stack<String> stack;  //中缀表达式转换为后缀表达式所需要的栈
    private String infix;    //输入的中缀表达式
    private String post = "";     //存储得到的后缀表达式

    //初始化构造器
    public InfixToPost(Stack<String> stack, String infix) {
        this.stack = stack;
        this.infix = infix;
    }
    
    public InfixToPost(){
    	
    }
    
    //将得到的公式转换为前缀形式
    private String processInfix(String infix) {
        String result = "";
        for (int i = 0; i < infix.length() - 1; i++) {
            char temp1 = infix.charAt(i);
            char temp2 = infix.charAt(i + 1);
            if (Character.isDigit(temp1) && Character.isDigit(temp2)) {
                result += temp1;
            } else {
                result += temp1 + " ";
            }
        }
        result += infix.charAt(infix.length() - 1); // 将最后一个元素添加进去
        return result;
    }

    //将前缀表达式转换为后缀表达式的处理过程
    public void process() {
        String[] strArr = processInfix(infix).split(" ");
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            switch (str) {
            case "+":
            case "-":
                getOperation(str, 1);
                break;
            case "*":
            case "/":
                getOperation(str, 2);
                break;
            case "(":
                stack.push(str);
                break;
            case ")":
                getParent();
                break;
            default:
                post += " " + str;
                break;
            }
        }
        // 数字全部输出后，需要输出栈中剩余的符号
        while (!stack.isEmpty()) {
            post += " " + stack.pop();
        }
    }

    //如果是右括号则把所有运算符输出
    private void getParent() {
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {
                break;
            } else {
                post += " " + top;
            }
        }
    }

    //判断符号级优先级，然后对栈就行处理
    private void getOperation(String str, int priority) {
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {
                stack.push(top);
                break;
            } else {
                int priTop = getPriority(top);
                if (priTop < priority) {
                    stack.push(top);
                    break;
                } else {
                    post += " " + top;
                }
            }
        }
        stack.push(str);
    }

    //判断符号优先级并返回
    private int getPriority(String str) {
        int pri = 0;
        if (str.equals("+") || str.equals("-")) {
            pri = 1;
        } else {
            pri = 2;
        }
        return pri;
    }

    //去除后缀表达式开头和结尾的空格
    public String getPost(){
        return post.trim();
    }

}