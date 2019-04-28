
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calculate{
	public void Calculate(){
		
	}
	
	
	 // 实现计算操作	
	public static float Calculate(String str) {
		float op1 = 0;// 记录出栈数字
		float op2 = 0;// 记录出栈数字
		float result = 0;// 记录运算结果
		Stack<String> stack = new Stack();// 创建栈对象

		String[] arr = str.split(" ");// 对传入的字符串通过空格进行分割，并传入数组

		for (int i = 0; i < arr.length; i++) {
			// 对字符进行判断，如果为数字，则入栈；如果为运算符，则进行运算。

			if (arr[i].matches(".*[\\d].*")) {
				stack.push(arr[i]);
			}

			else if (arr[i].matches(".*[\\+\\-\\*\\/].*")) {
				op2 = Float.parseFloat(stack.pop());
				op1 = Float.parseFloat(stack.pop());
				// 根据运算符，选择合适的运算
				if (arr[i].matches(".*[\\+].*")) {
					result = op1 + op2;
					
					stack.push(result + "");
				}

				else if (arr[i].matches(".*[\\-].*")) {
					result = op1 - op2;
					
					stack.push(result + "");
				}

				else if (arr[i].matches(".*[\\*].*")) {
					result = op1 * op2;
					
					stack.push(result + "");
				}

				else if (arr[i].matches(".*[\\/].*")) {
					result = op1 / op2;
					
					stack.push(result + "");
				}

			}
		}
		result = Float.parseFloat(stack.pop());
		return result;
	}
}