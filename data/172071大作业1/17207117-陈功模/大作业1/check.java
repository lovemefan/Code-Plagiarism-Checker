package Calculator;

import java.util.Stack;

class check {
	boolean c;
	check(String s,boolean ch){
		boolean check=true;
		//���Ƿ��ַ�
		check=invalid(s,check);
		//�жϿ�����
		check=bracket(s,check);
		//���Ų�ƥ��
		check=brackets(s,check);
		//���������
		check=operat(s,check);
		this.c=check;
	}
	//�жϷǷ��ַ�
	static boolean invalid(String s,boolean check) {
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
			check=false;
		}
		return check;
	}
	
	static boolean bracket(String s,boolean check) {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				if(s.charAt(i+1)==')') {
					System.out.println("ERROR");
					System.out.println("#���ʽ���п�����");
					check=false;
				}
			}
		}
		return check;
	}
	
	static boolean brackets(String s,boolean check) {
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
        	check=false;
        }
		return check;
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
	static boolean operat(String s,boolean check) {
		for(int i=0;i<s.length()-1;i++) {
			if(operation(s.charAt(i))) {
				if(operation(s.charAt(i+1))) {
					System.out.println("ERROR");
					System.out.println("#���������");
					check=false;
				}
			}
			if(s.charAt(i)=='(') {
				if(operation(s.charAt(i+1))) {
					System.out.println("ERROR");
					System.out.println("#С���ź���������,���ŷ����һ���ַ�");
					check=false;
				}
			}
			if(s.charAt(i)==')') {
				if(Character.isDigit(s.charAt(i+1))) {
					System.out.println("ERROR");
					System.out.println("#С���ź���������,���ŷ����һ���ַ�");
					check=false;
				}
			}
		}
		if(!Character.isDigit(s.charAt(0))) {
			System.out.println("ERROR");
			System.out.println("#�����ǰ��������");
			check=false;
		}
		if(operation(s.charAt(s.length()-1))){
			System.out.println("ERROR");
			System.out.println("#���������������");
			check=false;
		}
		return check;	
	}
}