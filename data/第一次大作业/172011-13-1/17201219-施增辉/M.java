import java.util.Scanner;
import java.io.IOException;;

public class M {
	public static void main(String[] args) throws IOException {
		
		java.io.File file = new java.io.File("text.txt");//���ļ��ж�ȡ���ʽ
		Scanner input = new Scanner(file);
		java.io.File file1 = new java.io.File("text1.txt");//���ļ�������
		java.io.PrintWriter output = new java.io.PrintWriter(file1);	
		System.out.println("����Ѵ����ļ���...");
		
		while(input.hasNext()){
			String m = input.nextLine();
			String q = "";
			String[] n = m.split(" ");
			for(int i=0;i<n.length;i++){
				q = q + n[i];
			}
			W e = new W(q);
		
			switch(e.pan()){
				case 0:Stack<String> stack = new Stack<>();
				   Zhan1 a = new Zhan1(stack, q);
				   a.process();
				   String b = a.getPost();
				   Stack<Integer> stack_result = new Stack<>();
				   Zhan2 c = new Zhan2(b, stack_result);
				   c.operate();
				   output.println(q + "=" + c.getResult());break;
				case 2:output.println("ERROR");
				   output.println("#���������");
				   break;
				case 3:output.println("ERROR");
				   output.println("#������");
				   break;
				case 4:output.println("ERROR");
				   output.println("#���Ų����");
				   break;
				case 5:output.println("ERROR");
				   output.println("#�����������");
				   break;
				case 6:output.println("ERROR");
				   output.println("#��ǰ�������");
				   break;
				case 7:output.println("ERROR");
				   output.println("#��ǰ���������");
				   break;
				case 8:output.println("ERROR");
				   output.println("#�����������");
				   break;
				case 9:output.println("ERROR");
				   output.println("#���ʽ���зǷ��ַ�");
				   break;
				case 10:output.println("ERROR");
				   output.println("0,+,-,*,/����ǰ");
				   break;
				default:System.exit(1);
			}
			
		}
		
		input.close();
		output.close();
	}
}
