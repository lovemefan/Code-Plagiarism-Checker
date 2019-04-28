package jisuanqi;

import java.util.Stack;

class calcheck {
	calcheck(String s){
		//���Ƿ��ַ�
		invalid(s);
		//�жϿ�����
		bracket(s);
		//���Ų�ƥ��
		brackets(s);
		//���������
		operat(s);
	}
	//�жϷǷ��ַ�
	void invalid(String s) {
		boolean j=true;
		for(int i=0;i<s.length()&&j;i++) {
				if(Character.isDigit(s.charAt(i))) {
					continue;
				}
				else {
					switch(s.charAt(i)) {
					case '+':
						break;
					case '-':
						break;
					case '*':
						break;
					case '/':
						break;
					case '(':
						break;
					case ')':
						break;
					default:
						j=false;
						break;
				}
			}
		}
		if(j==false) {
			System.out.println("ERROR");
			System.out.println("#���ʽ�����Ƿ��ַ�");
		}
	}
	
	void bracket(String s) {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				if(s.charAt(i+1)==')') {
					System.out.println("ERROR");
					System.out.println("#���ʽ���п�����");
				}
			}
		}
	}
	
	void brackets(String s) {
		boolean j=true;
		Stack<Character> sc = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch=='(')// ����������ţ�����ջ��
            {
                sc.push(ch);
            } 
            else if (ch==')') {// �����������
                if (sc.empty()){ // ջΪ�գ�ջͷû���ַ���������ƥ��
                    j=false;
                }
                // ջ��Ϊ�գ�ջͷ�ַ���������ƥ��
                else {
                	sc.pop();
                }
            }
        }
        if(!sc.isEmpty()||!j) {
        	System.out.println("ERROR");
        	System.out.println("#���Ų�ƥ��");
        }
	}
	//�ж��Ƿ��������
	public static boolean operation(char s) {
		char OP[]={'+','-','*','/'};
		int i=0;
		while(i<4){
			if(s!=OP[i])
				i++;
			else
				return true;
		}
		return false;
}
	//�ж�������Ƿ�������
	void operat(String s) {
		for(int i=0;i<s.length()-1;i++) {
			if(operation(s.charAt(i))) {
				if(operation(s.charAt(i+1))) {
					System.out.println("ERROR");
					System.out.println("#���������");
				}
			}
			if(s.charAt(i)=='(') {
				if(operation(s.charAt(i+1))) {
					System.out.println("ERROR");
					System.out.println("#С���ź���������,���ŷ����һ���ַ�");
				}
			}
			if(s.charAt(i)==')') {
				if(Character.isDigit(s.charAt(i+1))) {
					System.out.println("ERROR");
					System.out.println("#С���ź���������,���ŷ����һ���ַ�");
				}
			}
		}
		if(!Character.isDigit(s.charAt(0))) {
			System.out.println("ERROR");
			System.out.println("#�����ǰ��������");
		}
		if(operation(s.charAt(s.length()-1))){
			System.out.println("ERROR");
			System.out.println("#���������������");
		}	
	}
}