public class CountTheExpress {	
	double Trans(String experssion) {	 
		int i=0,a=0;
		double num1=0,num2=0;
		Stack OperatorStack=new Stack(20);//��ʱ�洢��������ջ
		Stack NumStack=new Stack(20);	
		ComparePriority compare=new ComparePriority();
		OperatorStack.push("#");
		while(experssion.charAt(i)!='#'||OperatorStack.peek()!="#"){
			if (experssion.substring(i,i+1).equals("-")) {//���ú����ж�-�Ǹ��ţ����ǲ�����
				if (i==0&&(experssion.charAt(i+1)<58&&experssion.charAt(i+1)>47)) {
					a=0;		
					while (experssion.charAt(i)<58&&experssion.charAt(i)>47) {//���������Ǹ���
						a=a*10+(experssion.charAt(i)-48);
						i++;
					}
					NumStack.push(String.valueOf(-a));
				}else//-7*-3ʱ���������� 
				if (experssion.substring(i+1,i+2).equals("(")) {
					if(i==0||!experssion.substring(i-1,i).equals(")")){
						if(i==0||!(experssion.charAt(i-1)<58&&experssion.charAt(i-1)>47)) {
							NumStack.push(String.valueOf(-1));
							OperatorStack.push("*");
							i++;
						}
					}
				}else 
				if (experssion.substring(i-1,i).equals("(")&&(experssion.charAt(i+1)<58&&experssion.charAt(i+1)>47)) {
					i++;
					a=0;
					while (experssion.charAt(i)<58&&experssion.charAt(i)>47) {//���������Ǹ���
						a=a*10+(experssion.charAt(i)-48);
						i++;
					}
					NumStack.push(String.valueOf(-a));
				}
			}/*else if((experssion.charAt(i+1)<58&&experssion.charAt(i+1)>47)) {
					if (experssion.substring(i-1,i).equals("+")||
					experssion.substring(i-1,i).equals("*")||experssion.substring(i-1,i).equals("-")) {
						i++;
						a=0;
						while (experssion.charAt(i)<58&&experssion.charAt(i)>47) {//���������Ǹ���
							a=a*10+(experssion.charAt(i)-48);
							i++;
						}
						NumStack.push(String.valueOf(-a));
					}
			}*/
			 if(experssion.charAt(i)<58&&experssion.charAt(i)>47){//����������������������	
				a=0;
				while (experssion.charAt(i)<58&&experssion.charAt(i)>47) {//��ʽ�е����ֱ���127��ȡ������������һ�����ֶ����������ַ�
					a=a*10+(experssion.charAt(i)-48);
					i++;
				}
				NumStack.push(String.valueOf(a));		
			 }
			else {								
			  	switch (compare.CompareThePriority(OperatorStack.peek(),experssion.substring(i,i+1))) {//ջ�����ȼ���
			  		case "<":	OperatorStack.push(experssion.substring(i,i+1));//ջ�����ȼ���
			  			i++;
			  			break;
			  		case "=":								
			  			OperatorStack.pop();//���ȼ����	
			  			i++;
			  			break;
			  		case ">":	num1=Double.parseDouble(NumStack.pop());
			  					num2=Double.parseDouble(NumStack.pop());														
			  			switch (OperatorStack.pop().charAt(0)){
						case '+' :	num1=num1+num2;
									NumStack.push(String.valueOf(num1));																			
									break;
						case '-' :	num1=num2-num1;
									NumStack.push(String.valueOf(num1));												
									break;																
						case '*' :	num1=num1*num2;
									NumStack.push(String.valueOf(num1));																		
										break;
						case '/' :	num1=num2/num1;
									NumStack.push(String.valueOf(num1));																			
										break;				
			  			}						  			
			  	}
			} 
		}
		//return 1;
		//System.out.println("aaa");
		return Double.parseDouble(NumStack.peek());
	}
}