import java.util.Stack;

public class count {
	
	
	public int cal(String expression){
		Stack<Integer> stackdate= new Stack<>();
		Stack<Character> stacksymble = new Stack<>();
		char[] expr = expression.toCharArray();
		
		for(int i = 0; i < expr.length; i++){
			
			if(isChar(expr[i])==1){//����������ջ
				int s = expr[i] - 48;
				int flag = 0;
				if((i+1)<expr.length){i++;flag=1;}
				int tp;
				while(flag==1&&i<expr.length&&isChar(expr[i])==1){
					tp = expr[i++] - 48;
					s*=10;
					s+=tp;
				}
				if(flag==1)i--;
				
				stackdate.push(s);
			}else if(isChar(expr[i])==0||isChar(expr[i])==2){//����������
				
				if(!stacksymble.isEmpty()){//ջ�ǿ�
					
					Character tp = stacksymble.peek();
					if(Compar(tp,expr[i])=='>'){//���expr[i]����tp����ջ
						stacksymble.push(expr[i]);
					}else	if(Compar(tp,expr[i])=='='){//������
						stacksymble.pop();
					}else{//������ȼ�С����������㲢�ѽ����ջ 
						int a = stackdate.pop();
						int b = stackdate.pop();
						stackdate.push(Option(b,a,stacksymble.pop()));
						i--;//ͣ�� ����һ���Ƚ�
					}				
				}else{//ջΪ�ղ�����ֱ����ջ
					stacksymble.push(expr[i]);
				}
			
			}
		}
		if(stacksymble.isEmpty())return stackdate.pop();
		else{
			while(!stacksymble.isEmpty()){
				int a = stackdate.pop();
				int b = stackdate.pop();
				Character tp = stacksymble.pop();
				stackdate.push(Option(b,a,tp));
			}
			return stackdate.pop();
		}
	}
	
	private int Option(int a,int b,Character op){
		switch (op) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			return a/b;
		}
		return 0;	
	}

	//�ж��������ȼ�
	private Character Compar(char c2,char c){
		 if (c == '+' || c == '-') { //cΪ�����Ĳ�������c2Ϊ֮ǰ����Ĳ�����
	            //���ͬΪ+ - ��c2�����ȼ�����c  ͬ�� * /�͸�����˵��
	            if (c2 == '+' || c2 == '-' || c2 == '*' || c2 == '/') {  //���Ժ�ջ��Ԫ����� ���ȼ�ҪС
	                return '<';
	            }
	            if (c2 == '(') {
	                return '>';
	            }
	            if (c2 == ')') {
	                return '<';
	            }
	        }
	        if (c == '*' || c == '/') {
	            if (c2 == '+' || c2 == '-') {
	                return '>';
	            }

	            if (c2 == '*' || c2 == '/') {
	                return '<';
	            }
	            if (c2 == '(') {
	                return '>';
	            }
	            if (c2 == ')') {
	                return '<';
	            }
	        }


	        if (c == '(') {
	            return '>';
	        }
	        if (c == ')') {
	            if (c2 != '(') {
	                return '<';
	            } else {
	                return '=';
	            }
	        }
	        return 0;		
	}
	
	//�ж��Ƿ�Ϊ�ַ� ȥ���Ƿ��ַ����ո�
	public int isChar(char ch){
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
			return 0;
		}else if(ch=='('||ch==')'){
			return 2;
		}else if(ch>='0'&&ch<='9')
		{
			return 1;
		}else{
			return -1;
		}
	}
}
