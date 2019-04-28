
public class LinkStack {// ��ʽջ�ࣨʵ�ֶ��еĹ��ܺ�ջ�Ĺ��ܣ�
	private Node head;//����ͷ�ڵ�
	private Node tail;//����β�ڵ�
	
	public LinkStack() {//��ʼ�������ͷ�ڵ�
		head = new Node();
		tail = getHead();
	}

	//����½ڵ���β��
	public void addNode(Node node) {
		tail.setNext(node);
		tail = node;
	}

	//��ӡ����
	public void printList() {
		//����һ�����ָ���һ���ڵ�
		Node tmp = getHead().getNext();
		
		//������������
		while (tmp != null) {
			System.out.print(tmp.getData() + " ");
			tmp = tmp.getNext();//ָ����һ���ڵ�
		}
		System.out.println("");
	}

	
	public void push(Node node) {//��ջ
		Node tmp = getHead().getNext();//���ջ��
		node.setNext(tmp);//�½ڵ�����ջ��
		getHead().setNext(node);//ͷ�ڵ������½ڵ�
	}

	public Node pop() {//��ջ
		Node tmp = getHead().getNext();//���ջ��
		if (tmp != null)//���ջ����Ϊ�����ջ
			getHead().setNext(tmp.getNext());
		tmp.setNext(null);;// �ڵ���һ��ַΪ��
		
		return tmp;// ջ��Ԫ��
	}
	
	public String top(){// ����һ��ջ��Ԫ��
		if(isEmpty()){
			return null;
		}
		
		return head.getNext().getData();
	}

	public boolean isEmpty() {//����Ϊ����true������false
		return head.getNext() == null;
	}

	public Node getHead() {// ����ͷ�ڵ�
		return head;
	}

}
