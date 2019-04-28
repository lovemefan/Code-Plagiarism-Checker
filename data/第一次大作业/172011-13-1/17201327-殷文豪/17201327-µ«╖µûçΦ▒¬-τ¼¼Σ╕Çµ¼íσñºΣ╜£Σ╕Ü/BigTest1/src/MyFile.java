import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

//�ļ���
public class MyFile {
	private Regex[] infix;//Regex��������
	private String inputName;//������ʽ���ļ�·��
	private String outputName;//������ļ�·��
	private int n;//Ҫ����ı��ʽ������
	
	//���췽��
	public MyFile() {
		
	}
	
	//���ع��췽��
	public MyFile(String inputName,String outputName,int n) {
		this.inputName = inputName;
		this.outputName = outputName;
		this.n = n;
		//��ʼ���������������С
		this.infix = new Regex[this.n];
	}
	
	//��ȡ����
	public void input() throws IOException {
		File file = new File(inputName);
		//�ļ��������򴴽��ļ�
		if (!file.exists()) {
			System.out.println("���ļ�������,�Ѵ���");
			file.createNewFile();
		}
		Scanner enter = new Scanner(file);
		int i = 0;
		//���ļ�������׺���ʽ����
		while (enter.hasNext() && i < infix.length) {
			infix[i] = new Regex(enter.nextLine());
			infix[i].check();//�����ʽ
			//������ǰ��ı��ʽ���Ƚ�
			for (int j = 0;j < i;j ++) {
				//֮ǰ����ͬ�ľ�ʹ������ʽΪ��
				if (infix[i].getInfix().equals(infix[j].getInfix())) {
					infix[i].setInfix("");
				}
			}
			i ++;
		}
		enter.close();
	}
	
	//�������
	public void output() throws IOException {
		File file = new File(outputName);
		PrintWriter export = new PrintWriter(file);
		for (int i = 0;i < infix.length;i ++) {
			if (infix[i] != null) {
				//���ʽ����
				if (!infix[i].isCorrect()) {
					export.println(infix[i].getError());
				}
				//���ʽ��Ϊ��
				else if (!infix[i].getInfix().equals("")) {
					PostfixCompute post = new PostfixCompute(infix[i].getInfix());
					//�жϳ����Ƿ�Ϊ��
					if (post.getResult() == Double.POSITIVE_INFINITY || post.getResult() == Double.NEGATIVE_INFINITY 
							|| post.getResult() == Double.NaN) {
						export.println("ERROR\r\n#����Ϊ0");
					}
					else {
						export.println(infix[i].getInfix() + "=" + post.getResult());
					}
				}
			}
		}
		export.close();
	}
	
}
