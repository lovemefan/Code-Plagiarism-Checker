package bigwork;

public class Node {
	private double data = 0;// �����׺���ʽ���������
	private int topData = 0;// ���������������˳��
	private Node next;// ָ����һ���ڵ�
	private char ch;// ת����׺���ʽ��������������

	public Node() {
		
	}

	// �����׺���ʽ���������
	public Node(double data) {
		this.data = data;
	}

	// ת����׺���ʽ��������������������˳��
	public Node(char ch, int topdata) {
		this.ch = ch;
		this.topData = topdata;
	}

	//��ȡdata
	public double getdata() {
		return data;
	}

	//��ȡtopdata
	public double gettopData() {
		return topData;
	}

	//��ȡ�ڵ�
	public Node getNext() {
		return next;
	}

	//��ȡ�ַ�
	public char getCh() {
		return ch;
	}

	//���ýڵ�
	public void setNext(Node next) {
		this.next = next;
	}
}
