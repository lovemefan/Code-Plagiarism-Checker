
import java.io.File;
import java.util.Scanner;

//���ļ���������
public class ReadData {

	private String expression; // ���ʽ
	private String allResult; // ���ս��

	// ���췽��
	public ReadData() {
		expression = ""; // ������ʽΪ��
		allResult = ""; // ���ս��δ��
	}

	// ���ʽ������
	public String getExpression() {
		return this.expression;
	}

	// ���ս��������
	public String getAllResult() {
		return this.allResult;
	}

	// ���ļ������ò�������
	public void readData() throws Exception {
		File file = new File("test.txt");
		Scanner input = new Scanner(file);
		// ����һ������������Ķ���
		Deal deal = new Deal();
		// ����һ�����ļ�д������Ķ���
		WriteData wD = new WriteData();
		// ���������һ�У������������
		while (input.hasNext()) {
			this.expression = input.nextLine();
			// �������ı��ʽ
			// System.out.println(expression);
			this.allResult = deal.dealExpression(expression, allResult);
		}
		wD.writeData(allResult);
		input.close();
	}
}
