package ����ҵ;
/**
 * ��������ʽ�ж���׺���ʽ����Boolean��
 * @author ����ʯ
 *
 */
public class Examine {
	String infix;//��������ʽ��
	int i;//������±�
	String [] say = {//����ʱ���õ��ַ���
		"ERROR\r\n#���ʽΪ���ַ���",
		"ERROR\r\n#���ʽ�ж�����������",
		"ERROR\r\n#���ʽ�п�����",
		"ERROR\r\n#���ʽ��\")\"�ұ�������",
		"ERROR\r\n#���ʽ��\"(\"���������",
		"ERROR\r\n#���ʽ��\"(\"�ұ��������",
		"ERROR\r\n#���ʽ��\")\"����������",
		"ERROR\r\n#���ʽ��\")\"���ұ���\"(\" ",
		"ERROR\r\n#���ʽ���׻�ĩλΪ����� ",
		"ERROR\r\n#���ʽ���ڷǷ��ַ�",
		"ERROR\r\n#���ʽ���Ų�ƥ��"
	};
	boolean flag = true;//����
	
	public Examine(){
		
	}
	
	public Examine(String infix) {
		this.infix = infix;
	}
	void examine(String infix){
		String [] temp = new String[10];//����ʽ�����͵�������ʽ
		temp[0] = "\\s";
		temp[1] = "[\\S]*[+-/*/][+-/*/]+[\\S]*";
		temp[2] = "[\\S]*[(][)][\\S]*";
		temp[3] = "[\\S]*[)][0-9][\\S]*";
		temp[4] = "[\\S]*[0-9][(][\\S]*";
		temp[5] = "[\\S]*[(][+-/*/][\\S]*";
		temp[6] = "[\\S]*[+-/*/][)][\\S]*";
		temp[7] = "[\\S]*[)][(][\\S]*";
		temp[8] = "([+-/*/]+.[\\S]*|[\\S]*.[+-/*/]+)";
		temp[9] = "[\\S]*[a-zA-Z_=!@#$%^&~][\\S]*";
		if(infix.matches(temp[0])){//���������ж�
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽΪ���ַ���");
			i = 0;
		}else if(infix.matches(temp[1])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽ�ж�����������");
			i = 1;
		}else if(infix.matches(temp[2])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽ�п�����");
			i = 2;
		}else if(infix.matches(temp[3])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽ��\")\"�ұ������� ");
			i = 3;
		}else if(infix.matches(temp[4])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽ��\"(\"��������� ");
			i = 4;
		}else if(infix.matches(temp[5])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽ��\"(\"�ұ�������� ");
			i = 5;
		}else if(infix.matches(temp[6])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽ��\")\"���������� ");
			i = 6;
		}else if (infix.matches(temp[7])) {
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽ��\")\"���ұ���\"(\"  ");
			i = 7;
		}else if (infix.matches(temp[8])) {
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽ���׻�ĩλΪ�����");
			i = 8;
		}else if (infix.matches(temp[9])) {
			flag = false;
			System.out.println("ERROR");
			System.out.println("#���ʽ�д��ڷǷ��ַ�");
			i = 9;
		}
	}
}

