import java.util.ArrayList;
import java.util.List;

public class deal {
	public deal() {

	}

	public String deal(String enterString) {
		String midString = "";
		for (int i = 0; i < enterString.length(); i++) {
			if (enterString.charAt(i) != ' ') {
				midString += enterString.charAt(i);
			}
		}
		// System.out.println("mid:"+midString);
		return midString;
	}

	public List<String> dealMidList(String midString) {
		List<String> midList = new ArrayList<String>();
		String temp = "";
		for (int i = 0; i < midString.length(); i++) {
			if (Character.isDigit(midString.charAt(i))) {
				temp += midString.charAt(i);
			} else {
				if (temp.length() > 0) {
					midList.add(temp);
					temp = "";
				}
				midList.add(Character.toString(midString.charAt(i)));
			}
		}
		if (temp.length() > 0) {
			midList.add(temp);
		}

		return midList;
	}
}