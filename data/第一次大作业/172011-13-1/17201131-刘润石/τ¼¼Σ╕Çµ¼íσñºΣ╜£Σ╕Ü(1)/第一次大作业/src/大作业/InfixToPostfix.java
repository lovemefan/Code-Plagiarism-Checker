package ����ҵ;
/**
 * ��׺���ʽת��׺���ʽ
 * @author ����ʯ
 * 
 */
import java.util.Stack;

public class InfixToPostfix {
	Insertion ins = new Insertion();
	Stack<String> stack;//ת��ʱ�õ�ջ
	String infix;//װ��׺���ʽ���ַ���
	String post = "";//װ��׺���ʽ���ַ���
	
	public InfixToPostfix() {
		
	}
    public InfixToPostfix(Stack<String> stack,String infix) {
		this.stack = stack;
		this.infix = infix;
	}
    
    
    
    int level(String str) {//��������������ȼ�����
        int lev = 0;
        if(str.equals("(")){
        	
        }else if (str.equals("+") || str.equals("-")) {
            lev = 1;
        }else {
            lev = 2;
        }
        return lev;
    }
    
    void separation(String str, int lev) {//������������ȼ�����ѹջ��ջ
        while (!stack.isEmpty()) {
            String top = stack.pop();//��ջ�����ϱߵ�������ó����Ƚ�
            int topLev = level(top);
            if(topLev == 0){//������ֱ��ѹջ
            	 stack.push(top);
                 break;
            }
            if(topLev<lev){
            	stack.push(top);//��ջ�����ϱߵ��������ѹ��ȥ
                break;
            }else{
            	post += " " + top;//��ջ�����ϱߵ���������뵽��׺���ʽ
            }
        }
        stack.push(str);//���ַ����ǿյ�ʱ����һ������������  ���ǿյ��Ƿ��뵱ǰ�����
    }
    
    void vip() {//"("�ϱߵ�����������ηŵ���׺���ʽ��
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {
                break;
            } else {
                post += " " + top;
            }
        }
    }
    void change(){//����ת��
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
            default://���������ֱ�ӷŵ���׺���ʽ���
                post += " " + str[i];
                break;
            }
    	}
    	while (!stack.isEmpty()) {
            post += " " +stack.pop();
        }
    }
    
    String getPost(){//���غ�׺���ʽ��ȥ��ʽ��ǰ�ߵĿո�
    	return post.trim();
    }
}
