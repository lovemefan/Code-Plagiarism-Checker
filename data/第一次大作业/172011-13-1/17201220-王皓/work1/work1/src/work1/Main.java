package work1;

import java.util.Scanner;

public class Main {
	private static String a;
	private static String w;
	public static void main(String args[]) throws Exception {
		java.io.File file = new java.io.File("count.txt");//读取文件
		java.io.File file1 = new java.io.File("result.txt");//写入文件
		Scanner input = new Scanner(file);
		java.io.PrintWriter output = new java.io.PrintWriter(file1);
		while (input.hasNext()){			
			a = input.nextLine();
			String b = "";			
			String[] c = a.split(" ");//去空格
			for (int i = 0;i < c.length;i ++){
				b = b + c[i];
			}
			Check ss = new Check(b);
			String ans = ss.judge(b);
			
			if(!ans.equals(""))
				output.println(ans);
			else{
	        Stack<String> stack = new Stack<>();
	        InfixToPost infix = new InfixToPost(stack, b);
	        infix.process();
	        String post = infix.getPost();
	        Stack<Integer> stack_result = new Stack<>();
	        PostToResult ptr = new PostToResult(post, stack_result);
	        ptr.operate();
	        w = b + "=" + ptr.getResult();
	        output.println(w);
	                
	     }	
		}
		output.close();	
		input.close();
			      		   
	}
		
}
