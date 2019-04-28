import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class midToLater {
	private List<String> laterList = new ArrayList<String>();
	private Stack<String> stack = new Stack<String>();
	
	final String regEx1 = "[\\/\\*]";//Ϊ�˽���Ȧ���Ӷ� ����������ʽ
	final String regEx2 = "[\\+\\-]";
	Pattern pattern1 = Pattern.compile(regEx1);
	Pattern pattern2 = Pattern.compile(regEx2);
	
	public midToLater() {

	}
	/*
	public void inStack1(){//��һ����ջ���� ��ջ ֱ������������ 
		while (!(stack.peek().equals("("))) {
			laterList.add(stack.pop());
			if (stack.isEmpty()) {
				return ;
			}
		}
	}*/
	
	public void inStack1(){//��һ����ջ���� ��ջ ֱ������������ 
		while (!(stack.isEmpty())&&!(stack.peek().equals("("))) {
			laterList.add(stack.pop());
		}
	}
		
	public void inStack2() {//��ջ��Ԫ��ȫ����ջ
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
			} else if (/*temp.equals("*") || temp.equals("/")*/b1) {//Ϊ�˽���Ȧ���Ӷ� ����������ʽ
				stack.push(temp);
			} else if (/*temp.equals("+") || temp.equals("-")*/b2) {//Ϊ�˽���Ȧ���Ӷ� ����������ʽ
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
