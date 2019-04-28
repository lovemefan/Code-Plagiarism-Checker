package homework;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class operate {
	private Stack<String> czf_stack = new Stack<>(); //����������ջ
	  private   Stack<String> ysbds1_stack = new Stack<>(); 
	private ArrayList<String> ysbds_list = new ArrayList<>(); //��� ԭʼ���ʽ�� arraylist
	//private ArrayList<String> ysbds1_list = new ArrayList<>(); //��� ������ʽ�� arraylist
    private ArrayList<String> nblbds_list = new ArrayList<>(); // ���ת����� �沨��ʽ
    private static final int One = 1; 
    private static final int Two = 3; //�����㷨�����ȼ�
    private static final int Three = 5;
    private static Stack<String> ys_stack = new Stack<>(); 
  
public operate(String bdString){//�ָ��ַ���
	StringTokenizer stringTokenizer = new StringTokenizer(bdString, "+-*/()",true);
	while(stringTokenizer.hasMoreTokens()){//�����Ƿ��пո��
		ysbds_list.add(stringTokenizer.nextToken());
	}
	
}
public operate() {
	
}
public boolean isNum(String str){
	  if(str.matches("[0-9]+")){ //����ʹ��������ʽ ��֤�Ƿ�������
	  //System.out.println("Y");
	    return true;
	  }
	  else{
	//System.out.println("#�Ƿ��ַ���");q11
	    return false;
	 }
	

}
public boolean isCzf(String str){
    if(str.matches("[\\+\\-\\*\\/\\(\\)]")){
    //System.out.println("Y");
    return true;
    }
    else{
   //System.out.println("#�Ƿ��ַ���");
       return false;
      }
}
public void stack_ysbds (String str){
	operate a1=new operate();
	 boolean a=a1.isNum(str);
	 boolean b=a1.isCzf(str);
	 if(a&&b!=true){
		 if(ysbds1_stack.isEmpty()){
			  ysbds1_stack.push(str);
			  return;
		 }
		 //System.out.println( ysbds1_stack.push(str));
		 ysbds1_stack.pop();
	 }
	
}
public int getYxj(String str){

	 switch(str){
 
	      case "(":return Three;
	      case "*":
	      case "/":return Two;
	      case "+":
	      case "-":return One;
	      case ")":return 0;
	      default : return -1;
	 }
}
//�ж����ȼ� 

public boolean isYxj(String str1,String str2){
     return getYxj(str1) > getYxj(str2); 
     
}


public void stack_czf(String czf){
	 //�жϵ�ǰջ���Ƿ�Ϊ��
	 if(czf_stack.isEmpty()){
	     czf_stack.push(czf);
	     return;
	 }
	 //�ж��Ƿ�Ϊ (
	 if("(".equals(czf)){
		 czf_stack.push(czf);
		     return;
    //�ж��Ƿ�Ϊ )
	 }
	 if(")".equals(czf)){
		 String string = "";
		 while(!"(".equals(string = czf_stack.pop())){
		     nblbds_list.add(string);
		 }
		 return;
	  }
	//��� ��ǰջ��Ԫ���� ( ֱ����ջ
	 if("(".equals(czf_stack.peek())){
	     czf_stack.push(czf);
	     return;
	}
	// �ж� �� ջ��Ԫ�ص����ȼ� , > Ϊtrue
	 if(isYxj(czf, czf_stack.peek())){
	    czf_stack.push(czf);
	       return;
	  }
	 if(!isYxj(czf, czf_stack.peek())){
		 nblbds_list.add(czf_stack.pop());
		 stack_czf(czf); //������ú��� �����������εĲ���������
		 }
	 
		 }
public String stack_ysbds1 (){
	for(String str:ysbds_list){
		ysbds1_stack.add(str);
	}
	return ysbds1_stack.pop();
}
public void zz_hz(){	 
// ����ԭʼ���ʽlist  
    for(String str:ysbds_list){
//System.out.println("-> " + str);
        if(isNum(str)){
            nblbds_list.add(str);
         }
        else if(isCzf(str)){
//TODO
       stack_czf(str);

        }
        else{
        	if(str!="("||str!=")"||str!="+"||str!="-"||str!="*"||str!="/")
         
          System.out.println("#ERROR�Ƿ������");
        }        
   }
 // ������ԭʼ���ʽ�� ��������ջ��Ԫ�� ȫ������� �沨�����ʽlist
    while(!czf_stack.isEmpty()){
    //System.out.println("���� " + czf_stack.peek());
        nblbds_list.add(czf_stack.pop());
    }
    
}
public int jsff(String s1,String s2,String s3){
	 int a = Integer.parseInt(s2);
	 int b = Integer.parseInt(s1);
	 switch(s3){
	     case "+":return a+b;
	     case "-":return a-b;
	     case "*":return a*b;
	     case "/":return a/b;
	     default : return 0;
	 }
	 
}
public int js_nbl(){
	 for(String str:nblbds_list){
	     if(isNum(str)){
	         ys_stack.push(str);
	     }
	     else{

	         ys_stack.push(String.valueOf(jsff(ys_stack.pop(), ys_stack.pop(), str)));
	     }
	 }
	 return Integer.parseInt(ys_stack.pop()); //��� ջ��Ԫ�� ��Ϊ���
	 
}

}

