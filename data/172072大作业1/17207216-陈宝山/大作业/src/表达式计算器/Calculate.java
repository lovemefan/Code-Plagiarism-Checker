package ���ʽ������;

public class Calculate {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int count;//ͳ���ı�����ı��ʽ�ĸ���
		StackOfOperater optr=new StackOfOperater();
		StackOfOperand opnd=new StackOfOperand();//����һ��������ջ��һ�������ջ
		FileOperation f=new FileOperation();//����һ���ļ�������Ķ���
		String[] s=new String[10];//�����ַ������飬���ڽ��ձ��ʽ
		
		String[] tokens=new String[30];//�����ַ������飬���һ�����ʽ�ַ���Ϊ������ַ���
		double value;
		double n1,n2;
		char theta;//����������������while���
		double[] result=new double[10];//����һ����ֵ�����飬���������
		count=f.readFile(s);//��ȡ�ļ��������ر��ʽ����
		optr.push('#');
		for(int i=0;i<count;i++) {
			tokens=s[i].split(" ");//ʹ���ַ�����֣���һ���ո�����ı��ʽ���һ�������ַ���
			char ch=tokens[0].charAt(0);//�����ַ���ת��Ϊ�ַ�
			char c=optr.peek();//��c��ΪΪ�����ջ��ջ��Ԫ��
			int j=0;
			while(ch!='#'||c!='#') {//��ջ��Ԫ�غ�����Ԫ�ز�ͬʱΪ#ʱ�����б��ʽ����
				if(ch>=48&&ch<=57) {//������Ԫ��Ϊ�����ַ�ʱ��ת�������֣�Ȼ����������ջ
					value=Double.parseDouble(tokens[j]);
					opnd.push(value);
					ch=tokens[++j].charAt(0);//ch������һ�ַ�
				}
				else {//������Ԫ��Ϊ�����ʱ���������������
					switch(prior(c,ch)) {//�Ƚ������ջջ��Ԫ�غ�����Ԫ�ص�����Ȩ
					case '<': optr.push(ch);			  
							  ch=tokens[++j].charAt(0);
							  break;
					case '=': optr.pop();
							  ch=tokens[++j].charAt(0);
							  break;
					case '>': n2=opnd.pop();
							  n1=opnd.pop();
							  theta=optr.pop();
							  opnd.push(operate(n1,theta,n2));
							  break;
					}
				}
				c=optr.peek();
			}
			result[i]=opnd.pop();
		}
		f.writeFile(s,count,result);
	}
	public static char prior(char a,char b) {
		char[][] ch= {
						{'>','>','<','<','<','>','>'},{'>','>','<','<','<','>','>'},
						{'>','>','>','>','<','>','>'},{'>','>','>','>','<','>','>'},
						{'<','<','<','<','<','=',' '},{'>','>','>','>',' ','>','>'},
						{'<','<','<','<','<',' ','='}
					};
		return ch[index(a)][index(b)];
	}
	public static int index(char a) {
		int index=0;
		if(a=='+')
			index=0;
		if(a=='-')
			index=1;
		if(a=='*')
			index=2;
		if(a=='/')
			index=3;
		if(a=='(')
			index=4;
		if(a==')')
			index=5;
		if(a=='#')
			index=6;
		return index;
	}
	public static double operate(double n1,char theta,double n2) {
		double result=0;
		if(theta=='+')
			result=n1+n2;
		if(theta=='-')
			result=n1-n2;
		if(theta=='*')
			result=n1*n2;
		if(theta=='/')
			result=n1/n2;
		return result;
	}

}
