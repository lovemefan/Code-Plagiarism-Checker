package bigwork;

import java.util.Stack;

public class cal {

	//������ʽ�Ƿ���ȷ(1.2.3���ִ���δ���)
	public static boolean check(String str){
		boolean bool=false;
		//�����Ƿ��зǷ�����
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'||
					str.charAt(i)=='^'||str.charAt(i)=='('||str.charAt(i)==')'||
					str.charAt(i)=='.'||(str.charAt(i)>=48&&str.charAt(i)<=57))
				continue;
			else{
				System.out.println("���ڷǷ��ַ���");
				return bool;
			}
		}
		//�����Ƿ����������ֵ����������������
		int num1=0,num2=0;
		int i=0;
		
		if(str.charAt(i)=='(') 
			num1++;
		if(str.charAt(i)==')') 
			num2++;
		
		while(/*!(str.charAt(i)>=48 && str.charAt(i)<=57) && */i<str.length() ){
			if(i+1>=str.length()){
				break;
			}
			
			if(!(str.charAt(i)>=48 && str.charAt(i)<=57)){
							
				if(((str.charAt(i)!='.'||str.charAt(i)!=')')&&(str.charAt(i+1)=='(') || (str.charAt(i+1)>=48&&str.charAt(i+1)<=57)) ||
						((str.charAt(i)==')'|| (str.charAt(i)>=48&&str.charAt(i)<=57))&&(str.charAt(i+1)!='('||str.charAt(i+1)=='.'))){
					
				}
				else if(((str.charAt(i)>=42&&str.charAt(i)<=47&&str.charAt(i)!=46)&&(str.charAt(i-1)==')'||(str.charAt(i-1)>=48&&str.charAt(i-1)<=57))) && 
						   ((str.charAt(i)>=42&&str.charAt(i)<=47&&str.charAt(i)!=46)&&(str.charAt(i+1)=='('||(str.charAt(i+1)>=48&&str.charAt(i+1)<=57)))){
					
				}
				else{
					System.out.println("���ʽ���Ϸ���");
					return bool;
				}
			}
			i++;
			if(str.charAt(i)=='(') 
				num1++;
			if(str.charAt(i)==')') 
				num2++;
		}
		
		if(num1==num2)
		{
			bool=true;
			}else
			System.out.println("���Ų�ƥ�䣡");
			return bool;
	}
	//ת��Ϊջ����ʽ������
	public static Float transfer(String str){
		str=str+'$';
		String str2=new String();
		str2="";
		//����ջ
		Stack<Float> number=new Stack<Float>();
		//������ջ
		Stack<Character> operator=new Stack<Character>();
		//������ջջ��Ԫ��#�����ȼ����
		operator.push('#');
		//System.out.println(operator.peek());
		//ɨ���ַ���ÿһ��Ԫ��
		loop:for(int i=0;i<str.length();i++){
		//�����ǰ�ַ�Ϊ���ֻ�С���㣬�����str2����
		if(str.charAt(i)=='.'||str.charAt(i)=='0'||str.charAt(i)=='1'||str.charAt(i)=='2'||
			str.charAt(i)=='3'||str.charAt(i)=='4'||str.charAt(i)=='5'||str.charAt(i)=='6'||
			str.charAt(i)=='7'||str.charAt(i)=='8'||str.charAt(i)=='9'){
			str2=str2+str.charAt(i);
			continue;
		}
		else{
			if(str2!=""){
			//���str2��Ϊ�գ���֮ǰ��ɨ�赽���֣������ѹջ
			number.push(Float.parseFloat(str2));
			//str2��ԭ
			str2="";
			}
			//�Ƚϵ�ǰԪ�أ���ʵΪһ���������������ջ�е�ջ��Ԫ�ص����ȼ�
			for(;;){
				//�����ǰԪ�ص����ȼ����ڻ����ջ��Ԫ�ص����ȼ�
				if(compare(str.charAt(i),operator.peek())){
					float temp;
					//�����²���
					switch(operator.peek()){
					//ջ��Ԫ��Ϊ+����������ջ��ǰ����Ԫ�أ���������
					case '+':
						temp=number.pop()+number.pop();
						number.push(temp);
						//����������ջ���ù���Ԫ��
						operator.pop();
						break;
					//ջ��Ԫ��Ϊ-����������ջ��ǰ����Ԫ�أ���������
					case '-':
						temp=-number.pop()+number.pop();
						number.push(temp);
						//����������ջ���ù���Ԫ��
						operator.pop();
						break;
					//ջ��Ԫ��Ϊ*����������ջ��ǰ����Ԫ�أ���������
					case '*':
						temp=number.pop()*number.pop();
						number.push(temp);
						//����������ջ���ù���Ԫ��
						operator.pop();
						break;
					//ջ��Ԫ��Ϊ/����������ջ��ǰ����Ԫ�أ���������
					case '/':
						temp=1/number.pop()*number.pop();
						number.push(temp);	
						//����������ջ���ù���Ԫ��
						operator.pop();
						break;
					//ջ��Ԫ��Ϊ^����������ջ��ǰ����Ԫ�أ���������
					case '^':
						float n=number.pop();
						float e=number.pop();
						temp=(float) Math.pow(e,n);
						//System.out.println(temp);
						number.push(temp);	
						//����������ջ���ù���Ԫ��
						operator.pop();
						break;
					//ջ��Ԫ��Ϊ(���������κ�����
					case '(':
						//ֻ�е���ǰԪ��Ϊ��)��ʱ���ŵ�����(�������򣬽���ǰԪ��ѹջ��
						//��������һ��ѭ������ɨ���ַ�������һ��Ԫ��
						if(str.charAt(i)==')'){
							//����������ջ���ù���Ԫ��
							operator.pop();
							continue loop;
						}
						else{
							operator.push(str.charAt(i));
							continue loop;
						}
					}
				}
				else{
					// ��)�� ����ջ
					if(str.charAt(i)!=')')
					operator.push(str.charAt(i));
					break;
				}
			}
			}
		}
		//����ջ��Ԫ�أ�����ʽ���
		return number.peek();
}
	
	//�Ƚ����ȼ�,�ж�b�����ȼ��Ƿ���ڵ���a�����ȼ�
	public static boolean compare(char a,char b){
		boolean bool=false;
		if(a=='#')bool=true;
		else
		if(a=='$'&&b!='#')bool=true;
		else
		if(a==')'&&b!='#'&&b!='$')bool=true;
		else
		if((a=='+'||a=='-')&&(b=='+'||b=='-'||b=='*'||b=='/'||b=='^'||b=='('))bool=true;
		else
		if((a=='*'||a=='/')&&(b=='*'||b=='/'||b=='^'||b=='('))bool=true;
		else
		if((a=='^')&&(b=='^'||b=='('))bool=true;
		else
		if(a=='('&&b=='(')bool=true;
		return bool;
	}
}