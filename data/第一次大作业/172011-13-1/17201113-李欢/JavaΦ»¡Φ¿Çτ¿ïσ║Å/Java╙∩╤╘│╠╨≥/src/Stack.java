public class Stack {

    private int Max;
    public String[] stackarray;
    private int op;

   
   public  Stack(int Max) {
        stackarray=new String[Max];
        op=-1;
    }

    public void push(String ch){
    	stackarray[++op]=ch;
    }
    public String peek(){
    	return stackarray[op];
    }
    public String pop(){
    	return stackarray[op--];
    }
    public boolean isEmpty(){
    	return op==-1;
    }
    public boolean ifFull(){
    	return op==Max-1;
    }
}