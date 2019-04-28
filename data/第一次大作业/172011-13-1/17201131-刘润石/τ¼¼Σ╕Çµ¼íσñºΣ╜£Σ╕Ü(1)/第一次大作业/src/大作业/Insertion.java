package 大作业;
/**
 * 由于分割时不能判断是否为多位数所以用空格填充
 * @author 刘润石
 *
 */
public class Insertion {
	String infix = "";
	
	void longNum(String infix) {
        for (int i = 0; i < infix.length() - 1; i++) {//遍历字符串
            char temp1 = infix.charAt(i);
            char temp2 = infix.charAt(i + 1);
            if (isNum(temp1) && isNum(temp2)) {
                this.infix += temp1;//数字连续时
            } else {
                this.infix += temp1 + " ";//数字不连续了，向后加空格
            }
        }
        this.infix += infix.charAt(infix.length() - 1); // 将最后一个元素添加进去
    }
	
	boolean isNum(char ch){//如果是数字
    	 if (ch >= '0' && ch <= '9')
             return true;
         else
             return false;
    }
}
