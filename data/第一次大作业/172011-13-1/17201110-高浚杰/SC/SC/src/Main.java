
public class Main {
	public static void main(String[] args) throws Exception {
	String s = FileOperate.readFile();//��ȡ�ļ�
	s = s.replaceAll(" ", "");
	Check a = new Check();
	String[] firstStr = s.split("\\n");
	String[] str = Check.delete(firstStr);
	
	Stack<String> stack = new Stack<>();//����һ���洢�ַ���ջ
	  for(int i = 0; i < str.length ; i ++){
		 a.setStr(str[i]);
		 a.check(str[i]);
		 if(a.getStr().contains("E") == false){
			 Convert infix = new Convert(stack,str[i]);		     
		     infix.process();//ת��Ϊ��׺���ʽ
		     String post = infix.getPost();//ȥ������ո��
		     
	         Stack<Integer> stack_result = new Stack<>();//����һ����������ջ
	         Result ptr = new Result(post,stack_result);
	         ptr.operate();//ֱ�Ӽ�����ѧ���ʽ���
	         
	         FileOperate.writeFile("D:\\result.txt",str[i] + "=" +ptr.getResult());//�õ����
		 } else{
		FileOperate.writeFile("D:\\result.txt",a.getStr());//������ʽ
	     
	  }
    }
  }
}
