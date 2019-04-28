
//����У����
public class Regex {
	private String infix;//��׺���ʽ
	private String error = "ERROR\r\n#";
	
	//���췽��
	public Regex() {
		
	}
	
	//���ع��췽��
	//infix ��׺���ʽ
	public Regex(String infix) {
		this.infix = infix;
	}
	
	//����infix
	public void setInfix(String infix) {
		this.infix = infix;
	}
	
	//��ȡinfix
	public String getInfix() {
		return infix;
	}
	
	//��ȡerror
	public String getError() {
		return error;
	}
	
	//�ж�infix�Ƿ��ǺϷ�����׺���ʽ
	public boolean isCorrect() {
		if (error.equals("ERROR\r\n#")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//���鷽��
	public void check() {
		//�����ʽ�еĿո�����
		infix = infix.replaceAll(" ", "");
		//����У��
		check1();
		check2();
		check3();
		check4();
		check5();
		check6();
		check7();
		check8();
		check9();
		check10();
		check11();
		check12();
		check13();
	}
	
	//������ַ���
	public void check1() {
		if (infix.equals("")) {
			error += "���ַ���" + " ";
		}
	}
	
	//�������������
	public void check2() {
		if (infix.matches(".*[\\+\\-\\*/][\\+\\-\\*/].*")) {
			error += "���������" + " ";
		}
	}
	
	//���������
	public void check3() {
		if (infix.matches(".*\\(\\).*")) {
			error += "������" + " ";
		}
	}
	
	//�������Ų����
	public void check4() {
		int temp1 = 0;//��¼(������
		int temp2 = 0;//��¼)������
		//�����ַ���
		for (int i = 0;i < infix.length();i ++) {
			if (infix.charAt(i) == '(') {
				temp1 ++;
			}
			if (infix.charAt(i) == ')') {
				temp2 ++;
			}
		}
		//�ַ�����(��β������)��ͷ
		if (infix.matches("\\).*") || infix.matches(".*\\(")) {
			error += "���Ų����" + " ";
		}
		else if (temp1 != temp2) {
			error += "���Ų����" + " ";
		}
	}
	
	//����(���������
	public void check5() {
		if (infix.matches(".*\\([\\+\\*/].*")) {
			error += "(���������" + " ";
		}
		else if (infix.matches(".*(\\(\\-)+[\\+\\*\\-/].*")) {
			error += "(���������" + " ";
		}
	}
	
	//����)ǰ���������
	public void check6() {
		if (infix.matches(".*[\\+\\-\\*/]\\).*")) {
			error += ")ǰ���������" + " ";
		}
	}
	
	//����(ǰ�治�������
	public void check7() {
		if (infix.matches(".*[^\\(\\+\\-\\*/]\\(.*")) {
			error += "(ǰ�治�������" + " ";
		}
	}
	
	//����)���治�������
	public void check8() {
		if (infix.matches(".*\\)[^\\)\\+\\-\\*/].*")) {
			error += ")���治�������" + " ";
		}
	}
	
	//������ʽ�ں��Ƿ��ַ�
	public void check9() {
		if (infix.matches(".*[^\\+\\-\\*/\\(\\)\\d].*")) {
			error += "���ʽ�ں��Ƿ��ַ�" + " ";
		}
	}
	
	//����������0��ͷ
	public void check10() {
		if (infix.matches(".*[\\+\\-\\*/\\(\\)]0[\\d]+.*") || infix.matches("0[\\d]+.*")) {
			error += "������0��ͷ" + " ";
		}
	}
	
	//�������������ͷ
	public void check11() {
		if (infix.matches("[\\+\\*/].*") || infix.matches("\\-[\\)\\+\\-\\*/].*")) {
			error += "���������ͷ" + " ";
		}
	}
	
	//�������������β
	public void check12() {
		if (infix.matches(".*[\\+\\*\\-/]")) {
			error += "���������β" + " ";
		}
	}
	
	//�򵥵��жϳ���Ϊ0
	public void check13() {
		if (infix.matches(".*/0") || infix.matches(".*/\\(0\\)")) {
			error += "����Ϊ0" + " ";
		}
	}

}
