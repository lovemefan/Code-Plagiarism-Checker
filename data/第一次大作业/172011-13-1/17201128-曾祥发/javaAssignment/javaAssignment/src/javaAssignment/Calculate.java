package javaAssignment;


public class Calculate {
	public Calculate(){
		
	}
	
public double calculating(String [] expression){//�Ѵ���ĺ�׺���ʽ���м��㣬����һ��double���͵Ľ��
	double result = 0.0;
//����׺���ʽ������ַ�����һ�������н��з�����ڼ���
	Node head = null;
	int i = 1;
	head =new Node(expression[0]);
	Node temp=head;
	while(expression[i] != null){
		temp.next=new Node(expression[i]);
		temp=temp.next;
		i++;
	}
	//��ʼ����
	temp = head;
	Node p = head.next;
	Node q = p.next;
	double a = 0.0;
	double b = 0.0;
	while(q.s != null){
		if(t(q.s)){//���ж��Ƿ����������
			 a = Double.parseDouble(head.s);//��ǰ������������ַ�ǿ������ת��
			 b = Double.parseDouble(p.s);
			 char c = q.s.charAt(0);
			 head.s = "" +cal(a,b,c);//����Ȼ��ִ�в���ɾ��pq�Ľ�㣬��������浽head.s��
			 Node tp = q.next;
			 if(tp == null)
				 break;
			 if(t(tp.s)){//��q.next.s�ǲ������������¿�ʼ����ѭ������p =q.next,q = p.next
				 p = head;
				 p.next = tp;
				 q = tp;
				head = temp;
				p = head.next;
				q = p.next;
				continue;	 
			 }
			 else{
				 p = tp;
				 q = p.next;
				 head.next = p;
				 continue;
			 }
		}
		else{
			head = p;
			p = q;
			q = q.next;
		}
			
	}
	result = Double.parseDouble(head.s);//���ؽ��
	return result;
}
	
	public double cal(double a,double b,char ch){//���ݲ���������
		double r = 0.0;
		switch(ch){
		case '+':
			r = a+b;
			break;
		case '-':
			r = a-b;
			break;
		case '*':
			r = a*b ;
			break;
		case '/':
			r = a/b;
			break;
		}
		return r;
	}
	
	public boolean t(String aa){//�ж��Ƿ��ǲ�����
		char c = aa.charAt(0);
		if(c == '+' || c =='-'|| c == '*'|| c == '/')
			return true;
		else
			return false;
	}
}



