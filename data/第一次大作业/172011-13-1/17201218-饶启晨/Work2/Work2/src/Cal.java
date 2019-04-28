import java.util.LinkedList;

public class Cal {

	private String infix;//中缀表达式
	private String postfix;//后缀表达式
	
	public Cal() {
		// TODO Auto-generated constructor stub
	}
	
	public Cal(String infix) {
		// TODO Auto-generated constructor stub
		this.infix = infix.replaceAll("\\s","");
	}
    public String toPostFix() {
        // 算式字符数组
        char[] ch = infix.trim().toCharArray();
        LinkedList<OperatorsEnum> stack = new LinkedList<OperatorsEnum>();
        StringBuilder sb = new StringBuilder();
        OperatorsEnum op = null;
        for (int i = 0; i < ch.length; i++) {
            // 对每个算式字符，检查它是不是操作符
            if ((op = isOperator(ch[i])) == null) {
                sb.append(ch[i]);
            } else {
                // 右括号
                // 持续弹出栈顶元素直到遇到左括号，但是不输出左括号
            	if(i > 0){
					if(isOperator(ch[i - 1]) == null){
						sb.append(';');
					}
				}
                if (op.equals(OperatorsEnum.RIGHT_BRACKET)) {
                    // 如果不是左括号，持续弹出并输出
                    while (!stack.peek().equals(OperatorsEnum.LEFT_BRACKET)) {
                        sb.append(stack.pop()).append(';');
                    }
                    // 此时栈顶元素为左括号，直接弹出，不输出
                    stack.pop();
                } else {
                    // 非右括号
                    // 1、弹出并输出所有高优先级或者同等优先级，直到遇到低优先级或者左括号为止
                    // 上面的弹出语句有可能将栈弹空，检查stack的size避免NPE
                    while (stack.size() > 0 && stack.peek().prior >= op.prior
                            && !stack.peek().equals(OperatorsEnum.LEFT_BRACKET)) {
                        sb.append(stack.pop()).append(';');
                    }
                    // 2、将当前操作符入栈
                    stack.push(op);
                }
            }
        }
        // 弹出所有栈中剩余操作符
        if(isOperator(ch[ch.length - 1]) == null){
			sb.append(';');
		}  
		while(stack.size() > 0){
			sb.append(stack.pop()).append(';');
		}
		this.postfix = sb.toString();
		return sb.toString();

    }

    public double calc() {
    	double newNum;
            LinkedList<String> stack = new LinkedList<>();
            OperatorsEnum op = null;
            String[] postStr=this.postfix.toString().split(";");
            for (String s:postStr) {
  	    	  char[] c = s.toCharArray();
  	            if ((op = isOperator(c[0])) != null){
  	                if (!stack.isEmpty()){
  	                    double num1=Double.valueOf(stack.pop());
  	                    double num2=Double.valueOf(stack.pop());
  	                    if (s.equals("/")&&num1==0){
  	                        System.out.println("除数不能为0");
  	                        return 0;
  	                    }
  	                    double newNum1=cal(num2,num1,op);
  	                    stack.push(String.valueOf(newNum1));
  	                    newNum=newNum1;
  	                    return newNum;
  	                }
  	            }
  	            else {
  	                //数字则压入栈中
  	                stack.push(s);
  	            }
  	        }
           if (!stack.isEmpty()){
	            System.out.println("result: "+stack.pop());
	        }
			return 0;
        }
    public double cal(double Num1,double Num2,OperatorsEnum operatorsEnum){
		switch(operatorsEnum){
		case PLUS:
			return Num1 + Num2;
		case MINUS:
			return Num1 - Num2;
		case MULTIPLY:
			return Num1 * Num2;
		case DIVIDE:
			return Num1 / Num2;
		case MODULAR:
			return Num1 % Num2;
		default:
			break;
		}
		return 0;
	}
    private OperatorsEnum isOperator(char ch) {
        for (OperatorsEnum op : OperatorsEnum.values()) {
            if (ch == op.operator) {
                return op;
            }
        }
        return null;
    }
}
