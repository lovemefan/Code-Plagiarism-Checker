import java.io.IOException;
import java.util.Scanner;

public class InputFile {
	public String Error = "";//����Ĵ�����Ϣ
	
	public InputFile(){
		
	}
	
	//�ļ��Ķ�ȡ
	public String[] inputFile()throws IOException{
		java.io.File file1 = new java.io.File("input.txt");//��ȡ"input.txt"�ļ�
		Scanner input = new Scanner(file1);
		String[] part = new String[50]; 
		String[] count = new String[50];
		InputJudge j ;
		j = new InputJudge();
		int i = 0;
		while(input.hasNextLine()){//���ļ��ڵ��ַ�����ȡ���ַ�������
			String str = input.nextLine();
			if(j.isEmpty(str)){//���ʽ�Ƿ�Ϊ��
				Error += "\r\nERROR\r\n#�ñ��ʽΪ��\r\n";
			}
			else if(j.isOk(str.replace(" ", ""))){//ȥ�����ʽ�еĿո�
				Error += j.InputJudge(str.replace(" ", "")) + "\n";
			}
			else{
				part[i] = str;//����ȷ�ı��ʽ�������
				i ++;
			}
		}
		part = j.Repetition(part,i);//�ж��Ƿ����ظ��ı��ʽ
		int h = 0;
		for(int k = 0;k < i; k ++){//��������Ϣ����
			if(j.hasError(part[k])){
				Error += part[k];
			}
			else {
				count[h] = part[k];
				h ++;
			}
		}
		return count;
	}
}
