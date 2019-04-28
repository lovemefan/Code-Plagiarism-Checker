package counter;

public class CountResult {
	private String postCounter; //��¼���ʽ
	Stack stack2 = new Stack();

	// ���췽��
	public CountResult(){

	}

	//�Ա������г�ʼ��
	public CountResult(String postCounter) {
		this.postCounter = postCounter;
		OperateCounter();
	}

	// �����������ַ�������ѹ��ջ��
	private void OperateCounter() {
		String[] divideCou = postCounter.split(" ");
		for (int i = 0; i < divideCou.length; i++) {
			String flag = divideCou[i];
			if (isNumber(flag) == true) {
				stack2.inputStack(flag);
			} else {
				String result = computeCounter(flag);
				stack2.inputStack(result);
			}
		}
	}

	//�����ݽ��м���
	private String computeCounter(String flag) {
		float rest = 0;
		String res = "";
		//���ַ�����ת����float
		float b = Float.parseFloat(stack2.outputStack());
		float a = Float.parseFloat(stack2.outputStack());
		switch (flag) {
		case "+":
			rest = a + b;
			break;
		case "-":
			rest = a - b;
			break;
		case "*":
			rest = a * b;
			break;
		case "/":
			rest = a / b;
			break;
		default:
			break;
		}
		res = rest + "";
		return res;
	}

	// �ж��ַ����ǲ��Ǵ�����
	private boolean isNumber(String flag){
		boolean a = true;
		for (int i = 0; i < flag.length(); i++) {
			if (!(flag.charAt(i) >= '0' && flag.charAt(i) <= '9')) {
				a = false;
				break;
			}
		}
		return a;
	}

	// ��ý����
	public String getCounterResult() {
		return stack2.outputStack();
	}
}
