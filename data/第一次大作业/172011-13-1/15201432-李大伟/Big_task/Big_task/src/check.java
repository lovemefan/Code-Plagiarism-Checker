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
	
	public boolean checking(){
		
		String pattern = "\\(\\-";//�����ʽ���Ƿ��С���-���ĸ�ʽ
		String th = "(0-";//Ϊ�޸ĸ�����ʽ����׼��
		
		Pattern r = Pattern.compile(pattern);// ���� Pattern ����

	
		Matcher m = r.matcher(str);	// ���ڴ��� matcher ����
		if (m.find()) {
			System.out.println("Found value: " + m.find() );
			
			str = m.replaceAll(th);//�����С���-���滻�ɡ���0-����ʽ
			System.out.println("replace:" + str );
			return true;
			
		} else {
			System.out.println("Found value:" + m.find());
			return false;
		}
		

	

	}	
		
}
	

