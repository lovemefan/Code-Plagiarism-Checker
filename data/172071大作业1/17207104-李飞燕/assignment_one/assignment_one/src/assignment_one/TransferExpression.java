package assignment_one;

public class TransferExpression {

	public static int index(char a){
			
			switch (a){
				case '+': return 0;
				case '-': return 1;
				case '*': return 2;
				case '/': return 3;
				case '(': return 4;
				case ')': return 5;
				case '#': return 6;
			}
			return -1;
		}
		
		public static char priority(char a,char b){
			char prior[][]=	{	{'>','>','<','<','<','>','>'},
								{'>','>','<','<','<','>','>'},
								{'>','>','>','>','<','>','>'},
								{'>','>','>','>','<','>','>'},
								{'<','<','<','<','<','=',' '},
								{'>','>','>','>',' ','>','>'},
								{'<','<','<','<','<',' ','='}};
			return prior[index(a)][index(b)];	//�����ȼ�����
		}
		
		public static String transfer( String nifixExpression, String postfixExpression){//����׺���ʽת��Ϊ��׺���ʽ 
			
			int i=0;
			StackOfChar stack = new StackOfChar();//������ջ 
			nifixExpression = nifixExpression.replaceAll("\\s+","");
			nifixExpression = "#"+nifixExpression+"#"; 
			stack.push(nifixExpression.charAt(i));//����׺���ʽ�е�һ��#ѹ���ջ 
			i++;
			char c = stack.peek();//��ȡջ��Ԫ�� 
			while(nifixExpression.charAt(i)!='#'||c!='#')
			{
				if(judgedigital ( nifixExpression.charAt(i) ) )
				{
					postfixExpression = postfixExpression + nifixExpression.charAt(i);//��Ϊ������ֱ�ӷ����׺���ʽ˳����� 
					if(!judgedigital ( nifixExpression.charAt(i+1) ) ){
						postfixExpression = postfixExpression +",";
					}
					i++;
				}
				else{
					c = stack.peek();
					char compare = priority(c,nifixExpression.charAt(i));
					switch(compare)
					{
						case '<':
								stack.push(nifixExpression.charAt(i));//����׺���ʽʶ��Ĳ��������ȼ��ߣ�ֱ��ѹ���ջ 
								i++;//ʶ����һ��׺���ʽ�е�Ԫ�� 
								break;
						case '=':
								stack.pop();//�������������ȼ���ȣ���ջ��Ԫ�ص��� 
								if(nifixExpression.charAt(i)!='#')//����׺���ʽδʶ�������ʶ�� 
									i++;
								break;
						case '>':
								c = stack.pop();//��ջ�����������ȼ��ߣ���ջ���������������������׺���ʽ���Ա��� 
								postfixExpression = postfixExpression + c ;
								break;
					}//switch 
				}//else 
			}//while 
			while(!stack.isEmpty())
			{
				char temp = stack.pop();
				if( temp != '#'){
					postfixExpression = postfixExpression + temp;
				}
		 	}
			return postfixExpression;
		} 
		
		static boolean judgedigital(char c)//�ж�c�����ֻ��������ַ�����Ϊ���֣�����1����Ϊ�����ַ�������-1 
		{
			if( c >='0' && c <= '9' )
				return true;
			else
				return false;	
		}

}

