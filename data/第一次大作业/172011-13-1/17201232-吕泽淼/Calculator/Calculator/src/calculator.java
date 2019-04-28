import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class calculator {
	



		//ö��
	public enum operatorEnum{
			PLUS(0, '+'), MINUS(0, '-'), MULTIPLY(1, '*'), DIVIDE(1, '/'),  LEFT_BRACKET(2, '('), RIGHT_BRACKET(2, ')');//ö�ٲ�����
			
			public Integer first;		//���ȼ�     ��װ��int
			public Character opera;     	//������			��װ�� char
				
			private operatorEnum(int first,char opera){
				this.first = first;
				this.opera = opera;
			}
				
			public String toString(){
				return String.valueOf(opera);
			}
					
		}
			
		//�ж��ַ��Ƿ�Ϊ������
	private operatorEnum isOperator(char c){
			for(operatorEnum p : operatorEnum.values()){
				if(c == p.opera){
					return p;
				}
			}
			return null;
		}
			
		//������ʽת��Ϊ��׺���ʽ
	public String toBack(String s1){
			//��������ַ�������
			char[] c = s1.trim().toCharArray();
			 LinkedList<operatorEnum> stack = new LinkedList<operatorEnum>();
			 StringBuilder sb = new StringBuilder();
			 
			 operatorEnum opera = null;
			 
			 for(int i = 0; i < c.length; i++){
				 //����ÿ���ַ�������Ƿ�Ϊ������
				 if((opera = isOperator(c[i])) == null){
					 sb.append(c[i]);
				 }
				 //��������ջ��Ԫ��ֱ�������ţ��������
				 else if(opera.equals(operatorEnum.RIGHT_BRACKET)){
					 //������������ţ��������������
					 while(!stack.peek().equals(operatorEnum.LEFT_BRACKET)){
						 sb.append(stack.pop());
					 }
					 stack.pop();
				 }
				 else{
					 //������������и����ȼ�����ͬ�����ȼ���ֱ�����������ȼ�����������Ϊֹ
					 while(stack.size() > 0 && stack.peek().first >= opera.first && !stack.peek().equals(operatorEnum.LEFT_BRACKET)){
						 sb.append(stack.pop());
					 }
					 //��ջ
					 stack.push(opera);
				 }
			 }
			 //����ջ��ʣ�µ����в�����
			 while(stack.size() > 0){
				 sb.append(stack.pop());
			 }
			 return sb.toString();
		}
			
		//�����׺���ʽ
	public double compute(String toback){
			char[] c = toback.toCharArray();
			LinkedList<Double> stack = new LinkedList<Double>();	//���ͷ���
			operatorEnum opera = null;
			for(int i = 0; i < c.length; i++){
				//�ж��Ƿ�Ϊ�����������������ջ
				if((opera = isOperator(c[i])) == null){
					stack.push(Double.parseDouble(String.valueOf(c[i])));
				}
				else{
					//������ǲ�����������м���
					double m = stack.pop();
					double n = stack.pop();
					switch(opera){
						
					case PLUS:
						stack.push(n + m);//�Լӷ�����
						break;
					case MINUS:
						stack.push(n - m);//�Լ�������
						break;
					case MULTIPLY:
						stack.push(n * m);//�Գ˷�����
						break;
					case DIVIDE:
						stack.push(n / m);//�Գ�������
						break;
							
					default:
						break;
					}
				}
			}
			//���ص���ջ��
			return stack.pop();
		}


}

