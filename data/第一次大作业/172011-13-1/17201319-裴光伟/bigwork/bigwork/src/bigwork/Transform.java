package bigwork;

import java.util.Scanner;

public class Transform {
	// 将从文件中获得的表达式转换成固定格式
		public static String transformExp(String exp) {
			String exp2 = "";
			if(!RegularExpression.errorPan(exp)){
				for (int i = 0; i < exp.length() - 1; i++) {// 将字符串中的表达式转换为固定形式
					char p = exp.charAt(i);
					char q = exp.charAt(i + 1);
					if (Character.isDigit(q) && Character.isDigit(p))// 如果为连续数字则不要空格
						exp2 = exp2 + p;
					else
						exp2 = exp2 + p + " ";
				}
				exp2 = exp2 + exp.charAt(exp.length() - 1);// 将最后的字符输入到新的字符串
			}
			else
				exp2 = exp;
			return exp2;
		}
		
		//将字符串的空格去掉
		public static String transformNoBlank(String exp){
			String exp1 = "";
			Scanner input = new Scanner(exp);
			while (input.hasNext()) {// 将文件中的表达式存入字符串
				exp1 += input.next();
			}
			input.close();
			return exp1;
		}

		// 将中缀表达式转换成后缀表达式
		public static String transformExpLast(String exp) {
			Stack stack = new Stack(new Node(), new Node());// 建立节点为空的栈
			Scanner input = new Scanner(exp);
			Queue q = new Queue(100);
			String exp1 = null;
			if(!RegularExpression.errorPan(exp)){
				while (input.hasNext()) {
					inStack(input, q, stack);
				}
				input.close();
				while (stack.getStackBottom() != stack.getStackTop()) {// 将栈中剩余的运算符输入到队列
					Queue.inLine(q, stack.outTopStack() + " ");
				}
				exp1 = Queue.queueToStr(q);// 将队列输出到字符串中
			}
			else
				exp1 = exp;
			
			return exp1;
		}
		
		//入栈操作
		public static void inStack(Scanner input, Queue q,Stack stack){
			String ch = input.next();// 判断是否为数字
			boolean pan = ch.matches("\\d*");
			if (pan)// 如果为数字则将其输入队列
				Queue.inLine(q, ch + " ");
			else {
				switch (ch) {
				case "+":
					pan(stack, 2, '+', q);
					break;
				case "-":
					pan(stack, 2, '-', q);
					break;
				case "*":
					pan(stack, 3, '*', q);
					break;
				case "/":
					pan(stack, 3, '/', q);
					break;
				case "(":
					pan(stack, 1, '(', q);
					break;
				case ")":
					pan(stack, 4, ')', q);
					break;
				}
			}
		}
		
		// 运算符的存入栈的规则
		public static void pan(Stack stack, int topdata, char ch, Queue q) {
			if (topdata == 4) {// 为右括号将左括号之前的运算符存入队列
				while (stack.getStackTop().gettopData() != 1 && stack.getStackBottom() != stack.getStackTop())
					Queue.inLine(q, stack.outTopStack() + " ");
				stack.outTopStack();// 将左括号丢弃
			} else if (topdata == 1)
				stack.printStack(ch, topdata);// 为左括号直接入栈
			
			
			else if (topdata > stack.getStackTop().gettopData()) {
				stack.printStack(ch, topdata);// 输入运算符优先级高于栈顶直接输入
			} else {
				Queue.inLine(q, stack.outTopStack() + " ");// 优先级低则将栈顶输出并存入队列
				if (topdata <= stack.getStackTop().gettopData())// 与新的栈顶判断优先级
					Queue.inLine(q, stack.outTopStack() + " ");
				stack.printStack(ch, topdata);
			}

		}
}
