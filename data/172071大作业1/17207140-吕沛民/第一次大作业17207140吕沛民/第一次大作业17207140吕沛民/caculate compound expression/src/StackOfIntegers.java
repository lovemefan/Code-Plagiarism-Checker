
public class StackOfIntegers 
{
		int top ;
		String[] array ;
		
		//���췽��
		public StackOfIntegers(){
			this.array = new String[100];
			this.top = 0;
		}
		
		//��ջ
		public void push( String ch ){
			array[top++] = ch;
			//�ж����ջ����û��
			if(top == array.length){
				System.out.println("���ջ�Ѿ�����");
			}	
		}
		
		// ��ջ
		public String pop() {
			String ch = array[--top];
			return ch;
		}
		
		//�ж�ջ�ǲ���Ϊ��
		public boolean isEmpty(){
			return top == 0;
		}
}
