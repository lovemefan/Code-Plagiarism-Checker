package Call;

public class StackLinlesNode<O> {
	private String data;// ջ�ڵ������ŵ�����
	private StackLinlesNode<String> next;// ջ����ĵ�ַ
	private StackLinlesNode<String> top;// ջ��
	private int size;// ջ�Ĵ�С

	// ��ǰջ�Ĵ�С
	public int length() {
		return size;
	}

	// �ж�ջ�Ƿ�Ϊ��
	public boolean empty() {
		return size == 0;
	}

	// ����ڵ�
	public String getData() {
		return this.data;
	}

	// �����ڵ�
	public void setData(String data) {
		this.data = data;
		size = 1;
	}

	// ���췽��
	public StackLinlesNode() {
		top = null;
	}

	// ���췽��
	public StackLinlesNode(String data, StackLinlesNode<String> next) {
		this.data = data;
		this.next = next;
	}

	// ��ջ
	public boolean push(String e) {
		top = new StackLinlesNode<String>(e, top);
		size = size + 1;
		return true;
	}

	// ջ��Ԫ�س�ջ
	public boolean pop() {
		if (top.next == null) {
			return false;
		}
		StackLinlesNode<String> p = new StackLinlesNode<String>();
		p = top;
		top = top.next;
		p.next = null;
		size = size - 1;
		return true;
	}

	// ȡջ��Ԫ��
	public String getTop() {
		if (top == null) {
			return null;
		}
		return top.getData();
	}
}