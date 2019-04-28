import java.util.ArrayList;

public class Expression {
	public Expression() {

	}

	public static ArrayList<String> Expression(ArrayList<String> ex) {

		int index = 0;

		while (index != ex.size()) {
			String temp = ex.get(index);
			temp = temp.replaceAll(" ", "");
			ex.set(index, temp);
			index++;
		}

		return ex;
	}

	public static ArrayList<String> ExpressionIgnoreTheSame(ArrayList<String> ex) {

		int index = ex.size();

		for (int i = 1; i < index; i++) {
			for (int j = 1; j < (index - i); j++) {
				if (ex.get(j).equals(ex.get(index - i))) {
					ex.set(index - i, "");
					break;
				}
			}
		}

		return ex;
	}

	public static ArrayList<String> ExpressionLegality(ArrayList<String> ex) {
		ArrayList<String> legality = new ArrayList<String>();

		for (int index = 0; index < ex.size(); index++) {
			// ���ַ���
			boolean l0 = ex.get(index).matches("");
			// ���������
			boolean l1 = ex.get(index).matches("(.*)[\\*+-/][\\*+-/](.*)");
			// ������
			boolean l2 = ex.get(index).matches("(.*)\\(\\)(.*)");
			// (�����������
			boolean l4 = ex.get(index).matches("(.*)\\([\\*+-/](.*)");
			// )ǰ���������
			boolean l5 = ex.get(index).matches("(.*)[\\*+-/]\\)(.*)");
			// (ǰ�治�������
			boolean l6 = ex.get(index).matches("(.*)[\\d]\\((.*)");
			// )���治����s���
			boolean l7 = ex.get(index).matches("(.*)\\)[\\d](.*)");
			// ���ʽ�ں��Ƿ��ַ�
			boolean l8 = (ex.get(index).matches("(.*)\\@#$%^&��!~_(.*)"));
			// ����Ϊ��
			boolean l9 = ex.get(index).matches("(.*)\\/0(.*)");
			// �ж��Ƿ�Ϸ�
			if (l0) {
				legality.add("ERROR\n#���ַ���");
			} else if (l1) {
				legality.add("ERROR\n#���������");
			} else if (l2) {
				legality.add("ERROR\n#������");
			} else if (l4) {
				legality.add("ERROR\n#(�����������");
			} else if (l5) {
				legality.add("ERROR\n#)ǰ���������");
			} else if (l6) {
				legality.add("ERROR\n#(ǰ�治�������");
			} else if (l7) {
				legality.add("ERROR\n#)���治�������");
			} else if (l8) {
				legality.add("ERROR\n#���ʽ�ں��Ƿ��ַ�");
			} else if (l9) {
				legality.add("ERROR\n#����Ϊ��");
			} else {
				boolean l3 = BracketMismatch(ex, index);
				if (l3) {
					legality.add("ERROR\n#���Ų�ƥ��");
				} else {
					legality.add("legal");
				}
			}
		}
		return legality;
	}

	public static boolean BracketMismatch(ArrayList<String> ex, int index) {
		int ofl = 0;
		int ofr = 0;
		char[] of = ex.get(index).toCharArray();
		for (int i = 0; i < of.length; i++) {
			if (of[i] == '(') {
				ofl++;
			} else if (of[i] == ')') {
				ofr++;
			}
		}
		if (ofl != ofr) {
			return true;
		} else {
			return false;
		}
	}
}
