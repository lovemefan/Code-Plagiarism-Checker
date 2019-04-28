package dazuoye;

public class adjust {
	private static int floor = 1;
	private static double t = 0;
	private static String a = null;
	private static String b = null;
	private static double c = 0.0;
	private static String z = null;
	private static String d[] = new String[4];

	public adjust() {

	}

	public adjust(String z) {
		adjust.z = z;
	}

	public String work() {
		fa y = new fa(z);
		y.divide();
		for (int i = 0; i < y.getshuzu().length; i++) {
			d[i] = y.getshuzu()[i];
		}

		if (d[0].equals("FR")) {
			if (t < Double.parseDouble(d[3])) {
				t = Double.parseDouble(d[3]);
			}

			if (floor > Integer.valueOf(d[1])) {
				b = "DOWN";
				t = (floor - Integer.valueOf(d[1])) * 0.5 + t;

			} else if (floor < Integer.valueOf(d[1])) {
				b = "UP";
				t = (Integer.valueOf(d[1]) - floor) * 0.5 + t;
			} else {
				b = "Still";
				t = t + 1.0;
			}

		} else {
			if (t < Double.parseDouble(d[2])) {
				t = Double.parseDouble(d[2]);
			}
			
			if (floor < Integer.valueOf(d[1])) {
				b = "UP";
				t = (Integer.valueOf(d[1]) - floor) * 0.5 + t;

			} else if (floor > Integer.valueOf(d[1])) {
				b = "DOWN";
				t = (floor - Integer.valueOf(d[1])) * 0.5 + t;
			} else {
				b = "Still";
				t = t + 1.0;
			}

		}
		
		
		floor = Integer.valueOf(d[1]);
		a = "" + floor;
		t = t + 1.0;
		c = t;
		return "(" + a + "," + b + "," + c + ")";
	}

	public String getshuzu() {
		return z;
	}

}
