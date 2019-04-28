package demo;

public class ExpressionFile {
	String EXP;
	double result;
	//把所有的表达式按要求形式写在文件上
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
	public String ToAllexps(String exp){
		
	exp.replace(" ", "");
	CheckStr s = new CheckStr(exp);
	if (s.judgeAll()) {
		GetResult a = new GetResult();
		EXP = a.EXP(exp);
		result = a.calculate(EXP);
		exp = exp + "=" + result;
	} 
	else {
		String a = s.error();
		exp = exp + "\r\n" +a;
	}
		return exp;
	}
}
