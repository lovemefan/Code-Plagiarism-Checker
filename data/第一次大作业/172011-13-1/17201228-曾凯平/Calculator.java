
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static void main(String[] args) {
        String src = "(15+5)*3-(3+3)*6";
        System.out.println(cal(src));
    }
    public static String cal(String src) {
        StringBuilder builder = new StringBuilder();
        if (src.contains("(")) {
            Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
            Matcher matcher = pattern.matcher(src);
            int lastEnd = 0;
            while (matcher.find()) {
				
                builder.append(src.substring(lastEnd, matcher.start()));
				System.out.println(builder.toString());
                builder.append(cal(matcher.group(1)));
                lastEnd = matcher.end();
            }
            builder.append(src.substring(lastEnd));
        } else {
            Pattern pattern = Pattern.compile("([\\d.]+)\\s*([*/])\\s*([\\d.]+)");
            builder.append(src);
            Matcher matcher = pattern.matcher(builder.toString());
            while (matcher.find()){
                float f1 = Float.parseFloat(matcher.group(1));
                float f2 = Float.parseFloat(matcher.group(3));
                float result = 0;
                switch (matcher.group(2)){
                    case "*":
                        result = f1 * f2;
                        break;
                    case "/":
                        result = f1 / f2;
                        break;
                }
                builder.replace(matcher.start(), matcher.end(),
                        String.valueOf(result));
                matcher.reset(builder.toString());
            }
            pattern = Pattern.compile("([\\d.]+)\\s*([+-])\\s*([\\d.]+)");
            matcher = pattern.matcher(builder.toString());
            while (matcher.find()){
                float f1 = Float.parseFloat(matcher.group(1));
                float f2 = Float.parseFloat(matcher.group(3));
                float result = 0;
                switch (matcher.group(2)){
                    case "+":
                        result = f1 + f2;
                        break;
                    case "-":
                        result = f1 - f2;
                        break;
                }
                builder.replace(matcher.start(), matcher.end(),
                        String.valueOf(result));
                matcher.reset(builder.toString());
            }
            return builder.toString();
        }
        System.out.println(builder);
        return cal(builder.toString());
    }
}

