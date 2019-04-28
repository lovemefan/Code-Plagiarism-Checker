import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class text {
	static String[] array = new String[500];
	static int flag = 0;
	
	public static void getArray(String s){
		array[flag] = s;
		flag++;
	}
	public static boolean Check(String s){
		for(int i = flag - 1; i > 0; i--){
			if(s.equals(array[i-1])){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{		//主函数，抛出异常
		
		calculator cal = new calculator();
		panDuan pd = new panDuan();
		file f = new file();
		File fp1 = new File("GS.txt");		//创建新的文本
		File fp2 = new File("GSR.txt");		//处理后的式子写入路径

		Scanner input = new Scanner(fp1);	//实例化新的文件对象
		PrintWriter fp = new PrintWriter(fp2);
	
		//若GSR.txt文件已经存在，则删除文件
		if(fp2.exists() && fp2.isFile()){
			fp2.delete();
		}	

		while(input.hasNext()){	//循环读取文本内容
			String s1 = input.nextLine(); //读取式子
			if(s1.length() == 0)
				continue;
			String check = s1.replaceAll(" ","");//去除字符串里的空格	
			getArray(s1);
			
			
				
						if(Check(check) == true){
							String result2 = check+" = "+"\r\n"+"	ERROR!"+"\r\n"+"	#输入的这个式子再次重复出现，系统自动过滤！";
							fp.println(result2);	
							System.out.println("重复");	
							continue;
						}
					 
				 		else if(pd.judge1(check) && pd.judge2(check) && pd.judge3(check) && pd.judge4(check) ){
				 
				 			String result = check+" = "+cal.compute(cal.toBack(check));
				 
				 			fp.println(result);		//写入结果进入文件
				 		}
				 		else{					//if-else 调用函数，对读取到的文本式子进行判断
							
							String result = check+" = "+"\r\n"+"	ERROR!"+"\r\n"+pd.getError() ;	//弹出错误
							fp.println(result);			//写入文件
							}
				 }
			

		f.outPut();	
		fp.close();		//关闭文件流
		input.close();

	
	}	
	
}
