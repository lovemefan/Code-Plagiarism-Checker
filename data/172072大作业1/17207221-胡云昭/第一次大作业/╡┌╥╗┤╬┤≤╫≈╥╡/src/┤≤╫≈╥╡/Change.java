package ����ҵ;

//9+(3-1)��3+10/2  
//931-3��+102/+

public class Change {

	public String lucky;// ��׺�ַ���
	public String nowlucky = "";// ��׺�ַ���
	LinkStack stack = new LinkStack();//����һ����stack��ջ

	// �������췽��
	public Change(String lucky) {
		this.lucky = lucky;
	}

	// ����ַ���
	public String proccess() {
		String b = "";
		for (int i = 0; i < lucky.length() - 1; i++) {
			char temp1 = lucky.charAt(i);
			char temp2 = lucky.charAt(i + 1);
			if (isDisgit(temp1) && isDisgit(temp2))
				b += temp1 + "";
			else
				b += temp1 + " ";

		}
		b += lucky.charAt(lucky.length() - 1);

		return b;
	}

	// �ж��Ƿ�������
	public boolean isDisgit(char temp) {
		if (temp <= '9' && temp >= '0')
			return true;
		else
			return false;
	}

	// ��׺ת��׺
	    public void transfer() {
		String[] arr = proccess().split(" ");
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i];
			switch (temp) {
			case "+":
			case "-":
				compare(temp, 1);
				break;
			case "*":
			case "/":
				compare(temp, 2);
				break;
			case "(":
				stack.push(temp);
				break;
			case ")":
				getParent();
				break;

			default:
				nowlucky += temp;
				nowlucky += " ";
				break;

			}
		}
		while (!stack.isEmpty()) {
			nowlucky += stack.pop();
			nowlucky += " ";
		}

	}

	// �Ƚ����㼶
	public void compare(String temp, int num) {
		String b = "";
		if (stack.isEmpty() || stack.getTop().equals("(")) {
			stack.push(temp);
		} else if (num == 1) {
			AllPop();
			stack.push(temp);
		} else if (num == 2) {
			if (stack.getTop().equals("+") || stack.getTop().equals("-")) {
				stack.push(temp);
			} else if (stack.getTop().equals("*") || stack.getTop().equals("/")) {
				nowlucky += stack.pop();
				nowlucky += " ";
				stack.push(temp);
			}
		}
	}

	//���Ŵ���
	public void getParent() {
		while (!stack.getTop().equals("(")) {
			nowlucky += stack.pop();
			nowlucky += " ";
		}
		String b = stack.pop();
	}

	//���Ŵ���
	public void AllPop() {
		while (!stack.isEmpty()) {
			if (stack.getTop().equals(")")) {
				break;
			}
			nowlucky += stack.pop();
			nowlucky += " ";

		}
	}

}
