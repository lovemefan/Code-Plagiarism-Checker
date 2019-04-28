import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class midToLater {
	private List<String> laterList = new ArrayList<String>();
	private Stack<String> stack = new Stack<String>();
	
	final String regEx1 = "[\\/\\*]";//为了降低圈复杂度 改用正则表达式
	final String regEx2 = "[\\+\\-]";
	Pattern pattern1 = Pattern.compile(regEx1);
	Pattern pattern2 = Pattern.compile(regEx2);
	
	public midToLater() {

	}
	/*
	public void inStack1(){//第一个入栈函数 入栈 直到遇见左括号 
		while (!(stack.peek().equals("("))) {
			laterList.add(stack.pop());
			if (stack.isEmpty()) {
				return ;
			}
		}
	}*/
	
	public void inStack1(){//第一个入栈函数 入栈 直到遇见左括号 
		while (!(stack.isEmpty())&&!(stack.peek().equals("("))) {
			laterList.add(stack.pop());
		}
	}
		
	public void inStack2() {//将栈中元素全部出栈
		while (!stack.isEmpty()) {
			laterList.add(stack.pop());
		}
	}
	
	public List<String> midToLater(List<String> list) {
		
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			Matcher matcher1 = pattern1.matcher(temp);
			Matcher matcher2 = pattern2.matcher(temp);
			boolean b1 = matcher1.find();
			boolean b2 = matcher2.find();
			
			if (temp.equals("(")) {
				stack.push(temp);
			} else if (/*temp.equals("*") || temp.equals("/")*/b1) {//为了降低圈复杂度 改用正则表达式
				stack.push(temp);
			} else if (/*temp.equals("+") || temp.equals("-")*/b2) {//为了降低圈复杂度 改用正则表达式
				if (!stack.isEmpty()) {/*
					while (!(stack.peek().equals("("))) {
						laterList.add(stack.pop());
						if (stack.isEmpty()) {
							break;
						}
					}*/
					inStack1();
				}
				stack.push(temp);
			}	else if (temp.equals(")")) {
				/*
				while (!stack.peek().equals("(")) {
					laterList.add(stack.pop());
				}*/
				inStack1();
				stack.pop();
			} else {
				laterList.add(temp);
			}
			/*
			if (i == list.size() - 1) {
				
				while (!stack.isEmpty()) {
					laterList.add(stack.pop());
				}
			}*/
		}
		/*
		while (!stack.isEmpty()) {
			laterList.add(stack.pop());
		}*/
		inStack2();
		/*
		 * for(int i=0;i<laterList.size();i++){
		 * System.out.print(laterList.get(i)+" "); }
		 */
		return laterList;
	}

}
