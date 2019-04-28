import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Judge {
	private String detail = "";
	private int flag = 1;
	
	public Judge() {//�вι���
		detail = "";
		flag = 1;
	}

	private static String brackets(String str) {// �ж�������������
		int n = 0;
		int m = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				n++;
			if (str.charAt(i) == ')')
				m++;
		}
		if (n == m)
			return "bingo";
		else
			return "no";
	}

	public String detail(String str) {//�Ƚ��Ƿ���ִ�������
		String strs[] = { ".*(\\+|\\-|\\*|\\/|\\(|\\)|\\d).*", "yes",
				".*(\\+\\+|\\+-|\\+\\*|\\+/|-\\+|--|-\\*|-/|\\*\\+|\\*-|\\*\\*|\\*/|/\\+|/-|/\\*|//).*", ".*(\\(\\)).*",
				".*(/0).*", ".*(\\(\\+|\\(-|\\(\\*|\\(/).*", ".*(\\+\\)|-\\)|\\*\\)|/\\)).*",
				".*(\\d\\(|\\)\\d|\\)\\().*", "(\\+|\\-|\\*|\\/|\\)).*", ".*(\\+|-|\\*|/|\\()" };
		String details[] = { "ERROR\r\n#������ź��Ƿ��ַ�", "ERROR\r\n#�������Ų�ƥ��", "ERROR\r\n#�����������", "ERROR\r\n#������Ϊ��",
				"ERROR\r\n#����Ϊ��", "ERROR\r\n#�������ǰ������", "ERROR\r\n#������ź�������", "ERROR\r\n#��������߽ӷǷ����������ұ߽ӷǷ�",
				"ERROR\r\n#������Ż��������ڵ�һλ", "ERROR\r\n#������Ż������������һλ" };
		strs[1]=brackets(str);

		for (int i = 0; i < 10; i++) {
			if(!str.matches(strs[0])){
				this.detail = details[i];
				flag = 0;
				break;
			}else if(strs[1].matches("no")){
				this.detail = details[i];
				flag = 0;
				break;
			}
			else if(i!=0&&str.matches(strs[i])) {
				this.detail = details[i];
				flag = 0;
				break;
			}
		}
		return detail;
	}

	public int getflag() {//�����Ƿ����
		return this.flag;
	}

}
