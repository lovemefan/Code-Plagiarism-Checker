import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class operation {

	public char[] op = { '+', '-', '*', '/', '(', ')' };
	public String[] strOp = { "+", "-", "*", "/", "(", ")" };
	//�ж��Ƿ�Ϊ����
	public boolean isDigit(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}
	//�ж��Ƿ�Ϊ�����
	public boolean isOp(char c) {
		for (int i = 0; i < op.length; i++) {
			if (op[i] == c) {
				return true;
			}
		}
		return false;
	}
	//�������أ��ж��Ƿ�Ϊ�����
	public boolean isOp(String s) {
		for (int i = 0; i < strOp.length; i++) {
			if (strOp[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	//��������ļ���ʽ
	public List<String> work(String str) {//�����ֲ�ֹΪһ������ ���ϲ�Ϊһ�����֣�����10��ԭ��Ϊ1��0�����ַ����ϲ�Ϊ10һ���ַ���
		List<String> list = new ArrayList<String>();
		char c;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (isDigit(c)) {
				sb.append(c);

			}
			if (isOp(c)) {
				if (sb.toString().length() > 0) {
					list.add(sb.toString());
					sb.delete(0, sb.toString().length());
				}
				list.add(c + "");
			}
		}
		if (sb.toString().length() > 0) {
			list.add(sb.toString());
			sb.delete(0, sb.toString().length());
		}
		return list;
	}
	//����׺���ʽת��Ϊ��׺���ʽ
	public List<String> InfixToPostfix(List<String> list1) {    //���������ȼ���ȫ����ջ  ���ȫ����ջ
		List<String> list = new ArrayList<String>();// ��ź�׺���ʽ
		Stack<String> stack = new Stack<String>();// �ݴ������
		for (int i = 0; i < list1.size(); i++) {
			String s = list1.get(i);//���ζ�ȡÿ���ַ�
			if (s.equals("(")) {  
				stack.push(s);
			} else if (s.equals("*") || s.equals("/")) {
				stack.push(s);
			} else if (s.equals("+") || s.equals("-")) {
				if (!stack.empty()) {
					while (!(stack.peek().equals("("))) {//������������������������������˳������׺���ʽ��ջ��
						list.add(stack.pop());
						if (stack.empty()) {
							break;
						}
					}
					stack.push(s);
				} else {
					stack.push(s);
				}
			} else if (s.equals(")")) {
				while (!(stack.peek().equals("("))) {
					list.add(stack.pop());
				}
				stack.pop();
			} else {
				list.add(s);
			}
			if (i == list1.size() - 1) {
				while (!stack.empty()) {
					list.add(stack.pop());
				}
			}
		}
		return list;
	}

	// ��׺���ʽ����
	public Double doCal(List<String> list) {
		Stack<Double> stack = new Stack<Double>();
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			double t = 0;
			if (!isOp(s)) {
				t = Double.parseDouble(s);//��������ֱ�ӽ������ַ�ת��Ϊ�������֣�ֱ�ӽ�ջ
				stack.push(t);
			} else {
				if (s.equals("+")) {//ÿһ������������������������Լ��¸������ٴ�����
					double a1 = stack.pop();
					double a2 = stack.pop();
				    double v = a2 + a1;
					stack.push(v);
				} else if (s.equals("-")) {
					double a1 = stack.pop();
					double a2 = stack.pop();
					double v = a2 - a1;
					stack.push(v);
				} else if (s.equals("*")) {
					double a1 = stack.pop();
					double a2 = stack.pop();
					double v = a2 * a1;
					stack.push(v);
				} else if (s.equals("/")) {
				    double a1 = stack.pop();
					double a2 = stack.pop();
					double v = a2 / a1;
					stack.push(v);
				}
			}
		}
		return stack.pop();
	}
}


