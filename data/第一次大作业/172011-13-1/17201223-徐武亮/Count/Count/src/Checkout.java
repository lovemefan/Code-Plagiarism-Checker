
public class Checkout {//У����
	
	private String data;//���ʽ
    boolean  corr;//�Ϸ���
    
    public Checkout(){
    	
    }
    
    public Checkout(String data,boolean corr){
    	this.data = data;
    	this.corr = corr;
    }
 
    public String c1(){//�жϷǷ��ַ�
    	
    	String s1="";
    	if (data.matches(".*([\\!-\\&]|\\,|\\.\\=|[\\:-\\~]).*"))
    	{
    		s1 = "���зǷ��ַ� ";
			corr = false;
    	}
    	return s1;
    }
    
    public String c2(){//�ж���������� 
    	String s2 = "";
    	if(data.matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")){
    		s2 = "��������� ";
    		corr = false;
    	}
    	return s2;
    }
    
    public String c3(){//�жϿ�����
    	String s3 = "";
    	if(data.matches(".*\\(\\).*")){
    		s3 = "������ ";
    		corr = false;
    	}
    	return s3;
    }
    
    public String c4(){//�ж�����)(֮��û�������
    	String s4 = "";
    	if(data.matches(".*\\)\\(.*")){
    		s4 = "����)(֮��û������� ";
    		corr = false;
    	}
    	return s4;
    }
    
    public String c5(){//�ж�(����������� 
    	String s5 = "";
    	if(data.matches(".*\\([\\+\\-\\*\\/].*")){
    		s5 = "(����������� ";
    		corr = false;
    	}
    	return s5;
    }
    
    public String c6(){//�ж�)ǰ��������� 
    	String s6 = "";
    	if(data.matches(".*[+-/]\\).*")){
    		s6 = ")ǰ��������� ";
    		corr = false;
    	}
    	return s6;
    }
    
    public String c7(){//�ж�(ǰ�治�������
    	String s7 ="";
    	if(data.matches(".*[\\d]\\(.*")){
    		s7 = "(ǰ�治������� ";
    		corr = false;
    	}
    	return s7;
    }
    public String c8(){//�ж�)���治�������
    	String s8 ="";
    	if(data.matches(".*\\)[\\d].*")){
    		s8 = ")���治������� ";
    		corr = false;
    	}
    	return s8;
    }
    public String c9(){//�ж����Ų���� 
    	char[] d = data.toCharArray();
    	String s9="";
    	int num1 = 0,num2 = 0;
    	for(int i = 0; i < d.length; i++){
    		if(d[i]=='('){
    			num1 =num1 +1;
    		}
    		if(d[i]==')'){
    			num2 = num2 +1;
    		}
    	}
    	if (num1 != num2){
    		s9 = "���Ų����  ";
    		corr = false;
    	}
    	return s9;
    }
    
    public String c10(){//�ж�ǰ���ж��������
    	String s10 ="";
    	if(data.matches("[\\+\\-\\*\\/](\\(|[\\d]).*")){
    		s10 = "ǰ���ж�������� ";
    		corr = false;
    	}
    	return s10;
    }
    
    public String c11(){//�жϺ����ж�������� 
    	String s11 ="";
    	if(data.matches(".*(\\)|[\\d])[\\+\\-\\*\\/]")){
    		s11 = "�����ж�������� ";
    		corr = false;
    	}
    	return s11;
    }
    
     public void check(){
    	 String s = "";
         s = c1() + c2() + c3() + c4() + c5() + c6() + c7() + c8() + c9() +c10() +c11();//��һ�����ʽ���д����������
         if (data.length()==0){//�жϿ��ַ���
        	 s = "���ַ��� ";
        	 corr = false;
         }
         if(s.length()>0){
        	 this.data = s;
         }
     }
     
     public String getdata(){
    	 return data;
     }
     
    public boolean getcorr(){
    	return corr;
    }
   
}
