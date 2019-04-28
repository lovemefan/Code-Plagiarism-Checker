import java.io.IOException;

public class Neglect {
	public Neglect() {
		
	}
	
	public static boolean neglectExpression(DeleteSpaces p, int i) throws IOException {
		// 现在还无法判断是否有空字符但表达是内容相同
		for (int j = i - 1; j >= 0; j --) {
			if (p.getStr().get(i).equals(p.getStr().get(j))) {
				String out = (i + 1) + ": " + "第" + (j + 1) + "题已经算过";
				WriteToFile.writeToFile(out);
				return true;
			}
		}
		return false;
	}
}
