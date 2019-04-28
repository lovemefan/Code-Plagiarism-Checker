package ����ҵ;

public class Calculate {

	private LinkStack1 stack1;//��Ҫ��ջ
	private String string;//����֮ǰ���ʽ
	private int nowLucky;//������

	//�������ʽ��ջ�Ĺ��췽��
	public Calculate(String string, LinkStack1 stack1) {
		this.string = string;
		this.stack1 = stack1;
	}

	//��ջ
	public void process() {

		String[] arr = string.split(" ");
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i];

			if (temp.matches("[0-9].*"))
				stack1.push(Integer.valueOf(temp));
			else
				stack1.push(result(temp));

		}
		nowLucky = stack1.pop();

	}
    
	//����
	public int result(String temp) {
		int x = 0;
		int n1 = stack1.pop();
		int n2 = stack1.pop();
		switch (temp) {
		case "+":
			x = n2 + n1;
			break;
		case "-":
			x = n2 - n1;
			break;
		case "*":
			x = n2 * n1;
			break;
		case "/":
			x = n2 / n1;
			break;
		}
		return x;
	}
   
	//�õ����
	public int getResult() {
		return nowLucky;
	}

}
