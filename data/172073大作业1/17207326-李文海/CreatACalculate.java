import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class CreatACalculate {
	public static void main(String[] args) throws FileNotFoundException {
		int i=0,j=0;
		CountTheExpress  trans=new CountTheExpress();
		RegularExpression regex=new RegularExpression();
		File f = new File("src\\express");
		File f1 = new File("src\\reslut");
		PrintWriter output = new PrintWriter(f1);
		String exper[]=new String[1000];
		Scanner input = new Scanner(f);
			while(input.hasNext()) {
				exper[i]=input.nextLine();
				exper[i]=exper[i].replaceAll(" ","");
				i++;		
			}
			String	s1[]=regex.deleSameFile(exper,i);
			j=0;
			while (j<s1.length) {				
				if (!regex.regex(s1[j],f1,output)) {			
					output.println(s1[j]+" = "+trans.Trans(s1[j]+"#"));
				}
				j++;
			}
		System.out.println("everything is ok!!! \nplease input expression in the file names express.\n"+"cheak the result in the file names result.");
		input.close();
		output.close();//如果没有close则数据在缓存区并未存储到硬盘，写到文件
		//中只有关闭，才会将文件全部写入
	}
	
}