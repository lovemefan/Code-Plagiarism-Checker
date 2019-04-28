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
	
	public static void main(String[] args) throws IOException{		//���������׳��쳣
		
		calculator cal = new calculator();
		panDuan pd = new panDuan();
		file f = new file();
		File fp1 = new File("GS.txt");		//�����µ��ı�
		File fp2 = new File("GSR.txt");		//������ʽ��д��·��

		Scanner input = new Scanner(fp1);	//ʵ�����µ��ļ�����
		PrintWriter fp = new PrintWriter(fp2);
	
		//��GSR.txt�ļ��Ѿ����ڣ���ɾ���ļ�
		if(fp2.exists() && fp2.isFile()){
			fp2.delete();
		}	

		while(input.hasNext()){	//ѭ����ȡ�ı�����
			String s1 = input.nextLine(); //��ȡʽ��
			if(s1.length() == 0)
				continue;
			String check = s1.replaceAll(" ","");//ȥ���ַ�����Ŀո�	
			getArray(s1);
			
			
				
						if(Check(check) == true){
							String result2 = check+" = "+"\r\n"+"	ERROR!"+"\r\n"+"	#��������ʽ���ٴ��ظ����֣�ϵͳ�Զ����ˣ�";
							fp.println(result2);	
							System.out.println("�ظ�");	
							continue;
						}
					 
				 		else if(pd.judge1(check) && pd.judge2(check) && pd.judge3(check) && pd.judge4(check) ){
				 
				 			String result = check+" = "+cal.compute(cal.toBack(check));
				 
				 			fp.println(result);		//д���������ļ�
				 		}
				 		else{					//if-else ���ú������Զ�ȡ�����ı�ʽ�ӽ����ж�
							
							String result = check+" = "+"\r\n"+"	ERROR!"+"\r\n"+pd.getError() ;	//��������
							fp.println(result);			//д���ļ�
							}
				 }
			

		f.outPut();	
		fp.close();		//�ر��ļ���
		input.close();

	
	}	
	
}
