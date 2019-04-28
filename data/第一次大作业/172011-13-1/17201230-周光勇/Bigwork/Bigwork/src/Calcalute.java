import java.util.ArrayList;
import java.util.Stack;

public class Calcalute {
	static ArrayList getStringList(String str) {
		ArrayList<String> result = new ArrayList<String>();
		String num = "";
		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))){
				num = num + str.charAt(i);
				}
			else  {
				if(num != ""){
					result.add(num);
					}			
				result.add(str.charAt(i) + "");
				num = "";
				}
			}
		if(num != ""){
			result.add(num);
			}
		return result;
	}
	static int calculate(ArrayList<String> list) {
		Stack stack = new Stack();
		for (int i = 0; i < list.size(); i++) {
			if (Character.isDigit(list.get(i).charAt(0))) {
				stack.push(Integer.parseInt(list.get(i)));
			} else {
					int a=(int) stack.pop();
				 	int b = (int) stack.pop();
				 int res = 0;
				switch (list.get(i).charAt(0)) {
				case '+':
					res = a+b;
					break;
				case '-':
					res = b-a;
					break;
				case '*':
					res = a*b;
					break;
				case '/':
					res = a/b;
					break;
				}
				stack.push(res);
			}
		}
		return   (int) stack.pop();
	}
	 
	static ArrayList getPostOrder(ArrayList<String> List) {
		ArrayList<String> result = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < List.size(); i++) {
			if (Character.isDigit(List.get(i).charAt(0))) {// 判断是否是数字，是数字则直接输出
				result.add(List.get(i));
			} else {
				switch (List.get(i).charAt(0)) {// 不是数字判断是什么运算符
				case '(':
					stack.push(List.get(i));
					break;
				case ')':
					while (!stack.peek().equals("(")) {
						result.add(stack.pop());
					}
					stack.pop();
					break;
				default:
					while (!stack.isEmpty() && compare(stack.peek(), List.get(i))) {
						result.add(stack.pop());
					}
					stack.push(List.get(i));
					break;
				}
			}
		}
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		return result;
	}

	 static boolean compare(String peek, String cur) {
		if("*".equals(peek) && ("/".equals(cur) || "*".equals(cur) ||"+".equals(cur) ||"-".equals(cur))){	
 			return true;	
 			}
 		else if("/".equals(peek) && ("/".equals(cur) || "*".equals(cur) ||"+".equals(cur) ||"-".equals(cur))){
 			return true;
 			}
 		else if("+".equals(peek) && ("+".equals(cur) || "-".equals(cur))){	
 			return true;
 			}
 		else if("-".equals(peek) && ("+".equals(cur) || "-".equals(cur))){			
 			return true;
 			}
 		return false;	
	}
}
