
//�ڵ���
public class Node {
	private char ch;//���׺���ʽʱ�洢�����ַ�
	private String str;//�����׺���ʽʱ�洢�ַ���
	Node next;//ָ����һ���ڵ�
	
	//���췽��
	public Node() {
		
	}
	
	//���ع��췽��
	//char
	public Node(char ch) {
		this.ch = ch;
	}
	
	//���ع��췽��
	//char,Note
	public Node(char ch,Node next) {
		this.ch = ch;
		this.next = next;
	}
	
	//���ع��췽��
	//String,Note
	public Node(String str,Node next) {
		this.str = str;
		this.next = next;
	}
	
	//����ch
	public void setChar(char ch) {
		this.ch = ch;
	}
	
	//��ȡch
	public char getChar() {
		return ch;
	}
	
	//����str
	public void setStr(String str) {
		this.str = str;
	}
	
	//��ȡstr
	public String getStr() {
		return str;
	}
}
