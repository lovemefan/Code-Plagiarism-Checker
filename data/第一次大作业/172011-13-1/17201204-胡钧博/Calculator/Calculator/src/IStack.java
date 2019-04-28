//中缀表达式转换为后缀表达式
import java.util.Stack;
public class IStack {
	
		IStack(){
			
		}	
		public static String inFix(String b){
			String[] strings = b.split(" ");
			Stack<String> s = new Stack<String>(); //创建操作符堆栈
			String post = "";  //要输出的后缀表达式
		    for(int i = 0 ; i < strings.length ; i ++){
				String temp; //临时字符串变量
				String ch = strings[i]; //获取该中缀表达式的每一个字符串并进行判断
				switch(ch){
				case "(":     //如果是左括号直接压入堆栈
					s.push(ch);
					break;
				case "+":      //碰到'+' '-',将栈中的所有运算符全部弹出去，直到碰到左括号为止，输出到队列中去
				case "-":
					while(s.size() != 0){
						temp = s.pop();
						// 只有比当前优先级高的或者相等的才会弹出到输出队列，遇到加减左括号，直接停止当前循环

						if(temp == "("){
							s.push("(");
							break;
						}
							post += temp+" ";
					
					}
					s.push(ch); 
					break;
					
				//如果是'*'或'/'，则弹出所有序列，直到碰到'+'，'-'，'('为止，最后将操作符压入栈中
				case "*":
				case "/":
					while(s.size() != 0){
						temp = s.pop();
						if(temp == "+" || temp == "-" || temp == "("){
							s.push(temp);
							break;
						}
						else{
							post += temp+" ";
						}
					}
					s.push(ch);
					break;
					
				//如果碰到的是右括号，则距离栈顶的第一个左括号上面的所有运算符弹出栈并抛弃左括号
				case ")":
					while ((temp = s.pop()) != ")") {
						post += temp;
					} 
					
					while(!s.isEmpty()){
						temp = s.pop();
						if(temp == "("){
							break;
						}
						else{
							post += temp+" ";
						}
					}
					break;
				//默认情况，如果读取到的是数字，则直接送至输出序列	
				default:
					post += ch+" ";
					break;
				}
			}
			//如果堆栈不为空，则把剩余运算符一次弹出，送至输出序列
			while(s.size() != 0){
				post += s.pop();
			}
			
			return post;
			
		}
}
