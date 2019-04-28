import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	// ������ʽ���ڼ�����ʽ�ĺϷ��� ���ܹ��жϵ����ţ�
	private static final String REGEX = "((^\\d+\\s*)|(^\\s*\\(\\s*\\d+\\s*([\\+\\-\\*/]\\s*\\d+\\s*)+\\)\\s*))(([\\+\\-\\*/]\\s*\\d+)\\s*|([\\+\\-\\*/]\\s*\\(\\s*\\d+\\s*([\\+\\-\\*/]\\s*\\d+\\s*)+\\)\\s*))+$";
	// ������ʽ�е�������
	private static Pattern pattern;
	private static Matcher matcher;

	// ���������� throws Exception ��Ϊ���ܻ�Ͷ������
	public static void main(String[] args) throws Exception {
		// ��ʼ��ջ(��Ԫ��) ������������
		Stack stack = new Stack(new Node(), new Node());
		// ջ����ջβ��ͬһָ��
		stack.stackBottom = stack.stackTop;
		// ָ��null
		stack.stackTop.next = null;
		Scanner input1 = new Scanner(System.in);
		System.out.println("�������������ʽ���ڵ��ļ�λ��(����·��!)");
		String address1 = input1.nextLine();
		java.io.File file1 = new java.io.File(address1);
		// ���������������ʽ����λ���ļ��Ƿ����
		while (!file1.exists()) {
			System.out.println("Source file " + address1 + " " + "does not exist");
			System.out.println("�������������������ʽ���ڵ��ļ�λ��(����·��!)");
			address1 = input1.nextLine();
			file1 = new java.io.File(address1);
		}
		// ���������ļ����粻���ڻ��Զ��½�һ�� ������������ḽ����ȥ ���Բ���Ҫ�����ļ��Ƿ����
		System.out.println("�������������ʽ�����Ҫ������ļ�λ��(����·��!)");
		Scanner input3 = new Scanner(System.in);
		String address2 = input3.nextLine();
		java.io.File file2 = new java.io.File(address2);
		// ע��˴�input������ǰ���׻���
		Scanner input2 = new Scanner(file1);
		while (input2.hasNext()) {
			// ���ļ��ж�ȡ���ʽ
			String expression = input2.nextLine();
			// ����������ʽ���м�����ʽ�ĺϷ���
			pattern = Pattern.compile(REGEX);
			matcher = pattern.matcher(expression);
			// ���ʽ������ģʽ ��matches��������true ���򷵻�false �����������
			if (matcher.matches()) {
				// ������ģʽ�ı��ʽת���ɺ�׺���ʽ
				InfixToPost infix = new InfixToPost(stack, expression);
				infix.process();
				// ����׺���ʽ����String���͵� post��
				String post = infix.getPost();
				// �½�һ����Ž����ջ ���Ҽ�������
				Stack stack_result = new Stack();
				PostToResult ptr = new PostToResult(post, stack_result);
				ptr.operate();
				// ����Ŀ���ļ��Ƿ���� ���������½�һ�� ������ֱ���Ը��ӷ�ʽд��
				if (!file2.exists()) {
					// �½��ļ�д��
					java.io.PrintWriter output = new java.io.PrintWriter(file2);
					output.println(expression + "=" + ptr.getResult());

					output.close();
				} else {
					// ��׷�ӷ�ʽд��
					BufferedWriter out = null;
					out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
					out.write(expression + "=" + ptr.getResult() + "\r\n");
					out.close();
				}

			}else{
				// ����Ŀ���ļ��Ƿ���� ���������½�һ�� ������ֱ���Ը��ӷ�ʽд��
				if (!file2.exists()) {
					// �½��ļ�д��
					java.io.PrintWriter output = new java.io.PrintWriter(file2);
					output.println("ERROR" + "\r\n"  + "#" + " " + expression);

					output.close();
				} else {
					// ��׷�ӷ�ʽд��
					BufferedWriter out = null;
					out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
					out.write("ERROR" + "\r\n" +  "#" + " " + expression + "\r\n");
					out.close();
				}
			}

		}
		input2.close();
	}
}
