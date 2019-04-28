import java.util.*;    

public class Operate {
	
	private String[] result ;//结果数组，表达式合法存入计算结果，不合法存入错误类型
	private boolean[] correct; //存表达式的合法性，true合法，false不合法，默认true
	
	public Operate(){
		
	}
	
	public void set(String[] result){//初始化数组
		this.result = result;
		boolean[] co = new boolean[result.length];
		for (int i = 0 ;i <result.length ;i++){
			co[i] = true;
		}
		this.correct = co;
	}
	
	public void checkout(){
		for(int j = 0; j<result.length ; j++){//用于判断表达式的合法性
			String corre = result[j].substring(0, result[j].length()-1);
		    Checkout chec = new Checkout(corre,correct[j]);
		    chec.check();
		    result[j] = chec.getdata();
		    correct[j] = chec.getcorr();
	
		}
		for(int k = 0; k<result.length ; k++){//将合法的表达式送去计算
			if (correct[k] == true){
				Result res = new Result("("+result[k]+")#");			
				double a = res.caculate();//得到计算结果
				String re = result[k].substring(0, result[k].length());
				result[k] = re + "=" + a;
			}
			
		}
	}
	public String[] getresult(){
		return result;
	}
	public boolean[] getcorrect(){
		return correct;
	}

}
