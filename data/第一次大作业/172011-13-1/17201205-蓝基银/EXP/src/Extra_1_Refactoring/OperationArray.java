package Extra_1_Refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationArray {
	final int LENGTH = 1001;
	int []stackNum = new int [LENGTH];
	
	char []stackOp = new char [LENGTH];
	String []list = new String[LENGTH];
	String []opStack = new String [LENGTH];

	OperationArray(){
		for (int i=0;i<LENGTH;i++){
			list[i] = null;	
		}
	}
	String goIntoStack(String input){
		Priority C1 = new Priority();
		PopAndPush C2=new PopAndPush();
		String infix = input ;
		String result = "" ;
		//String []list = new String[LENGTH];
		//String []opStack = new String [LENGTH];
		int m=0;//m��listջ������һλ
		int n=0;//n��opStackջ������һλ
		char chArr[] = new char [LENGTH];
		chArr = ("("+input+")").toCharArray();
        char ch = chArr[0];
        String str = "";
        int len = 0;
		for (int i = 0; i < chArr.length; i++) {
			
			ch = chArr[i];
			if(Character.isDigit(ch)) {//�����ǰ����Ϊ ����  
                len++;					//���ȼ�һ
                //System.out.println("len = "+len);
            }
			if ((ch=='/')||(ch=='*')||(ch=='+')||(ch=='-')||(ch=='(')||(ch==')')){
            	for (int j=i-len ;j<i;j++){//�ѷ�������ַ���list��
            	str=str+chArr[j];
            	}
            	if (str!=""){
				list[m] = str;
				str="";
				m++;
				len=0;
            	}
				
				//�ѷ��ŷ���list��
				if ((ch=='(')){
				opStack[n]=String.valueOf('(');
				n++;
				
				}
				if ((ch=='/')||(ch=='*')||(ch=='+')||(ch=='-')){//��+-*/�����
					if (opStack[n-1]=="("){//��һ���ǣ� �ͽ�
						opStack[n] = String.valueOf(ch);
						n++;
					}else if (C1.pri(ch)>C1.pri(opStack[n-1].charAt(0))){//Ҫ��ջ������������ȼ��������ջ��,����ջ
						opStack[n] = String.valueOf(ch);
						n++;
						
					}
					else{//Ҫ��ջ������������ȼ����С�ڵ���ջ�����򵯳�ջ����listֱ�����ջ��и�С���ȼ����������,�����������ջ;
						//�������ջ
						for (;;){
						if ((C1.pri(opStack[n-1].charAt(0))>=C1.pri(ch))){
							list[m] = opStack[n-1];//opStackջ����list
							C2.pop(opStack,n-1);//����ջ��
							n--;
							m++;
						}else{
							if ((opStack[0]==null)||((C1.pri(opStack[n-1].charAt(0))<C1.pri(ch)))){
								opStack[n] = String.valueOf(ch);
								n++;
								break;////�������ջ���˳�ѭ��
							}
						}
						}
						
					}
				}
				
			}
			if (ch==')'){//��)�����
				for (;;){
				if (!opStack[n-1].equals("(")){
				list[m] = opStack[n-1];//opStackջ����list
				C2.pop(opStack,n-1);//����ջ��
				n--;
				m++;
				}else{
					break;
				}
				}//ɾ����
				C2.pop(opStack,n-1);
				n--;
			}
		}
		int pin = 0;
		for (pin = 0; (pin < list.length)&&(list[pin]!=null); pin++) {
			result= result+list[pin];
			//System.out.print(list[pin]+",");
			//System.out.println(opStack[pin]+"");
		}
		list[pin] = "";
		//System.out.print("\n");
		return result;
	}

	
	
	
	void showAll(){
		for (int pin = 0; (pin < list.length)&&(list[pin]!=null); pin++) {
			System.out.print(list[pin]+",");
			System.out.println(opStack[pin]+"");
		}

	}
}
	class stack {
		int num = 0;
		char op = 0;
		Boolean isEnd = true;
		stack(){
			this.num = 0;
			this.op = 0;
			this.isEnd = true;
		}
}