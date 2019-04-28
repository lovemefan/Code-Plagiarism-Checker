package 大作业;
/**
 * 
 * @author 刘润石
 * 
 */
import java.util.Stack;

import 大作业.InfixToPostfix;
import 大作业.Examine;
import 大作业.Io;
import 大作业.PostfixToResult;

public class Main {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		Io o = new Io();
		String accept = o.fileReader();
		accept = accept.replaceAll(" ", "");//把接收到的运算符空格都去掉
		String regex = "\\s";
		String[] input = accept.split(regex);//把收到的多个运算式进行分割存入字符串数组中
		String re = "";
		String err = "";
		String rep = "";
		int j = 0;
		Examine[] exa = new Examine[input.length];
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
			if (i>0){//进行排重复的运算式
				if(input[i].equals(input[i-1])){
					System.out.println("ERROR\n#输入重复");
					rep = input[i] + "=" + "\r\n" + "ERROR\r\n#输入重复";
					j++;
				}
			}
			if(j==0){//如果重复直接跳过以下判断
				exa[i] = new Examine(input[i]);
				exa[i].examine(input[i]);
				if (exa[i].flag ) {
					InfixToPostfix infix = new InfixToPostfix(stack, input[i]);
					infix.change();
					String post = infix.getPost();
					Stack<Double> postResult = new Stack<>();
					PostfixToResult res = new PostfixToResult(post, postResult);
					res.operate();
					String  result = String.valueOf(res.getResult());
					res.denominator(result);
					re = input[i] + "=" + res.denominator(result) + " ";
					System.out.println(re);
				}else{
					err = input[i] + "=" + "\r\n" + exa[i].say[exa[i].i];
				}
			}
			
			String all = rep + re + err;
			String[] res = all.split(" ");
			Io io = new Io(res);
			io.fileWiter();
			re = "";//把这三个字符串进行初始化
			err = "";
			rep = "";
			j=0;//把j归为0
		}
	}
}
