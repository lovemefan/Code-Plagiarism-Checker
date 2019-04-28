
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		// 创建变长数组，储存表达式
		ArrayList<String> ex = new ArrayList<String>();
		// 调用FileR方法，将文件中的表达式读入变长数组
		ex = File.FileR();
		// 调用Expression方法，去掉表达式中的空格
		ex = Expression.Expression(ex);
		// 调用ExpressionIgnoreTheSame方法，将相同的表达式滤掉
		ex = Expression.ExpressionIgnoreTheSame(ex);
		// 创建变长数组储存表达式的合法信息
		ArrayList<String> legality = new ArrayList<String>();
		// 合法性序列
		legality = Expression.ExpressionLegality(ex);
		// 调用方法计算结果
		ArrayList<String> result = new ArrayList<String>();
		// 结果序列
		result = Calculation.Calculate(ex, legality);
		// 传入文件
		File.FileW(ex, result);
	}

}
