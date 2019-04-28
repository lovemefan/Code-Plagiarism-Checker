import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) throws IOException {
		Enter enter = new Enter();
		enter.enter();

		String enterList[] = enter.getEnterList();
		int time = enter.getTime();

		Output op=new Output();
		op.OutPutToFile(time, enterList);
/*
		List<String> Flag = new ArrayList<String>();

		for (int i = 1; i <= time; i++) {
			int flag = 0;
			// System.out.println(enterList[i]);
			if (check.check1(enterList[i]).equals("true") != true) {
				System.out.println("ERROR");
				System.out.println("#" + check.check1(enterList[i]));
			} else if (check.check2(enterList[i]).equals("true") != true) {
				System.out.println("ERROR");
				System.out.println("#" + check.check2(enterList[i]));
			} else {
				dealMid dm = new dealMid();
				midToLater mtl = new midToLater();
				dealLaterList dll = new dealLaterList();

				String mid = dm.deal(enterList[i]);

				for (int j = 0; j < Flag.size(); j++) {
					if (mid.equals(Flag.get(j))) {
						System.out.println("表达式重复计算 直接进行下一个表达式运算");
						flag = 1;
						break;
					}
				}
				if (flag == 1)
					continue;

				Flag.add(mid);

				System.out.print(mid);
				System.out.print("=");

				String s = String.format("%.1f",
						dll.dealLaterList(mtl.midToLater(dm.dealMidList(dm.deal(enterList[i])))));
				System.out.println(s);
			}

		}*/

	}

}
