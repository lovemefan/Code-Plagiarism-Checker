package BigClasswork;

public class BigClasswork {
	public static void main(String[] args) {
		String fileName1 = "data.txt";
		String fileName2 = "result.txt";
		DataIn di = new DataIn(fileName1);
		di.dataIn();

		for (int i = 0; i < di.getI(); i++) {
			Check check = new Check(di.getExpression()[i]);
			String noBlank = di.getExpression()[i].replace(" ", "");// ���ʽȥ�ո�

			if (check.check() == 0) {
				int flag = 0;
				if (i > 0) {
					for (int j = 0; j < (i-1); j++) {// �жϱ��ʽ�Ƿ��ظ�
						String noBlank1 = di.getExpression()[j].replaceAll(" ", "");
						if (noBlank.equals(noBlank1)) {
							flag = 1;
							break;
						}
					}
				} 
				if (flag == 0){
					Stack stack = new Stack(noBlank.length());
					Transform expTrans = new Transform(noBlank, stack);
					expTrans.transform();// ��׺���ʽת��׺���ʽ

					String str = expTrans.getOutput();
					Stack result = new Stack(str.length());
					Calculate re = new Calculate(str, result);
					re.operate();
					String outcome = re.getResult();// ��׺���ʽ������
					String s = di.getExpression()[i] + " = " + outcome;// ������ͱ��ʽƴ�ӳ�һ���ַ���
					DataOut da = new DataOut(s, fileName2);
					da.dataOut();// ����Ϣ�����ļ�
				}
			
			} else {
				// String[] message =
				// {"�������������","���ұ������ֵ����","(��������ֵ����","ƥ��
				//������","��������ߺ��������","�������ұ��������","����������0","��һ��Ϊ�����","�Է��Ž�β",")(����"};
				String me = null;
				String[] message = { "�������������", "���ұ������ֵ����", "(��������ֵ����", "������", "��������ߺ��������", "�������ұ��������", "����������0",
						 "��һ��Ϊ�����", "�Է��Ž�β",")(����","���Ų����","���ʽ�к��зǷ��ַ�"};// ������Ϣ����
				for (int j = 0; j < 13; j++) {
					if (check.check() == (j+1)) {
						me = message[j];// ��������Ϣ�ʹ����Ӧ
						break;
					}
				}
				String outcome = "ERROR   \r\n# " + me;
				DataOut da = new DataOut(outcome, fileName2);
				da.dataOut();
			}
		}
	}
}
