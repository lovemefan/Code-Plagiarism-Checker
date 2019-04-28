import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	public String exp;// ��Ҫ��֤�ı��ʽ
	public Boolean flag = true;
	public String Error;
	
	// �޲�������
	public Check(){ 
		
	}
	
    public Check(String exp){
		this.exp = exp;
		this.flag = true;
	}

	// У����ʽ��ʽ�Ƿ����
	public void cheak() {
		String mistake[] = new String[9];
		String error[] = new String[9];
		mistake[0]="";
		error[0] = "ERROR\r\n#���ַ���";
		mistake[1] = "[\\+\\-\\*\\/][\\+\\-\\*\\/]";
		error[1] = "ERROR\r\n#���������";
		mistake[2] = "[\\(][\\)]";
		error[2] = "ERROR\r\n#������";
		mistake[3] = "[\\(][\\+\\*\\/]";// ����ƥ�����,�п���(�����Ǹ���
		error[3] = "ERROR\r\n#(���������";
		mistake[4] = "[\\+\\-\\*\\/][\\)]";
		error[4] = "ERROR\r\n#)ǰ�������";
		mistake[5] = "[0-9][\\(]";// \\)
		error[5] = "ERROR\r\n#(ǰ�治�������";
		mistake[6] = "[\\)][0-9]";// \\(
		error[6] = "ERROR\r\n#)���治�������";
		mistake[7] = "[^\\+\\-\\*\\/\\d\\(\\)]";
		error[7] = "ERROR\r\n#���ʽ�ں��Ƿ��ַ�";
		mistake[8] = "\\/0";
		error[8] = "ERROR\r\n#��������Ϊ0";
		if (exp.equals("")) {
			flag = false;
			Error = error[0];
			return;
		}
		for (int i = 1; i < mistake.length; i++) {

			Pattern p = Pattern.compile(mistake[i]);
			Matcher m = p.matcher(exp);

			if (m.find()) {
				flag = false;
				Error = error[i];
				break;
			}
		}
	}
	
	// �ж������Ƿ�ƥ��
	public void cheak1(){
		int num = 0;
		for(int i = 0;i < exp.length();i ++){
			if(exp.charAt(i) == '('){
				num ++;
			}
			if(exp.charAt(i) == ')'){
				num --;
			}
		}
		if(num != 0){
			flag = false; 
			Error = "ERROR\r\n#���Ų�ƥ��";
		}
	}
	
	// ��ȥ���ʽ�Ŀո��
	public void cancelSpace(){
		String s1 = "[^\\s]";
		String s2 = "";
		Pattern p = Pattern.compile(s1);
		Matcher m = p.matcher(exp);
		while (m.find()){
			s2 += m.group();
		}
		exp = s2;
	}
	
	// �ж�������0��ͷ
	public void cheakZero(){
		String s = "[0][0-9]";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(exp);
		if (!exp.equals("")){
			if (m.find()||(exp.charAt(0) == '0' && Character.isDigit(exp.charAt(1)))){
				Error = "ERROR\r\n#���ʽ�к�����0��ͷ������";
				flag = false;
			}
		}
		
	}
	
	// �ж���β������Ƿ�ʹ����ȷ
	public void cheakAndEnd(){
		if(exp.charAt(0) == '+' || exp.charAt(0) == '*' || exp.charAt(0) == '/'){
			Error = "ERROR\r\n#���ʽ�����ʹ�ô���";
			flag = false;
		}
		if (exp.charAt(exp.length() -1) == '+' || exp.charAt(exp.length() - 1) == '-'
				|| exp.charAt(exp.length() - 1 )== '*' || exp.charAt(exp.length() - 1) == '/'){
			Error = "ERROR\r\n#���ʽ�����ʹ�ô���";
			flag = false;
		}
	}
	
	//�ж��������
	public Boolean cheakAll(){
		cancelSpace(); // ��ȥ�ո��
		cheakZero();// �ж�������0��ͷ
		if (flag==false){
			return flag;
		}
		if (flag==false){
			return flag;
		}
		cheak();// У����ʽ��ʽ�Ƿ����
		if (flag==false){
			return flag;
		}
		cheak1();// �ж������Ƿ�ƥ��
		if (flag==false){
			return flag;
		}
	
		cheakAndEnd();// �ж���β������Ƿ�ʹ����ȷ
		return flag;
	}
	
	// ���ش�����Ϣ 
	public String errorAll(){
		cheakZero();// �ж�������0��ͷ
		if (flag==false){
			return Error;
		}
		cheak();// У����ʽ��ʽ�Ƿ����
		if (flag==false){
			return Error;
		}
		cheak1();// �ж������Ƿ�ƥ��
		if (flag==false){
			return Error;
		}
		cheakAndEnd();// �ж���β������Ƿ�ʹ����ȷ
		return Error;
	}
}
