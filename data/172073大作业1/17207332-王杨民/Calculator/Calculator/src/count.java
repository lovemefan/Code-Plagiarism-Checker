import java.util.Stack;

public class count {
	
	
	public int cal(String expression){
		Stack<Integer> stackdate= new Stack<>();
		Stack<Character> stacksymble = new Stack<>();
		char[] expr = expression.toCharArray();
		
		for(int i = 0; i < expr.length; i++){
			
			if(isChar(expr[i])==1){//操作数进堆栈
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
			}else if(isChar(expr[i])==0||isChar(expr[i])==2){//操作符处理
				
				if(!stacksymble.isEmpty()){//栈非空
					
					Character tp = stacksymble.peek();
					if(Compar(tp,expr[i])=='>'){//如果expr[i]大于tp则入栈
						stacksymble.push(expr[i]);
					}else	if(Compar(tp,expr[i])=='='){//脱括号
						stacksymble.pop();
					}else{//如果优先级小，则进行运算并把结果入栈 
						int a = stackdate.pop();
						int b = stackdate.pop();
						stackdate.push(Option(b,a,stacksymble.pop()));
						i--;//停留 与下一个比较
					}				
				}else{//栈为空操作符直接入栈
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

	//判断运算优先级
	private Character Compar(char c2,char c){
		 if (c == '+' || c == '-') { //c为后进入的操作符，c2为之前进入的操作符
	            //如果同为+ - 则c2的优先级大于c  同理 * /就更不用说了
	            if (c2 == '+' || c2 == '-' || c2 == '*' || c2 == '/') {  //所以和栈顶元素相比 优先级要小
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
	
	//判断是否为字符 去除非法字符及空格
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
