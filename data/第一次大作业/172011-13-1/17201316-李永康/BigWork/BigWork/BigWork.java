package BigWork;
import java.io.*;
import java.util.Scanner;

public class BigWork {
	public static void main(String[] args) throws FileNotFoundException{
		//����һ���ļ�����
		File file = new File();
		//���������СΪ�ļ�����
		String[] arrny = new String[file.numFile()];
		String[] instands = new String[file.numFile()];
		double[] fianlSum = new double[file.numFile()];
		//���ļ���������
		arrny = file.readFile();
		//����һ���������
		Check checks = new Check(arrny);
		//��������ı��ʽ������֤������һ������ǵ�����
		arrny = checks.checked(arrny);
		//��������
		for(int i = 0;i < arrny.length;i ++){
			//���������鱻��ǣ���ֱ�����
			if(arrny[i].matches("ERROR\\r\\n.*")){
				continue;
			}
			//û�б�ǵĻ��͵ó�����������
			else{
				InfixToPost infixToPost = new InfixToPost(arrny[i]);
				instands[i] = infixToPost.change();
				PostToResult postToResult = new PostToResult(instands[i]);
				fianlSum[i] = postToResult.result(instands[i]);
				if(fianlSum[i] == Double.NEGATIVE_INFINITY || fianlSum[i] == Double.POSITIVE_INFINITY){
					arrny[i] = "ERROR\r\n#��������Ϊ��";
					continue;
				}
				arrny[i] = arrny[i] + " = " + fianlSum[i];
			}
		}
		//������д���ļ�
		file.writeFile(arrny);
	}
}
