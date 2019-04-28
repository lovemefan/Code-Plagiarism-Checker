
public class Figure {

	private double[] figure =new double[500];
	private int n = -1;


	public Figure() {
		
	}
   //进栈
	public void pushFigure(double x) {
		figure[++n] = x;
	}
   //出栈
	public double popFigure() {
		
			return figure[n--];
		}
	

	public boolean Decide() {
		return n == -1 ? true : false;
	}

	// 查看当前数所在位置既栈的长度
	public int getN() {
		return n;
	}
   public double searchFigure(){
	   return figure[n];
   }

}
