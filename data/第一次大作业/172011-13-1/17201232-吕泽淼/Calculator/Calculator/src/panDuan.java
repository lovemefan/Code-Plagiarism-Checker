
public class panDuan {
	String s ;
	
	public void setError(String g){
		
		s= g;
	}
	
	public String getError(){
		
		return s;
	}
	
	//����������ʽ�������ʽ���ж�	
	
	public boolean judge1(String s){

		boolean m1= s.matches("[0-9\\+\\-\\(\\)\\*\\/]*");//�ж��ַ���ֻ��������������ţ����֣�����������
		boolean m2= s.matches("(.*)[0-9]\\((.*)");//ȱ�ٲ����������������ȱ�ٲ�����
		boolean m3= s.matches("(.*)\\)[0-9](.*)");//ȱ�ٲ��������������ұ�ȱ�ٲ�����
		boolean m4= s.matches("(.*)\\([\\*+-/](.*)");//ȱ�ٲ��������������ұ�ȱ�ٲ�����
		boolean m5= s.matches("(.*)[\\*+-/]\\)(.*)");//ȱ�ٲ����������������ȱ�ٲ�����
		boolean m6= s.matches("(.*)\\(\\)(.*)");//�����ţ��������ޱ��ʽ
		boolean m7= s.matches("(.*)[\\*+-/][\\*+-/](.*)");//�����ȱ�ٲ�����
		boolean m8= s.matches("(.*)\\/0(.*)");//����Ϊ0


 
		if(m1 == false){
			 String q ="	#�ַ���ֻ��������������ţ����֣�����������";
			 setError(q);
			 return false;
		}
		else if(m2){
			 String q ="	#ȱ�ٲ����������������ȱ�ٲ�����";
			 setError(q);
			 return false;
		}
		else if(m3){
			String q ="		#ȱ�ٲ��������������ұ�ȱ�ٲ�����";
			setError(q);
			return  false;
		}
		else if(m4){
			String q ="		#ȱ�ٲ��������������ұ�ȱ�ٲ�����";
			setError(q);
			return false;
		}	
		else if(m5){
			String q ="		#ȱ�ٲ����������������ȱ�ٲ�����";
			setError(q);
			return false;		
		}
		else if(m6){
			 String q ="	#�����ţ��������ޱ��ʽ";
			 setError(q);
			 return false;
		}
		else if(m7){
			 String q ="	#�����ȱ�ٲ�����";
			 setError(q);
			 return false;
		}
		else if(m8){
			 String q ="	#����Ϊ0";
			 setError(q);
			 return false;
		}


		else
			return true;
	}


	public boolean judge2(String s){
		char first=s.charAt(0);

		if(first =='+' || first =='-'|| first =='*'|| first =='/'|| first =='��'){
			 String q ="	#���ַ����������";
			 setError(q);
			 return false;
		}
		
		else
			return true;
	}
	
	public boolean judge3(String s){
		char end=s.charAt(s.length()-1);
	 if(end =='+' || end =='-'|| end =='*'|| end =='/' || end =='��'){
			 String q ="	#β�ַ����������";
			 setError(q);
			 return false;
		}
	else
		return true;
	}
	
	public boolean judge4(String s){
        int top = 0;// ������������ 1�������� -1������ܺ�0��ƥ��
        boolean end = true;// true ��ʾƥ��


        char[] biao = s.toCharArray();// ���ַ���ת�����ַ�����


        // �������ʽ�������ַ�
        for (int i = 0; i < biao.length; i++){
            // �����(���1����ջ
            if (biao[i] == '('){
                top++;
            }else if (biao[i] == ')'){// �����)��-1����ջ 
                if (!(top == 0)){
                    top--;
                }

                else {//top == 0,��������ȴ��һ�������ţ���һ�������Ų�ƥ��
                    System.out.println("���Ų�ƥ�� - -");
                    end = false;
                    return false;
                }
            }
        } 

        // ѭ������ʱ���ֿ���
         if (top != 0 && end){
			 String q ="	#���������鲻ƥ��";
			 setError(q);
        	return false;// ��ѭ��ʱstack����
         }
         else
            return true;
    }

	
	
}
