import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Main {
	public static void main(String[] args) throws Exception {	
		String[] expression = new String[500];
		String[] result = new String[500];
		File file = new File("expression.txt");
		Scanner input = new Scanner(file);
		int i = 0;
		while (input.hasNextLine()) {
			expression[i] = input.nextLine();
			Check c = new Check(expression);
			c.Judge();
			result[i] = c.output[i];
			System.out.println(result[i]);
			i++;
		}
		FileInput in = new FileInput();//newһ���ļ����������
		in.fileInput("result.txt", result, i);//���������Ϣ����result.txt�ļ�
	}
}