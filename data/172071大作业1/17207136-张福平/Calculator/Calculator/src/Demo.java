import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws IOException {
        //对写过的类进行测试
    	Calc calc = new Calc();
        Scanner in = new Scanner(System.in);
        FileExpression fo = new FileExpression();
        ArrayList<String> list = new ArrayList<>();
        ArrayList newlist = new ArrayList();
        //读取数据
        list = fo.Reader();
        //调用校验类
        IsLegal legal = new IsLegal();
        //消除相同命令
        newlist = getSingle(list);
        //清空所有数据
        list.clear();
        for (int i = 0; i < newlist.size() ; i++) {
            list.add((String)newlist.get(i));
        }
        //消除最后可能读到的换行
        if (list.get(list.size()-1).equals("")&&list.size()!=0){
        list.remove(list.size()-1);
        }
        //将计算结果及错误输出输入到结果.txt中
        ArrayList<String> list1  = new ArrayList<>();
        list1 = legal.judge(list);
        String []list2 = new String[list1.size()];
        for (int i = 0; i <list1.size() ; i++) {
            list2[i] = list1.get(i);
        }
        //最终写入
        fo.Writer(list2);
    }

    public static ArrayList getSingle(ArrayList list) {
        ArrayList tempList = new ArrayList();                    //1,创建新集合
        Iterator it = list.iterator();
        //2,根据传入的集合(老集合)获取迭代器
        while(it.hasNext()) {                                    //3,遍历老集合
            Object obj = it.next();                                //记录住每一个元素
            if(!tempList.contains(obj)) {                        //如果新集合中不包含老集合中的元素
                tempList.add(obj);                                //将该元素添加
            }
        }
        return tempList;
    }
}
