import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		FileRead f = new FileRead("expression.txt");
		String[] temp = new String[1000];//储存从文件读取的表达式
		String[]  outcome= new String[1000];//储存结果信息
		int n = 0;
		int m = 0;
		double result = 0;
		
		temp = f.readFile();
		while(temp[n] != null){
			outcome[n] = temp[n];
			VerifyExpression a = new VerifyExpression(temp[n]);//创建正则校验类对象
			if (a.judgeverifyExpression()){
		 	   String str = temp[n];
		 	  ToPostfix t = new ToPostfix();//创建中缀转后缀类对象
		 	  result = t.toPostfix(temp[n]);
		 	 outcome[m++] =temp[n]+ " = " + result+"\n\t";
			   System.out.println(temp[n]+ " = " + result+"\n\t");//在控制台打印结果
		    }
			else{
				outcome[m++] =a.s;
				System.out.println(a.s);//在控制台打印结果
			}
			n ++;
		}
		FileInput in = new FileInput();//new一个文件输入类对象
		in.fileInput("result.txt", outcome, m);//将储存的信息存入result.txt文件
	}
}

