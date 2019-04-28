
public class Main {
	public static void main(String[] args) throws Exception {
	String s = FileOperate.readFile();//读取文件
	s = s.replaceAll(" ", "");
	Check a = new Check();
	String[] firstStr = s.split("\\n");
	String[] str = Check.delete(firstStr);
	
	Stack<String> stack = new Stack<>();//创建一个存储字符的栈
	  for(int i = 0; i < str.length ; i ++){
		 a.setStr(str[i]);
		 a.check(str[i]);
		 if(a.getStr().contains("E") == false){
			 Convert infix = new Convert(stack,str[i]);		     
		     infix.process();//转译为后缀表达式
		     String post = infix.getPost();//去掉多余空格符
		     
	         Stack<Integer> stack_result = new Stack<>();//创建一个储存结果的栈
	         Result ptr = new Result(post,stack_result);
	         ptr.operate();//直接计算数学表达式结果
	         
	         FileOperate.writeFile("D:\\result.txt",str[i] + "=" +ptr.getResult());//得到结果
		 } else{
		FileOperate.writeFile("D:\\result.txt",a.getStr());//错误表达式
	     
	  }
    }
  }
}
