import java.util.regex.*;
public class VerifyExpression{//���ʽУ����
	private String str;//����ı��ʽ
	private boolean f = true;//�жϱ��ʽ����ȷ���
	String s = "";//���������Ϣ���ַ���
	public VerifyExpression(String str){//���캯��
		this.str = str;
	}
	public  boolean judgeverifyExpression() {//�жϱ��ʽ�Ƿ�Ϸ�
		
		Space();//ȥ���ո�
		str = str.replace("(+","(0+");//����0
		addZero();//������ſ�ͷ�����0
 		judge1();
 		judge2(str);
 		judge3();
 		judge4();
 		return getF();//����f
	}
	public boolean getF(){//��ȡ���ʽ��true��false
		return f;
	}
public void addZero(){//����+-��ͷ�ı��ʽǰ��0Ԥ����
	if(!str.equals("")){
	if(str.charAt(0) == '-'||str.charAt(0) == '+' )
			str = "0"+str;
	}
	

 }
public void Space(){//ȥ���ո�ķ���
	String s = "[^\\s]";
	String s1 = "";
	Pattern pattern = Pattern.compile(s);
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()){
		s1 += matcher.group();
	}
	str = s1;
}

 public void judge2(String s){//�ж��Ƿ����Ų�ƥ��
	  int top1 = 0;// ����
	  int top2 = 0;
      char[] biao = s.toCharArray();// ���ַ���ת�����ַ�����
      for (int i = 0; i < biao.length; i++){
          if (biao[i] == '('){//�����������
              top1++;
          }else if (biao[i] == ')'){// �����)
        	  top2++;   
              }
          }
      if(top1 !=top2){
    	  f = false;
    	  s = "ERROR\r\n#���ʽ���Ų�ƥ��\r\n";
    	  return;
      }
      	 
      } 

   public void judge4(){//�жϣ�+*/)��������ģʽ�Ƿ����
	 String  s1 = "[\\(][\\+\\*\\/][\\d]{1,10}[\\)]";
	 String  s2 = "[\\(][\\d]{1,10}[\\)]";
	 Pattern p1 = Pattern.compile(s1);
	 Matcher m1 = p1.matcher(str);
	  Pattern p2 = Pattern.compile(s2);
	  Matcher m2 = p2.matcher(str);
	  if( m2.find()){
		  f = false;
		  s = "ERROR\r\n#���ʽ����\r\n";
		  return;
	  }
	 
	   
   }
 public  void judge1(){//�жϿ�ͷ�Ƿ�Ϊ+*/,0
	 String s1= "[0]{1,10}[0-9]+";
	 Pattern pattern = Pattern.compile(s1);
	 Matcher matcher = pattern.matcher(str);
	if(!str.equals("")){
	 if(str.charAt(0)== '*'||str.charAt(0)== '/'||
			 matcher.find()||str.charAt(str.length() -1) == '+'||str.charAt(str.length() - 1) == '-'||
			 str.charAt(str.length() - 1 )== '*'||str.charAt(str.length() - 1) == '/'){
		 s = "ERROR\r\n#���ʽ�д���\r\n";
		 f = false;	
		 }
	}
 }
 
 public void judge3(){//�ж�(���Ƿ�����������Ƿ���true,���Ƿ���false
	 String[] s1 = new String[10];
	 s1[0] = "[\\(][\\+\\*\\/]";
	 s1[1] = "[\\+\\-\\*\\/][\\)]";
	 s1[2] = "[\\d]{1,10}[\\(]";
	 s1[3] = "[\\)][\\d]{1,10}";
	 s1[4] = "[\\)][\\(]";
	 s1[5] = "[\\(][\\)]";
	 s1[6] = "[\\+\\-\\*\\/]{2}";
	 s1[7] = "[\\-][\\(][\\d]{1,10}[\\)]";//
	 s1[8]= "[\\/][0]";//����Ϊ0 
	 s1[9] = "[^0-9\\+\\-\\*\\/\\(\\)]";//�����ַ�
	 for(int i = 0; i <10;i ++){
		 Pattern p =  Pattern.compile(s1[i]);	 
		 Matcher m =  p.matcher(str);
		 if(m.find()){
			 f = false;
			 s = "ERROR\r\n#���ʽ���Ϸ�\r\n";
			 break;
		 }
	 }

 }

 }

