public class ExpressionFile {

	//String[] RPNs = new String[1000];
		String RPN;
		double result;
		//把所有的表达式的最后要求形式一个一个写在文件上
		public void write(String[] s) throws Exception {
			  java.io.File file = new java.io.File("result.txt"); 
			  int i = 0;
			  java.io.PrintWriter output = new java.io.PrintWriter(file);
			while(s[i]!=null)  {
			  output.println(s[i]);
			i++;
			} 
			output.close();
		}

		//计算每一个表达式的结果，并与表达式一起返回的一个方法
		public String expsToAllexps(String exp){
		exp.replace(" ", "");
		exp = exp.replace("(-", "(0-");// 在减号前面加个0
		if (exp.charAt(0) == '-')
			exp = "0" + exp;		
		CheckStr s = new CheckStr(exp);
		if (s.judgeAll()) {
			GetResult a = new GetResult();
			RPN = a.RPN(exp);
			result = a.calculateResult(RPN);
			exp = exp + "=" + result;
		} 
		else {
			String a = s.error();
			exp = exp + a;
		}
			return exp;
		}
}