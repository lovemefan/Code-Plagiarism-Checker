package bighomework;

import java.io.FileNotFoundException;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		outPut();
	}

	public static void outPut() throws FileNotFoundException {
		File file1 = new File();
		Calculate cal1 = new Calculate();
		String[] Except = new String[1000];
		Except = file1.OutputFile();// 从文件中获取的表达式
		System.out.println("文件读取完成");
		Check check1 = new Check();
		String[] Except1 = new String[1000];// 除去空格后的字符串
		String[] Except3 = new String[1000];// 最后得出结果的字符串

		int a = 0;
		for (int i = 0; Except[i] != null; i++) {
			Except1[i] = check1.cleanBlank(Except[i]);// 出去字符串中的空格
			int y = Except1[i].length();
//			System.out.println(Except1[i]);
//			System.out.println(y);
			String Except2 = check1.addBlank(Except1[i]);// 用空格将数字和运算符分开
			String Except4 = check1.Judge(Except2);// 校验字符串
			int x = Cheat(Except1[i], i, Except1);//判断字符串是否重复
			if(y==0){
				Except3[i] = "s0";//空字符
		        a++;
			}
			else if (Except4.equals("s1")) {
				Except3[i] = "s1";//括号
				a++;
			} else if (Except4.equals("s2")) {
				Except3[i] = "s2";//0
				a++;
			} else if (x == 1) {
				Except3[i] = "s5";//#表达式重复输入";
				a++;
			} 
			else if(Except4.equals("s4")){
				Except3[i] = "s4";//非法字符
				a++;
			}	
			else if(Except4.equals("s3")){
				Except3[i] = "s3";//格式
				a++;
			}	
			else {
			
				Except3[i] = cal1.Cal(Except4);// 计算返回结果
				a++;
			}
		}
		file1.InputFile1(Except1, Except3, a);// 将原表达式，结果，表达式的个数传入函数
		System.out.println("文件写入完成，请在文件中查看");
	}

	public static int Cheat(String s, int x, String[] s1) {
		int m = 0;
		for (int i = 0; i < x; i++) {
			if (s.equals(s1[i])) {
				m = 1;
			} else {
				continue;
			}

		}
		return m;

	}
}
