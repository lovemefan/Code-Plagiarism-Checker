package assignment1;

//�ǹ�����ջ�ڵ�
class StackNode {

	public String symbol;//����
	public StackNode nextNode;
	
	//��ʼ���ڵ�,Ĭ��
	public StackNode() {
		this.symbol = "";
	}
	
	//��ʼ���ڵ�,����
	public StackNode(String symbol) {
		this.symbol = symbol;
	}
}
