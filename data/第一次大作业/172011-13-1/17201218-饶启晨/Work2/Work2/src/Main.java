import java.io.IOException;


public class Main {
	static Cal b;
	//private static String cs[] = new String[50];
	
	public static void main(String[] args) throws IOException{
		wenjian wenjian = new wenjian();
		int flag;	
		try {
			String cs[] = new String[50];
			String s[] = new String[50];
			for(int i=0;i<50;i++) {
			 s[i] = wenjian.array();
			 }
			cs[0]=s[0];
			for(int i=1;i<51;i++) {
				if(s[i]==null) {
					break;
				}else {
				for(int j = 0;j<50;j++) {
					if(s[i].equals(cs[j]) != true) {
						cs[j+1]=s[i];
					}
				}
				}
			}
			 for(int i=0;i<50;i++) {
			 if(cs[i]==null) {
				 break;
			 }
			if(cs[i] != null) {
				flag = regular.check(cs[i]);
				String xin;
				switch (flag) {
				case 0:
					b = new Cal(cs[i]);
					if(cs[i].matches("(.*)[^\\0123456789](.*)")) {
						xin=cs[i];
						xin = xin+"="+xin;
						  wenjian.input(xin);
					}
					else {
					b.toPostFix();
					b.calc();
				    xin=cs[i];
				    xin = xin + "="+b.calc();
				    wenjian.input(xin);
				    }
					break;
				case 1:
					//System.out.println("ERROR: "
							//+ "#���������Ƿ��ַ�");
					xin="ERROR: #���������Ƿ��ַ�";
					wenjian.input(xin);
					break;
				case 2:
					//System.out.println("ERROR: "
							//+ "#�����������������");
					xin="ERROR:#�����������������";
					wenjian.input(xin);
					break;
				case 3:
					//System.out.println("ERROR: "
							//+ "#���ʽ��������ұ�û������");
					xin="ERROR: #���ʽ��������ұ�û������";
					wenjian.input(xin);
					break;
				case 4:
					//System.out.println("ERROR: "
							//+ "#���ʽ��(����ǷǷ��ַ�");
					xin="ERROR: #���ʽ��(����ǷǷ��ַ�";
					wenjian.input(xin);
					break;
				case 5:
					//System.out.println("ERROR: "
							//+ "#���ʽ��)�ұ��ǷǷ��ַ�");
					xin="ERROR: #���ʽ��)�ұ��ǷǷ��ַ�";
					wenjian.input(xin);
					break;
				case 6:
					//System.out.println("ERROR: "
							//+ "#���ʽ��(����ǷǷ��ַ�");
					xin="ERROR: #���ʽ��(����ǷǷ��ַ�";
					wenjian.input(xin);
					break;
				case 7:
					//System.out.println("ERROR: "
							//+ "#���ʽ��(�ұ��ǷǷ��ַ�");
					xin="ERROR: #���ʽ��(�ұ��ǷǷ��ַ�";
					wenjian.input(xin);
					break;
				case 8:
					//System.out.println("ERROR: "
							//+ "#���ʽ��)����ǷǷ��ַ�");
					xin="ERROR: #���ʽ��)����ǷǷ��ַ�";
					wenjian.input(xin);
					break;
				case 9:
					//System.out.println("ERROR: "
							//+ "#���ʽ�д��ڿ�����");
					xin="ERROR:#���ʽ�д��ڿ�����";
					wenjian.input(xin);
					break;
					default:;
				}
			}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
