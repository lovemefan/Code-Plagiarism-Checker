package BigClasswork;

public class BigClasswork {
	public static void main(String[] args) {
		String fileName1 = "data.txt";
		String fileName2 = "result.txt";
		DataIn di = new DataIn(fileName1);
		di.dataIn();

		for (int i = 0; i < di.getI(); i++) {
			Check check = new Check(di.getExpression()[i]);
			String noBlank = di.getExpression()[i].replace(" ", "");// 表达式去空格

			if (check.check() == 0) {
				int flag = 0;
				if (i > 0) {
					for (int j = 0; j < (i-1); j++) {// 判断表达式是否重复
						String noBlank1 = di.getExpression()[j].replaceAll(" ", "");
						if (noBlank.equals(noBlank1)) {
							flag = 1;
							break;
						}
					}
				} 
				if (flag == 0){
					Stack stack = new Stack(noBlank.length());
					Transform expTrans = new Transform(noBlank, stack);
					expTrans.transform();// 中缀表达式转后缀表达式

					String str = expTrans.getOutput();
					Stack result = new Stack(str.length());
					Calculate re = new Calculate(str, result);
					re.operate();
					String outcome = re.getResult();// 后缀表达式计算结果
					String s = di.getExpression()[i] + " = " + outcome;// 将结果和表达式拼接成一个字符串
					DataOut da = new DataOut(s, fileName2);
					da.dataOut();// 将信息输入文件
				}
			
			} else {
				// String[] message =
				// {"运算符连续出现","）右边是数字的情况","(左边是数字的情况","匹配
				//空括号","右括号左边含有运算符","左括号右边有运算符","除数后面是0","第一个为运算符","以符号结尾",")(连续"};
				String me = null;
				String[] message = { "运算符连续出现", "）右边是数字的情况", "(左边是数字的情况", "空括号", "右括号左边含有运算符", "左括号右边有运算符", "除数后面是0",
						 "第一个为运算符", "以符号结尾",")(连续","括号不配对","表达式中含有非法字符"};// 错误信息数组
				for (int j = 0; j < 13; j++) {
					if (check.check() == (j+1)) {
						me = message[j];// 将错误信息和错误对应
						break;
					}
				}
				String outcome = "ERROR   \r\n# " + me;
				DataOut da = new DataOut(outcome, fileName2);
				da.dataOut();
			}
		}
	}
}
