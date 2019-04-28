package BigWork;
import java.io.*;
import java.util.Scanner;

public class BigWork {
	public static void main(String[] args) throws FileNotFoundException{
		//创建一个文件对象
		File file = new File();
		//定义数组大小为文件行数
		String[] arrny = new String[file.numFile()];
		String[] instands = new String[file.numFile()];
		double[] fianlSum = new double[file.numFile()];
		//把文件读入数组
		arrny = file.readFile();
		//创建一个检验对象
		Check checks = new Check(arrny);
		//对数组里的表达式进行验证并返回一个代标记的数组
		arrny = checks.checked(arrny);
		//遍历数组
		for(int i = 0;i < arrny.length;i ++){
			//如果这个数组被标记，就直接输出
			if(arrny[i].matches("ERROR\\r\\n.*")){
				continue;
			}
			//没有标记的话就得出结果，并输出
			else{
				InfixToPost infixToPost = new InfixToPost(arrny[i]);
				instands[i] = infixToPost.change();
				PostToResult postToResult = new PostToResult(instands[i]);
				fianlSum[i] = postToResult.result(instands[i]);
				if(fianlSum[i] == Double.NEGATIVE_INFINITY || fianlSum[i] == Double.POSITIVE_INFINITY){
					arrny[i] = "ERROR\r\n#除数不能为零";
					continue;
				}
				arrny[i] = arrny[i] + " = " + fianlSum[i];
			}
		}
		//将数据写入文件
		file.writeFile(arrny);
	}
}
