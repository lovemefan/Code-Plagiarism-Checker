
public class Figure {

	private double[] figure =new double[500];
	private int n = -1;


	public Figure() {
		
	}
   //��ջ
	public void pushFigure(double x) {
		figure[++n] = x;
	}
   //��ջ
	public double popFigure() {
		
			return figure[n--];
		}
	

	public boolean Decide() {
		return n == -1 ? true : false;
	}

	// �鿴��ǰ������λ�ü�ջ�ĳ���
	public int getN() {
		return n;
	}
   public double searchFigure(){
	   return figure[n];
   }

}
