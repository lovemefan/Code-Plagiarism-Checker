package BigHomeWork1;
// ջ ��
public class StackLine {
	private Node top;// ջ��
	private Node bottom;// ջ��
	
	public StackLine(){//�޲ι���
		top = new Node();
		top.setNext(bottom);
		bottom = new Node();
	}
	// ��� ջ��
	public Node getTop(){
		return top;
	}
	// ���  ͷ�ڵ������
	public String getData(){
		if (top.getNext() != null ){
		    return top.getNext().getData();
		}
		else{
			return null;
		}
	}
	// ��ջ����
	public void push(Node newNode){
		Node n = top.getNext();
		newNode.setNext(n);
		top.setNext(newNode);
	}
	// ��ջ����
	public void pop(){
		if (top.getNext() != null){
			top.setNext(top.getNext().getNext());
		}
	}
}
