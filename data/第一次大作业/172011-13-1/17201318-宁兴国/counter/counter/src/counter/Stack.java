package counter;

//ջ��
public class Stack{
	int top ;
	String[] array ;
	
	//���췽��
	public Stack(){
		this.array = new String[100];
		this.top = 0;
	}
	
	//��ջ
	public void inputStack( String ch ){
		array[top++] = ch;
		//�ж����ջ����û��
		if(top == array.length){
			System.out.println("���ջ�Ѿ�����");
		}	
	}
	
	// ��ջ
	public String outputStack() {
		String ch = array[--top];
		return ch;
	}
	
	//�ж�ջ�ǲ���Ϊ��
	public boolean isEmpty(){
		return top == 0;
	}
}
