package tt;

public class ExpressionFile {
	
	String RPN;
	double result;
	//�����еı��ʽ�����Ҫ����ʽд���ļ���
	public void write(String[] s) throws Exception {
		  java.io.File file = new java.io.File("src\\result"); /*�ļ���ַ*/
		  int i = 0;
		  java.io.PrintWriter output = new java.io.PrintWriter(file);
		while(s[i]!=null)  {
		  output.println(s[i]);
		i++;
		} 
		output.close();
	}

	//����ÿһ�����ʽ�Ľ����������ʽһ�𷵻ص�һ������
	public String expsToAllexps(String exp){
	exp.replace(" ", "");
	exp = exp.replace("(-", "(0-");// �ڼ���ǰ��Ӹ�0
	if (exp.charAt(0) == '-')
		exp = "0" + exp;
//	if()
	
	CheckStr s = new CheckStr(exp);
	if (s.judgeAll()) {
		GetResult a = new GetResult();
		RPN = a.RPN(exp);
		result = a.calculateResult(RPN);
		exp = exp + "=" + result;
	} 
	else {
		String a = s.error();
		exp = exp +"\n"+ a;
	}
		return exp;
	}
}
