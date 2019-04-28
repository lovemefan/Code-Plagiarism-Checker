package counter;

//处理预处理发过来的代码类。将中缀表达式转化成后缀表达式
public class Process {
	Stack stack1 = new Stack();
	private String postCounter = "";
	private String infix;
	
	public Process(){
	
	}
	
	//构造方法
	public  Process(String infix){
		this.infix = infix;
		processCounter();
	}
	
	//将表达式转化成后缀表达式
	private void processCounter(){
		//通过空格拆分
		String[] divideCou = infix.split(" ");
		for(int i = 0; i < divideCou.length; i++){
			String div = divideCou[i];
			switch(div){
			case" ":
				break;
			case "+" :
			case "-" :
				getOperationCounter(div, 1);
				break;
			case "*":
			case "/":
				getOperationCounter(div, 2);
				break;
			case "(":
				stack1.inputStack(div);
				break;
			case ")":
				getParent();
				break;
			default :
					postCounter += " " + div;
					break;
			}
		}
		while (!stack1.isEmpty()){
			postCounter += " " + stack1.outputStack();
		}
	}
	
	//判断")"；弹栈
	private void getParent() {
		while(!stack1.isEmpty()){
			String tops = stack1.outputStack();
			if(tops.equals("(")){
				break;
			}
			else{
				postCounter += " " + tops;
			}
		}
	}

	//判断优先级
	private void getOperationCounter(String div, int priority) {
		while(!stack1.isEmpty()){
			String tops = stack1.outputStack();
			if(tops.equals("(")){
				stack1.inputStack(tops);
				break;
			}
			else{
				//判断优先级* /和+ -； 
				int priTop = getPriorityNumber(tops);
				if(priTop < priority){
					stack1.inputStack(tops);
					break;
				}
				else{
					postCounter += " " + tops;
				}
			}
		}
		stack1.inputStack(div);
	}

	//判断是"+" 或者是“-”；
	private int getPriorityNumber(String div) {
		int pri = 0;//优先级判断数字
		if(div.equals("+") || div.equals("-")){
			pri = 1;
		}
		else{
			pri = 2;
		}
		return pri;
	}
	
	//去掉后缀表达式的空格
	public String getPostConter(){
		return postCounter.trim();
	}
	
	//
}
