
public class Main {
	public static void main(String[] agrs) throws Exception {
		File_IO file;
		Judge judge;
		file = new File_IO();
		String[] post = file.FileI();// 数组post接收文件里的各个表达式
		judge = new Judge(post);// 将post导入判断类中
		for (int i = 0; post[i] != null; i++) {
			judge.Judge1();// 调用judge判断正确性并转换计算
			System.out.println(judge.output[i]);// 打印结果
		}
		file.FileO(judge.output);// 将运算结果导入文件中
	}
}
