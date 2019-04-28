
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex {
	public String[] judgeRegex(String[] str,int l){
		String[] error = {"(\\(\\)){1}","\\((\\+|\\*|\\/)","[\\+\\-\\*\\/]\\)",
				"\\d\\(","^\\s*$","��*[\\+\\-\\*\\/\\(]$","[\\+\\-\\*\\/]{2}","^[\\+\\*\\/\\)]"};
		String[] errorMessage = {"\r\nERROR\r\n#���ֿ�����","\r\nERROR\r\n#������������",
				"\r\nERROR\r\n#��ǰ���������","\r\nERROR\r\n#��ǰ���������","\r\nERROR\r\n#�հ��ַ�",
				"\r\nERROR\r\n#�ԷǷ��ַ���β","\r\nERROR\r\n#�����������������","\r\nERROR \r\n#�ԷǷ��ַ���ͷ"};
		for(int i = 0;i<l;i++){
			System.out.println(str[i]);
			if(!str[i].contains("ERROR")){
				for(int j = 0;j<error.length;j++){
				Pattern  pattern = Pattern.compile(error[j]);
	            Matcher matcher = pattern.matcher(str[i]); 
			     if(matcher.find()) {
			         str[i]+=errorMessage[j];
			     	}
				}
				 str[i] = judgeKuohao(str[i]);//�ж����������Ƿ�ƥ��
				 str[i] = judgeFuShu(str[i]);//�Ը����Ĵ�������
			}
			else str[i] = str[i];
		}
		return str;
	}
	
	//�ж����������Ƿ�ƥ��
	public static String judgeKuohao(String s){
		int number = 0;
		for(int i =0;i<s.length();i++){
			if(s.charAt(i)=='(')
				number++;
			if(s.charAt(i)==')'){
				number--;
			}
		}
			if(number!=0)
				s+="\r\nERROR\r\n#�������Ų�ƥ��!";
			return s;
	}
	
	//�Ը������жϺʹ���
	public static String judgeFuShu(String s){
		Pattern  pattern = Pattern.compile("\\(\\-");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
        	s = s.replaceAll("\\(\\-", "\\(\\0\\-");
        }
        Pattern  pattern1 = Pattern.compile("^\\-");
        Matcher matcher1 = pattern1.matcher(s);
        if(matcher1.find()){
        	s = s.replaceAll("^\\-", "\\0\\-");
        }
        return s;
	}
	
}
