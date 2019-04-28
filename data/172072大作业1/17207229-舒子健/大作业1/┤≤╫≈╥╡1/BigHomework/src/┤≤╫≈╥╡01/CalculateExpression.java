package ����ҵ01;

/*���ʽ��ֵ��*/
public class CalculateExpression {

		StackOfChar optr = new StackOfChar();//��������ջ
		StackOfIntegers opnd = new StackOfIntegers();//��������ջ  
		
		/*�ж��Ƿ����������������������������Ƚ����ȼ�Ȼ�������Ӧ������������ѹ���������ջ*/
		public void testExp(String infix) {
			String num = "";//������
			
			for(int i=0; i<infix.length(); i++){
				char ch = infix.charAt(i);
				if(Character.isDigit(ch)) {	//�����������
					num = num + ch;	//�ɽ�����λ�����ϵ���
				}else {	//����������
					if(num != "") {//num��Ϊ����ת��Ϊ��ֵѹ���������ջ
						int intValue = Integer.parseInt(num);
						opnd.push(intValue);
					}
					switch(ch){//�Ƚ�����������ȼ�������Ӧ����
						case '+':
					    case '-':
					    	precede(ch,1);//��Ҫ�ж����ȼ���n1���趨���ǵ�ǰ�����ȼ�
					    	num = "";
					        break;
					    case '*':
					    case '/':
					    	precede(ch,2);//��Ҫ�ж����ȼ�
					    	num = "";
				            break;
					    case '(':
					        optr.push(ch);//���������ȼ����ֱ�ӽ�ջ
					        num = "";
					        break;
					    case ')':
					    	rightParentheses();//�����ұ������漰��ջ
					    	num = "";
					        break;
					    default:
					    	num = "";
					        break;
					}
					
				}		
			}
			if(num != "") {//ѭ��������num��Ϊ��ʱ
				int intValue = Integer.parseInt(num);
				opnd.push(intValue);
			}
			while(!optr.empty()) {//��ջ�л������������������
				int op1 = opnd.pop();
				int op2 = opnd.pop();
				char ch = optr.pop();
				int sum = calculator(op1, ch, op2);
				opnd.push(sum);
			}
		}
		
		/*�Ƚ���������ȼ�*/
		private void precede(char opThis, int n1) {
			
			while(!optr.empty()){
				char opTop = optr.peek();
				if(opTop == '('){  //���ջ�ж���������žͽ�ȥ����ѭ��
					break;
				 }
				else{
					int n2;
					//��¼ջ�в��������ȼ����Ӽ����ȼ���1�˳����ȼ���2
					if(opTop == '+' || opTop == '-'){
						n2 = 1;
					}
					else{
						n2 = 2;
					}
					//��ǰ��������ȼ�����ջ�����ȼ�����ǰ�������ջ
					if(n2 < n1){
						optr.push(opThis);
						break;
					 }
					//��ǰ��������ȼ�����ջ�����ȼ�������������ջ�����㣬�ٽ����ѹ���������ջ
					 else{
						 	int op1 = opnd.pop();
							int op2 = opnd.pop(); 
							char ch = optr.pop();
							int sum = calculator(op1, ch, op2);
							opnd.push(sum);
					 }
				}
			}
			//ջΪ�վ�ֱ�ӽ�ջ���������������Ҳ��ֱ�ӽ�ջ����ջ�洢��ջ�����ȼ�С��
			optr.push(opThis);
			
		}
		
		/*��ǰ�����Ϊ������ʱ*/
		private void rightParentheses() {
			while(!optr.empty()){
				if(optr.peek() == '(') {//����������ֱ�ӳ�ջ
					optr.pop();
					break;
				}
				else {
					int op1 = opnd.pop();
					int op2 = opnd.pop();
					char ch = optr.pop();
					int sum = calculator(op1, ch, op2);
					opnd.push(sum);
				}
			}
		}
		
		
		/*����*/
		private int calculator(int op1, char ch, int op2) {
			int sum = 0;
			switch(ch) {
				case '+':
					sum = op2 + op1;
					break;
				case '-':
					sum = op2 - op1;
					break;
				case '*':
					sum = op2 * op1;
					break;
				case '/':
					sum = op2 / op1;
					break;
				default:
					break;
			}
			return sum;
		}
		
}

