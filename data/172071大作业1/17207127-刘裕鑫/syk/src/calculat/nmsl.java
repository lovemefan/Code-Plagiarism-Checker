package calculat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

    class nmsl{
    
    static String n;
    static char a[];
    static char a1[];
    static int num[]=new int[100];
 
    nmsl(String n) {
        this.n=n;
    } 
    //比较运算符优先级
    public static int jisuan() {
        File f=new File("src/output");
        //String n=sc.nextLine();
        a=n.toCharArray();//从键盘读入算式，并存入数组a；
        int result=count(zhongToHou(a));

        return result;
    }
    
    public  static int YXJ(char c) {
        if(c==')') {
            return 1;
        }
        else if(c=='+'||c=='-') {
            return 2;
        }
        else if(c=='*'||c=='/') {
            return 3;
        }
        else if(c=='(') {
            return 4;
        }
        return -1;
    }
    
    //计算得出结果
    public  static int jisuan(int a,int b,char c) {
        if(c=='+') {
            return a+b;
        }
        else if(c=='-') {
            return b-a;
        }
        else if(c=='*') {
            return a*b;
        }
        else if(c=='/'&&a!=0) {
            return b/a;
        }
        return -1;
    }
    
    
    //中缀转后缀
    public static char[] zhongToHou(char []ch) {
        String str="";
        for(int i=0;i<ch.length;i++) {
            
            if(ch[i]>='0'&&ch[i]<='9') {
                if(i+1<ch.length&&(ch[i+1]<'0'||ch[i+1]>'9')||i+1==ch.length) {
                    push(ch[i]);
                    push('#');
                }
                else {
                    push(ch[i]);
                }
            }
            else {
                if(isEmpty2()||ch[i]=='('||YXJ(ch[i])>YXJ(peek2())) {
                    push2(ch[i]);
                }
                else if(ch[i]==')') {
                    while(peek2()!='(') {
                        push(pop2());
                    }
                    pop2();
                }
                else {
                    while(!isEmpty2()&&YXJ(ch[i])<=YXJ(peek2())&&peek2()!='(') {
                        push(pop2());
                    }
                    push2(ch[i]);
                    
                }
            }
        }
        while(!isEmpty2()) {
            push(pop2());
        }
        while(!isEmpty()) {
            str +=pop()+"";
        }
        a1=str.toCharArray();
        int w=a1.length;
        for(int i=0;i<w/2;i++) {
            char t;
            t=a1[i];
            a1[i]=a1[w-1-i];
            a1[w-1-i]=t;
        }
        return a1;
        
    }
        //计算算式结果
        public static  int count(char ch[]) {
            int sum=0;
            int k=0;
            int tmp=0;
            for(int i=0;i<ch.length;i++) {
                if(ch[i]=='#') {
                    continue;
                }
                else if(ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/') {
                    sum=jisuan(pop1(),pop1(),ch[i]);
                    push1(sum);
                }
                else {
                    if(ch[i+1]=='#') {
                        num[k++]=ch[i]-'0';
                        for(int j=0;j<k;j++) {
                            tmp+=(num[j]*(int)Math.pow(10, k-j-1));
                        }
                        push1(tmp);
                        tmp=0;
                        k=0;
                    }
                    else {
                        num[k++]=ch[i]-'0';
                    }
                }
            }
            return peek1();
            
        }   
    
 
    private static int  N=100;
    private static char data[]=new char[N];//数字字符栈
    private static char data2[]=new char[N];//操作符栈
    private static int data1[]=new int[N];//结果栈
    private static int top=-1;
    private static int top1=-1;
    private static int top2=-1;
 
     static boolean isEmpty() {
        
            return top==-1;
        
            
    }
 
    static void push(char n) {
        
            data[++top]=n;
    }
 
    static  char pop() {
        
            return data[top--];
        
        
        
    }
    static char peek() {
         return data[top];
     }
     
    static boolean isEmpty1() {
            
            return top1==-1;
        
            
    }
 
    static void push1(int n) {
        
            data1[++top1]=n;
    }
 
    static int pop1() {
        
            return data1[top1--];
        
        
        
    }
    static int peek1() {
         return data1[top1];
     }
    
    static boolean isEmpty2() {
            
            return top2==-1;
        
            
    }
 
    static void push2(char n) {
        
            data2[++top2]=n;
    }
 
    static char pop2() {
        
            return data2[top2--];
        
    }
    static char peek2() {
         return data2[top2];
     }
        
}
