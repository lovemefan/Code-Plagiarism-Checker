package ooExperiment2;

import java.util.Stack;

//��׺ת��׺����
public class InfixToPost {
	
	private Stack<String> stack; //��׺���ʽת��Ϊ��׺���ʽ��Ҫ��ջ
	
	private String post ; //�洢�õ��ĺ�׺���ʽ
	
	public InfixToPost(){
		
	}
 
	//��ʼ��������
	public InfixToPost( Stack<String> stack,String post) {
		this.stack=stack;
	
		this.post = post;
	}
	
	//����׺���ʽת��Ϊ��׺���ʽ�Ĺ���
	public void  process(String express) {
		  
		String[] strArr = express.split(" ");//�ָ��ַ����������ո��ָ�һ�Σ��ָ�������ַ����浽String������
		for (int i = 0; i < strArr.length; i++){
			switch (strArr[i]){
			case "+":
			case "-":
				getOperation(strArr[i], 1);
				break;
			case "*":
			case "/":
				getOperation(strArr[i], 2);
				break;
			case "(":
				stack.push(strArr[i]);
				break;
			case ")":
				getParent();
				break;
			default:
				
				post +=  " "+strArr[i];     //���������ַ��������
				break;	
			}
		}
		
		//����ȫ���������Ҫ���ջ��ʣ�����
		while (!stack.isEmpty()) {
			
			post +=  " "+ stack.pop();
		}
	}
	
	public void getOperation(String str, int priorit ){
		while (!stack.isEmpty()){
			String top =stack.pop();
			if(top.equals("(")){
				stack.push(top);
				break;
			}else {
				int priTop = getPriority(top);
				if (priTop < priorit) {
					stack.push(top);
					break;
				}else {
					post += " "+ top;
				}
			}
		}
		stack.push(str);
	}
	public int getPriority(String str) {
		int pri = 0;
		if (str.equals("+") || str.equals("-")){
			pri = 1;
		} else {
			pri = 2;
		}
		return pri;
	}
	public void getParent() {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")){
				break;
			} else {
				post += " "+ top;
			}
		}
	}

	public String getpost() {
		return post;
	}
	
}
