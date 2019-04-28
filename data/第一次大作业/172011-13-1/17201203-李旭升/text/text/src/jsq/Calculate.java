package jsq;
import java.util.*;
public class Calculate {
	private Stack<Character> priStack = new Stack<Character>();// ������ջ
	private Stack<Integer> numStack = new Stack<Integer>();// ������ջ

	public int caculate(String str) {
		String temp;// ������ʱ��Ŷ�ȡ���ַ�

		StringBuffer tempNum = new StringBuffer();// ������ʱ��������ַ���(��Ϊ��λ��ʱ)
		StringBuffer string = new StringBuffer().append(str);// �������棬���Ч��

		while (string.length() != 0) {
			temp = string.substring(0, 1);
			string.delete(0, 1);

			if (!isNum(temp)) {

				if (!"".equals(tempNum.toString())) {
					// �����ʽ�ĵ�һ������Ϊ����
					int num = Integer.parseInt(tempNum.toString());
					numStack.push(num);
					tempNum.delete(0, tempNum.length());
				}
				while (!compare(temp.charAt(0)) && (!priStack.empty())) {
					int a = (int) numStack.pop();
					int b = (int) numStack.pop();
					char ope = priStack.pop();
					int result = 0;// ������
					switch (ope) {
					// ����ǼӺŻ��߼��ţ���
					case '+':
						result = b + a;
						// ������������������ջ
						numStack.push(result);
						break;
					case '-':
						result = b - a;
						// ������������������ջ
						numStack.push(result);
						break;
					case '*':
						result = b * a;
						// ������������������ջ
						numStack.push(result);
						break;
					case '/':
						result = b / a;// ������������������ջ
						numStack.push(result);
						break;
					}

				}
				if (temp.charAt(0) != '=') {
					priStack.push(new Character(temp.charAt(0)));
					if (temp.charAt(0) == ')') {// ��ջ��Ϊ'('������ǰԪ��Ϊ')'ʱ�����������������꣬ȥ������
						priStack.pop();
						priStack.pop();
					}
				}
			} else
				tempNum = tempNum.append(temp);// ����������һλ���ӵ��Զ���������(�����Ǹ�λ����ʱ��)
		}
		return numStack.pop();
	}

	private boolean isNum(String temp) {
		return temp.matches("[0-9]");
	}

	private boolean compare(char str) {
		if (priStack.empty()) {
			// ��Ϊ��ʱ����Ȼ ��ǰ���ȼ���ͣ����ظ�
			return true;
		}
		char last = (char) priStack.lastElement();
		// ���ջ��Ϊ'('��Ȼ�����ȼ���ͣ�')'������Ϊջ����
		if (last == '(') {
			return true;
		}
		switch (str) {
		case '=':
			return false;// ������
		case '(':
			// '('���ȼ����,��Ȼ����true
			return true;
		case ')':
			// ')'���ȼ���ͣ�
			return false;
		case '*': {
			// '*/'���ȼ�ֻ��'+-'��
			if (last == '+' || last == '-')
				return true;
			else
				return false;
		}
		case '/': {
			if (last == '+' || last == '-')
				return true;
			else
				return false;
		}
		// '+-'Ϊ��ͣ�һֱ����false
		case '+':
			return false;
		case '-':
			return false;
		}
		return true;
	}
}
