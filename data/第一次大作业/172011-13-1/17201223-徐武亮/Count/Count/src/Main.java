import java.io.*;
import java.util.*;

public class Main {
	static Operate ope = new Operate();


	public static void main(String[] args) throws Exception{
		String[] str=delete();//得到删除空格和重复表达式的表达式数组
		Scanner input = new Scanner(System.in);
		System.out.println("请输入保存输出结果的文件的绝对路径：");
		String path1 = input.nextLine();
		File file = new File(path1);
		PrintWriter output = new PrintWriter(file);
		ope.checkout();
		String[] resul = ope.getresult();//得到表达式结果
		boolean[] corre = ope.getcorrect();
		for (int i=0 ;i<str.length ; i++){//写入文件中
			if (corre[i] ==  false){
				output.println(str[i]);
				output.println("ERROR");
				output.println("#"+resul[i]);
				output.println("========================================================================================================================================");
			}
			else{
				output.println(resul[i]);
				output.println("========================================================================================================================================");
			}	
			
		}
		output.close();
	}
	
	public static String[] in() throws Exception{//导入表达式文件
		
		Scanner input = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		System.out.println("请输入要导入的表达式文件的绝对路径：");
		String path = input.nextLine();
		File file = new File(path);
		Scanner in = new Scanner(file);
		while (in.hasNextLine()){//读取文件
			String a = in.nextLine();
			String b = a.replace(" ","");//去掉表达式里的空格
			list.add(b);//将去掉空格后的表达式加到列表中
		} 
		String[] str1 = new String[list.size()];
		str1 =  list.toArray(str1);
		in.close();  
		return str1;
	}  
	
	public static String[] delete()throws Exception{//用来去掉重复的表达式
		String[] str2=null ;
		str2 = in();
		TreeSet<String> tr = new TreeSet<String>();//TreeSet类中没有重复的，将表达式加入可去重复
		String[] str3=null;
		
		for (int i=0;i<str2.length;i++){
			tr.add(str2[i]);
		}
		str3 = new String[tr.size()];
		for (int j=0;j<str3.length;j++){//得到没有重复表达式的字符串数组
			str3[j]=tr.pollFirst();
		}
		String[] str4 = new String[str3.length];
		for (int j=0;j<str3.length;j++){//将每个表达式加#用于计算
		str4[j]=str3[j]+"#";
		}
		ope.set(str4);
		return str3;
	}
	

}
