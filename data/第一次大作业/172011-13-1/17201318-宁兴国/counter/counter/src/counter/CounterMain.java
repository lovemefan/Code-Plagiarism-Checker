package counter;

public class CounterMain {
	public static void main(String[] agrs) throws Exception{
		//�����ļ���
		CreateFile file1 = new CreateFile();
		//��¼������ַ���
		String []inputCount = new String[file1.line()];
		//��¼������ַ���
		String []outputCount = new String[file1.line()];
		//��ȡ�ļ����������
		inputCount = file1.scannerFlie();
		//���ļ��������ʽ���м���
		for(int i = 0;i<file1.line();i++){
			//ȥ�����ʽ�еĿո�
			Checkout checkout = new Checkout(inputCount[i].replaceAll(" ", ""));
			//�õ�������ʽУ�������ʽ
			String first = checkout.compare();
			//�õ����ʽ�ǲ�����ȷ
			boolean out = checkout.getFlag();
			//�������ȷ�ĶԱ��ʽ���м���
			if(out==true){
				//�Ա��ʽ���г����Ĵ����ӿո�
				ProcessInfix processInfix = new ProcessInfix(first);
				String infix = processInfix.getProcessInfix();
				//�����ʽ��׺ת��׺
				Process process = new Process(infix);
				String post = process.getPostConter();
				//���ʽ������
				CountResult resul = new CountResult(post);
				String result = resul.getCounterResult();
				outputCount[i] = first + " = " + result;
			}
			//����Ǵ��޵������¼������Ϣ
			else {
				outputCount[i] = "ERROR" + "\r\n" + first;
			}
		}
		//��������Ϣд���ļ�����
		file1.plintFile(outputCount);
	}

}
