package BigWork;

public class InfixToPost {
	private Stacks<String> stack = new Stacks();//创建一个栈
	private String infix;//中缀表达式
	private String post = "";//后缀表达式
	private String temp;//中转作用
	//构造函数
	public InfixToPost(String infix){
		this.infix = infix;
	}
	//将中缀表达式加入空格
	private String addSpace(String infix){
		String addInfix = " ";
		for(int i = 0;i < infix.length() -1;i ++) {
            char temp1 = infix.charAt(i);
            char temp2 = infix.charAt(i + 1);
            if (pan(temp1) && pan(temp2))
                addInfix += temp1 + "";
            else 
                addInfix += temp1 + " ";
        }
        addInfix += infix.charAt(infix.length() - 1); // 将最后一个元素添加进去
        return addInfix;
    }
	//判断是否为数字
	private boolean pan(char a){
		if(a > '0' && a < '9')
			return true;
		else
			return false;
	}
	//中缀表达式转后缀表达式
	public String change(){
		String instand = addSpace(infix);
		for(int i = 0;i < instand.length();i ++){
			String str = String.valueOf(instand.charAt(i));
			switch(str){
				case " ": break;
				case "(": stack.push(String.valueOf(str)); break;
				case "+":
				case "-": post = addMinus(str); break;
				case "*":
				case "/": post = multDivis(str);break;
				case ")": post = rightPare(str);break;
				default:
					post += str; 
			}
		}
		 while (stack.size() != 0) {
			 post += " " + stack.pop();
		}
		return post;
	}
	//出栈并操作，左括号则进栈，否者出栈放入post
	private String addMinus(String s){
		while(stack.size() != 0){
			temp = stack.pop();
			if(temp.equals("(")){
				stack.push(temp);
				break;
			}
			post += " " + temp;
		}
		stack.push(s);
		post += " " ;
		return post;
	}
	//出栈，同上
	private String multDivis(String s){
		while(stack.size() != 0){
			temp = stack.pop();
			if(temp.equals("(") || temp.equals("+") || temp.equals("-")){
				stack.push(temp);
				break;
			}
			post += " " + temp;
		}
		stack.push(s);
		post += " ";
		return post;
	}
	//出栈
	private String rightPare(String s){
		while(stack.size() != 0){
			temp = stack.pop();
			if (temp.equals("("))
				break;
			else
				post += " " + temp;
		}
		return post;
	}
}
