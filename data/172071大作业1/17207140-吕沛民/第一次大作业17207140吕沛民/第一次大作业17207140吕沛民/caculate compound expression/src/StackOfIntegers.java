
public class StackOfIntegers 
{
		int top ;
		String[] array ;
		
		//构造方法
		public StackOfIntegers(){
			this.array = new String[100];
			this.top = 0;
		}
		
		//进栈
		public void push( String ch ){
			array[top++] = ch;
			//判断这个栈满了没；
			if(top == array.length){
				System.out.println("这个栈已经满了");
			}	
		}
		
		// 出栈
		public String pop() {
			String ch = array[--top];
			return ch;
		}
		
		//判断栈是不是为空
		public boolean isEmpty(){
			return top == 0;
		}
}
