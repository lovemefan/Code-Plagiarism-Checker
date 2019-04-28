public class Node {
	private String data;//��¼����
	private Node next;	//��¼��һ�ڵ�ĵ�ַ

	public Node(){//�˹��콫��Ϣ��ʼ��Ϊ��
		setData("");
		next = null;
	}
	
	public Node(String data) {//�˹��촫���½ڵ����Ϣ
		setData(data);
		next = null;
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
