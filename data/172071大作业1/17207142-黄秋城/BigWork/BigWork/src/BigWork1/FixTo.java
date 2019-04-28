package BigWork1;

public class FixTo//中缀式转换为后缀式
{
	String before;
	String after="";
	Stack stack;
	
	public FixTo(Stack stack,String s) {
		this.stack=stack;
		this.before=s;
	}
	
	public String AddKong(String s) {//在表达式中加空格
		String str="";
		for(int i=0;i<s.length()-1;i++) {
			char temp1=s.charAt(i);
			char temp2=s.charAt(i+1);
			if(IsDigital(temp1)&&IsDigital(temp2)) {
				str+=temp1;
			}
			else {
				str+=temp1+" ";
			}
		}
		str+=s.charAt(s.length()-1);//
		return str;//现在是带空格的字符换
	}
	
	public String[] Process(String s,Stack p) {
		String s1 = s.replaceAll(" ", "");//将传进来的字符串去掉所有空格
		
		String[] strarr=AddKong(s1).split(" ");//用空格分割带空格的字符串进入字符串数组
		
		int n=strarr.length;
		String[] aft=new String[n];
		int a=0;
		
		for(int i=0;i<n;i++) {
			switch(strarr[i]) {
				case "+":
				case "-":
					if(p.isEmpty()||p.first.data.equals("(")) {//空栈或左括号
						p.push(strarr[i]);
					}
					else if(p.first.data.equals("+")||p.first.data.equals("-")||p.first.data.equals("*")||p.first.data.equals("/")) {//优先级相等
							while(!stack.isEmpty()) {
								if(p.first.data.equals("(")) {
									break;
								}
								String top = stack.pop();
								aft[a]=top;
								a++;
							}
							p.push(strarr[i]);//进栈
						}
					break;
				
				case "*":
				case "/":
					if(p.isEmpty()||p.first.data.equals("(")||p.first.data.equals("+")||p.first.data.equals("-")) {//空栈、左括号、优先级比我低
						p.push(strarr[i]);
					}
					else if(p.first.data.equals("*")||p.first.data.equals("/")) {
						String top = stack.pop();
						aft[a]=top;
						a++;
						p.push(strarr[i]);//进栈
					}
					break;
					
				case "(":
					p.push(strarr[i]);//进栈
					break;
					
				case ")":
					while(!p.first.data.equals("(")) {
						String top = stack.pop();
						aft[a]=top;
						a++;
					}
					p.pop();
					break;
				default://数字直接进队
					aft[a]=strarr[i];//进队
					a++;
					
			}
		}
		while (!stack.isEmpty()) {
			String top = stack.pop();
			aft[a]=top;
			a++;
		}//清空栈中运算符
		

		return aft;
	}
	
	public boolean IsDigital(char a) {
		if(a>='0'&&a<='9') {
			return true;
		}
		else return false;
	}
}
