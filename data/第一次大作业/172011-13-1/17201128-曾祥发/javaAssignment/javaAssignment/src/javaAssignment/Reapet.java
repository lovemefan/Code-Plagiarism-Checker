package javaAssignment;

public class Reapet {//

	Reapet() {

	}

	public void stringReapet(String[] expression, boolean[] tf, String[] result) {//�淶���ʽ
		Regex reg = new Regex();
		reg.regex(expression, result, tf);//������ʽ�ж�
		int j = 0;
		while (expression[j] != null) {//�ҵ���ͬ�ı��ʽ
			if (tf[j]) {
				int k = j + 1;
				while (expression[k] != null) {
					if (expression[j].equals(expression[k])) {
						tf[k] = false;
						result[k] = "has been calculated!";//����ͬ�ı��ʽ����ҽ��������
					}
					k++;
				}
			}
			j++;
		}

		cl(expression, tf, result);
	}

	public void cl(String[] expression, boolean[] tf, String[] result) {
		int i = 0;
		while (expression[i] != null) {
			if (tf[i]) {
				Negative n = new Negative();//������������
				expression[i] = n.cNegative(expression[i]);
				Split split = new Split();//�������ȥ���
				result[i] = "=" + split.split(expression[i]);//�ջؽ��
			}
			i++;
		}
	}

}