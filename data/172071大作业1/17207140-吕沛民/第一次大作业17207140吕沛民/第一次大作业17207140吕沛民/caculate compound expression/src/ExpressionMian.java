
public class ExpressionMian {

	public static void main(String[] args) throws Exception{
		FileSet file1 = new FileSet();
		String[] input1 = new String[file1.numberOfline()];
		String[] output1 = new String[file1.numberOfline()];
		input1 = file1.readFile();
		for(int i =0; i<file1.numberOfline();i++)
		{
			CheckExpression check = new CheckExpression(input1[i].replaceAll(" ", ""));
			String pression = check.errorFind();
			boolean flag = check.getdetermine();
			if(flag == true)
			{
				AddSpace space = new AddSpace(pression);
				String spacePression = space.getFixedExpression();// 获得文件信息
				System.out.println(spacePression);
				CaculateExpression Caculate = new CaculateExpression(spacePression);
				String result = Caculate.getExpressionResult();
				output1[i] =  pression +" = " + result;
			}
			else
			{
				output1[i] = "ERROR" +"\r\n" + pression;
			}
		}
		file1.writerFile(output1);
	}

}
