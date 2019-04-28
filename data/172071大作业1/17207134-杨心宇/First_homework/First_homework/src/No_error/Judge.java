package No_error;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.*;

/*���������Ϊ�жϱ��ʽ�Ƿ���ȷ���������ȷ�Ļ� ��Expression�Ķ������Խ����޸�
 * �޸��������޸ģ�һ��Ϊ������Ϊboolean �� IsaExp ���Խ����޸ģ������ȷ�Ļ�����ֱ�������
 * ��һ��Ϊ�Դ������ͽ����޸ģ������ȷ�Ļ���TypeOfError���䣬Ϊ��ʼֵ0���������Ļ������Ѹ����Ĵ������ͽ���������ļ��У�������������һ�����ʽ*/

class Judge {

	String expression = null;

	/* �ܵ��жϷ�������Expression��Ķ����TypeOfError�����޸� */

	/* ɾ������ı��ʽ */
	void DelSameEXP(Expression[] exp)/* ��������ظ�����ֱ�ӽ����ʽ�ַ�����Ϊnull����Ϻ���Ŀ��Խ����ж϶��� */ {
		String[] string1 = new String[50];
		String string2 = null;
		int[] index = new int[50];
		int count = 0;

		int i = 0; // ���ڼ�¼�����жϵı��ʽ���±�
		for (count = 0; count < exp.length; count++) {
			string1[count] = exp[count].expression;
			string1[count] = string1[count].substring(1);
			if (string1[count].matches("\\s+"))
				;
			else {
				string1[count] = string1[count].replaceAll(" ", "");
			}

		}
		int length = exp.length;

		for (i = 0; i < length; i++) {
			string2 = string1[i];
			for (count = i + 1; count < length; count++) {

				if (string2.equals(string1[count]) != true) {
					continue;
				} else {
					string1[count] = "";
				}
			}
		}
		for (i = 0; i < length; i++) {
			if (string1[i].equals("")) {
				exp[i].expression = "";
				exp[i].TypeOfError = 11;
				exp[i].IsaExp = false;
				System.out.println(exp[i].expression);
			}
		}

	}
	/* ��DealedStrings�����޸ĵķ������������������н��е��� */

	private void setExpression(Expression exp) {
		this.expression = exp.expression;
	}

	/* ����ո�����к� */
	private void getNumber(String string) {
		int pre = 0;
		char[] ch = string.toCharArray();
		int count = 0;// use to coungt number
		if (string.matches("\\d\\d?\\s+") == false) {
			for (count = 1; count < ch.length; count++) {
				if (ch[count] != ' ') {
					pre = count;
					break;
				}
			}
			string = string.substring(pre - 1);// �����ַ���
			this.expression = string.replaceAll(" ", "");// ɾ���ո�
		}

	}

	public void JudgeType(Expression exp) {// ������ʽ���Ϲ淶���򷵻�true�����򷵻�false

		setExpression(exp);
		if (exp.IsaExp == true) {
			getNumber(this.expression);

			if (EmptyExp(this.expression) == true) {// ��ǰ�ᣬ�ж��Ƿ�Ϊ�ձ��ʽ
				System.out.println("ERROR");
				System.out.println("#���ʽλ��");
				exp.TypeOfError = 1;
				exp.IsaExp = false;
			} else {// �����Ϊ��

				if (illegalBuffer(this.expression) == true) {// �ڶ���ǰ�ᣬ�ж��Ƿ�����Ƿ��ַ�
					System.out.println("ERROR");
					System.out.println("#���ʽ�����Ƿ��ַ�");
					exp.TypeOfError = 3;
					exp.IsaExp = false;
				} else { // �����������ж�
					if (UnmatchBrackets(this.expression) == true) {// ������Ų�ƥ��
						System.out.println("ERROR");
						System.out.println("#���ʽ������ƥ������");
						exp.TypeOfError = 4;
						exp.IsaExp = false;
					} else {
						if (EmptyBrackets(this.expression) == true) {// �п�����
							System.out.println("ERROR");
							System.out.println("#���ʽ����������");
							exp.TypeOfError = 2;
							exp.IsaExp = false;
						} else {
							if (continuellyCharacter(this.expression)) {// ���������
								// ���������
								System.out.println("ERROR");
								System.out.println("#���ʽ�������������");
								exp.TypeOfError = 5;
								exp.IsaExp = false;
							} else {
								if(NoNumberBeforeOPTR (this.expression) == true) {//��+-*/����ͷ
									System.out.println("ERROR");
									System.out.println("#�����ǰ��������");
									exp.TypeOfError = 6;
									exp.IsaExp = false;
									return ;
									
								}
								if (NoNumberAfterOPTR(this.expression) == true) {//��+-*/����β
									System.out.println("ERROR");
									System.out.println("#���������������");
									exp.TypeOfError = 7;
									exp.IsaExp = false;
									return;
								}
								if (NoNumberBeforeBracketAndBracketNottheFirst(this.expression) == true) {//9��
									System.out.println("ERROR");
									System.out.println("#���ŷǵ�һ���ַ���֮ǰ�������� ");
									exp.TypeOfError = 8;
									exp.IsaExp = false;
									return;
									
								}
								if (NonumberBeforeBracketAndBracketNottheLast(this.expression) == true) {//��9
									System.out.println("ERROR");
									System.out.println("#С���ź��������������ŷ����һ���ַ� ");
									exp.TypeOfError = 9;
									exp.IsaExp = false;


							}

						}
					}
				}
			}
		}

	}
}

	void RidSame(String[] string) {// ���ڼ�ȥ��ȡ���ַ����е���ͬ���ַ���,���յõ���Ϊһ��û���ظ����ַ���
		int p = 0;
		int q = 0;
		int r = 0;
		r = string.length + 1;
		for (p = 0, q = p + 1; q < r; q++) {
			if (string[p] != string[q]) {
				string[p + 1] = string[q];
				p++;
			} else {
				int i = string.length;
			}
		}
	}

	/* 1 */
	boolean EmptyExp(String str) {// ���Ϊ�� ����true,��Ϊ�շ���false

		String regex = "\\d\\d?\\s+";// ���ʽΪ��

		return Pattern.matches(regex, str);
	}

	/* 2 */
	boolean EmptyBrackets(String str) {// ������ڿ����ţ��򷵻�true�����򷵻�false
		String regex = ".*\\(\\).*";
		return Pattern.matches(regex, str);
	}

	/* 3�� �˴��෴ */
	boolean illegalBuffer(String str) {// ������зǷ��ַ����򷵻�true;���򷵻�false

		boolean flag = true;
		String regex = "[-*/+0-9\\(\\)\\=]+";
		if (Pattern.matches(regex, str) == true)
			flag = false;
		else {
			flag = true;
		}
		return flag;

	}

	/* 4 */
	boolean UnmatchBrackets(String s) {// ������Ų�ƥ�䣬�򷵻� true;���򷵻�false
		int len = s.length();

		LinkedList<Character> stack = new LinkedList<Character>();
		// ѭ�������ַ���
		for (int i = 0; i < len; i++) {
			// ���������������ջ
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(ch);
				// �����������
			} else if (ch == ')') {
				// ջ�գ���������û��ƥ��������ţ��򷵻�false
				if (stack.isEmpty()) {
					return true;
					// ջ���գ����ջ���Ƚ�
				} else if (stack.peek().equals(ch)) {
					return true;
				} else {
					stack.pop();
				}
			}
		}
		// ѭ��������ջ�ձ�ʾƥ�����ˣ����ձ�ʾ����������
		if (stack.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	/* 5 */
	/* ���� ��+ ����� ������������ǰ�޲����� */
	boolean continuellyCharacter(String str) {// �������������������򷵻�true;���򷵻�false

		char ch[] = str.toCharArray();
		boolean flag = false;
		int i = 0;
		int theNext = 0;
		for (i = 0; i < ch.length - 1; i++) {
			if (ch[i] == '+' || ch[i] == '-' || ch[i] == '/' || ch[i] == '*') {
				theNext = i + 1;
				if (ch[theNext] == '+' || ch[theNext] == '-' || ch[theNext] == '/' || ch[theNext] == '*') {
					flag = true;
					break;
				}
			}

			/* �ж��Ƿ���� ��+ ��� */
			if (ch[i] == '(') {
				theNext = i + 1;
				if (ch[theNext] == '+' || ch[theNext] == '/' || ch[theNext] == '-' || ch[theNext] == '*') {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/*
	 * 6 �����ǰ�������� ֻ���ǿ�ͷΪ +-/*�����,������ ��+ �����
	 */
	boolean NoNumberBeforeOPTR(String str) {//  ��-*/+)��ͷ �򷵻�true ���򷵻�false
		char ch = str.charAt(0);
		if(ch == '+'||ch == '-'||ch == '*'||ch == '/'||ch == ')') {
			return true;
		}
		else return false;
		
	}

	/* 7 */
	boolean NoNumberAfterOPTR(String string) {// ��-*/+����β �򷵻�true ���򷵻�false
		int len = string.length();
		char ch = string.charAt(len-1);
		if(ch == '+'||ch == '-'||ch == '*'||ch == '/'||ch == '(') {
			return true;
		}
		else return false;
	}

	/*
	 * 8 ��Ϊ��������ʧ
	 */
	boolean NoNumberBeforeBracketAndBracketNottheFirst(String string) {
		String regex = ".*\\d\\(.*";
		return string.matches(regex);
	}

	/* 9 */
	boolean NonumberBeforeBracketAndBracketNottheLast(String string) {// ��return true,��return false
		String regex = ".*\\)\\d.*";
		return string.matches(regex);
	}

}
