
public class MyStack {
	private int size;// ջ�Ĵ�С
	private String[] stackArray;// �洢���ݵ�����
	private int top;// ջ��ָ��
	public MyStack() {
		size = 1000;// ��ʼ��ջ�Ĵ�С
		stackArray = new String[size];
		top = -1;
	}

	public void push(String a) {// ��ջ
		  if(top == size-1){
	            throw new RuntimeException("ջ�������޷���Ԫ����ջ��");
	        }else{
	        	stackArray[++top]=a;
	           
	        }    
		
	}


	public String pop() {// ��ջ
		 if(top == -1){
	            throw new RuntimeException("ջΪ�գ�");
	        }else
	            return stackArray[top--];
	        
	        
		
	}
	

	public String peek() {// ��ѯջ��Ԫ��
		
		 if(top == -1){
	            throw new RuntimeException("ջΪ�գ�");
	        }else
	            return stackArray[top];
		 }
	


	public boolean isEmpty() {// �ж�ջ�Ƿ�Ϊ��
		return top==-1 ? true : false;

	}
	public int getTop(){
		return top;
		
	}

}
