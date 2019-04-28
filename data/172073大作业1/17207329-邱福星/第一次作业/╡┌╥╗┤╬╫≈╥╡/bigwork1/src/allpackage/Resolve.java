package allpackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resolve {
	/*
	 * һ������������ָ��
	 * �Զ����˿ո�
	 *�ܺ�����ͬ������
	*/
	String[] ex = {
			".*\\(\\).*",					//�п�����
			".*[^\\d+-/*\\(\\)].*",			//���ʽ�����Ƿ��ַ�"
			".*[+-/*][+-/*].*",				//���������
			"^[+-/*].*|.*\\([+-/*].*",		//�����ǰ��������
			".*[+-/*]$|.*[+-/*]\\).*",		//���������������
			".*\\d\\(.*",					//���ŷǵ�һ���ַ���֮ǰ��������
			".*\\)\\d.*"					//С���ź��������������ŷ����һ���ַ�
											//���Ų�ƥ��
											//���ʽΪ�� 
	};
	int isLegal(String a) {
		int anum = 0,bnum = 0;
		for(int i = 0;i < a.length();i++) {
			if(a.charAt(i) == '(')
				anum++;
			if(a.charAt(i) == ')')
				bnum++;
		}
		if(anum != bnum)
			return 8;
		for(int i= 0;i < 7;i++) {
			Pattern pattern = Pattern.compile(ex[i]);
			Matcher matcher = pattern.matcher(a);
			if (matcher.find()) {;
				return i+1;
			}
		}
		return 0;
	}
}
