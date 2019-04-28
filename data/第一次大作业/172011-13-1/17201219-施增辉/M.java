import java.util.Scanner;
import java.io.IOException;;

public class M {
	public static void main(String[] args) throws IOException {
		
		java.io.File file = new java.io.File("text.txt");//从文件中读取表达式
		Scanner input = new Scanner(file);
		java.io.File file1 = new java.io.File("text1.txt");//向文件存入结果
		java.io.PrintWriter output = new java.io.PrintWriter(file1);	
		System.out.println("结果已存入文件中...");
		
		while(input.hasNext()){
			String m = input.nextLine();
			String q = "";
			String[] n = m.split(" ");
			for(int i=0;i<n.length;i++){
				q = q + n[i];
			}
			W e = new W(q);
		
			switch(e.pan()){
				case 0:Stack<String> stack = new Stack<>();
				   Zhan1 a = new Zhan1(stack, q);
				   a.process();
				   String b = a.getPost();
				   Stack<Integer> stack_result = new Stack<>();
				   Zhan2 c = new Zhan2(b, stack_result);
				   c.operate();
				   output.println(q + "=" + c.getResult());break;
				case 2:output.println("ERROR");
				   output.println("#运算符连续");
				   break;
				case 3:output.println("ERROR");
				   output.println("#空括号");
				   break;
				case 4:output.println("ERROR");
				   output.println("#括号不配对");
				   break;
				case 5:output.println("ERROR");
				   output.println("#（后是运算符");
				   break;
				case 6:output.println("ERROR");
				   output.println("#）前是运算符");
				   break;
				case 7:output.println("ERROR");
				   output.println("#（前不是运算符");
				   break;
				case 8:output.println("ERROR");
				   output.println("#）后不是运算符");
				   break;
				case 9:output.println("ERROR");
				   output.println("#表达式含有非法字符");
				   break;
				case 10:output.println("ERROR");
				   output.println("0,+,-,*,/在最前");
				   break;
				default:System.exit(1);
			}
			
		}
		
		input.close();
		output.close();
	}
}
