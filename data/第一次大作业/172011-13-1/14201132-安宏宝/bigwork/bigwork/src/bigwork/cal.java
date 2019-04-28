package bigwork;

import java.util.Stack;

public class cal {

	//检验表达式是否正确(1.2.3此种错误未解决)
	public static boolean check(String str){
		boolean bool=false;
		//检验是否有非法符号
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'||
					str.charAt(i)=='^'||str.charAt(i)=='('||str.charAt(i)==')'||
					str.charAt(i)=='.'||(str.charAt(i)>=48&&str.charAt(i)<=57))
				continue;
			else{
				System.out.println("存在非法字符！");
				return bool;
			}
		}
		//检验是否有连续出现的运算符，（）除外
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
					System.out.println("表达式不合法！");
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
			System.out.println("括号不匹配！");
			return bool;
	}
	//转化为栈的形式并计算
	public static Float transfer(String str){
		str=str+'$';
		String str2=new String();
		str2="";
		//数字栈
		Stack<Float> number=new Stack<Float>();
		//操作符栈
		Stack<Character> operator=new Stack<Character>();
		//操作符栈栈底元素#，优先级最低
		operator.push('#');
		//System.out.println(operator.peek());
		//扫描字符串每一个元素
		loop:for(int i=0;i<str.length();i++){
		//如果当前字符为数字或小数点，则存入str2备用
		if(str.charAt(i)=='.'||str.charAt(i)=='0'||str.charAt(i)=='1'||str.charAt(i)=='2'||
			str.charAt(i)=='3'||str.charAt(i)=='4'||str.charAt(i)=='5'||str.charAt(i)=='6'||
			str.charAt(i)=='7'||str.charAt(i)=='8'||str.charAt(i)=='9'){
			str2=str2+str.charAt(i);
			continue;
		}
		else{
			if(str2!=""){
			//如果str2不为空，既之前有扫描到数字，则进行压栈
			number.push(Float.parseFloat(str2));
			//str2还原
			str2="";
			}
			//比较当前元素（其实为一操作符）与操作符栈中的栈顶元素的优先级
			for(;;){
				//如果当前元素的优先级低于或等于栈顶元素的优先级
				if(compare(str.charAt(i),operator.peek())){
					float temp;
					//做如下操作
					switch(operator.peek()){
					//栈顶元素为+，弹出数字栈的前两个元素，进行运算
					case '+':
						temp=number.pop()+number.pop();
						number.push(temp);
						//弹出操作符栈中用过的元素
						operator.pop();
						break;
					//栈顶元素为-，弹出数字栈的前两个元素，进行运算
					case '-':
						temp=-number.pop()+number.pop();
						number.push(temp);
						//弹出操作符栈中用过的元素
						operator.pop();
						break;
					//栈顶元素为*，弹出数字栈的前两个元素，进行运算
					case '*':
						temp=number.pop()*number.pop();
						number.push(temp);
						//弹出操作符栈中用过的元素
						operator.pop();
						break;
					//栈顶元素为/，弹出数字栈的前两个元素，进行运算
					case '/':
						temp=1/number.pop()*number.pop();
						number.push(temp);	
						//弹出操作符栈中用过的元素
						operator.pop();
						break;
					//栈顶元素为^，弹出数字栈的前两个元素，进行运算
					case '^':
						float n=number.pop();
						float e=number.pop();
						temp=(float) Math.pow(e,n);
						//System.out.println(temp);
						number.push(temp);	
						//弹出操作符栈中用过的元素
						operator.pop();
						break;
					//栈顶元素为(，不进行任何运算
					case '(':
						//只有当当前元素为“)”时，才弹出“(”，否则，将当前元素压栈，
						//并进行下一次循环，即扫描字符串的下一个元素
						if(str.charAt(i)==')'){
							//弹出操作符栈中用过的元素
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
					// “)” 不入栈
					if(str.charAt(i)!=')')
					operator.push(str.charAt(i));
					break;
				}
			}
			}
		}
		//返回栈顶元素，即算式结果
		return number.peek();
}
	
	//比较优先级,判断b的优先级是否大于等于a的优先级
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