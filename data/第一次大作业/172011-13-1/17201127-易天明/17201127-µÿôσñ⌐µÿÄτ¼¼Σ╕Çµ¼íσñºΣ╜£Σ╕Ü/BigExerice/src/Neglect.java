import java.io.IOException;

public class Neglect {
	public Neglect() {
		
	}
	
	public static boolean neglectExpression(DeleteSpaces p, int i) throws IOException {
		// ���ڻ��޷��ж��Ƿ��п��ַ��������������ͬ
		for (int j = i - 1; j >= 0; j --) {
			if (p.getStr().get(i).equals(p.getStr().get(j))) {
				String out = (i + 1) + ": " + "��" + (j + 1) + "���Ѿ����";
				WriteToFile.writeToFile(out);
				return true;
			}
		}
		return false;
	}
}
