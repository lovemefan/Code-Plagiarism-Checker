import java.util.*;

public class Action {
	private int index;//��ǰ�����ַ���λ��
	private String fuction;//Ҫ����ı��ʽ
//Ĭ���޲ι��취
	public Action(){
		index = 0;
		fuction = "0";
	}
//���ó�ֵ�Ĺ��췽��
	public Action(String fuction){
		this.index = 0;
		this.fuction = fuction;
	}
//�����ţ��˳����֣����������������������壬���мӼ����㣬���ؽ��
	public double suma() {
		double sum = digit();//sumΪ�����digit()Ϊ��һ�������ֵ
		
		while(index != fuction.length() && fuction.charAt(index) != ')'){
			if(fuction.charAt(index) == '+' ){
	   	    	index ++;
				sum = sum + digit();
			}
			else if(fuction.charAt(index) == '-' ){
				index ++;
				sum = sum - digit();
			}
		}
		index++;
		return sum;
		
	}
//�����ַ����ʽ�������������ţ���˳������ֵ
    public double digit(){
    	double vale = 0;
    	if(Character.isDigit(fuction.charAt(index))){ //��ǰ������ַ�Ϊ
			int flag = index;
        	while(Character.isDigit(fuction.charAt(index))){ 
        		index ++;
        		if(fuction.length() == index){
        			break;
        		}
        	}
        	vale = Integer.parseInt(fuction.substring(flag,index));
        	
		}
    	
    	if(fuction.length() != index && fuction.charAt(index) == '('){
    		index ++;
    		vale = suma();
    	}
    	
    	if(fuction.length() != index && fuction.charAt(index) == '*'){
    		index ++;
    		return vale * digit();
    	}
    	
    	if(fuction.length() != index && fuction.charAt(index) == '/'){
    		index ++;
    		return vale / digit();
    	}
    	
    	return vale;
    }
    

}
