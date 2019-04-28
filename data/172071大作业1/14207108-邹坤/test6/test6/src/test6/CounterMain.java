package test6;

public class CounterMain {
	public static void main(String[] agrs) throws Exception{
		//创建文件类
		CreateFile file1 = new CreateFile();
		//记录输入的字符串
		String []inputCount = new String[file1.line()];
		//记录输出的字符串
		String []outputCount = new String[file1.line()];
		//读取文件里面的内容
		inputCount = file1.scannerFlie();
		//对文件里面的算式进行计算
		for(int i = 0;i<file1.line();i++){
			//去掉表达式中的空格
			Checkout checkout = new Checkout(inputCount[i].replaceAll(" ", ""));
			//得到正则表达式校验过的算式
			String first = checkout.compare();
			//得到表达式是不是正确
			boolean out = checkout.getFlag();
			//如果是正确的对表达式进行计算
			if(out==true){
				//对表达式进行初步的处理，加空格
				ProcessInfix processInfix = new ProcessInfix(first);
				String infix = processInfix.getProcessInfix();
				//将表达式中缀转后缀
				Process process = new Process(infix);
				String post = process.getPostConter();
				//表达式计算结果
				CountResult resul = new CountResult(post);
				String result = resul.getCounterResult();
				outputCount[i] = first + " = " + result;
			}
			//如果是错无的输出记录错误信息
			else {
				outputCount[i] = "ERROR" + "\r\n" + first;
			}
		}
		//将错误信息写入文件当中
		file1.plintFile(outputCount);
	}

}
