import java.util.regex.Pattern;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

public class Check {
   private String str;

	public void check(String str) {
		String p1 = "[\\S]*[)][0-9][\\S]*";
		Pattern pater1 = Pattern.compile(p1);// )�ұ�������
		Matcher m1 = pater1.matcher(str);
		if (m1.find()) {
			this.str = str + "\r\nERROR\r\n#)�ұ�������";
		}
		String p2 = "[\\S]*[0-9][(][\\S]*";
		Pattern pater2 = Pattern.compile(p2);// (���������
		Matcher m2 = pater2.matcher(str);
	    if (m2.find()) {
			this.str = str + "\r\nERROR\r\n#(���������";
		}
		String p3 = "[\\S]*[(][)][\\S]*";
		Pattern pater3 = Pattern.compile(p3);// ������
		Matcher m3 = pater3.matcher(str);
		if (m3.find()) {
			this.str = str + "\r\nERROR\r\n#������";
		}
		String p4 = "[\\S]*[+-/*/]{2,}[\\S]*";
		Pattern pater4 = Pattern.compile(p4);// ���������
		Matcher m4 = pater4.matcher(str);
		if (m4.find()) {
			this.str = str + "\r\nERROR\r\n#���������";
		}
		String p5 = ("[^\\d\\+\\-\\*\\/\\(\\)]");
		Pattern pater5 = Pattern.compile(p5);// �Ƿ��ַ�
		Matcher m5 = pater5.matcher(str);
		if (m5.find()) {
			this.str = str + "\r\nERROR\r\n#�Ƿ��ַ�";
		}
		String p6 = ("^$");
		Pattern pater6 = Pattern.compile(p6);// ���ַ���
		Matcher m6 = pater6.matcher(str);
		if (m6.find()) {
			this.str = str + "\r\nERROR\r\n#���ַ���";
		}
		String p7 = "[\\S]*[+-/*/][)][\\S]*";
		Pattern pater7 = Pattern.compile(p7);// )���Ϊ�����
		Matcher m7 = pater7.matcher(str);
		if (m7.find()) {
			this.str = str + "\r\nERROR\r\n#)���Ϊ�����";
		}
		String p8 = "[\\S]*[(][+-/*/][\\S]*";
		Pattern pater8 = Pattern.compile(p8);// (�ұ�Ϊ�����
		Matcher m8 = pater8.matcher(str);
		if (m8.find()) {
			this.str = str + "\r\nERROR\r\n#(�ұ�Ϊ�����";
		}
		String p9 = "^[+-/*/]|[+-/*/]$";
		Pattern pater9 = Pattern.compile(p9);// ��β�������
		Matcher m9 = pater9.matcher(str);
		if (m9.find()) {
			this.str = str + "\r\nERROR\r\n#��β�������";
		}
		String p10 = "[[(]|[)]{2,}[[(]|[)]{4,}]]";
		Pattern pater10 = Pattern.compile(p10);// ���Ų�ƥ��
		Matcher m10 = pater10.matcher(str);
		if (m10.find()) {
			this.str = str + "\r\nERROR\r\n#���Ų�ƥ��";
		}
		 
	}

    public String getStr(){
    	return str;
    }
    
    public void setStr(String str){
    	this.str = str;
    }
    
  //ɾ����ͬ�ı��ʽ
  	public static String[] delete(String[] str) {
  		List<String> list = new LinkedList<String>();
  		for (int i = 0; i < str.length; i++) {
  			if (!list.contains(str[i])) {
  				list.add(str[i]);
  			}
  		}
  		String[] newStr = list.toArray(new String[list.size()]);
  		return newStr;
  	}
}

