
public class CaculateExpression {
	StackOfIntegers stack1 = new StackOfIntegers();
	StackOfIntegers stack2 = new StackOfIntegers();
	private String postExpression = "";
	private String expression;
	
	
	public CaculateExpression() {
		
	}
	public CaculateExpression(String expression) {
		this.expression = expression;
		toPostExpression();
		getResult();
	}
	public String getExpressionResult() {
		
		return stack2.pop();
	}
		
	public String getPostExpression() {   //��ꡱ��ʽ
		return postExpression;
	}
	private void findLeftParent() {		//ջ�����������ǡ�������������
		while(!stack1.isEmpty()) 
		{
			String top = stack1.pop();
			if(top.equals("("))
			{
				break;
			}
			else
			{
				postExpression += " "+ top;
			}
		}
	}
	private int getNum(String num) {	//�ҵ�ջ������������ȼ�
		int num2 =0;
		if(num.equals("+")||num.equals("-")) {
			 num2=1;
		}
		else
		{
			num2 =2;
		}
		return num2; 
	}
	private void getOperation(String cut,int num){		//�õ�ǰ���������ջ���������Ƚ����ȼ������ȼ��ߵ�д���ꡱ��ʽ
		while(!stack1.isEmpty())
		{
			String top = stack1.pop();
			if(top.equals("(")) {
				stack1.push(top);
				break;
			}
			else
			{
				int num1 = getNum(top);
				if(num1<num)
				{
					stack1.push(top);
					break;
				}
				else
				{
					postExpression += " "+top;
				}
			}
		}
		stack1.push(cut);
	}
	private void toPostExpression() {		//�õ���ꡱ��ʽ
		String[] cutting = expression.split(" ");
		for(int i =0; i<cutting.length;i++)
		{
			String cut = cutting[i];
			switch(cut) 
			{
				case" ":
					break;
				case"+":
				case"-":
					getOperation(cut,1);
					break;
				case"*":
				case"/":
					getOperation(cut,2);
					break;
				case"(":
					stack1.push(cut);
					break;
				case")":
					findLeftParent();
					break;
				default:
					postExpression += " " + cut;
					break;
			}
		}
		while(!stack1.isEmpty()) 
		{
			postExpression += " " + stack1.pop();
		}
	}
	private void getResult() {		//�õ�������
		String[] cutt = postExpression.split(" ");
		for(int i =0;i<cutt.length;i++) 
		{
			String cut1 =cutt[i];
			if(isNumber(cut1)== true)
			{
				stack2.push(cut1);
			}
			else
			{
				String result = Caculate(cut1);
				stack2.push(result);
			}
		}
	}
	private String Caculate(String cut1) {   //���������е�ջ��������
		float flo = 0;
		String str = "";
		float flo1 = Float.parseFloat(stack2.pop());
		float flo2 = Float.parseFloat(stack2.pop());
		switch(cut1) 
		{
			case"+":
				flo = flo1 + flo2;
				break;
			case"-":
				flo = flo1 - flo2;
				break;
			case"*":
				flo = flo1 * flo2;
				break;
			case"/":
				flo = flo2 / flo1;
				break;
			default:
				break;
		}
		str = flo +"";
		return str;
	}
	private boolean isNumber(String flag){   //�ж��ַ��Ƿ�������
		boolean n = true;
		for (int i = 0; i < flag.length(); i++) {
			if (!(flag.charAt(i) >= '0' && flag.charAt(i) <= '9')) {
				n= false;
				break;
			}
		}
		return n;
	}
}
