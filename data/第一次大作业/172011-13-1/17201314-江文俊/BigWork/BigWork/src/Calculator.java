
public class Calculator {
	
	//���췽��
	public Calculator(){
		
	}

	// ��׺ת��׺
	// �ַ������� �洢�źϷ�����ʽ
	public String Change(String src) {
		newStack newstack = new newStack(100);
		String src2 = "";
		int m = 0;
		int n = 0;
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			switch (ch) {
			case '(':
				newstack.push(ch);
				m = 0;
				n = 1;
				break;
			case ')':
				src2 = gotParen(ch, newstack, src2);
				m = 0;
				n = 0;
				break;
			case '+':
			case '-':
				src2 = gotOper1(ch, newstack, src2, n);
				m = 0;
				break;
			case '*':
			case '/':
				src2 = gotOper2(ch, newstack, src2);
				m = 0;
				n = 0;
				break;
			default:
				n = 0;
				if (m == 0) {
					src2 += " " + ch;
					m = 1;
				} else {
					src2 += ch;
				}
				break;
			}
		}
		while (newstack.size() != 0) {
			src2 += " " + newstack.pop();
		}

		return src2;

	}

	// ��׺ת��׺������")"
	// �ַ����� ��ʱ���ж����ַ� �Զ���ջ���� ��׺���ʽ����ŵ��ַ���
	public String gotParen(char ch, newStack stack, String src) {
		Character temp;
		while (stack.size() != 0) {
			temp = stack.pop();
			if (temp == '(') {
				break;
			} else{
				src += " " + temp;
			  }
		}
		return src;
	}

	// ��׺ת��׺������"+"��"-"
	// �ַ����� ��ʱ���ж����ַ� �Զ���ջ���� ��׺���ʽ����ŵ��ַ���
	public String gotOper1(char ch, newStack stack, String src, int n) {
		if (n == 1) {// �����븺��ʱ �ڸ���ǰ�Ӹ�0 ��Ϊ(-1) ��ôת��׺ʱΪ 01-
			src = src + " 0";
			n = 0;
		}
		Character temp;
		while (stack.size() != 0) {
			temp = stack.pop();
			if (temp == '(') {
				stack.push('(');
				break;
			}
			src += " " + temp;
		} 
			stack.push(ch);
		return src;
	}

	// ��׺ת��׺������"*"��"/"
	// �ַ����� ��ʱ���ж����ַ� �Զ���ջ���� ��׺���ʽ����ŵ��ַ���
	public String gotOper2(char ch, newStack stack, String src) {
		Character temp;
		while (stack.size() != 0) {
			temp = stack.pop();
			if (temp == '(' || temp == '+' || temp == '-') {
				stack.push(temp);
				break;
			} else {
				src += " " + temp;
			}
		}
		stack.push(ch);
		return src;
	}

	// ������
	// �ַ������� ��׺���ʽ
	public String Cal(String src, int flag) {
		src = src.trim();
		src = src + " ";
		newStack stack = new newStack(100);
		char ch;
		String temp = "";
		for (int i = 0; i < src.length(); i++) {
			ch = src.charAt(i);
			if (ch == ' ') {// �ո�ָ������������ ���������ո������ж�һ��
				flag = Calculate(temp, stack, flag);
				if (flag != 0) {// ��Calculate(temp, stack,flag)����ֵ��Ϊ0ʱ
									// ˵������ /0 ����� ������ʽ���Ϸ� ����false��ֵ
					String result = "false";
					return result;
				}
				temp = "";
			} else {
				temp = temp + ch;
			}
		}
		return stack.pop2();
	}

	// ��ջ�м���
	// ���ж����ַ��� ջ
	public int Calculate(String temp, newStack stack, int flag) {
		double result = 0;
		double f1, f2;
		switch (temp) {
		case "+":// ���Ϊ"+" �򵯳�����ջ�� ����������� �ٷ���ջ��
			f2 = Double.parseDouble(stack.pop2());
			f1 = Double.parseDouble(stack.pop2());
			result = f1 + f2;
			stack.push(result);
			break;
		case "-":// ���Ϊ"-" �򵯳�����ջ�� �����ڶ��ε����ļ�ȥ��һ�ε�����
			f2 = Double.parseDouble(stack.pop2());
			f1 = Double.parseDouble(stack.pop2());
			result = f1 - f2;
			stack.push(result);
			break;
		case "*":// ���Ϊ"*" �򵯳�����ջ�� ����������� �ٷ���ջ��
			f2 = Double.parseDouble(stack.pop2());
			f1 = Double.parseDouble(stack.pop2());
			result = f1 * f2;
			stack.push(result);
			break;
		case "/":// ���Ϊ"/" �򵯳�����ջ�� �����ڶ��ε����Ĵ����Ե�һ�ε�����
			f2 = Double.parseDouble(stack.pop2());
			f1 = Double.parseDouble(stack.pop2());
			if (f2 != 0) {// �����Ƿ���� /0 ����� �����򷵻�false
				result = f1 / f2;
				stack.push(result);
			} else{
				flag = 2;
			  }
			break;
		default:// ���Ϊ���� ��ֱ��ѹ��ջ��
			stack.push(temp);
		}
		return flag;
	}

}
