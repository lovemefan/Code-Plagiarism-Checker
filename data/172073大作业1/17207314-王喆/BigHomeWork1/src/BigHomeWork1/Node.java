package BigHomeWork1;
// ����ջ�Ľڵ���
public class Node {
	private String data;//��¼����
	private Node next;	//��¼��һ�ڵ�ĵ�ַ
	//�޲ι��죬����Ϊ��
	public Node(){
		data = "";
		next = null;
	}
	//�����½ڵ����Ϣ �����췽��
	public Node(String newData) {
		data = newData;
		next = null;
	}
	// ��� �ڵ������
	public String getData() {
		return data;
	}
    // ��� ��һ�ڵ�ĵ�ַ
	public Node getNext() {
		return next;
	}
    // ���ýڵ������ 
	public void setData(String newData) {
		data = newData;
	}
    // ���� ��һ�ڵ�ĵ�ַ
	public void setNext(Node newNext) {
		next = newNext;
	}

}
