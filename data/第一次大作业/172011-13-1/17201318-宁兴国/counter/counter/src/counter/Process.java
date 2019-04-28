package counter;

//����Ԥ���������Ĵ����ࡣ����׺���ʽת���ɺ�׺���ʽ
public class Process {
	Stack stack1 = new Stack();
	private String postCounter = "";
	private String infix;
	
	public Process(){
	
	}
	
	//���췽��
	public  Process(String infix){
		this.infix = infix;
		processCounter();
	}
	
	//�����ʽת���ɺ�׺���ʽ
	private void processCounter(){
		//ͨ���ո���
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
	
	//�ж�")"����ջ
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

	//�ж����ȼ�
	private void getOperationCounter(String div, int priority) {
		while(!stack1.isEmpty()){
			String tops = stack1.outputStack();
			if(tops.equals("(")){
				stack1.inputStack(tops);
				break;
			}
			else{
				//�ж����ȼ�* /��+ -�� 
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

	//�ж���"+" �����ǡ�-����
	private int getPriorityNumber(String div) {
		int pri = 0;//���ȼ��ж�����
		if(div.equals("+") || div.equals("-")){
			pri = 1;
		}
		else{
			pri = 2;
		}
		return pri;
	}
	
	//ȥ����׺���ʽ�Ŀո�
	public String getPostConter(){
		return postCounter.trim();
	}
	
	//
}
