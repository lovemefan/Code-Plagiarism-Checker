import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Check {
		 Pattern simpleLang = Pattern.compile("\\s*?\\d+(\\s*[-+*%/]\\s*-?\\d+)*\\s*");
		Pattern innerParen = Pattern.compile("[(]([^()]*)[)]");
		public boolean validateExpr(String expr) {
		    while (expr.contains(")") || expr.contains("(")) {
		        Matcher m = innerParen.matcher(expr);
		        if (m.find()) {
		            if (!simpleLang.matcher(m.group(1)).matches()) {
		                return false;
		            }
		            expr = expr.substring(0,m.start()) + " 1 " + expr.substring(m.end());
		        } else {
		            // we have parens but not an innermost paren-free region
		            // This implies mismatched parens
		            return false;
		        }
		    }
		    return simpleLang.matcher(expr).matches();
		}
	}
	
			  
	
	
	




