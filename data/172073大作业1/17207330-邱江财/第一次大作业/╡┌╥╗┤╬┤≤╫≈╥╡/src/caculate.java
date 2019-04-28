import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class caculate {
	public static int Calculation(String formula){
		int result=0;
		ScriptEngineManager manager = new ScriptEngineManager();   
		ScriptEngine engine = manager.getEngineByName("js");  
		try {result = (int) engine.eval(formula);}  
			catch (ScriptException e) {
			} 
//		System.out.print(result);
		return result;
	}	

}