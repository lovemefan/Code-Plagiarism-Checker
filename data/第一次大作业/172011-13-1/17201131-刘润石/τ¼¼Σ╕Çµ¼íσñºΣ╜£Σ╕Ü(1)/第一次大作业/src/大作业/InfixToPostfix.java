package 大作业;
/**
 * 中缀表达式转后缀表达式
 * @author 刘润石
 * 
 */
import java.util.Stack;

public class InfixToPostfix {
	Insertion ins = new Insertion();
	Stack<String> stack;//转换时用的栈
	String infix;//装中缀表达式的字符串
	String post = "";//装后缀表达式的字符串
	
	public InfixToPostfix() {
		
	}
    public InfixToPostfix(Stack<String> stack,String infix) {
		this.stack = stack;
		this.infix = infix;
	}
    
    
    
    int level(String str) {//对运算符进行优先级划分
        int lev = 0;
        if(str.equals("(")){
        	
        }else if (str.equals("+") || str.equals("-")) {
            lev = 1;
        }else {
            lev = 2;
        }
        return lev;
    }
    
    void separation(String str, int lev) {//根据运算符优先级进行压栈出栈
        while (!stack.isEmpty()) {
            String top = stack.pop();//把栈中最上边的运算符拿出来比较
            int topLev = level(top);
            if(topLev == 0){//是括号直接压栈
            	 stack.push(top);
                 break;
            }
            if(topLev<lev){
            	stack.push(top);//把栈中最上边的运算符再压回去
                break;
            }else{
            	post += " " + top;//把栈中最上边的运算符放入到后缀表达式
            }
        }
        stack.push(str);//当字符串是空的时，第一个放入的运算符  不是空的是放入当前运算符
    }
    
    void vip() {//"("上边的运算符都依次放到后缀表达式上
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {
                break;
            } else {
                post += " " + top;
            }
        }
    }
    void change(){//进行转换
    	ins.longNum(infix);
    	String[] str = ins.infix.split(" ");
    	for(int i=0;i<str.length;i++){
    		switch (str[i]) {
            case "+":
            case "-":
            	separation(str[i], 1);
                break;
            case "*":
            case "/":
            	separation(str[i], 2);
                break;
            case "(":
            	separation(str[i], 3);
                break;
            case ")":
                vip();
                break;
            default://如果是数字直接放到后缀表达式后边
                post += " " + str[i];
                break;
            }
    	}
    	while (!stack.isEmpty()) {
            post += " " +stack.pop();
        }
    }
    
    String getPost(){//返回后缀表达式并去掉式子前边的空格
    	return post.trim();
    }
}
