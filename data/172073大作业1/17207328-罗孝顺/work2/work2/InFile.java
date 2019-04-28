package work2;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.DecimalFormat;
import java.util.Scanner;
//import java.util.regex.*;

class InFile {
	String s;//向文件输入的内容
	
	
	InFile(String s){
		this.s = s;
	}

	void creatfile(String s) {
		Scanner scan=new Scanner(System.in);
		System.out.println("在最后算式下一行输入#号结束输入");
		File file = new File("infile.txt");
		if(file.exists()) {
				file.deleteOnExit();
//				System.out.println("文件已删除");	
			}else {
				try {
						file.createNewFile();
//						System.out.println("文件已创建");
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		s=scan.next();   
		try{
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			while(!s.equals("#")){
        	
				bw.write(s+"\r\n");
				bw.flush();
				s=scan.next();
				
				}
			scan.close();
			bw.close();
			fw.close();
			}catch(Exception e){
				e.printStackTrace(); 
			}
	}

}	

