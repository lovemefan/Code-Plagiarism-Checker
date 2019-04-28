package tt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CheckStr {
    String str = "";//��Ҫ��֤���ַ���
    boolean isTrue = true;
    String error;

    //���ι��췽��������Ҫ��֤���ַ���
    public CheckStr(){
    }
    
	public CheckStr(String newStr){
		str = newStr;
	    }
	
	// ����ַ���
		public String getStr(){
			return str;
		}
		
		// ���isTrue��ֵ
		public boolean getIsTrue(){
			return isTrue;
		}
		

		//
		public void cancelSpace(){ 
			String s = "[^\\s]";
			String s1 = "";
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(str);
			while (matcher.find()){
				s1 += matcher.group();
			}
			str = s1;
		} 
		//�ж��Ƿ�Ϊ��
		public void panNULL(){
			String s = "  ";
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(str);
			if( matcher.find()){
				error = "ERROR\r\n#���ʽΪ��";
				isTrue = false;
			}
		}

		
		// �ж��Ƿ��������ַ�����+��-��*��/���������������⣩
		public void judgeOtherChar(){
			String s = "[^0-9\\+\\-\\*\\/\\(\\)]";
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()){
				error = "ERROR\r\n#���ʽ�����Ƿ��ַ�";
				isTrue = false;
			}
		}
		

		//�ж�������Ƿ�����
		public void judgeChar(){
			String[] s = {"[\\+\\-\\*\\/][\\+\\-\\*\\/]"};
			for (int i = 0;i < s.length;i ++){
			    Pattern pattern = Pattern.compile(s[i]);
			    Matcher matcher = pattern.matcher(str);
			    if (matcher.find()){
				    error = "ERROR\r\n#���������";
				    isTrue = false;
			    }
			}
		}
		
		
		// �жϱ��ʽ��β���������
		public void judgeStartAndEnd(){
			if (str.charAt(0) == '+'||str.charAt(0) == '*'||str.charAt(0) == '/')	
		{
				error = "ERROR\r\n#�����ǰ��������";
				isTrue = false;
			}
			if (str.charAt(str.length() -1) == '+'||str.charAt(str.length() - 1) == '-'||str.charAt(str.length() - 1 )== '*'||str.charAt(str.length() - 1) == '/'){
				error = "ERROR\r\n#���������������";
				isTrue = false;
			}
			}	
		
		// �ж������Ƿ�ƥ��  �Լ��Ƿ��п�����
		public void judgeBracketNumber(){
			int bracketNum = 0;
			for (int i = 0;i < str.length();i ++){
				if (str.charAt(i) == '(')
					bracketNum += 1;
				if (str.charAt(i) ==')')
					bracketNum += -1;
				if (bracketNum < 0){ //�����ű��������ȳ���
					error = "ERROR\r\n#���Ų�ƥ��";
					isTrue = false;
				}
			}
			if (bracketNum != 0){ // ����������������
				 error = "ERROR\r\n#���Ų�ƥ��";
				isTrue = false;}
		
					String[] s = {"[\\(][\\)]"};
			for (int i = 0;i < s.length;i ++){
			    Pattern pattern = Pattern.compile(s[i]);
			    Matcher matcher = pattern.matcher(str);
			    if (matcher.find()){
				    error = "ERROR\r\n#���ʽ���п�����";
				    isTrue = false;
			    }
			}
		
		
		}
		
		//���еĴ����������һ���һ������
		public boolean judgeAll(){
		
			judgeOtherChar(); // �ж��Ƿ��������ַ�
			judgeChar(); // �ж�������Ƿ����
			judgeStartAndEnd(); // �жϱ��ʽ��β���������������
			judgeBracketNumber(); // �ж����ŵ������Լ��Ƿ�Ϊ��
		
			panNULL();//�жϱ��ʽ�Ƿ�Ϊ��
			return isTrue;
		}	
		
		//���еĴ������������һ�𣬲�����һ���ַ���ֵ
		public String error(){
		
			judgeOtherChar(); // �ж��Ƿ��������ַ�
			judgeChar(); // �ж�������Ƿ����
			judgeStartAndEnd(); // �жϱ��ʽ��β���������������
			judgeBracketNumber(); // �ж����ŵ������Լ��Ƿ�Ϊ��
		
			panNULL();//�жϱ��ʽ�Ƿ�Ϊ��
			return error;
		}		
}