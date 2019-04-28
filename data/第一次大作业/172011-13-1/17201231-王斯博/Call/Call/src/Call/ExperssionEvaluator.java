package Call;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//����Ϊ�����������ﴫ������ȷ���ʽ
public class ExperssionEvaluator {
	// �÷���Ϊ����operatorȷ���Ƿ��Ƿ���Ҫ��ķ���
	private static int getOperatorIndex(String operator) {
		String[] operators = { "+", "-", "*", "/", "(", ")", "#" };// ƥ����������޶�����
		for (int i = 0; i < operators.length; i++) {
			if (operator.equalsIgnoreCase(operators[i])) {
				return i;// ���У����ط���
			}
		}
		return -1;// û�з���-1
	}

	// ����getOperatorIndex(c)�������ҽ�����ֵ�����õķ���
	private static boolean isOperator(String c) {
		int index = getOperatorIndex(c);
		if (index == -1) {
			return false;
		} else {
			return true;
		}
	}

	// �Ƚ������������ļ�������˳�򣬲��ҷ��رȽ��Ժ�����ȼ�˳��
	private static String priority(String operatorA, String operatorB) {
		String[][] priorityMatrix = { { ">", ">", "<", "<", "<", ">", ">" }, { ">", ">", "<", "<", "<", ">", ">" },
				{ ">", ">", ">", ">", "<", ">", ">" }, { ">", ">", ">", ">", "<", ">", ">" },
				{ "<", "<", "<", "<", "<", "=", "" }, { ">", ">", ">", ">", "", ">", ">" },
				{ "<", "<", "<", "<", "<", "", "=" } };
		return priorityMatrix[getOperatorIndex(operatorA)][getOperatorIndex(operatorB)];
	}

	// ����Ϊ��׺���ʽ
	public static String[] splitExpression(String experssion) {
		List<String> units = new ArrayList<String>();
		units.add("#");// Ϊ�����б���ʽ�������ڱ��ʽ����ǰ���������ʼ����#��ջ��ʼ��ʱ���ò�����ջΪ�գ������ջ��ջ��Ԫ��Ϊ���ʽ��ʼ����#,��ʾ���㼴����ʼ
		String unit = "";
		Pattern p = Pattern.compile("\\d+(\\.\\d+)*");// ������ʽ�жϣ�����Ϊ��׺ʽ
		Matcher m = p.matcher(experssion);
		int i = 0;
		while (i < experssion.length()) {
			if (isOperator(String.valueOf(experssion.charAt(i)))) {
				units.add(String.valueOf(experssion.charAt(i)));
				i++;
			} else {
				if (m.find()) {
					units.add(m.group());
					i = i + m.group().length();
				}
			}
		}
		units.add("#");// ������ʼ��
		String[] u = new String[units.size()];
		units.toArray(u);
		return u;// ���غ�׺ʽ
	}

	// �����׺���ʽ�������м����������ս��
	public static String calculate(String leftOperand, String operand, String rightOperand) {
		double left = Double.parseDouble(leftOperand);
		double right = Double.parseDouble(rightOperand);
		double result = 0;
		switch (operand) {
		case "+":
			result = left + right;
			break;
		case "-":
			result = left - right;
			break;
		case "*":
			result = left * right;
			break;
		case "/":
			result = left / right;
			break;
		}
		return String.valueOf(result);
	}

	// �����������Ӵ���
	public static double evaluate(String experssion) {
		String result = null;// ���ʽ�����Ŵ�
		StackLinlesNode<String> operatorStack = new StackLinlesNode<String>();// ���������ʽ
		StackLinlesNode<String> operandStack = new StackLinlesNode<String>();// ���������ʽ
		String[] units = splitExpression(experssion);// ����splitExpression�����������������expression��Ϊ��׼��׺ʽ
		int unitIndex = 1;
		operatorStack.push(units[0]);// ���ʽ�Ĳ�������ջ
		String u = units[unitIndex];//
		// ������ջ���������ַ��������һ���ַ�Ϊ#��˵����ȡ��ȫ���˳�ѭ��
		while ((!u.equalsIgnoreCase("#")) || !(operatorStack.getTop().equalsIgnoreCase("#"))) {
			if (isOperator(u)) {// �ж��Ƿ��ǲ�������
				String priority = priority(operatorStack.getTop(), u);// �Ƚ������ջջ��Ԫ����ö�ȡ��������Ƚ����ȼ�������ֵΪboolean
				switch (priority) {
				case "<":// ջ��������ȼ�С�ڴ�������������ȼ���ѹ�������ջ
					operatorStack.push(u);
					unitIndex++;
					break;
				case "=":// ջ��������ȼ����ڴ�������������ȼ��������ջ��һ����������ȡ�����������
					operatorStack.pop();
					unitIndex++;
					break;
				case ">":// ջ��������ȼ����ڴ�������������ȼ��������ջ��һ�����������ջ�����������������㣬���ѹ�������ջ
					String rightOperand = operandStack.getTop();// �õ�ջ��Ԫ�أ��������
					operandStack.pop();// ջ��Ԫ�س�ջ
					String leftOperand = operandStack.getTop();// �õ�ջ��Ԫ�أ��Ҳ�����
					operandStack.pop();// ջ��Ԫ�س�ջ
					String operand = operatorStack.getTop();// ��������һ��������
					operatorStack.pop();// ջ��Ԫ�س�ջ
					result = calculate(leftOperand, operand, rightOperand);// ���ü��㷽��
					operandStack.push(result);// �����м����������ս��
					break;
				}
			} else {
				operandStack.push(u);// ��������ջ
				unitIndex++;
			}
			u = units[unitIndex];
		}
		return Double.parseDouble(result);// ���ս����Ϊ���������ݷ���
	}
}