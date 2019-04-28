package ooExperiment2;


import java.util.Stack;

public class Main {
	public static void main(String[] ages) {

		deals(); //调用deal()方法

	}

	public static void deals()  {

		Io io = new Io();   //创建Io类对象io
		Check check = new Check();   //创建Check类对象check
        
		//读取文件中的数学表达式
		while (io.getHasNextLine()) {
			String express = io.getNextLine();
			String exp = deal(express);   //调用deal()方法进行表达式预处理
			String b = check.match(exp);  //调用Check类中match()方法进行表达式的验证
			if (b.equals("true")) {
				Stack<String> stack = new Stack<String>(); // 创建栈，栈内存字符串
				String post = "";

				InfixToPost inf = new InfixToPost(stack, post);   //创建InfixToPost类 对象inf
				inf.process(exp);                                 //调用InfixToPost类中的process()方法，将中缀表达式转化为后缀 表达式

				Stack<Integer> stack_result = new Stack<>();      //创建栈，存放后缀表达式
				PostToResult pos = new PostToResult(stack_result);//创建PostToResult类对象pos
				pos.operate(inf);                                 //调用PostToResult类中的operate()方法，用后缀表达式计算表达式

				io.getAns(exp + " = " + String.valueOf(pos.getResult())+"\n");  //将表达式及结果输出到文件中
			}else{
				io.getAns(b+"\n");                                           //将错误的表示式内容输出到文件中
			}

		}

	}

	// 预处理将数字与运算符隔开
	public static String deal(String express) {
		String exp = "";

		for (int i = 0; i < express.length() - 1; i++) { // 只能到倒数第二个
			char temp1 = express.charAt(i);// 将字符串中的字符分离出来

			char temp2 = express.charAt(i + 1);

			if (isDigital(temp1) && isDigital(temp2)) { // 判断是否是多位数
				exp += temp1;
			} else {
				exp += temp1 + " ";
			}
		}
		exp += express.charAt(express.length() - 1);// 最后一个字符跳出
		return exp;
	}

	// 判断是否是数字
	public static boolean isDigital(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		} else {
			return false;
		}
	}

}
