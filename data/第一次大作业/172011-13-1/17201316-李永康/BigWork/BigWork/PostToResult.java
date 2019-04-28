package BigWork;

public class PostToResult {
	private String post;//��׺���ʽ
	private Stacks<Double> stack = new Stacks();//����һ��ջΪDouble����
	//���캯��
	public PostToResult(String post){
		this.post = post;
	}
	//��׺���ʽ�ó����
	public double result(String post){
        String[] strings = post.split(" ");  //���ַ���ת��Ϊ�ַ�������
        double finalResult = 0;
        for (int i = 0; i < strings.length;i ++){
        	strings[i] = strings[i].trim();  //ȥ���ַ�����β�Ŀո�
        }
		for(int i = 0;i < strings.length;i ++){
			if(strings[i].equals(" "))
				continue;
			else if(judge(strings[i])){
				stack.push(Double.valueOf(strings[i]));
			}
			else if(judge(strings[i]) == false){
				finalResult = value(strings[i]);
				stack.push(finalResult);
			}
		}
		return finalResult;
	}
	//��ջ�����������������
	public double value(String s){
		s = s.trim();
		double values = 0;
		double m = stack.pop();
		double n = stack.pop();
		switch(s){
		case "+":
			values = n + m;
			break;
		case "-":
			values = n - m;
			break;
		case "*":
			values = n * m;
			break;
		case "/":
			values = n / m;
			break;
		default :
			break;
		}
		return values;
	}
	//StringתDouble��
	public double stringToInt(String s){
		s = s.trim();
		double num = Double.valueOf(s);
		return num;
	}
	//�ж��ַ����Ƿ�Ϊ����
	public boolean judge(String s){
		boolean flag = true;
		for(int k = 0;k < s.length();k ++){
			if(s.charAt(k) > '9' || s.charAt(k) < '0')
				flag = false;
		}
		return flag;
	}
}
