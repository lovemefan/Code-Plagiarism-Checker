//У����
public class regular {
	public regular() {
	
	}
	public static int check(String s) {
		int flag = 0;
		if(s.matches("(.*)[^\\*+-/0123456789()](.*)")){//���������Ƿ��ַ�
			flag=1;
			return flag;//System.out.println("ERROR: ���������Ƿ��ַ�");
	    }
		if (s.matches("[\\S]*[+\\-/*/][+/*/][\\S]*")) {
			flag=2;
			return flag;//System.out.println("ERROR: �����������������");
		}
		if(s.matches("[\\S]*[+\\-/*/]")){
			flag=3;
			return flag;//System.out.println("ERROR: ���ʽ��������ұ�û������");
			
		}
		if(s.matches("[\\S]*[+\\-/*/(][\\-][(][\\S]*")){
			flag=4;
			return flag;//System.out.println("ERROR: ���ʽ��(����ǷǷ��ַ�");
			
		}
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			flag=5;
			return flag;//System.out.println("ERROR: ���ʽ��)�ұ��ǷǷ��ַ�");
			
		}
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			flag=6;
			return flag;//System.out.println("ERROR: ���ʽ��(����ǷǷ��ַ�");	
		}
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			flag=7;
			return flag;//System.out.println("ERROR: ���ʽ��(�ұ��ǷǷ��ַ�");
		}
		if (s.matches("[\\S]*[+\\-/*/][)][\\S]*")) {
			flag=8;
			return flag;//System.out.println("ERROR: ���ʽ��)����ǷǷ��ַ�");
		}
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			flag=9;
			return flag;//System.out.println("ERROR: ���ʽ�д��ڿ�����");
		}
		return flag;
	}
	
}


