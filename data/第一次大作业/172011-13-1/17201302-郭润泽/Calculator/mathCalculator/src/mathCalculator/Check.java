package mathCalculator;

import java.util.regex.Pattern;

public class Check {          //������
	private String[] write;       //������Ϣ
	
	String regEx1 = "[\\*\\/\\+\\-]{2}";     //���������     
	String regEx2 = "\\(\\)";                //������
	String regEx3 = "[^\\*\\/\\+\\-]\\(";    //������ǰ���������
	String regEx4 = "[\\*\\/\\+\\-]\\)";     //������ǰ�������
	String regEx5 = "\\([\\*\\/\\+]";        //�����ź��������
	String regEx6 = "\\)[^\\*\\/\\+\\-\\)]";  //�����ź������������������
	String regEx7 = "\\/0";                  //����0
	String regEx8 = "^[\\*\\/\\+]";          //��ͷ�ǳ�-���������
	String regEx9 = "[^\\*\\/\\+\\-\\d\\(\\)]"; //���зǷ��ַ�
	String regEx10 = "[\\*\\/\\+\\-\\(]$";   //��β��(���������
	
	public Check(){            //���췽��
		this.write= new String[2];
	}
	
	public boolean dealPosition(String str){   //λ����Ϣ�ж�
		boolean flag = true ;
		
		if(Pattern.compile(regEx8).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#��ͷ����";
    		flag = false;
        }
		
		else if(Pattern.compile(regEx10).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#��β����";
			flag = false;
        }
		return flag ;
	}
	
	public boolean dealBrac(String str){       //��������ж�
		boolean flag = true ;
		if(Pattern.compile(regEx2).matcher(str).find()){
			write[0] = "ERROR";
			write[1] = "#������";
			flag = false;
		}
		else if(Pattern.compile(regEx3).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#������ǰ���������";
			flag = false;
		}
		
        else if(Pattern.compile(regEx4).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#������ǰ�������";
			flag = false;
        }
		
        else if(Pattern.compile(regEx5).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#�����ź��������";
    		flag = false;
        }
		
        else if(Pattern.compile(regEx6).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#�����ź��������";
			flag = false;
        }
        return flag;
	}
	
    public boolean dealChar(String str){ //�ַ�����ж�
    	boolean flag = true ;
        if(Pattern.compile(regEx7).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#����0";
			flag = false;
        }
		
        else if(Pattern.compile(regEx9).matcher(str).find()){
        	write[0] = "ERROR";
        	write[1] = "#�Ƿ��ַ�";
			flag = false;
        }
        else if(Pattern.compile(regEx1).matcher(str).find()){
			write[0] = "ERROR";
			write[1] = "#���������";
			flag = false;
		}
		return flag ;
	}
	
	public boolean process(String str){     //�жϴ������
		boolean flag = true;
		if (!checkCount(str)){
			write[0] = "ERROR";
			write[1] = "#���Ų�ƥ��";
			flag = false;
		}
		else if(str.equals("")){
			write[0] = "ERROR";
			write[1] = "#���ַ���";
			flag = false;
		}
		else if (!dealBrac(str)||!dealPosition(str)||!dealChar(str)){  //����в��Ϸ�����ʧ��
			flag = false;
		}
		
		return flag ;
	}
	
	public boolean checkCount(String str){ //����ƥ���ж�
		boolean flag = true;
		int len = str.length();
		stringStack stack = new stringStack(len);
		for (int i = 0;i < len;i ++){             //(��ջ
			if (str.charAt(i)=='('){
				stack.push("(");
			}
			else if(str.charAt(i)==')'){      //)��ջ
				if(stack.isEmpty()){       //ջΪ�������Ų�ƥ��
					flag = false;
					break;
				}
				else{
					stack.pop();
				}
			}
			if(!flag){
				break;
			}
		}
		if(!stack.isEmpty()){       //ջΪ��������ƥ��
			flag = false;
		}
		return flag ;
	}
	
	public boolean checkStart(String str){          //��ͷ�Ƿ�Ϊ����
		return Pattern.compile("^\\-").matcher(str).find();
	}
	
	public boolean checkB(String str){            //(�����Ƿ�Ϊ����
		return Pattern.compile("\\(\\-").matcher(str).find();
	}
	
	public String[] getWrite(){    //������Ϣ��ȡ��
		return this.write; 
	}
	
}
