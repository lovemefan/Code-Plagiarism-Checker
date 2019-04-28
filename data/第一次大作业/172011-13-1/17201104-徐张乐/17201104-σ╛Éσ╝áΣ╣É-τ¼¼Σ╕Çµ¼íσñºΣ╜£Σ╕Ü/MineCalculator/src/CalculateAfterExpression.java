//计算后缀表达式的值
public class CalculateAfterExpression {

    String exp = null;
    double[] number = new double[2000];     //以数组形式代替的栈
    int len = 0;

    public CalculateAfterExpression(String s){
        //获取后缀表达式
        this.exp = s;
    }

    public double CalcAll(){
        //计算最终结果的方法
        String[] strArr = exp.split(" ");
        //按照之前添加的空格划分区块

        for (int i = 0;i<strArr.length;i++){
            //计算每一个区块
            String temp = strArr[i];

            if (isDigital(temp)){
                //判断为数字并转换
                number[++len] = (double) Integer.valueOf(temp);
            }
            else {
                //判断不为数字则从栈中取出下一个元素和刚刚存入的元素计算
                if (len >= 2){
                    double res = CalcPart(temp);        //使用部分计算方法
                    number[++len] = res;                //将结果存起来放在栈的最上面
                }
            }
        }

        return number[len--];

    }

    private double CalcPart(String s){
        double res = 0.0;                 //代表计算结果
        double n = number[len--];       //栈顶的第一个元素
        double m = number[len--];       //栈顶的第二个元素

        switch (s){
            //计算这两个元素的结果
            case "+":res = m + n;break;
            case "-":res = m - n;break;
            case "*":res = m * n;break;
            case "/":res = m / n;break;
            default:break;
        }

        return res;     //返回计算结果
    }


    private boolean isDigital (String s){
        //判断是否为数字
        int len = s.length();

        if (len == 1 && Character.isDigit(s.charAt(0))){
            //长度为1时是否直接为数字
            return true;
        }
        else if (len > 1 && Character.isDigit(s.charAt(1))){
            //长度超过1时判断是否可能为负数
            return true;
        }
        else {
            return false;
        }
    }
}
