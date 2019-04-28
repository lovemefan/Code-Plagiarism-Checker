package javaAssignment;


public class Calculate {
	public Calculate(){
		
	}
	
public double calculating(String [] expression){//把传入的后缀表达式进行计算，返回一个double类型的结果
	double result = 0.0;
//将后缀表达式数组的字符存入一个链表中进行方便后期计算
	Node head = null;
	int i = 1;
	head =new Node(expression[0]);
	Node temp=head;
	while(expression[i] != null){
		temp.next=new Node(expression[i]);
		temp=temp.next;
		i++;
	}
	//开始计算
	temp = head;
	Node p = head.next;
	Node q = p.next;
	double a = 0.0;
	double b = 0.0;
	while(q.s != null){
		if(t(q.s)){//先判断是否碰到运算符
			 a = Double.parseDouble(head.s);//将前面的两个数字字符强制类型转换
			 b = Double.parseDouble(p.s);
			 char c = q.s.charAt(0);
			 head.s = "" +cal(a,b,c);//计算然后执行操作删除pq的结点，将结果保存到head.s里
			 Node tp = q.next;
			 if(tp == null)
				 break;
			 if(t(tp.s)){//若q.next.s是操作符，则重新开始整个循环否则p =q.next,q = p.next
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
	result = Double.parseDouble(head.s);//返回结果
	return result;
}
	
	public double cal(double a,double b,char ch){//根据操作符运算
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
	
	public boolean t(String aa){//判断是否是操作符
		char c = aa.charAt(0);
		if(c == '+' || c =='-'|| c == '*'|| c == '/')
			return true;
		else
			return false;
	}
}



