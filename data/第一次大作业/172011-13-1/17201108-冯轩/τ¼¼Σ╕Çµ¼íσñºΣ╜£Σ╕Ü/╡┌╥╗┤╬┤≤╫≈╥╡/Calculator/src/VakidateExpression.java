import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VakidateExpression {
	
	static String[] regexStr = new String[7];
	static String regexParenthesis = "\\(|\\)";
	static String parenthesisResult = "";
	static String statusString[] = {"ERROR\n#�Ƿ��ַ�","ERROR\n#����������","ERROR:\n#'('�����������","ERROR\n#')'�ұ���������","ERROR\n#�����������ֱ������"
			,"ERROR\n#�Ƿ�����","ERROR\n#�Ƿ�'()'"};
	static {

	regexStr[0]= "^\\s*$|[\\+\\*-/\\(\\)\\d]{1,}"; // ƥ�� �Ƿ��ַ�   ����ƥ��
	regexStr[1]= "[\\+-/\\*]{2,}";// ƥ��������Ƿ�����
	regexStr[2]= "\\d\\("; // ��(�������������
	regexStr[3]= "\\)\\d"; // ��)���ұ���������
	regexStr[4]= "[-\\+/\\*]\\)|\\([-\\+/\\*]";
	regexStr[5]= "^\\s*$";
	regexStr[6]= "\\(\\)";
	}
	public static String isLegalExpression(String str){
		str = str.replaceAll("\\s+","");//�滻�ַ����еĿո�
		//System.out.println(str);
		if (!str.matches(regexStr[0])){ //ƥ��Ƿ��ַ�
			return statusString[0];
		}
		//����������ʽ
		for (int i = 1; i < regexStr.length; i ++){
			Pattern pattern = Pattern.compile(regexStr[i]);
			Matcher matcher = pattern.matcher(str);
			if(matcher.find() == true){
				return statusString[i];
			}
		}
		Pattern pattern = Pattern.compile(regexParenthesis);
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			parenthesisResult += matcher.group();
		}
		if (!isLegalParenthesis(parenthesisResult)){
			return "ERROE:#\n���Ų�ƥ�䣡";
		}
		return "legal";
	}
	
	//�ж������Ƿ�ƥ��
	private static boolean isLegalParenthesis(String parenthesisResult){
		int left = 0;
		for (int i = 0; i < parenthesisResult.length(); i ++){
			if (parenthesisResult.charAt(i) == '('){
				left ++;
			} else {
				left --;
			}
			if (left < 0){
				return false;
			}
		}
		if (left != 0){
			return false;
		}
		return true;
	}
	
	//ɾ���ظ�������
	public static String[] removeRepetition(String[] strs){
		for (int i = 0; i < strs.length; i++){
			strs[i] = strs[i].replaceAll("//s+", "");
		}
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < strs.length; i++){
			if(!list.contains(strs[i]) || strs[i].equals("")){
				list.add(strs[i]);
			}
		}	
		String[] newStrs = list.toArray(new String [1]);
		return newStrs;
	}
}
