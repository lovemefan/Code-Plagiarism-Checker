
public class Main {
	public static void main(String[] args) throws Exception {
		Stack<String> stack = new Stack<>();
		Regular str = new Regular();
		str.setRegular(Files.readFile());
		String[] s1 = str.getString(str.getRegular());
		String[] s2 = str.dealString(s1);
		String result = "";
        for(int i = 0; i< s2.length; i ++){
        	if(s2[i].contains("E") == true){
        		result += s2[i];
        	}
        	else{
        		Infix infix = new Infix(stack, s2[i]);
        		infix.process();
        		String post = infix.getPost();
        		Stack<Integer> stack_result = new Stack<Integer>();
        		Result ptr = new Result(post, stack_result);
        		ptr.operate();
        		int d = ptr.getResult();
        		result += s2[i] + " = " + d +"\r\n"; //TXT文件\r\n换行
        	}
        }
        Files.writeFile(result);
	}

}
