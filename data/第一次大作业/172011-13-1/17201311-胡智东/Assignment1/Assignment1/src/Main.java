
public class Main {
	public static void main(String[] agrs) throws Exception {
		File_IO file;
		Judge judge;
		file = new File_IO();
		String[] post = file.FileI();// ����post�����ļ���ĸ������ʽ
		judge = new Judge(post);// ��post�����ж�����
		for (int i = 0; post[i] != null; i++) {
			judge.Judge1();// ����judge�ж���ȷ�Բ�ת������
			System.out.println(judge.output[i]);// ��ӡ���
		}
		file.FileO(judge.output);// �������������ļ���
	}
}
