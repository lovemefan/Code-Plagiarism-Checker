
//���������
import java.util.*;

public class Orerate {
	private Stack<Double> numStack = new Stack<Double>();// ������ջ
	private Stack<Character> priStack = new Stack<Character>();// ������ջ

	public double caculate(String str) { // ������ʽ

		String temp;// ������ʱ��Ŷ�ȡ���ַ�
		StringBuffer tempNum = new StringBuffer();// ������ʱ��������ַ��� ������Ϊ��λ��ʱ
		StringBuffer string = new StringBuffer().append(str + '=');// ���������ַ���������=Ϊ������
		double num = 0;//������
		
		while (string.length() != 0) {
			temp = string.substring(0, 1); // ��ȡ��x��yǰ��λ��
			string.delete(0, 1);
			// �ж�temp����tempΪ������ʱ
			if (!isNum(temp)) {
				if (!"".equals(tempNum.toString())) {
					num = Double.valueOf(tempNum.toString());//����ת��
					numStack.push(num); 
					tempNum.delete(0, tempNum.length());//���tempNum
				}
				if (!compare(temp.charAt(0)) && (!priStack.isEmpty())) {//���ȼ����Ҳ�����ջ��Ϊ��ʱ
					double a = numStack.pop();// �ڶ���������
					double b = numStack.pop();// ��һ��������
					char ope = priStack.pop();//������֮��������
					double result = 0;// ������

					switch (ope) {
					case '+':
						result = b + a;
						numStack.push(result);
						break;
					case '-':
						result = b - a;
						numStack.push(result);
						break;
					case '*':
						result = b * a;
						numStack.push(result);
						break;
					case '/':
						if (a == 0) {// ��ĸΪ�� ���ش�����
							return 999999999;
						}
						result = b / a;
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
				// ��Ϊ�ǲ�����ʱ�����֣�
				tempNum = tempNum.append(temp);// ����������һλ���ӵ��Ѷ���������(��λ�����)

		}
		return numStack.pop();

	}

	private boolean isNum(String temp) {
		return temp.matches("[0-9]");
	}

	// �ȽϽ�� true�����ջ��Ԫ�����ȼ��ߣ�false�����ջ��Ԫ�����ȼ���
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
			// '('���ȼ����,����true
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
		// '+-'Ϊ��ͣ�����false
		case '+':
			return false;
		case '-':
			return false;
		}
		return true;
	}
}
