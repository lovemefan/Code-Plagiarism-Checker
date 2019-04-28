package mathCalculator;

import java.util.ArrayList;

public class Main{   //����
	
	private  static ArrayList<String> input;    //������ִ�����
	private  static ArrayList<String> temp;     //�����ִ����飬���ڲ���
	private  static ArrayList<String> write;    //Ҫд���ļ����ִ�����
	private  static file F;                     //�ļ���д����
	private  static Check check;                //���ʽ�������
	
	public static String add0(int x , String str){
		String res = str;
		StringBuilder sb = new StringBuilder();  //StringBuilder�ഴ������
		sb.append(res);  
		sb.insert(x,"0");                       //ָ��λ�ü�0
		res = sb.toString();
		return res;
	}
	
 	public static String deal(String str){      //����Ϸ����ʽ
		if(check.checkStart (str)){              //�����ͷ�Ǹ��� ���ڿ�ͷ����ǰ���0
			str = add0(0,str);
		 }
		 else if(check.checkB(str)){              //��������������ź���
			 for (int j = 0;j < str.length()-1;j++){         
				 if(str.charAt(j) == '(' && str.charAt(j+1) == '-'){
					 //��ÿ������������������������ź͸����м��0
	    			  str = add0(j+1,str);
				  }
			  }
		  }
		  Change infix = new Change(str);            //��������ĺϷ���ʾתΪ��׺���ʽ
          String post = infix.process();             
          Result ans = new Result(post);             //���ú�׺���ʽ������
          String s = "" + ans.process();
          return s;
	}
	
	public static void process(ArrayList<String> input){			//�Զ�����ִ����鴦��
		for (int i = 0;i < input.size();i++){ 
			String str = input.get(i);      
			str = str.replaceAll(" ", "");                         //���˿ո�
			boolean flag = true ;
			flag = check.process(str);                   
			if ( flag && !temp.contains(str) ){                     //�Ϸ�����û���ظ�ָ�������
				temp.add(str);                                      //��ӵ������ִ����飬�Ա����
				String s = deal (str);                               
                write.add(input.get(i).replaceAll(" ", "") + "=" + s);                  //���𰸼���Ҫд���ļ����ַ�������
    		} 
			else if(!temp.contains(str)){                           //���Ϸ� ��û���ظ�ָ��
				String[] t = new String[2];
				t = check.getWrite();                                //��¼�Ƿ���Ϣ
				write.add(t[0]);
				write.add(t[1]);
			}
        }
		F.Write(write);
	}
	
    public static void init( ) {		 //��ʼ������������Ϣ
    	write = new ArrayList<String>();
		input = new ArrayList<String>();
		temp = new ArrayList<String>();
		F = new file();
		check = new Check();		
	} 
	
	public static void main(String[] args) {
		init();                  //��ʼ��
		input = F.getRead();     //������ʽ
		process(input);          //������ʽ
	} 

}
