package javaAssignment;

import java.util.Stack;

public class Split {//中缀表达式转后缀表达式

	
	Split(){
		
	}

	public  double split(String expression){

		String [] expr = new String[100];
		prefix(expr,expression);//表达式传入
		
		Calculate c = new Calculate();//将后缀表达式传入计算类
		return c.calculating(expr);//返回计算结果
	}
	
	public void prefix(String [] expr,String exp){//拆分开始
		Stack<Character> s = new Stack<Character>();//系统栈
		int j = 0;
		for(int i = 0;i < exp.length();i++){//在表达式长度内循环
			char temp;
			char ch = exp.charAt(i);//一个个字符判断
			if(ch == '('){//遇到（进栈
				s.push(ch);
			}
			else if(ch == '*'||ch == '/'){//遇到*/时
				j++;
				 while (s.size() != 0){//栈不为空
					 temp = s.pop();
					 if(temp == '+'||temp == '-'||temp == '('){//前一个的是+-（栈不变否则弹出到后缀表达式
						 s.push(temp);
						 break;
					 }
					 else{
						 expr[j] =""+ temp;
						 j++;
					 }
				 }
				 s.push(ch);//进栈
			}
			else if(ch =='+'||ch == '-'){//遇到+-
				j++;
				while (s.size() !=0){
					temp = s.pop();
					if(temp == '('){//直到遇到（将其他全部弹出
						s.push(temp);
						break;
					}
					
					 expr[j] = ""+temp;
					 j++;	
				}
				 s.push(ch);//进栈
			}
			else if(ch ==')'){//遇到）将到（之前的全弹出
				
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
		while (s.size() != 0){//将栈清空
			j++;
			expr[j]=""+s.pop();
		}
	}	
}
