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
		
		// �ж���0��ͷ�ı��ʽ
		public void judgeZeroInitially(){
			String s = "[0][0-9]";
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()||(str.charAt(0) == '0' && Character.isDigit(str.charAt(1)))){
				error = "ERROR\r\n#���ʽ�к�����0��ͷ������";
				isTrue = false;
			}
		}
		
		// �ж��Ƿ��������ַ�����+��-��*��/���������������⣩
		public void judgeOtherChar(){
			String s = "[^0-9\\+\\-\\*\\/\\(\\)]";
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()){
				error = "ERROR\r\n#���ʽ�к��в��Ϸ��ַ�";
				isTrue = false;
			}
		}
		
		// �ж�������Ƿ�����������������������Ƿ���ȷ
		public void judgeChar(){
			String[] s = {"[\\+\\-\\*\\/][\\+\\-\\*\\/]","[\\(][\\+\\*\\/]","[\\+\\-\\*\\/][\\)]",
					"[0-9][\\(]","[\\)][0-9]","[\\(][\\)]"};
			for (int i = 0;i < s.length;i ++){
			    Pattern pattern = Pattern.compile(s[i]);
			    Matcher matcher = pattern.matcher(str);
			    if (matcher.find()){
				    error = "ERROR\r\n#���ʽ�������������ʹ�ô���";
				    isTrue = false;
			    }
			}
		}
		
		// �жϱ��ʽ��β���������
		public void judgeStartAndEnd(){
			if (str.charAt(0) == '+'||str.charAt(0) == '*'||str.charAt(0) == '/')	
		{
				error = "ERROR\r\n#���ʽ�������ʹ�ô���";
				isTrue = false;
			}
			if (str.charAt(str.length() -1) == '+'||str.charAt(str.length() - 1) == '-'||str.charAt(str.length() - 1 )== '*'||str.charAt(str.length() - 1) == '/'){
				error = "ERROR\r\n#���ʽβ�����ʹ�ô���";
				isTrue = false;
			}
			}	
		
		// �ж������Ƿ�ƥ��
		public void judgeBracketNumber(){
			int bracketNum = 0;
			for (int i = 0;i < str.length();i ++){
				if (str.charAt(i) == '(')
					bracketNum += 1;
				if (str.charAt(i) ==')')
					bracketNum += -1;
				if (bracketNum < 0){ //�����ű��������ȳ���
					error = "ERROR\r\n#���ʽ���������ô���";
					isTrue = false;
				}
			}
			if (bracketNum != 0){ // ����������������
				 error = "ERROR\r\n#���ʽ���������ô���";
				isTrue = false;}
		}
		
		//���еĴ����������һ���һ��������������һ������ֵ
		public boolean judgeAll(){
			cancelSpace();  // ��ȥ�ո��
			judgeOtherChar(); // �ж��Ƿ��������ַ�
			judgeChar(); // �ж�����������ŵ������Ƿ����
			judgeStartAndEnd(); // �жϱ��ʽ��β���������������
			judgeBracketNumber(); // �ж����ŵ������Ƿ���ȷ
			judgeZeroInitially();//�жϱ��ʽ���ַ��Ƿ�Ϊ0
			return isTrue;
		}	
		
		//���еĴ������������һ�𣬲�����һ���ַ���ֵ
		public String error(){
			cancelSpace();  // ��ȥ�ո��
			judgeOtherChar(); // �ж��Ƿ��������ַ�
			judgeChar(); // �ж�����������ŵ������Ƿ����
			judgeStartAndEnd(); // �жϱ��ʽ��β���������������
			judgeBracketNumber(); // �ж����ŵ������Ƿ���ȷ
			judgeZeroInitially();//�жϱ��ʽ���ַ��Ƿ�Ϊ0
			return error;
		}		
}
