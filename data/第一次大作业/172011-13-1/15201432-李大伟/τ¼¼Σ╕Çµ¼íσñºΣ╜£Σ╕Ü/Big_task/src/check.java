import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class check {
	public String str; 
	public check(){
		
	}
	public check(String str){
		this.str = str;
	}
	
	public int checking(){
		
		String pattern = "\\(\\-";//�����ʽ���Ƿ��С���-���ĸ�ʽ


		String th = "(0-";//Ϊ�޸ĸ�����ʽ����׼��
		String th1 = "0-";
		Pattern r = Pattern.compile(pattern);// ���� Pattern ����

	
		Matcher m = r.matcher(str);	// ���ڴ��� matcher ����
		if (m.find()) {
			System.out.println("Found value: " + m.find() );
			
			str = m.replaceAll(th);//�����С���-���滻�ɡ���0-����ʽ
			System.out.println("replace:" + str );
			return 1;
			
		} 
		
		else if(Pattern.matches(".*[\\+\\-\\*\\/]\\).*",str)){//�������������������
			return 2;
		}
		
		else if(Pattern.matches(".*\\)[^\\+\\-\\*\\/].*",str)){//�������ź����������
			return 3;
		}
		else if(Pattern.matches(".*\\(\\).*",str)){//��������������
			return 4;
		}
		else if(Pattern.matches(".*\\([\\+\\*\\/].*",str)){//�������źͳ���-�ŵ����������
			return 5;
		}
		else if(Pattern.matches(".*[\\+\\-\\*\\/\\(\\)]{2,}.*",str)){//���ظ��������������
			return 6;
		}
		else if(Pattern.matches(".*[^\\+\\-\\*\\/\\d+\\(\\)\\s].*",str)){//�г�������������ֵ��ַ�
			return 7;
		}
		else if(Pattern.matches(".*\\/0.*",str)){//�г�0����ʽ
			return 8;
		}
		else if(Pattern.matches(".*0\\d+[\\+\\-\\*\\/\\)].*",str)){//0������֮ǰ
			return 9;
		}
		else if(str.charAt(0)=='+'||str.charAt(0)=='*'||str.charAt(0)=='/'||str.charAt(0)==')'){//��ͷ��һλ�г��ˡ�-�����������������
			return 10;
		}
		else if(str.endsWith("-")||str.endsWith("+")||str.endsWith("*")||str.endsWith("/")||str.endsWith("(")){//��β���һλ�������������
			return 11;
		}
		else if(Pattern.matches("str.charAt(0)=='-'",str)){//�������������������
			System.out.println("Found value: " + m.find() );
			str = m.replaceAll(th1);//�����С���-���滻�ɡ���0-����ʽ
			System.out.println("replace:" + str );
			return 12;
		}
		else {
			System.out.println("Found value:" + m.find());
			return 0;
		}

	

	}	
		
}
	

