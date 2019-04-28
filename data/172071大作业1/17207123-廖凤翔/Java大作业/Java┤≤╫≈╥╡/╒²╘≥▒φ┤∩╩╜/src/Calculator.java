import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {
	public static void main(String[] args) throws ScriptException, IOException {
		File f = new File("src\\reserve");
		/*store f1 = new store();
		f1.store(); */
		judge f2 = new judge();
		f2.Read(f);
	}
}
