package calcultor;

public class Formula {
	private static String[] formula;
	
	public Formula(){
		
	}
	
	public static String[] checkFile(String[] array){
		String formula[] = new String[100];
		int i = 0;
		int j = 0;
		boolean isTrue = true;
		while(array[i] != null){
			Check check = new Check(array[i]);
			i ++;
			if(check.checkAll()){
				Calcuate calcuate = new Calcuate(check.getStr());
				//if(checkRepetition(j))
				for(int k = 0;k < j;k ++){
					if(formula[k].equals(calcuate.getCal())){
						isTrue = false;
					}
				}
				if(isTrue){
					formula[j] = calcuate.getCal();
					j ++;
				}
			}
		}
		return formula;
	}
	
	/*public static boolean checkRepetition(int m){
		
		for(int n = 0; n < m; n ++){
			while(formula[n] == formula[m]){
				isTrue = false;
				break;
			}
		}
		return isTrue;
	}*/
}
