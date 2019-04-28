package javaAssignment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] expression = new String[100];//将文件读取的表达式存在字符串数组里
		String [] expression1 = new String[100];
		String [] result = new String[100];//结果保存
		boolean [] tf= new boolean[100];//保存判断表达式是否正确
		ReadFile read = new ReadFile();
		read.Read(expression);//读文件
		read.Read(expression1);
		Reapet reapet = new Reapet();
		reapet.stringReapet(expression, tf, result);//开始执行操作
		WriteFile writer = new WriteFile();
		writer.write(expression1, result);//写入结果
	}

}
