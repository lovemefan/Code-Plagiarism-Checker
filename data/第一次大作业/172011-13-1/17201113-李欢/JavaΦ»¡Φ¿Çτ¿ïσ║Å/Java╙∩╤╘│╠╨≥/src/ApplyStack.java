
public class ApplyStack {
	private Stack stack; // ��׺���ʽת��Ϊ��׺���ʽ����Ҫ��ջ
	private String fox; // �������׺���ʽ
	private String add = ""; // �洢�õ��ĺ�׺���ʽ

	public ApplyStack(Stack stack, String fox) {
		this.stack = stack;
		this.fox = fox;
	}

	private String processInfix(String fox) {
		String result = "";
		for (int i = 0; i < fox.length() - 1; i++) {
			char temp1 = fox.charAt(i);
			char temp2 = fox.charAt(i + 1);
			if (isDigital(temp1) && isDigital(temp2)) {
				result += temp1;
			} else {
				result += temp1 + " ";// �����ʽ�е��ַ����мӿո���
			}
		}
		result += fox.charAt(fox.length() - 1); // �����һ��Ԫ����ӽ�ȥ
		return result;
	}

	private boolean isDigital(char ch) {// �ж��ַ��Ƿ�������
		if (ch >= '0' && ch <= '9')
			return true;
		else
			return false;
	}

	

	private void getParent() {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				break;
			} else {
				add += " " + top;
			}
		}
	}

	private void getOperation(String str, int priority) {// ��������ȼ�����
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				stack.push(top);
				break;
			} else {
				int priTop = getPriority(top);
				if (priTop < priority) {
					stack.push(top);
					break;
				} else {
					add += " " + top;
				}
			}
		}
		stack.push(str);
	}

	private int getPriority(String str) {// �����ȼ���Ϊ1,2���и�ֵ
		int tx = 0;
		if (str.equals("+") || str.equals("-")) {
			tx = 1;
		} else {
			tx = 2;
		}
		return tx;
	}

	public String getPost() {
		return add.trim();

	}
	// ����׺���ʽת��Ϊ��׺���ʽ�Ĵ������
		public void process() {
			String[] strArr = processInfix(fox).split(" ");
			for (int i = 0; i < strArr.length; i++) {
				String ig = strArr[i];
				if(ig.equals("+")||ig.endsWith("-")){
					getOperation(ig, 1);
				}
				else if(ig.equals("*")||ig.endsWith("/")){
					getOperation(ig, 2);
				}
				else if(ig.equals("(")){
					stack.push(ig);
				}
				else if(ig.equals(")")){
					getParent();
				}
				else{
					add += " " + ig;
				}
			}
			// ����ȫ���������Ҫ���ջ��ʣ��ķ���
			while (!stack.isEmpty()) {
				add += " " + stack.pop();

			}
		}
}


