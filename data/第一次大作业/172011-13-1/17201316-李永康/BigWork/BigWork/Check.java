package BigWork;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Check {
	private static String[] old;//����һ��˽�����������ű��ʽ
	boolean flag = true;//�жϱ��ʽ�ĶԴ�
	String[] mistake = new String[12];
	String[] matchers = new String[14];
	//�յĹ��캯��
	Check(){
		
	}
	//���캯�������Σ�
	Check(String[] old){
		this.old = old;
	}
	//ƥ����ʽ��Ӧ�Ĵ���
	private void match(){
		mistake[0] = "[\\(][\\+|\\-|\\*|\\/]";
		matchers[0] = "�����ź�Ϊ�����";
		mistake[1] = "[\\+|\\-|\\*|\\/][\\)]";
		matchers[1] = "������ǰΪ�����";
		mistake[2] = "[\\d][\\(]";
		matchers[2] = "������ǰ���������������";//
		mistake[3] = "[\\)][\\d]";
		matchers[3] = "�����ź��������������";//
		mistake[4] = "[^\\+|\\-|\\/|\\*|\\(|\\)|\\d]";
		matchers[4] = "������쳣";
		mistake[5] = "[\\+|\\-|\\*|\\/][\\+|\\-|\\*|\\/]";
		matchers[5] = "���������";
		mistake[6] = "[\\(][\\)]";
		matchers[6] = "������Ϊ��";
		mistake[7] = "^[\\+|\\*|\\/]";
		matchers[7] = "�ַ���Ϊ�����";
		mistake[8] = "[\\+|\\*|\\/|\\-]$";
		matchers[8] = "�ַ�ĩΪ�����";
		mistake[9] = "[\\)][\\(]";
		matchers[9] = "�������ż��������";
		mistake[10] = "(\\(\\d{1,}\\))";
		matchers[10] = "�����ڲ���Ϊ����";
		mistake[11] = "[\\+|\\-|\\/|\\*|\\(][0{1,}][\\d{1,}]";
		matchers[11] = "���ֲ������㿪ͷ";
		matchers[12] = "���ַ���";
		matchers[13] = "���Ų�ƥ��";
	}
	//����Ϣ����һ���ַ�������
	public String[] checked(String[] old){
		match();
		for(int i = 0;i < old.length;i ++){
			flag = true;
			old[i] = old[i].replaceAll(" ", "");
			old[i] = old[i].replace("(-","(0-");
			//�Ը������д���
			old[i] = minus1(old[i]);
			//old[i] = minus2(old[i]);
			int number = check(old[i]);
			if(flag == false){
				old[i] = "ERROR\r\n#" + matchers[number];
			}
		}
		return old;
	}
	//�Ա��ʽ�����жϲ����
	private int check(String a){
		int num = 0;
		for( ;num < 12;num ++){
			Pattern pattern = Pattern.compile(mistake[num]);
			Matcher matcher = pattern.matcher(a);
			if(matcher.find()){
				flag = false;
				break;
			}
		}
		num = check1(a,num);
		num = check2(a,num);
		return num;
	}
	//�ж��Ƿ�Ϊ���ַ���
	private int check1(String a,int num){
		if(flag == false){
			return num;
		}
		else if(a == null){
			flag = false;
			num = 12;
		}
		return num;
	}
	//�ж������Ƿ�ƥ��
	private int check2(String a,int b){
		if(flag == false){
			return b;
		}
		else{
			int num = 0;
			for(int j = 0;j < a.length();j ++){
				if(a.charAt(j) == '('){
					num ++;
				}
				else if(a.charAt(j) == ')'){
					num --;
				}
				if(num < 0){
					flag = false;
				}
			}
			if(num != 0){
				flag = false;
				b = 13;
			}
		}
		return b;
	}
	//�Ը������д���
	private String minus1(String a){
		Pattern pattern = Pattern.compile("^[\\-]");
		Matcher matcher = pattern.matcher(a);
		StringBuilder sb = new StringBuilder(a);
		if(matcher.find()){
			 sb.insert(0,"0");
			 a = sb.toString();
		}
		return a;
	}
	//�Ը������д���
	/*private String minus2(String a){
		Pattern pattern = Pattern.compile("(.*)(\\(\\-\\d{1,}\\))(.*)");
		Matcher matcher = pattern.matcher(a);
		StringBuilder sb = new StringBuilder(a);
		if(matcher.find()){
			 MatchResult result = matcher.toMatchResult();
			 for(int i = 1;i <= result.groupCount();i ++){
				 sb.insert(result.start(i) + 1-i,"0");
			 }
			 a = sb.toString();
		}  
		return a;
	}*/
}