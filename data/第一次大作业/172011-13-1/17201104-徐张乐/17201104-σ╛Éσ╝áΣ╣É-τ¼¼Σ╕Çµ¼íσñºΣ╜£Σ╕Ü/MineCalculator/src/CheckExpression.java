//检查表达式输入是否存在明显错误的类
public class CheckExpression {
    String s = "";
    String ans = null;      //存有错误信息，无错误时返回null

    CheckExpression (String s) {
        this.s = s;  // 传入表达式
    }

    public String check() {

        if (s.matches("[\\S]*[+\\-/*/][+\\-/*/][\\S]*")) {
            // 两个运算符连续出现
            ans = "ERROR: \n#两个连续运算符！";
        }

        else if (s.matches("[\\S]*[+\\-/*/]")) {
            //当运算符右边没有数字
            ans = "ERROR：\n#运算符右边没有数字！";
        }

        //else if (s.matches("[\\S]*[A-Z][\\S]*") || s.matches("[\\S]*[a-z][\\S]*") || s.matches("[\\S]*[!@#$%^&_{}:'?><,./|;~`][\\S]*")){
        //    ans = "ERROR：含有非法字符！";
        //}

        else if (s.matches("[\\S]*[^0-9+\\-/*/()][\\S]*")){
            //表达式中存在除了0到9，+-*/()以外的字符
            ans = "ERROR：\n#含有非法字符！";
        }

        else if (s.matches("[\\S]*[+\\-/*/(][\\-][(][\\S]*")) {
            //左括号左侧运算符不合法
            ans = "ERROR: \n#左括号左边出现非法字符！";
        }

        else if (s.matches("[\\S]*[)][0-9][\\S]*")) {
            // 当右括号右边是数字
            ans = "ERROR: \n#右括号右边出现非法字符！";
        }

        else if (s.matches("[\\S]*[0-9][(][\\S]*")) {
            // 当左括号左边是数字
            ans = "ERROR:\n #左括号左边出现非法字符！";
        }

        else if (s.matches("[\\S]*[(][/*/+][\\S]*")) {
            // 当左括号右边是+ * /
            ans = "ERROR:\n #左括号右边出现非法字符！";
        }

        else if (s.matches("[\\S]*[+\\-/*/][)][\\S]*")) {
            // 当右括号左边是+ - * /
            ans = "ERROR:\n #右括号左边出现非法字符！";
        }

        else if (s.matches("[\\S]*[(][)][\\S]*")) {
            //存在空括号
            ans = "ERROR:\n#存在空括号";
        }

        //与当前方法中所有错误形式都不符合，即返回null
        return ans;
    }
}
