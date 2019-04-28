package mathCalculator;

public class Result {     //�����׺���ʽ��
	private intStack stack;        //����ջ
	private String post;           //Ҫ����ĺ�׺���ʽ
	
	public Result(String post){       //���췽����������ʽ
		this.post = post;
		stack = new intStack(post.length());
	}
	
	public boolean number(String str){     //�ж��Ƿ�ΪΪ����
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) > '9' || str.charAt(i) < '0'){
                return false;
            }
        }
        return true;
    }
	
	public int calculate(String str){      //��ջ���������
		int ans = 0;
        int m = stack.pop();             //ջ���������ֳ�ջ
        int n = stack.pop();
        if (str.equals("+")){            //�ӷ�����
        	ans = n + m;
        }
        else if (str.equals("-")){    //��������
        	ans = n - m;
        }
        else if (str.equals("*")){    //�˷�����
        	ans = n * m;
        }
        else if (str.equals("/")){    //��������
        	ans = n / m;
        }
        return ans;
	}
	
	public int process(){                //�������
        String[] s = post.split(" ");    //���ո����
        for(int i = 0; i < s.length; i++){
            String str = s[i];     
            if(number(str)){             //�����������ջ
                stack.push(Integer.valueOf(str));
            }
            else  {                      //����ǲ����������ջ��Ԫ�ص���Ӧ�������
                int result = calculate(str);
                stack.push(result);      //�����ջ
            }
        }
        return stack.pop();
    }
}
