
class Calcuator{
	public static void main(String[] args) throws Exception {
		WriteData write = new WriteData();
		String[] expression = new String[1024];
		ReadData read = new ReadData();
		expression = read.Read();
        Check check = new Check();
        String[] expression2 = new String[1024];
        int a = 0;
        for(int i = 0;expression[i] != null;i ++){
            expression[i] = check.RemoveBlank(expression[i]);//��ȥ�ַ����еĿո�
        	String expression1 = check.Judge(expression[i]);//�ж��ַ���
        	if(expression1.equals("s1")){
        		expression2[i] = "s1";//�Ƿ��ַ�
        		a ++;
        	}else if(expression1.equals("s4")){
        		expression2[i] = "s4";//�����ʽ����
        		a ++;
        	}
        	else if(expression1.equals("s2")){
        		expression2[i] = "s2";//����������������
        		a ++;
        	}
             else if(expression1.equals("s3")){
        		expression2[i] = "s3";//"��������Ϊ'0'";
        		a ++;
        	}else if(expression1.equals("s5")){
        		expression2[i] = "s5";//"�����������������";
        		a ++;
        	}else if(expression.equals("s6")){
        		expression2[i] = "s6";//����
        	}
        	else{
        		Stack<String> stack = new Stack<>();
                String input = expression1;
                InfixToPost infix = new InfixToPost(stack, input);
                infix.process();
                String post = infix.getPost();
                Stack<Integer> stack_result = new Stack<>();
                PostToResult ptr = new PostToResult(post, stack_result);
                ptr.operate();
        		int b =  ptr.getResult();
        		expression2[i] = expression1 + "=" + b;
        		a ++;
        	}
        	}
        write.Write(expression2,a);//��������ʽ�ĸ������뺯��
        System.out.println("�����Ѿ���ɣ������ļ��в鿴���");
        
    }
}

