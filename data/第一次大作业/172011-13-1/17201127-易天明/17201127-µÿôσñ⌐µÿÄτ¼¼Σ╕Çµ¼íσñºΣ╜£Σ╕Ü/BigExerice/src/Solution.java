import java.util.Stack;

public class Solution {
	// ����ջ
	private static Stack<String> stack = new Stack<String>();
	// ���ڼ�¼�����׺���ʽ
	private static StringBuffer suffixExpression = new StringBuffer();
	
	public Solution() {
		
	}

	// �ж��Ƿ�Ϊ������
	public static boolean isOperateationalCharacter(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*") || str.equals("(")
				|| str.equals(")"))
			return true;
		return false;
	}

	// ��������������ȼ�
	public static int priority(String str) {
		switch (str) {
		case "+":
			return 1;
		case "-":
			return 1;
		case "*":
			return 2;
		case "/":
			return 2;
		case "(":
			return 3;
		case ")":
			return 3;
		default:
			return 0;
		}
	}

	// ת��Ϊ��׺���ʽ
	/*
	 * ˼·: 1.������������ֱ����� 2.ջΪ��ʱ���������������ջ�� 3.���������ţ�������ջ
	 * 4.���������ţ�ִ�г�ջ������������ջ��Ԫ�������ֱ������ջ���������ţ������Ų����
	 * 5.�������������"+"��"-"��"*"��"/"ʱ�������������ȼ����ڻ���ڸ��������ջ��Ԫ�أ�Ȼ�󽫸��������ջ
	 * 6.���ս�ջ�е�Ԫ�����γ�ջ������� ��������Ĳ��裬�õ����������ת���õ��ĺ�׺���ʽ ������a+b*c+(d*e+f)g ������> a b c
	 * + d e * f + g * +
	 */
	public static StringBuffer transformToSuffixExpression(String s) {
		suffixExpression.delete(0, suffixExpression.length());
		String[] arr = s.split(" ");
		for (int i = 0; i < arr.length; i++) {
			transexpression(arr[i]);
		}
		
		// ���ջ��Ϊ�գ���ʣ�����������ε���������������С�
		while (stack.size() != 0) {
			suffixExpression.append(" " + stack.pop());
		}
		return suffixExpression;
	}

	public static void transexpression(String c) {
		switch (c) {
		// ���Կո�
        case " ":
            break;
		// ������ֱ�ӽ�ջ
		case "(":
			stack.push(c);
			break;
		// ����"+""-"����ջ������������������͵����
		case "+":
		case "-":
			encounterAdditionOrSubtraction(c);
			break;
		// ����'*''/'����ջ�����г˳�������������͵����
        case "*":
        case "/":
        	encounterMultiplicationOrDivision(c);
        	break;
        // ���������ţ�������ջ���ĵ�һ������������������ȫ�����ε���������������к��ٶ���������
        case ")":
        	encounterClosingParentheses();
        	break;
        default :
        	suffixExpression.append(c);
		}
	}

	private static void encounterClosingParentheses() {
		String temp;
		while (stack.size() != 0) {
            temp = stack.pop();
            if (temp.equals("("))
                break;
            else
            	suffixExpression.append(" " + temp);
        }
	}

	private static void encounterMultiplicationOrDivision(String c) {
		String temp;
		while (stack.size() != 0) {
            temp = stack.pop();
            if (temp.equals("(") || temp.equals("+") || temp.equals("-")) {
            	stack.push(temp);
                break;
            } else {
            	suffixExpression.append(" " + temp);
            }
        }
        stack.push(c);
        suffixExpression.append(" ");
	}

	private static void encounterAdditionOrSubtraction(String c) {
		String temp;
		while (stack.size() != 0) {
            temp = stack.pop();
            if (temp.equals("(")) {
                stack.push("(");
                break;
            }
            suffixExpression.append(" " + temp);
        }
        stack.push(c);
        suffixExpression.append(" ");
	}
}
