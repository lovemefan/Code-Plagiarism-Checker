
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calculate{
	public void Calculate(){
		
	}
	
	
	 // ʵ�ּ������	
	public static float Calculate(String str) {
		float op1 = 0;// ��¼��ջ����
		float op2 = 0;// ��¼��ջ����
		float result = 0;// ��¼������
		Stack<String> stack = new Stack();// ����ջ����

		String[] arr = str.split(" ");// �Դ�����ַ���ͨ���ո���зָ����������

		for (int i = 0; i < arr.length; i++) {
			// ���ַ������жϣ����Ϊ���֣�����ջ�����Ϊ���������������㡣

			if (arr[i].matches(".*[\\d].*")) {
				stack.push(arr[i]);
			}

			else if (arr[i].matches(".*[\\+\\-\\*\\/].*")) {
				op2 = Float.parseFloat(stack.pop());
				op1 = Float.parseFloat(stack.pop());
				// �����������ѡ����ʵ�����
				if (arr[i].matches(".*[\\+].*")) {
					result = op1 + op2;
					
					stack.push(result + "");
				}

				else if (arr[i].matches(".*[\\-].*")) {
					result = op1 - op2;
					
					stack.push(result + "");
				}

				else if (arr[i].matches(".*[\\*].*")) {
					result = op1 * op2;
					
					stack.push(result + "");
				}

				else if (arr[i].matches(".*[\\/].*")) {
					result = op1 / op2;
					
					stack.push(result + "");
				}

			}
		}
		result = Float.parseFloat(stack.pop());
		return result;
	}
}