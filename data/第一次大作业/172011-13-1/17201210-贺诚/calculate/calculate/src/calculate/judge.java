package calculate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class judge {
	private static final String REGEX = "((^\\d+\\s*)|(^\\s*\\(\\s*\\d+\\s*([\\+\\-\\*/]\\s*\\d+\\s*)+\\)\\s*))(([\\+\\-\\*/]\\s*\\d+)\\s*|([\\+\\-\\*/]\\s*\\(\\s*\\d+\\s*([\\+\\-\\*/]\\s*\\d+\\s*)+\\)\\s*))+$";
    
	static work It = new work();
	
	public static void Judge(ArrayList<String> data) throws IOException{
		
		int count = data.size();
		for(int i = 0;i < count;i ++){
			if(data.get(i).matches(REGEX)){
				int j = 0;
				while(!data.get(i).equals( data.get(j)) && j < i){
					j ++;
				}
				if(j == i){
				    work lt = new work();
				
				    List<String> list = lt .Work(data.get(i));
				    List<String> list2 = lt.InfixToPostfix(list);
				    //System.out.println("原式为："+data.get(i));
				    //System.out.println("计算结果为："+lt.doCal(list2));
				    input.Output(data.get(i)+"="+lt.doCal(list2)+"\n");
				}
			}
			else{
				int j = 0;
				while(!data.get(i).equals( data.get(j)) && j < i){
					j ++;
				}
				if(j == i){
				   //System.out.println("ERROR");
				   //System.out.println("#"+data.get(i));
				   input.Output("ERROR");
				   input.Output("#"+data.get(i));
			    }
			}
		}
	}

}
