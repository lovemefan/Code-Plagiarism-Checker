package calculate;

import java.util.ArrayList;

public class Mian {
	public static void main(String[] args) throws Exception{
		ArrayList<String> data = new ArrayList<>();
		
		data = input.Input();
		judge.Judge(data);
	}

}
