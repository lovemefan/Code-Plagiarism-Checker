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
	String s;//���ļ����������
	
	
	InFile(String s){
		this.s = s;
	}

	void creatfile(String s) {
		Scanner scan=new Scanner(System.in);
		System.out.println("�������ʽ��һ������#�Ž�������");
		File file = new File("infile.txt");
		if(file.exists()) {
				file.deleteOnExit();
//				System.out.println("�ļ���ɾ��");	
			}else {
				try {
						file.createNewFile();
//						System.out.println("�ļ��Ѵ���");
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

