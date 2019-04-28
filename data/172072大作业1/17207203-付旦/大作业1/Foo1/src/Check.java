import java.util.*;

class Check {
	   String expression;
	    
	     // �����ʽ�Ƿ�Ϸ�
	
	    public int checkit() {
	        int flag = 0;
	        if(this.expression.length() == 0)
	            flag = 1;
	        else if (this.expression.matches("^(\\+|\\-|\\*|\\/).*|.*(\\+|\\-|\\*|\\/)$"))//�����������Ϊ��ͷ���β
	            flag = 2;
	        else if (this.expression.matches(".*([^0-9\\+\\-\\*\\/\\)\\(]).*"))      //�����������ַ�����
	            flag = 3;
	        else if (this.expression.matches(".*([\\+\\-\\*\\/]{2,}).*"))//�������������������
	            flag = 4;
	        else if(this.expression.matches(".*(\\d\\(|\\)\\d).*"))      //������ǰ�������ź���������
	            flag = 5;
	        else if(this.expression.matches(".*(\\(\\+|\\(\\-|\\(\\*|\\(\\/|\\+\\)|\\-\\)|\\*\\)|\\/\\)).*"))//�����ź��������ǰ���ܳ��������
	            flag = 6;
	        else if(this.expression.matches(".*(\\(\\))"))
	            flag = 7;
	        return flag;
	    }

	
	     // �ж������Ƿ�ƥ��
	     
	    public boolean BracktMatcher() {
	        Stack<Character> Brackt = new Stack<Character>();
	        int flag = 0;
	        for (int i = 0; i < this.expression.length(); i++){
	            flag = judge(i, Brackt);
	            if(flag == 1)
	                return false;
	        }
	        return Result(Brackt.size());
	    }
	    private int judge(int i, Stack<Character> Brackt){
	        int flag = 0;
	        if (this.expression.charAt(i) == '(')
	            Brackt.push(this.expression.charAt(i));
	        else if (this.expression.charAt(i) == ')'){
	            if(Brackt.size() == 0)
	                flag = 1;
	            else
	            {
	                if(Brackt.peek() == '(')
	                    Brackt.pop();
	                else
	                    flag = 1;
	            }
	        }
	        return flag;
	    }
	    private boolean Result(int num){
	        if (num != 0)
	            return false;
	        else
	            return true;
	    }

	    
	     // �����ж����ɴ�������

	    String OutError() {
	        String str = "";
	        if(!this.BracktMatcher())
	            str = "���ʽ�����Ų����  ^o^";
	        else{
	            int c = this.checkit();
	            switch (c) {
	                case 1: str = "���ʽ����Ϊ���ַ���������������У�  ^o^"; break;
	                case 2: str = "���ʽ�����԰��������Ϊ��ͷ���β  ^o^"; break;
	                case 3: str = "���ʽ�ں��Ƿ��ַ�  ^o^"; break;
	                case 4: str = "���ʽ�ڳ������������  ^o^"; break;
	                case 5: str = "���ʽ��������ǰ�������ź󲻿�Ϊ����  ^o^"; break;
	                case 6: str = "���ʽ�������ź��������ǰ����Ϊ�����  ^o^"; break;
	                case 7: str = "���ʽ�ڳ��ֿ�����  ^o^"; break;
	            }
	        }
	        return str;
	    }
	}
