
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		// �����䳤���飬������ʽ
		ArrayList<String> ex = new ArrayList<String>();
		// ����FileR���������ļ��еı��ʽ����䳤����
		ex = File.FileR();
		// ����Expression������ȥ�����ʽ�еĿո�
		ex = Expression.Expression(ex);
		// ����ExpressionIgnoreTheSame����������ͬ�ı��ʽ�˵�
		ex = Expression.ExpressionIgnoreTheSame(ex);
		// �����䳤���鴢����ʽ�ĺϷ���Ϣ
		ArrayList<String> legality = new ArrayList<String>();
		// �Ϸ�������
		legality = Expression.ExpressionLegality(ex);
		// ���÷���������
		ArrayList<String> result = new ArrayList<String>();
		// �������
		result = Calculation.Calculate(ex, legality);
		// �����ļ�
		File.FileW(ex, result);
	}

}
