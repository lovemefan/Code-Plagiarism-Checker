package No_error;

import java.io.IOException;
import java.io.LineNumberReader;


public class Expression {

	String expression = null;// ���ʽ
	boolean IsaExp = true;// �����жϸı��ʽ�Ƿ�������û�д�����ֵΪtrue������д�����ֵΪfalse
	String Error = null;// ���������������
	int TypeOfError = 0;// ������ʽû�д���Ļ���ֵΪ0���д�Ļ������ݴ�������ͽ����ж�,�����ļ��Ĵ���
	/*
	 * 0:���ʽ��ȷ 1:���ʽΪ��2�����ʽ���п����� 3�����ʽ���Ƿ��ַ� 4�����Ų�ƥ�� 5����������� 6���������Ч�������ǰ����������
	 * 7��������Ч�������������������8���������Ч�����ŷǵ�һ�����������֮ǰ���������� 9���������Ч��С���ź��������������ŷ����һ���ַ���
	 */

	public void SetTypeOfError(int Type) {
		this.TypeOfError = Type;
		
	}
	public static void main(String[] args) throws IOException {

		int count = 0;// ����ѭ������
		
		/* ��ʼ���������� */
		FileOperation file = new FileOperation();
		Judge judge = new Judge();
		
		int length = 0;
		length = file.GetLine();
		
		
		Expression[] exp = new Expression[length];// 
		for( int j = 0;j<length;j++) {
			exp[j] = new Expression();
		}
		CalculateExpression cal = new CalculateExpression();
		for(count = 0;count<exp.length;count++) {
			exp[count] = new Expression();
		}

		/* ��ȡ�ļ��еı��ʽ */
		try {
			file.ReadExpression(exp);
			System.out.println("��ȡ���");
		} catch (IOException ex) {
			System.out.println(ex.getLocalizedMessage());
		}

		/* �������ʽ�е���ͬ���ַ��� */
			judge.DelSameEXP(exp);
		
		/* �Զ�ȡ�ı��ʽ�����ж� ,���ı���������*/
			for( int count1 = 0;count1<length;count1++) {
				judge.JudgeType(exp[count1]);	
			}
			
		
		/* �ж���ɺ󣬶Ա��ʽ������� */
		
		for (count = 0; count < exp.length; count++) {

			cal.Calculate(exp[count]);
		}
		System.out.println("������ɣ�");
		/* ������ɺ󣬽����ٴδ����ļ��� */
		for (count = 0; count < exp.length; count++) {

			file.WriteTheResult(exp[count]);
		}
		System.out.println("�洢��ɣ������ڡ�src\\\\No_error\\\\output��Ŀ¼�²鿴");

	}
	public void SetExp(String string) {
		this.expression = string;
	}

}
