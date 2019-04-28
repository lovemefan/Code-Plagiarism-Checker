package homeWork;
import java.util.Scanner;
import java.io.*;
public class Caculator {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		String string1="";
		String result="";
		File file_1=new File("expression.txt");//表达式文件
		File file_2=new File("result.txt");//结果文件
		deleteTxt(file_2);//清空文件
		boolean temp_1=false;
		int temp_2=0;
		ComputeExpression getResult=new ComputeExpression();//计算表达式获得结果
		LegalExamine object_1=new LegalExamine();//合法性检验
		FileOutputStream output_2=new FileOutputStream(file_2,true);//在文件末尾追加内容
		ExpressionStack arrayTemp=inputExpressionFile(file_1);//读取文件并过滤已计算的表达式
		for(int i=0;i<=arrayTemp.size;i++) {
			output_2=new FileOutputStream(file_2,true);
			string1=arrayTemp.stack[i];
			temp_1=object_1.examine(string1, output_2);//判断合法性
			if(temp_1)
				continue;
			result=getResult.copmpute(string1);
			String string2=string1+"="+result+"\n";
			output_2.write(string2.getBytes());//写入文件,(将字符串转为数组)
			output_2.close();
			}//for
		print(file_2,output_2);//输出结果
	}
	
	private static void print(File file_2,FileOutputStream output_2) throws IOException {//输出结果
		String result="";
		try(
				Scanner input_2=new Scanner(file_2);	
		){
			while(input_2.hasNextLine()) {
				result=input_2.nextLine();
				System.out.println(result);
			}
		}
	}
	
	private static void deleteTxt(File file_2) throws IOException {
		FileOutputStream output_2=new FileOutputStream(file_2,false);//在文件末尾追加内容
		output_2=new FileOutputStream(file_2,false);
		output_2.write("".getBytes());//清空
		output_2.close();
	}
	
	private static ExpressionStack inputExpressionFile(File file_1) throws IOException {
		ExpressionStack arrayTemp=new ExpressionStack();
		LegalExamine object_1=new LegalExamine();//合法性检验
		String string="";
		int temp_2=0;
		try(
				Scanner input_1=new Scanner(file_1);
		){
			while(input_1.hasNextLine()) {
				string=input_1.nextLine();
				string=string.replace(" ","");//去空格
				temp_2=object_1.deleteSameExpression(arrayTemp, string, temp_2);//过滤已计算的表达式
				if(temp_2>0)
					continue;
				arrayTemp.push(string);
			}
		}
		return arrayTemp;
	}
}
