package calculators;

import java.util.Scanner;

   public class Main {
	
	public static void main(String[] args) throws Exception{
		
		java.io.File fileIn = new java.io.File("input");  
		java.io.File fileOut = new java.io.File("output");
		java.io.PrintWriter out = new java.io.PrintWriter(fileOut);
		Scanner in = new Scanner(fileIn);
		
			while(in.hasNext()){	
			String str = in.nextLine();        //�ļ�����
		    int tes = 0;
			Test t = new Test(str);           //�������ʽ�Ƿ���ȷ
			tes = t.testIt(str);
			
			if(tes == 1){                    //����ʽ����

			    out.println("ERROR");
				out.println(t.finding(t.find));//����ԭ��
			}
			
			if(tes == 0){
            LinkStack<String> ss  = new LinkStack<String>();      
			Stack s = new Stack(ss,str);
			s.process(str);                           //��׺ת��׺
			String str2 = s.getPost();
			
			LinkStack<Integer> cc = new LinkStack<Integer>();
			Calculators c = new Calculators(str2,cc);
			c.calculate(str2);                        //��׺����
			int str3 = c.getResult();
			out.println(str3);
			System.out.println(str3);
			}
		}
			
		out.close();                        //  �ر��ļ�
		
  }
}
