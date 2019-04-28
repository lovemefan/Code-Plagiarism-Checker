
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class resolve {
	
	public static boolean ceshi(String string){
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		try {
		Object obj = engine.eval(string);
		//System.out.println(obj.toString());
		
		} catch (Exception e) {
		System.out.println(" ‰»Î¥ÌŒÛ");
		return false;
		}
		return true;
	}
}
