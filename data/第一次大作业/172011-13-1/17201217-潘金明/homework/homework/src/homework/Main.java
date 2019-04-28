package homework;

public class Main {
  public static void main(String[] args) throws Exception {
	  ReadDate readdate = new ReadDate();
	  String bdString  = readdate.getData();
	 
	  System.out.println(bdString);
	
	 /* operate nbl=new operate(bdString);
	 } //
	  int result=0;
	  nbl.zz_hz();
	 result= nbl.js_nbl();
	 // nbl.
	  nbl.js_nbl();
	 // System.out.println( operate1.js_nbl());*/
	 // output output1 = new output(bdString);
	//  output1.outputData();
	 // System.out.println(bdString + " = " +result);
  }
}
//1.通过主方法 把文件读取出来的字符串 放到bdString中 
//之后 把bdString传到operate的类的构造方法中 
//之后在operate类中处理完 返回bdString的运算结果 
//之后通过主方法调用output将结果输出到result。txt中




