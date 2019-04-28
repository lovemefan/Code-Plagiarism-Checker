import java.util.*;
public class Main {
	
	//判断重复表达式
	public static int compareEqual(String[] strs){
	    boolean flag = false;    //字符串数组中是否有两个字符串相等
	    String temp = "";
	    int i=0;
	    for ( i = 0; i < strs.length; i++) {
	        if (temp.contains(strs[i]+",")) {
	            flag = true;
	            //System.out.println(i+1);
	            break;    //若果有重复就直接跳出循环
	        }
	        temp += strs[i] + ",";    //将已经比较过的拼接成字符串
	        
	    }
	    return i;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		FileOperation f = new FileOperation();
		Calculator ca = new Calculator();
		Check c=new Check();
		String[] stringArr = f.readToString("r.txt");
		
		//调用判断重复函数
		int posi=compareEqual(stringArr);
		
		
		Expression[] e = new Expression[stringArr.length];
		for(int i = 0 ; i < stringArr.length ; i ++)
        {
			if(posi == i){
				f.writeFile("w.txt", "ERROR#与以上其中一个表达式重复"+stringArr[i]);
				continue;
			}
			if( 1 == stringArr[i].length())
			{
				f.writeFile("w.txt", "ERROR#"+stringArr[i]);
					continue;
			}
	            e[i] = new Expression();
	            e[i].setEx(stringArr[i]);
	            if(c.validateExpr(e[i].getEx())){
	            	long result = ca.caculate(e[i].getEx());
	            	f.writeFile("w.txt",e[i].getEx() + " = " + result );
	            }
	            else{
	            	f.writeFile("w.txt", "ERROR#"+stringArr[i]);
	            }
	         System.out.println("计算完毕！");
	         
        }
	}

		

}
