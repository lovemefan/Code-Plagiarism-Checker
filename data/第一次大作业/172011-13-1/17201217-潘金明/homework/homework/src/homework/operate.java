package homework;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class operate {
	private Stack<String> czf_stack = new Stack<>(); //存放运算符的栈
	  private   Stack<String> ysbds1_stack = new Stack<>(); 
	private ArrayList<String> ysbds_list = new ArrayList<>(); //存放 原始表达式的 arraylist
	//private ArrayList<String> ysbds1_list = new ArrayList<>(); //存放 错误表达式的 arraylist
    private ArrayList<String> nblbds_list = new ArrayList<>(); // 存放转换后的 逆波兰式
    private static final int One = 1; 
    private static final int Two = 3; //定义算法的优先级
    private static final int Three = 5;
    private static Stack<String> ys_stack = new Stack<>(); 
  
public operate(String bdString){//分割字符串
	StringTokenizer stringTokenizer = new StringTokenizer(bdString, "+-*/()",true);
	while(stringTokenizer.hasMoreTokens()){//返回是否含有空格符
		ysbds_list.add(stringTokenizer.nextToken());
	}
	
}
public operate() {
	
}
public boolean isNum(String str){
	  if(str.matches("[0-9]+")){ //这里使用正则表达式 验证是否是数字
	  //System.out.println("Y");
	    return true;
	  }
	  else{
	//System.out.println("#非法字符串");q11
	    return false;
	 }
	

}
public boolean isCzf(String str){
    if(str.matches("[\\+\\-\\*\\/\\(\\)]")){
    //System.out.println("Y");
    return true;
    }
    else{
   //System.out.println("#非法字符串");
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
//判断优先级 

public boolean isYxj(String str1,String str2){
     return getYxj(str1) > getYxj(str2); 
     
}


public void stack_czf(String czf){
	 //判断当前栈内是否为空
	 if(czf_stack.isEmpty()){
	     czf_stack.push(czf);
	     return;
	 }
	 //判断是否为 (
	 if("(".equals(czf)){
		 czf_stack.push(czf);
		     return;
    //判断是否为 )
	 }
	 if(")".equals(czf)){
		 String string = "";
		 while(!"(".equals(string = czf_stack.pop())){
		     nblbds_list.add(string);
		 }
		 return;
	  }
	//如果 当前栈顶元素是 ( 直接入栈
	 if("(".equals(czf_stack.peek())){
	     czf_stack.push(czf);
	     return;
	}
	// 判断 与 栈顶元素的优先级 , > 为true
	 if(isYxj(czf, czf_stack.peek())){
	    czf_stack.push(czf);
	       return;
	  }
	 if(!isYxj(czf, czf_stack.peek())){
		 nblbds_list.add(czf_stack.pop());
		 stack_czf(czf); //这里调用函数 本身，并将本次的操作数传参
		 }
	 
		 }
public String stack_ysbds1 (){
	for(String str:ysbds_list){
		ysbds1_stack.add(str);
	}
	return ysbds1_stack.pop();
}
public void zz_hz(){	 
// 遍历原始表达式list  
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
         
          System.out.println("#ERROR非法运算符");
        }        
   }
 // 遍历完原始表达式后 将操作符栈内元素 全部添加至 逆波兰表达式list
    while(!czf_stack.isEmpty()){
    //System.out.println("即将 " + czf_stack.peek());
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
	 return Integer.parseInt(ys_stack.pop()); //最后 栈中元素 即为结果
	 
}

}

