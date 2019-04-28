import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Math {
    public static void main(String[] args){
        //文件读取
        File file = new File("D:\\JAVA\\zuoye1.txt");
        //将数据放入List中，使用ArrayList
        //ArrayList类继承并实现了List接口
        ArrayList<String> listStr = new ArrayList<String>();

        BufferedReader br = null;
        String str = null;
        try {
            br = new BufferedReader(new FileReader(file));
            //将文件数据循环每行放入数组
            while ((str = br.readLine()) != null){
                listStr.add(str);
            }
            //关闭输入流
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        //输出数组
        System.out.println(listStr);

        //计算结果放入LIstStrResult
        ArrayList<String> listStrResult = new ArrayList<String>();
        for(int i=0;i<listStr.size();i++){
            //每一个循环结果临时存放的变量
            String resultStr = null;
            String result = FormulaCalculator.getResult(listStr.get(i));
            //判断返回结果是否正确
            if(result.indexOf("#error") != -1){
                //拼接结果
                resultStr = listStr.get(i) + " " + result;
            }else{
                //拼接结果
                resultStr = listStr.get(i) + "=" + result;
            }
            //将计算结果放入到ListStrResult
            if (resultStr != null) {
                listStrResult.add(resultStr);
            }
        }
        //输出结果
        System.out.println(listStrResult);

        //把输出的结果放到文件里
        // 利用File类找到要操作的对象
        File resultfile = new File("D:\\JAVA\\answer1.txt");
        //如果没有就创建一个
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        BufferedWriter  out = null;
        try {
            FileWriter fw =new FileWriter(resultfile);
            out = new BufferedWriter(fw);
            //循环输出
            for(int i=0;i<listStrResult.size();i++) {
                out.write(listStrResult.get(i));
                out.newLine();//换行
            }
            //关闭输出流
            out.flush();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
