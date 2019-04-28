import java.util.LinkedList;

public class Cal {

	private String infix;//��׺���ʽ
	private String postfix;//��׺���ʽ
	
	public Cal() {
		// TODO Auto-generated constructor stub
	}
	
	public Cal(String infix) {
		// TODO Auto-generated constructor stub
		this.infix = infix.replaceAll("\\s","");
	}
    public String toPostFix() {
        // ��ʽ�ַ�����
        char[] ch = infix.trim().toCharArray();
        LinkedList<OperatorsEnum> stack = new LinkedList<OperatorsEnum>();
        StringBuilder sb = new StringBuilder();
        OperatorsEnum op = null;
        for (int i = 0; i < ch.length; i++) {
            // ��ÿ����ʽ�ַ���������ǲ��ǲ�����
            if ((op = isOperator(ch[i])) == null) {
                sb.append(ch[i]);
            } else {
                // ������
                // ��������ջ��Ԫ��ֱ�����������ţ����ǲ����������
            	if(i > 0){
					if(isOperator(ch[i - 1]) == null){
						sb.append(';');
					}
				}
                if (op.equals(OperatorsEnum.RIGHT_BRACKET)) {
                    // ������������ţ��������������
                    while (!stack.peek().equals(OperatorsEnum.LEFT_BRACKET)) {
                        sb.append(stack.pop()).append(';');
                    }
                    // ��ʱջ��Ԫ��Ϊ�����ţ�ֱ�ӵ����������
                    stack.pop();
                } else {
                    // ��������
                    // 1��������������и����ȼ�����ͬ�����ȼ���ֱ�����������ȼ�����������Ϊֹ
                    // ����ĵ�������п��ܽ�ջ���գ����stack��size����NPE
                    while (stack.size() > 0 && stack.peek().prior >= op.prior
                            && !stack.peek().equals(OperatorsEnum.LEFT_BRACKET)) {
                        sb.append(stack.pop()).append(';');
                    }
                    // 2������ǰ��������ջ
                    stack.push(op);
                }
            }
        }
        // ��������ջ��ʣ�������
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
  	                        System.out.println("��������Ϊ0");
  	                        return 0;
  	                    }
  	                    double newNum1=cal(num2,num1,op);
  	                    stack.push(String.valueOf(newNum1));
  	                    newNum=newNum1;
  	                    return newNum;
  	                }
  	            }
  	            else {
  	                //������ѹ��ջ��
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
