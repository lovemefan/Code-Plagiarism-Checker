import java.io.IOException;
import java.util.*; 
public class expression {
	public static void main(String[] args) throws IOException {
		operation lt = new operation();
		fileIO a = new fileIO();
		checkexpression t = new checkexpression();
		StringBuilder str = new StringBuilder();
		a.fileInput();
		for (int i = 0; a.setexpression(i) != null; i++) {
			if (t.check(a.setexpression(i))=="1") {//�жϱ��ʽ�Ƿ���ȷ
				List<String> list = lt.work(a.setexpression(i));//����׺���ʽ���뺯����Ϊ��׺���ʽ
				List<String> list2 = lt.InfixToPostfix(list);//����׺���ʽ���뺯��������ʽ��ֵ
				str.append(a.setexpression(i)+"="+((double)Math.round(lt.doCal(list2)*10)/10)+"\r\n");//�����ȷ���ʽ������ֵ ������һλС��
			} else
				str.append("ERROR\r\n#" + t.check(a.setexpression(i))+"\r\n");//���������ʽ�����Ĵ�����Ϣ
           }
		a.fileOutput(str.toString());//���ú�������������Ϣд���ļ���
	}
}
