import java.util.*;
import java.io.*;

public class CalculatorMain {
    public static void main(String[] args) throws IOException{
        //Scanner input = new Scanner(System.in);
        Map<String, Double> map = new HashMap<String, Double>();        //判断是否重复输入的map

        String PathFile  = "E:\\Java_Code\\Big_Homework\\First";
        String PathInput = "E:\\Java_Code\\Big_Homework\\First\\input.txt";
        String PathOutput = "E:\\Java_Code\\Big_Homework\\First\\output.txt";
        //标注文件路径

        createDir(PathFile);
        createFile(PathFile,"input.txt");
        createFile(PathFile,"output.txt");
        //生成文件路径以及文件

        java.io.File filein = new java.io.File(PathInput);
        java.io.File fileout = new java.io.File(PathOutput);
        java.io.PrintWriter output = new java.io.PrintWriter(fileout);
        //建立实现文件输入输出的对象

        Scanner input = new Scanner(filein);

        printFile("",PathOutput);    //清空原文件内容
        FileWriter fileout1 = new FileWriter(PathOutput,true); //创建用于文件写入的对象

        while (input.hasNextLine()){
            //循环输入，当输入为空/文件结尾时结束

            String post = input.nextLine();
            String postRem = post;      //保存字符串未加工的样子

            post = post.replaceAll(" ","");     //消除表达式中所有的空格
            CheckExpression checkExpression = new CheckExpression(post);
            String answer = checkExpression.check();        //检查表达式是否存在明显错误

            if (answer != null){
                //表达式有明显错误则直接输出，并进入下一循环
                output.print(answer + "\n");
            }
            else {
                //没发现明显错误则进行转换与计算
                Transform transform = new Transform(post);
                String temp = transform.transf_MtoA();

                if (transform.isTrue()){
                    //括号不匹配的情况返回输出错误
                    output.print("ERROR\n#括号不匹配\n");
                }
                else {
                    //括号也没问题
                    temp = temp.trim();     //掐头去尾
                    CalculateAfterExpression calculateAfterExpression = new CalculateAfterExpression(temp);
                    double realAnswer = calculateAfterExpression.CalcAll();         //计算表达式结果

                    if (map.get(temp) == null){
                        //判断是不是出现过的表达式，没有则输出结果并保存记录
                        map.put(temp,realAnswer);
                        output.print(postRem + " = " + realAnswer + "\n");
                    }
                    else {
                        //出现过则输出出现过
                        output.print("ERROR：\n#计算过的表达式，请在记录中查找结果！\n");
                    }
                }
            }
        }

        output.close();     //关闭文件输出

    }

    public static void createDir(String path){
        //创建文件路径的方法
        File dir = new File(path);
        if(!dir.exists())
            dir.mkdir();
    }

    public static void createFile(String path,String filename) throws IOException{
        //创建路径下对应的文件
        File file = new File(path +"/" + filename);
        if(!file.exists())
            file.createNewFile();
    }
    public static void printFile(String content,String pathName) {
        //文件中覆盖写入的方法
        BufferedWriter bw = null;
        try {
            File file = new File(pathName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
