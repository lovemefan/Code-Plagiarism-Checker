package greatproject;

public class Combine {
	public void start() {
		String[] newS = null;
		String[] oldS = null;
		ToFile tofile = new ToFile();
		oldS = tofile.getExpre();
		newS = new String[oldS.length];
		for (int i = 0; i < oldS.length; i++) {
			Check c = new Check(oldS[i]);
			if (i > 0 && oldS[i].equals(oldS[i - 1])) {
				continue;
			} else if (c.judge().equals("�޴���")) {
				Translate tr = new Translate(oldS[i]);
				Caculate ca = new Caculate(tr.tran());
				if (ca.getResult().equals("��ĸ����Ϊ0")) {
					newS[i] = "ERROE  \r\n#   " + "��ĸ����Ϊ0";
				} else {
					newS[i] = oldS[i] + "=" + ca.getResult();
				}
			} else if (c.judge().equals("�ո�")) {
				oldS[i] = oldS[i].replaceAll("\\s+", "");
				i--;
			} else {
				newS[i] = "ERROE  \r\n#   " + c.judge();
			}
		}
		FileTo fileto = new FileTo(newS);
		fileto.wriResult();
	}

}
