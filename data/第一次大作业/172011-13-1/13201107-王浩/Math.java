import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Math {
    public static void main(String[] args){
        //�ļ���ȡ
        File file = new File("D:\\JAVA\\zuoye1.txt");
        //�����ݷ���List�У�ʹ��ArrayList
        //ArrayList��̳в�ʵ����List�ӿ�
        ArrayList<String> listStr = new ArrayList<String>();

        BufferedReader br = null;
        String str = null;
        try {
            br = new BufferedReader(new FileReader(file));
            //���ļ�����ѭ��ÿ�з�������
            while ((str = br.readLine()) != null){
                listStr.add(str);
            }
            //�ر�������
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        //�������
        System.out.println(listStr);

        //����������LIstStrResult
        ArrayList<String> listStrResult = new ArrayList<String>();
        for(int i=0;i<listStr.size();i++){
            //ÿһ��ѭ�������ʱ��ŵı���
            String resultStr = null;
            String result = FormulaCalculator.getResult(listStr.get(i));
            //�жϷ��ؽ���Ƿ���ȷ
            if(result.indexOf("#error") != -1){
                //ƴ�ӽ��
                resultStr = listStr.get(i) + " " + result;
            }else{
                //ƴ�ӽ��
                resultStr = listStr.get(i) + "=" + result;
            }
            //�����������뵽ListStrResult
            if (resultStr != null) {
                listStrResult.add(resultStr);
            }
        }
        //������
        System.out.println(listStrResult);

        //������Ľ���ŵ��ļ���
        // ����File���ҵ�Ҫ�����Ķ���
        File resultfile = new File("D:\\JAVA\\answer1.txt");
        //���û�оʹ���һ��
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        BufferedWriter  out = null;
        try {
            FileWriter fw =new FileWriter(resultfile);
            out = new BufferedWriter(fw);
            //ѭ�����
            for(int i=0;i<listStrResult.size();i++) {
                out.write(listStrResult.get(i));
                out.newLine();//���С�
            }
            //�ر������
            out.flush();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
