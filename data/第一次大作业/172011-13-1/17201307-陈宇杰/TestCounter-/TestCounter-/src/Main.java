import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		FileRead f = new FileRead("expression.txt");
		String[] temp = new String[1000];//������ļ���ȡ�ı��ʽ
		String[]  outcome= new String[1000];//��������Ϣ
		int n = 0;
		int m = 0;
		double result = 0;
		
		temp = f.readFile();
		while(temp[n] != null){
			outcome[n] = temp[n];
			VerifyExpression a = new VerifyExpression(temp[n]);//��������У�������
			if (a.judgeverifyExpression()){
		 	   String str = temp[n];
		 	  ToPostfix t = new ToPostfix();//������׺ת��׺�����
		 	  result = t.toPostfix(temp[n]);
		 	 outcome[m++] =temp[n]+ " = " + result+"\n\t";
			   System.out.println(temp[n]+ " = " + result+"\n\t");//�ڿ���̨��ӡ���
		    }
			else{
				outcome[m++] =a.s;
				System.out.println(a.s);//�ڿ���̨��ӡ���
			}
			n ++;
		}
		FileInput in = new FileInput();//newһ���ļ����������
		in.fileInput("result.txt", outcome, m);//���������Ϣ����result.txt�ļ�
	}
}

