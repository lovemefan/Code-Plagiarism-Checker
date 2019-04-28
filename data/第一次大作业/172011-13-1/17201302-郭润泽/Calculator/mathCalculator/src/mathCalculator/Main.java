package mathCalculator;

import java.util.ArrayList;

public class Main{   //主类
	
	private  static ArrayList<String> input;    //读入的字串数组
	private  static ArrayList<String> temp;     //备用字串数组，用于查重
	private  static ArrayList<String> write;    //要写入文件的字串数组
	private  static file F;                     //文件读写对象
	private  static Check check;                //表达式检验对象
	
	public static String add0(int x , String str){
		String res = str;
		StringBuilder sb = new StringBuilder();  //StringBuilder类创建对象
		sb.append(res);  
		sb.insert(x,"0");                       //指定位置加0
		res = sb.toString();
		return res;
	}
	
 	public static String deal(String str){      //计算合法表达式
		if(check.checkStart (str)){              //如果开头是负号 ，在开头负号前面加0
			str = add0(0,str);
		 }
		 else if(check.checkB(str)){              //如果负号在左括号后面
			 for (int j = 0;j < str.length()-1;j++){         
				 if(str.charAt(j) == '(' && str.charAt(j+1) == '-'){
					 //在每个负号左括号组合中往左括号和负号中间加0
	    			  str = add0(j+1,str);
				  }
			  }
		  }
		  Change infix = new Change(str);            //将处理完的合法表示转为后缀表达式
          String post = infix.process();             
          Result ans = new Result(post);             //利用后缀表达式计算结果
          String s = "" + ans.process();
          return s;
	}
	
	public static void process(ArrayList<String> input){			//对读入的字串数组处理
		for (int i = 0;i < input.size();i++){ 
			String str = input.get(i);      
			str = str.replaceAll(" ", "");                         //过滤空格
			boolean flag = true ;
			flag = check.process(str);                   
			if ( flag && !temp.contains(str) ){                     //合法，且没有重复指令则计算
				temp.add(str);                                      //添加到备用字串数组，以便查重
				String s = deal (str);                               
                write.add(input.get(i).replaceAll(" ", "") + "=" + s);                  //将答案加入要写入文件的字符串数组
    		} 
			else if(!temp.contains(str)){                           //不合法 且没有重复指令
				String[] t = new String[2];
				t = check.getWrite();                                //记录非法信息
				write.add(t[0]);
				write.add(t[1]);
			}
        }
		F.Write(write);
	}
	
    public static void init( ) {		 //初始化各个对象信息
    	write = new ArrayList<String>();
		input = new ArrayList<String>();
		temp = new ArrayList<String>();
		F = new file();
		check = new Check();		
	} 
	
	public static void main(String[] args) {
		init();                  //初始化
		input = F.getRead();     //读入表达式
		process(input);          //处理表达式
	} 

}
