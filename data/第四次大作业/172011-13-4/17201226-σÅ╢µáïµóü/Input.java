package Hellowworld;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Input {


	String[] inputAcquisition(String s) {
	
		s = s.replaceAll("\\(|\\)", "");
		// ×ª»»String×Ö·û´®Êý×é
		String[] s1 = s.split(",");
		return s1;
	}
	
	public LinkedList<String> getList(){
		Scanner sc = new Scanner(System.in);
		LinkedList<String> list = new LinkedList<>();
		
		while(true) {
	    String Command = sc.next();
		if(Command.equals("RUN")) {
			break;
		} else {
			list.add(Command);
		}

		}

		return list;
	}
	

}