import java.util.*;

public class Action {
	private int index;//当前处理字符的位置
	private String fuction;//要计算的表达式
//默认无参构造法
	public Action(){
		index = 0;
		fuction = "0";
	}
//设置初值的构造方法
	public Action(String fuction){
		this.index = 0;
		this.fuction = fuction;
	}
//将括号，乘除部分，单独的数视作独立的整体，进行加减运算，返回结果
	public double suma() {
		double sum = digit();//sum为结果，digit()为第一个整体的值
		
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
//处理字符表达式，返回数，括号，或乘除运算的值
    public double digit(){
    	double vale = 0;
    	if(Character.isDigit(fuction.charAt(index))){ //当前处理的字符为
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
