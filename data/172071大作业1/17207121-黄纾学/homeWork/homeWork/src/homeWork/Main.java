package homeWork;

public class Main {

	public static void main(String[] args) throws Exception {

		CreatFile file = new CreatFile();

		Test judge = new Test();

		Calculator calculator = new Calculator();

		String src[] = new String[10000];// 存储算式

		String result[] = new String[10000];// 存储结果

		int effective[] = new int[10000];// 存储算式是否合法 0为合法 1,2,3为不合法

		int i = file.Read(src);

		for (int k = 0; k < i; k++) {

			effective[k] = judge.Test(src[k]);

			src[k] = judge.replace(src[k], effective[k]);

			if (effective[k] != 0) {// 当算式不合法时 便跳过中缀转后缀与计算结果 直接进入下一循环

				continue;

			}

			String src2 = "";

			src2 = calculator.Change(src[k]);

			result[k] = calculator.Cal(src2, effective[k]);

			if (result[k] == "false") {// 出现 /0 情况 算式变为不合法 直接进入下一循环

				effective[k] = 8;

				src[k] = judge.replace(src[k], effective[k]);

				continue;

			}

		}

		file.writeResult(src, result, effective, i);

	}

}
