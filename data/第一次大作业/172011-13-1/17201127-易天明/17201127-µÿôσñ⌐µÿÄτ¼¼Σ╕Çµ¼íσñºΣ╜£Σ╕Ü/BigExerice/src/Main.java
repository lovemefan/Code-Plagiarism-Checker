import java.io.IOException;
import java.util.ArrayList;

public class Main {
	// �����ÿո�ֿ��������
	private static ArrayList<String> st = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		WriteToFile.fileDel(); // ɾ���Ѵ��ڵ�����ļ�
		ReadFromFile p1 = new ReadFromFile();

		DeleteSpaces p2 = new DeleteSpaces();

		// ɾ��ԭʼ���ݵĿո�
		p2.delSpaces(p1);

		// ��ӿո��ǵ����ݸ�ʽ���Ա�����
		p2.addSpace(st);
		
		//��������������ķ���
		HandleAll.handleAll(st, p1, p2);
	}
}
