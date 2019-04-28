package BigWork;

public class InfixToPost {
	private Stacks<String> stack = new Stacks();//����һ��ջ
	private String infix;//��׺���ʽ
	private String post = "";//��׺���ʽ
	private String temp;//��ת����
	//���캯��
	public InfixToPost(String infix){
		this.infix = infix;
	}
	//����׺���ʽ����ո�
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
        addInfix += infix.charAt(infix.length() - 1); // �����һ��Ԫ����ӽ�ȥ
        return addInfix;
    }
	//�ж��Ƿ�Ϊ����
	private boolean pan(char a){
		if(a > '0' && a < '9')
			return true;
		else
			return false;
	}
	//��׺���ʽת��׺���ʽ
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
	//��ջ�����������������ջ�����߳�ջ����post
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
	//��ջ��ͬ��
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
	//��ջ
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
