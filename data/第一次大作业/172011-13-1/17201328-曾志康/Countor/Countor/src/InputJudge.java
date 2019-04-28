import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputJudge {
	
	public InputJudge(){
		
	}
	
	//�ļ�������ж�
	public String InputJudge(String input){
		String[] strArr = new String[9];
		strArr[0] = isIllegal(input);//�Ƿ��зǷ��ַ�
		strArr[1] = equalRight(input);//�����ź����Ƿ���ȷ
		strArr[2] = equalLeft(input);//�����ź����Ƿ���ȷ
		strArr[3] = equalRighti(input);//������ǰ���Ƿ���ȷ
		strArr[4] = equalLeftb(input);//������ǰ���Ƿ���ȷ
		strArr[5] = leftRight(input);//�������������Ƿ�ƥ��
		strArr[6] = count(input);//������Ƿ�����һ��
		strArr[7] = countFront(input);//�����ǰ���Ƿ���ȷ
		strArr[8] = countBehind(input);//����������Ƿ���ȷ
		int i = 0;
		for(i = 0;i < 9;i ++){
			if(hasError(strArr[i])){
				break;
			}
		}
		return strArr[i];
	}
	
	public boolean isOk(String input){//�жϱ��ʽ�Ƿ���ȷ
		String[] strArr = new String[9];
		strArr[0] = isIllegal(input);
		strArr[1] = equalRight(input);
		strArr[2] = equalLeft(input);
		strArr[3] = equalRighti(input);
		strArr[4] = equalLeftb(input);
		strArr[5] = leftRight(input);
		strArr[6] = count(input);
		strArr[7] = countFront(input);
		strArr[8] = countBehind(input);
		int i = 0;
		int tag = 0;
		for(i = 0;i < 9;i ++){
			if(hasError(strArr[i])){
				tag = 1;
			}
		}
		if(tag == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean  hasError(String input){//���ʽ����ERROR
		Pattern p = Pattern.compile("ERROR");
		Matcher m = p.matcher(input);
		return m.find();
	}
	
	public String[] Repetition(String[] input,int s){//���ʽ�ظ�
		for(int i = 0; i < s - 1;i ++){
			for(int j = i + 1;j < s;j ++){
				if(input[i] != null){
					if(input[i].equals(input[j])){
						input[i] = input[i] + "\r\nERROR!\r\n#�ñ��ʽ���������ʽ�ظ�\r\n";
						break;
					}
				}
			}
		}
		return input;
	}
	
	public boolean isEmpty(String input){//���ʽΪ��
		Pattern p = Pattern.compile("^\\s*$");
		Matcher m = p.matcher(input);
		return m.find();
	}
	
	public String isIllegal(String input){//���ڷǷ��ַ�
		if(input.matches(".*[[^\\d]&&[^\\+]&&[^\\-]&&[^\\*]&&[^/]&&[^(]&&[^)]]+.*")){
			input += "\r\nERROR\r\n#�ñ��ʽ���Ƿ��ַ�\r\n";
		}
		return input;
	}
	
	public String equalRighti(String input){//������ǰ�治ƥ��
		if(input.matches(".*[\\(|\\+\\-\\*/]\\).*")){
			input += "\r\nERROR\r\n#�ñ��ʽ������ǰ�治ƥ��\r\n";
		}
		return input;
	}
	
	public String equalRight(String input){//�����ź��治ƥ��
		if(input.matches(".*\\)[\\(|\\d].*")){
			input += "\r\nERROR\r\n#�ñ��ʽ�����ź�ƥ��\r\n";
		}
		return input;
	}
	
	public String equalLeft(String input){//������ǰ�治ƥ��
		if(input.matches(".*[\\)|\\d]\\(.*")){
			input += "\r\nERROR\r\n#�ñ��ʽ������ǰ�治ƥ��\r\n";
		}
		return input;
	}
	
	public String equalLeftb(String input){//�����ź��治ƥ��
		if(input.matches(".*\\([\\+|\\*|/|\\)].*")){
			input += "\r\nERROR\r\n#�ñ��ʽ�����ź��治ƥ��\r\n";
		}
		return input;
	}
	
	public String leftRight(String input){//�������Ų�ƥ��
		char[] cha = input.toCharArray();
		int left = 0;
		int right = 0;
		for(int i = 0;i < cha.length;i ++){
			if(cha[i] == '('){
				left ++;
			}
			else if(cha[i] == ')'){
				right ++;
			}
		}
		if(left != right){
			input += "\r\nERROR\r\n#�ñ��ʽ�������Ų�ƥ��\r\n";
		}
		return input;
	}
	
	public String count(String input){//�����������һ��
		if(input.matches(".*[\\+|\\-|\\*|/][\\+|\\-|\\*|/].*")){
			input += "\r\nERROR\r\n#�ñ��ʽ�������������һ��\r\n";
		}
		return input;
	}
	
	public String countFront(String input){//�������ͷ
		if(input.matches("[\\+|\\*|/].*")){
			input += "\r\nERROR\r\n#�ñ��ʽ���������ͷ";
		}
		return input;
	}
	
	public String countBehind(String input){//���������β
		if(input.matches(".*[\\+|\\-|\\*|/]")){
			input += "\r\nERROR\r\n#�ñ��ʽ���������β\r\n";
		}
		return input;
	}
}
