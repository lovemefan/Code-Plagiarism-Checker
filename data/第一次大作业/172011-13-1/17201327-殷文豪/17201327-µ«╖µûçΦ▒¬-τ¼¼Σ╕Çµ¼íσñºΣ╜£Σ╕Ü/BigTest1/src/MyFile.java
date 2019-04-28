import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

//文件类
public class MyFile {
	private Regex[] infix;//Regex对象数组
	private String inputName;//读入表达式的文件路径
	private String outputName;//输出的文件路径
	private int n;//要读入的表达式的数量
	
	//构造方法
	public MyFile() {
		
	}
	
	//重载构造方法
	public MyFile(String inputName,String outputName,int n) {
		this.inputName = inputName;
		this.outputName = outputName;
		this.n = n;
		//初始化创建对象数组大小
		this.infix = new Regex[this.n];
	}
	
	//读取方法
	public void input() throws IOException {
		File file = new File(inputName);
		//文件不存在则创建文件
		if (!file.exists()) {
			System.out.println("该文件不存在,已创建");
			file.createNewFile();
		}
		Scanner enter = new Scanner(file);
		int i = 0;
		//从文件读入中缀表达式数据
		while (enter.hasNext() && i < infix.length) {
			infix[i] = new Regex(enter.nextLine());
			infix[i].check();//检查表达式
			//遍历与前面的表达式作比较
			for (int j = 0;j < i;j ++) {
				//之前有相同的就使这个表达式为空
				if (infix[i].getInfix().equals(infix[j].getInfix())) {
					infix[i].setInfix("");
				}
			}
			i ++;
		}
		enter.close();
	}
	
	//输出方法
	public void output() throws IOException {
		File file = new File(outputName);
		PrintWriter export = new PrintWriter(file);
		for (int i = 0;i < infix.length;i ++) {
			if (infix[i] != null) {
				//表达式错误
				if (!infix[i].isCorrect()) {
					export.println(infix[i].getError());
				}
				//表达式不为空
				else if (!infix[i].getInfix().equals("")) {
					PostfixCompute post = new PostfixCompute(infix[i].getInfix());
					//判断除数是否为零
					if (post.getResult() == Double.POSITIVE_INFINITY || post.getResult() == Double.NEGATIVE_INFINITY 
							|| post.getResult() == Double.NaN) {
						export.println("ERROR\r\n#除数为0");
					}
					else {
						export.println(infix[i].getInfix() + "=" + post.getResult());
					}
				}
			}
		}
		export.close();
	}
	
}
