
//ջ��
public class Stack {
	private Node first = null;//ջ��
	
	//���췽��
	public Stack() {
		
	}
	
	//���ع��췽��
	//Node
	public Stack(Node first) {
		this.first = first;
	}
	
	//����ջ��
	public void setFirst(Node first) {
		this.first = first;
	}
		
	//��ȡջ��
	public Node getFirst() {
		return first;
	}
}
