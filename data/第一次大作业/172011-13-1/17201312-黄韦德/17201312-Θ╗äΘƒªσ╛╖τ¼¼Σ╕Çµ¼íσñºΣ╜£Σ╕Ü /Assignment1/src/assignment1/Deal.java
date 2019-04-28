package assignment1;

import java.util.regex.*;

public class Deal {
	private String[] str = {""};//ԭ���ʽ
	private String result;//���
	Stack stack;//����ջģ��
	private static int indexOfoutputArr = 0;
	static String[] outputArr = new String[1000000];//�������Ϣ
	private static String errors[] = {"[^0-9\\+\\-\\/\\*\\(\\)]", "(\\(\\))", 
			"(\\(\\*)", "(\\(\\/)", "[\\+\\-\\*\\/][\\+\\-\\*\\/]", 
			"(\\+\\))", "(\\-\\))", "(\\*\\))", "(\\/\\))", "[\\d][\\(]", "[\\)][\\d]", "[\\+\\-\\*\\/]$", "^\\*.", "^\\/."};
	private static String errorsName[] = {"���ڷǷ��ַ�", "���ʽ����", "���ʽ����", "���ʽ����", "���ʽ����", "���ʽ����", "���ʽ����", 
			"���ʽ����", "���ʽ����", "���ʽ����", "���ʽ����", "���ʽ����", "���ʽ����", "���ʽ����"};
	
	//����һ������
	public Deal(String[] str) {
		this.str = str;
		stack = new Stack();//����һ��ջ
	}
	
	//��ÿ�����ָ� ������
	public String[] divideArr() {
		for (int i = 0; str[i] != null; i++) {
			String originalWrong = str[i];
			if(isEmptyString(str[i])) {
				printWrongResults(originalWrong, "���ڿձ��ʽ");
				continue;
			}
			result = str[i] = deleteAllBlankSpace(str[i]);//ɾ��ԭ���ʽ�еĿո�
			if (isrepeated(result, i)) {
				continue;
			}
			String original = str[i];
			if (isValid(result, originalWrong)) {
				result = dealWtihExpection(result);
				if (result == "ERROR") {
					printWrongResults(originalWrong, "���ڳ���Ϊ��");//��ӡ������
					continue;
				}
				printRightResults(original, result);//��ӡ��ȷ������������뵽�ļ���
			}
			else {
				continue;
			}
		}
		return outputArr;
	}
	
	//�жϸñ��ʽ��ʽ�Ƿ���ȷ,��������ʽ
	public static boolean isValid(String str,String originalWrong) {//ʡ�Բ���
		if (!isNumberOfBracketRight(str, indexOfoutputArr)) {//�ж��������������Ƿ�ƥ��
			printWrongResults(originalWrong, "��������������ƥ��");
			return false;
		}
		for (int i = 0;i < errors.length; i++) {
			Pattern p = Pattern.compile(errors[i]);
			Matcher m = p.matcher(str);
			if (m.find()) {
				outputArr[indexOfoutputArr] = originalWrong + "\r\nERROR\r\n#" + errorsName[i];
				System.out.println(outputArr[indexOfoutputArr]);
				indexOfoutputArr++;
				return false;
			}
		}
		return true;
	}
	
	//��ӡ��ȷ��ÿ���������Ľ��,���������뵽�ļ���
	public void printRightResults(String str, String result){
		String s = "";
		if (result != "") {
			s = str + "=" + result;
		}
		else {//ֻ������
			s = str + "=" + str;
		}
		outputArr[indexOfoutputArr] = s;
		System.out.println(s);
		indexOfoutputArr++;
	}
	
	//��ӡ�����ÿ�����Ľ��
	public static void printWrongResults(String originalWrong, String wrongInformation) {
		outputArr[indexOfoutputArr] = originalWrong + "\r\nERROR\r\n#" + wrongInformation;
		System.out.println(outputArr[indexOfoutputArr]);
		indexOfoutputArr++;
	}
	
	//ɾ���ַ��������еĿո�
	public String deleteAllBlankSpace(String str) {
		String strDel;
		strDel = str.replace(" ", "");
		strDel = strDel.replace("\t", "");
		return strDel;
	}
	
	//����ɾ�����пհ׺��ԭ���ʽ
	public String DealAfterDeleteAllBlankSpace(String str) {
		String result = "";
		int i;
		for (i = 0;i < str.length() - 1; ++i) {
			if (isNumber(str.charAt(i)) && isNumber(str.charAt(i + 1)) ) {
				result += str.charAt(i);
			}
			else {
				result = result + str.charAt(i) + " ";
			}
		}
		result += str.charAt(str.length() - 1);
		return result;
	}
	
	//�ж��Ƿ�Ϊ����
	public boolean isNumber(char ch) {
        if (ch >= '0' && ch <= '9') {
        	return true;
        }
        else {
        	return false;
        } 
    }
	
	//�ж��Ƿ�Ϊ����
	public boolean isNumber(String str) {
		char[] chs = str.toCharArray();
        int number = 0;
        for(int i = 0; i < chs.length; i++){
            if(chs[i] >= '0' && chs[i] <= '9') {
            	number++;
            }
        }
        if (chs.length == number) {
        	return true;
        }
        else {
        	return false;
        }
    }
	
	//�ж��������������Ƿ�ƥ��
	public static boolean isNumberOfBracketRight(String str, int index) {
		int numberOfBracket = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				numberOfBracket++;
			}
			else if (str.charAt(i) == ')') {
				numberOfBracket--;
			}
			if (numberOfBracket < 0) {
				return false;
			}
		}
		if (numberOfBracket != 0) {
			return false;
		}
		return true;
	}
	
	//�ж����ַ��Ƿ��ǼӼ���������0
	public String starWithAddOrSub(String str) {
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			str = "0" + str;
		}
		return str;
	}
	
	//�ж��Ƿ�Ϊ���ַ���
	public boolean isEmptyString(String str) {
		if (str.matches("^\\s*$")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//�ж��Ƿ���ַ����Ƿ��ظ�
	public boolean isrepeated(String str1, int index) {
		for (int i = 0; i <  index; i++) {
			if (str1.equals(this.str[i])) {
				return true;
			}
		}
		return false;
	}
	
	//�淶�����ʽ
	public String regularyException(String str) {
		str = str.replace("(+", "(0+");//��0
		str = str.replace("(-", "(0-");//��0
		str = starWithAddOrSub(str);//�ж��Ƿ��ԼӼ��ſ�ͷ���ǵĻ���0
		return str;
	}
	
	//������ʽ
	public String dealWtihExpection(String str) {
		str = regularyException(str);//�淶�����ʽ
		str = DealAfterDeleteAllBlankSpace(str);// ����ɾ���ո��ı��ʽ
		str = stack.toSuffixExpression(str);//��ԭ���ʽ��Ϊ��׺���ʽ
		str = stack.calculateSuffixExpression(str);//�����׺���ʽ
		return str;
	}
	
}
