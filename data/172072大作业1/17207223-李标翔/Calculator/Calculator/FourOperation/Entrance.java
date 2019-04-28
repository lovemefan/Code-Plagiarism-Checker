package FourOperation;
/**
 * 四则运算程序入口
 */
public class Entrance {
	/**
	 * main函数进入文件中的表达式处理
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileOperate expression = new FileOperate();//申请一个文本中的表达式处理对象
		
		expression.buildFile();//表达式检验和运算方法
		
		System.exit(0);//程序退出
	}

}
