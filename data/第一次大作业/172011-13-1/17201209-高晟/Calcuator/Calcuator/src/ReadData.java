import java.util.Scanner;

public class ReadData {
	public ReadData(){
		
	}
	public String[] Read() throws Exception{
		java.io.File file = new java.io.File("C:\\Users\\87912\\workspace\\Calcuator\\expression.txt");
		Scanner input = new Scanner(file);
		String[] expression = new String[1024];
		int i = 0;
		while(input.hasNext()){
			expression[i] = input.nextLine();
			i ++;
		}
		for(int m = i;m < 1024;m ++){
			expression[m] = null;
		}
		input.close();
		return expression;
	}

}
