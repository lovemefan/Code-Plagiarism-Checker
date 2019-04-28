
public class StackOfString {
	private String[] expression;
	private int size;
	private int i;
	public static final int DEFULT_CAPACITY = 20;
	
	//无参默认构造法
	public StackOfString(){
		this (DEFULT_CAPACITY);
	}
	
	public StackOfString(int capacity){
		expression = new String[capacity];
	}
	
	public void push(String count){
		if(size >= expression.length){
			String[] temp = new String[expression.length*2];
			System.arraycopy(expression, 0, temp, 0, expression.length);
			expression = temp;
		}
		expression[size++] = count;
	}
	
	public String pop(){
		return expression[i++];
	}
	
	public boolean endString(){
		return i == size;
	}
	
	public void setI(){
		this.i = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public void clearBlank(){
		int a = 0;
		while(expression[a] != null){
    	    String temp = "";
    	    int b = 0;
    	    while(b != expression[a].length()){
    	    	if(expression[a].charAt(b) != ' '){
        	    	temp = temp + expression[a].charAt(b);
    	    	}
    	    	b++;
    	    }
    	    expression[a] = temp;
    	    a++;
		}
	}

}
