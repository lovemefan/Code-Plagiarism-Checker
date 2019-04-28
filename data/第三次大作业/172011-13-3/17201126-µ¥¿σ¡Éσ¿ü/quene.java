package dazuoye;

public class quene {
	 private String[] data=null;
	    private int maxSize; //队列容量
	    private int front = 0;  //队列头，允许删除
	    private int rear = 0;   //队列尾，允许插入

	    
	    public quene(){
	        this(10);
	    }
	    
	    public quene(int initialSize){
	        if(initialSize >=0){
	            this.maxSize = initialSize;
	            data = new String[initialSize];
	        }
	        else{
	            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
	        }
	    }
	    
	    public boolean empty(){
	        return rear==front?true:false;
	    }
	    

	    public void add(String e){
	        if(rear== maxSize){
	            throw new RuntimeException("队列已满，无法插入新的元素！");
	        }
	        else{
	            data[rear++]=e;
	          rear = (rear + 1) % data.length;
	        }
	    }
	    


		public String peek(){
	        if(empty()){
	            throw new RuntimeException("空队列异常！");
	        }else{
	            return  data[front];
	        }    
	    }
	    
	   
	    public String poll(){
	        if(empty()){
	            throw new RuntimeException("空队列异常！");
	        }else{
				String value = data[front];  //保留队列的front端的元素的值
	            data[front++] = null;     //释放队列的front端的元素                
	            return value;
	        }            
	    }
	    
	    
	    public int length(){
	        return rear-front;
	    }
}
