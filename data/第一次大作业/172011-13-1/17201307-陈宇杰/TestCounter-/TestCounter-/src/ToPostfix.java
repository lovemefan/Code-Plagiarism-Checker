import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class  ToPostfix {
	int m = 0;
	public ToPostfix(){
		
	}
	public  double toPostfix(String str1) {
		String[] str = new String[1000];
		str1 = Space(str1);//ȥ���ո�
		str1 = str1.replace("(-", "(0-");
		str1 = addZero(str1);//������ſ�ͷ�����0
		String str4 = predeal(str1);// ��#����	
		str4 = str4.replace("##", "#");
		String[] str2 = str4.split("#");// �ָ���ַ�������
		str2 = change(str2);//ȥ��#
		MyStack stack = new MyStack();
		int n = str2.length;
		for (int i = 0; i < n; i++) {	
			 if (!str2[i].matches("[\\+|\\-|\\*|\\/|\\(|\\)]")) {// �ж��Ƿ�������
					str[m++] = str2[i];
			}
			// ����������
			else {
				if (injudge(stack,str2[i])){// ��������ջΪ�ջ��߸��������ջ������������ȼ��ߵ�ʱ��ֱ����ջ
					stack.push(str2[i]);
				} else if (str2[i].trim().equals(")")) {// ���������ŵ�ʱ��
					while (!stack.peek().equals("(")) {
						str[m++] = stack.pop();
					}
					stack.pop();
				} 
				else if(injudge2(stack, str2[i])){
					stack.push(str2[i]);
					
				}
					else {// ���ȼ�����ջ���������ʱ��
					while (!stack.isEmpty() && getPriority(str2[i]) <= getPriority(stack.peek())) {
						str[m++] =stack.pop();
					}
					stack.push(str2[i]);
				}
			}
		}
		while (!stack.isEmpty()) {// ��ջ��ʣ����ŷ����׺���ʽ
			str[m++] =stack.pop();
		}
		CountResult outcome = new CountResult();
		return outcome.counte(str,m);
	}
	public String Space(String s2){
		String s = "[^\\s]";
		String s1 = "";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(s2);
		while (matcher.find()){
			s1 += matcher.group();
		}
		s2 = s1;
		return s2;
	}
	public String addZero(String s){
		if(!s.equals("")){
		if(s.charAt(0) == '-')
			s = "0"+s;
		}
	 return s;
 }
	public boolean injudge(MyStack stack,String s){//�ж�ջ�Ƿ�Ϊ�ջ���ջ��Ԫ���Ƿ�Ϊ"("
		boolean f = false;
		if(stack.isEmpty()|| stack.peek().equals("(")|| s.trim().equals("("))
			f = true;
		return f;
	}
	public boolean injudge2(MyStack stack,String str2){
		boolean f = false;
		if(!stack.isEmpty() && getPriority(str2) > getPriority(stack.peek()))
			f = true;
		return f;
	}
	
	public  String[] change(String[] str){//ȥ���ַ���������ÿ���ַ�����#
		String[] s;
		for(int i = 0;i <str.length;i++){
			if(str[i]!=" ")
				str[i] = str[i].replace("#","");
			
		}				
		return str;
	}
	public  int getPriority(String a) {// �ж��ַ����ȼ�
		int priority = 0;
		switch (a) {
		case "+":
		case "-":
			priority = 2;
			break;
		case "*":
		case "/":
			priority = 3;
			break;
		}
		return priority;

	}

	public  String predeal(String s) {//�ָ��ַ�������
		String result = "";	
		for (int i = 0; i < s.length(); i++) {				
		    if(s.charAt(i) == '+' || s.charAt(i) == '-'|| s.charAt(i) == '*' || s.charAt(i) == '/')
				result += "#" + s.charAt(i) + "#";
			else if(s.charAt(i) == '(' )
			
				result += s.charAt(i)+"#";
			
			else if( s.charAt(i) == ')')
				result += "#"+s.charAt(i);
			else
				result += s.charAt(i);
		}
		return result;
	}
}
