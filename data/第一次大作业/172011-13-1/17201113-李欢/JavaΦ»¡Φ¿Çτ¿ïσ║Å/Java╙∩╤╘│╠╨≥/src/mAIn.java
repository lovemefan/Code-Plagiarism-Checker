
public class mAIn {
	public static void main(String[] args) {
		String[] z = new String[50];
		String[] a = new String[50];
		int i = 0;

		Readfile x = new Readfile();
		x.readMethod2();
		while (x.getXep()[i] != null) {
			x.getXep()[i] = x.getXep()[i].replace(" ", "");
			a[i] = x.getXep()[i];
			RegularExpression u = new RegularExpression();
			System.out.println(u.check(a[i]));
			if (u.check(a[i]) == "right" && (u.MP(a[i]) != 2)) {
				int j = 0;
				for (int p = 0; p < i; p++) {
					if (a[i].equals(a[p])) {
						j = 1;
					}
				}
				if (j == 1) {
					
				} else {
					Stack stack = new Stack(a[i].length());
					ApplyStack fox = new ApplyStack(stack, a[i]);
					fox.process();
					String skt = fox.getPost();
					Stack stack_result = new Stack(skt.length());
					Result ptr = new Result(skt, stack_result);
					ptr.operate();
					z[i] = ptr.getResult();
					Writefile y = new Writefile(a[i] + "=" + z[i]);
					
					y.writeMethod3();
				}
			} else if (u.MP(a[i]) == 2) {
				Writefile k = new Writefile("ERROR" + "\r\n" + "#À¨ºÅ²»Æ¥¶Ô");
				k.writeMethod3();
			} else {
				Writefile k = new Writefile(u.check(a[i]));
				k.writeMethod3();
			}
			i++;
		}

	}

}
