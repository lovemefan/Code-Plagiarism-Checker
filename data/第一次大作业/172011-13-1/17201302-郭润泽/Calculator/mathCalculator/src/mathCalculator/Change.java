package mathCalculator;

public class Change { //ת��׺���ʽ��
	
	private stringStack stack;  //�Զ����ִ�����ջ
	private String infix;    //�������׺���ʽ
    private String post = "";     //�洢�õ��ĺ�׺���ʽ
    
    public Change(String infix){   //���췽��������׺���ʽ
    	this.infix = infix;
    	stack = new stringStack(infix.length());
    }
    
    public boolean number(char ch){    //�ж�����
    	return (ch >= '0' && ch <= '9');
    }
    
    public String preProcess(){  //Ԥ���������ͷ��ż���ӿո��Ա����
    	String str = "";
    	for (int i = 0; i < infix.length() - 1; i ++){
    		if ( number( infix.charAt(i)) && number( infix.charAt(i + 1))){
    			str += infix.charAt(i);             //����ֱ�ӽ�
    		}
    		else {
    			str += infix.charAt(i) + " ";       //�ҵ����ֺͷ���֮����ӿո�
    		}
    	}
    	str += infix.charAt(infix.length() - 1);   //������һ��Ԫ��
    	return str;
    }
    
    public int getRank(String str){    //�������ȼ�
    	if (str.equals("+") || str.equals("-")){
          	return 1; 
        }
    	return 2;
    }
    
    
    public void getOp(String str,int rank){    //�����������������ȼ���ջ	���ջ
    	while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {          //����������ֱ����ջ
                stack.push(top);
                break;
            } 
            else {
                int rank1 = getRank(top); 
                if (rank1 < rank) {       //���ջ��Ԫ�����ȼ��͵�ǰԪ����ջ
                    stack.push(top);
                    break;
                } 
                else {
                    post += " " + top;   //���ջ��Ԫ�����ȼ��߳�ջ
                }
            }
        }
        stack.push(str);
    }
    
    private void getParent() {    //��ջ�ڴ��ջ
    	while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {
                break;
            } 
            else {
                post += " " + top;
            }
        }
    }
    
    public String process(){   //�������
    	String[] s = preProcess().split(" ");   //���ݿո�ָ�

    	for (int i = 0; i < s.length; i++) { 
            String str = s[i];                 
            if (str.equals("+") || str.equals("-")){   //+��-���ȼ�Ϊ1
            	getOp(str, 1);
            }
            else if(str.equals("*") || str.equals("/")){  //*��/���ȼ�Ϊ2
            	getOp(str, 2);
            }
            else if(str.equals("(")){   //(ֱ����ջ
            	stack.push(str);
            }
            else if (str.equals(")")){  //)��ջ
            	getParent();
            }
            else {
                post += " " + str;    //����ֱ�����
            }
        }
    	
    	while (!stack.isEmpty()) {   //��ʣ��Ԫ�ؼ���post
            post += " " + stack.pop();
        }
    	
    	return post.trim();    //ȥ����ͷ��β�ո�
    }
    
}
