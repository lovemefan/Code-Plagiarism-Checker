import java.util.regex.*;

public class Check {
	stack a = new stack();
	String[] str;// ԭ���ʽ
	String result = "";// ���
	Shep stack = new Shep();// ����ջģ��
	String[] output = new String[500];// �������Ϣ
	public Check(String[] str) {
		this.str = str;
	}

	public void Judge() {
		for (int i = 0; str[i] != null; i++) {
			if (EmptyString(str[i])) {
				Wrong(str[i], i, "����Ϊ�ձ��ʽ!");
				continue;
			}         
			result = str[i].replace(" ", "");
			result = result.replace("\t", "");
			result = firstchar(result);
			if (repeated(result, i)) {
				Wrong(str[i], i, "����Ϊ�ظ����ʽ!");
				continue;
			}

			if(isValid(result,i)){
				result = result.replace("(-", "(0-");//��0
				result = result.replace("(+", "(0+");
				Right(str[i],i,a.evaluateExpression(result));
			}
		}
	}

	public boolean EmptyString(String str) {
		if (str.matches("^\\s*$")) {
			return true;
		} else {
			return false;
		}
	}

	public  void Wrong(String wrongStr, int index, String wrongInformation) {
		output[index] = wrongStr + "\r\nERROR\r\n#" + wrongInformation;
	}

	public boolean repeated(String str1, int index) {
		for (int i = 0; i < index; i++) {
			if (str1.equals(str[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean isValid(String str, int index) {
		if (!isNumberOfBracketRight(str)) {// �ж��������������Ƿ�ƥ��
			Wrong(str, index, "��������������ƥ��!");
			return false;
		} 
		String errors[] = { "[^0-9\\+\\-\\/\\*\\(\\)]", "(\\(\\))", "(\\(\\*)", "(\\(\\/)",
				"[\\+\\-\\*\\/][\\+\\-\\*\\/]", "(\\+\\))", "(\\-\\))", "(\\*\\))", "(\\/\\))", "[\\d][\\(]",
				"[\\)][\\d]", "[\\+\\-\\*\\/]$", };
		String errorsName[] = { "����Ϊ�Ƿ��ַ�!", "�����ڲ���ʲô��û��!", "���ܴ���(*!", "���ܴ���(/!", "���ܴ������������!", "���ܴ���+)!", "���ܴ���-)!", "���ܴ���*)!", "���ܴ���/)!",
				"��������߲���������!", "�������ұ߲���������!", "��β����Ϊ�����!", };
		for (int i = 0; i < errors.length; i++) {
			Pattern p = Pattern.compile(errors[i]);
			Matcher m = p.matcher(str);
			if (m.find()) {
				output[index] = str + "\r\nERROR\r\n#" + errorsName[i];
				return false;
			}
		}
		return true;
	}

	// �ж��������������Ƿ�ƥ��
	public boolean isNumberOfBracketRight(String str) {
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				number++;
			} else if (str.charAt(i) == ')') {
				number--;
			}
		}
		if (number == 0) {
			return true;
		} else
			return false;
	}
	public void Right(String str,int index,double result){
		String temp = str + "="+ result; 
		output[index] = temp;
	}
	public String firstchar(String str){
		if(str.charAt(0)=='-'||str.charAt(0)=='+'){
			str = "0"+str;
		}
		return str;
	}
}