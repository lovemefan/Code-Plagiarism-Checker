import java.io.IOException;
import java.util.ArrayList;

public class HandleAll {
	public static void handleAll(ArrayList<String> st,ReadFromFile p1,DeleteSpaces p2) throws IOException {
		// ���ʽУ�飬תת��׺���ʽ���������ز���
		for (int i = 0; i < st.size(); i++) {
			// ȥ��֮ǰ����ı��ʽ
			if (Neglect.neglectExpression(p2, i)) {
				continue;
			}

			// ������ʽ�ж��Ƿ���ϱ��ʽ����
			if (Check.CheckingRegularExpression(p1.getStrings().get(i),i)) {
				continue;
			}

			// ���㼰��ʾ
			double result = Calculate.calculate((Solution.transformToSuffixExpression(st.get(i)).toString()));
			WriteToFile.writeToFile((i + 1) + ": " + p1.getStrings().get(i) + " = " + result);
		}
	}
}
