package Project;

public class Calculate {
	//���췽��
	public  Calculate(){
		
	}
	
	// ������
	public double calResult(String post) {
		Stack stack = new Stack();// ����ջ
		String culExp[] = post.split(" ");// �Ѻ�׺���ʽ�����ݷ���culExp��
		int length = culExp.length;// �ַ�������
		for (int i = 0; i < length; i++) {
			culExp[i].trim();
			if (culExp[i].equalsIgnoreCase("+") || culExp[i].equalsIgnoreCase("-") || culExp[i].equalsIgnoreCase("*")
					|| culExp[i].equalsIgnoreCase("/")) {
				double a;
				double result;
				double b;
				switch (culExp[i]) {
				case "+":
					b = Double.parseDouble(stack.pop());
					a = Double.parseDouble(stack.pop());
					result = a + b;
					stack.push(String.valueOf(result));
					break;
				case "-":
					b = Double.parseDouble(stack.pop());
					a = Double.parseDouble(stack.pop());
					result = a - b;
					stack.push(String.valueOf(result));
					break;
				case "*":
					b = Double.parseDouble(stack.pop());
					a = Double.parseDouble(stack.pop());
					result = a * b;
					stack.push(String.valueOf(result));
					break;
				case "/":
					b = Double.parseDouble(stack.pop());
					a = Double.parseDouble(stack.pop());
					result = a / b;
					stack.push(String.valueOf(result));
					break;
				}
			} else {
				stack.push(culExp[i]);
			}
		}
		return Double.parseDouble(stack.pop());
	}
	
}
