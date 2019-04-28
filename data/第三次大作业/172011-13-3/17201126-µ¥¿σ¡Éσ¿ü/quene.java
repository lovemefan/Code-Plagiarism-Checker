package dazuoye;

public class quene {
	 private String[] data=null;
	    private int maxSize; //��������
	    private int front = 0;  //����ͷ������ɾ��
	    private int rear = 0;   //����β���������

	    
	    public quene(){
	        this(10);
	    }
	    
	    public quene(int initialSize){
	        if(initialSize >=0){
	            this.maxSize = initialSize;
	            data = new String[initialSize];
	        }
	        else{
	            throw new RuntimeException("��ʼ����С����С��0��" + initialSize);
	        }
	    }
	    
	    public boolean empty(){
	        return rear==front?true:false;
	    }
	    

	    public void add(String e){
	        if(rear== maxSize){
	            throw new RuntimeException("�����������޷������µ�Ԫ�أ�");
	        }
	        else{
	            data[rear++]=e;
	          rear = (rear + 1) % data.length;
	        }
	    }
	    


		public String peek(){
	        if(empty()){
	            throw new RuntimeException("�ն����쳣��");
	        }else{
	            return  data[front];
	        }    
	    }
	    
	   
	    public String poll(){
	        if(empty()){
	            throw new RuntimeException("�ն����쳣��");
	        }else{
				String value = data[front];  //�������е�front�˵�Ԫ�ص�ֵ
	            data[front++] = null;     //�ͷŶ��е�front�˵�Ԫ��                
	            return value;
	        }            
	    }
	    
	    
	    public int length(){
	        return rear-front;
	    }
}
