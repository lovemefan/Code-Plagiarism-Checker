package work;

import java.util.Stack;

public class Calculatortest {
public static int test(String[] s,int i) {	//�ж������Ƿ���ͬ
		
		for(int j=i-1;j>=0;j--) {
				
			if(s[j].equals(s[i]))
				return 1;				
		}
		
		return 0;
	}
	
	public static int test1(String s){
		String regex1=".*[\\\\(][\\\\)].*";//������ƥ��
		//String regex2=".*[\\\\D&&[^+&&[^-&&[^*&&[^/&&[^(&&[^)]]]]]]].*";//�Ƿ��ַ�
		String regex3=".*[+[-[*[/]]]]{2}.*";//������ظ�
		String regex4=".*[\\\\D&&[^)]][+[-[*[/]]]].*|[+[-[*[/]]]].*";//�����ǰû������
		String regex5=".*[+[-[*[/]]]][\\\\D&&[^(]].*|.*[+[-[*[/]]]]";//�������û������
		String regex6=".*[^+&&[^-&&[^*&&[^/&&[^(]]]]][(].*";//����ǰû��������
		String regex7=".*[)][^+&&[^-&&[^*&&[^/&&[^)]]]]].*";//���ź�û��������
		//String regex8 = "\\))*\\((";
		
		if(s.matches("")) {//���ʽΪ��
			return 1;
		}else if(s.matches(regex1)) {//���ʽ���п�����
			return 2;
		}/*else if(s.matches(regex2)) {//�Ƿ��ַ�
			return 3;
		}*/
		else if(s.matches(regex3)) {//������ظ�
			return 4;
		}
		else if(s.matches(regex4)) {//�����ǰû������
			return 5;
		}
		else if(s.matches(regex5)) {//�������û������
			return 6;
		}
		else if(s.matches(regex6)) {//����ǰû��������
			return 7;
		}
		else if(s.matches(regex7)) {//���ź�û��������
			return 8;
		}
		return 0;
	}

	

	
public static int test2(String s) {	//���Ų�ƥ��
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			
			char c = s.charAt(i);
			if(c == '('){
				stack.push('(');
			}
			else if(c == ')'){
				
				if(!stack.isEmpty())
					stack.pop();
				else
					return 1;
			}
		}
		if(!stack.isEmpty())
			return 1;
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int test3(String s) {
		// TODO Auto-generated method stub

		if(s.matches(".*[\\D&&[^+&&[^-&&[^*&&[^/&&[^(&&[^)]]]]]]].*"))
			return 1;
		
		return 0;
		
	}

}
