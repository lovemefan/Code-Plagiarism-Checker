package javaAssignment;

import java.util.Stack;

public class Split {//��׺���ʽת��׺���ʽ

	
	Split(){
		
	}

	public  double split(String expression){

		String [] expr = new String[100];
		prefix(expr,expression);//���ʽ����
		
		Calculate c = new Calculate();//����׺���ʽ���������
		return c.calculating(expr);//���ؼ�����
	}
	
	public void prefix(String [] expr,String exp){//��ֿ�ʼ
		Stack<Character> s = new Stack<Character>();//ϵͳջ
		int j = 0;
		for(int i = 0;i < exp.length();i++){//�ڱ��ʽ������ѭ��
			char temp;
			char ch = exp.charAt(i);//һ�����ַ��ж�
			if(ch == '('){//��������ջ
				s.push(ch);
			}
			else if(ch == '*'||ch == '/'){//����*/ʱ
				j++;
				 while (s.size() != 0){//ջ��Ϊ��
					 temp = s.pop();
					 if(temp == '+'||temp == '-'||temp == '('){//ǰһ������+-��ջ������򵯳�����׺���ʽ
						 s.push(temp);
						 break;
					 }
					 else{
						 expr[j] =""+ temp;
						 j++;
					 }
				 }
				 s.push(ch);//��ջ
			}
			else if(ch =='+'||ch == '-'){//����+-
				j++;
				while (s.size() !=0){
					temp = s.pop();
					if(temp == '('){//ֱ��������������ȫ������
						s.push(temp);
						break;
					}
					
					 expr[j] = ""+temp;
					 j++;	
				}
				 s.push(ch);//��ջ
			}
			else if(ch ==')'){//������������֮ǰ��ȫ����
				
				while ((temp = s.pop()) != '('){
					j++;
					 expr[j] = ""+temp;
				}
			}
			else{
				if(expr[j]==null)
					expr[j] = ""+ch;
				else
					expr[j]+=ch;
			}
		}
		while (s.size() != 0){//��ջ���
			j++;
			expr[j]=""+s.pop();
		}
	}	
}
