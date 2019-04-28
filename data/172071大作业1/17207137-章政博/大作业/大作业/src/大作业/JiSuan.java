package ����ҵ;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class JiSuan {
	public int isSwitch(char ch) {
        int number = 0;
        switch (ch) {
        case '+': number = 0; break;
        case '-': number = 1; break;
        case '*': number = 2; break;
        case '/': number = 3; break;
        case '(': number = 4; break;
        case ')': number = 5; break;
        case '#': number = 6; break;
        default:
        	number = 7; break;
        }
        return number;
    }

    private char Judge(char One, char Two) {

        char[][] menu = { 
                { '>','>','<','<','<','>','>' },
                { '>','>','<','<','<','>','>' },
                { '>','>','>','>','<','>','>' },
                { '>','>','>','>','<','>','>' },
                { '<','<','<','<','<','=',' ' },
                { '>','>','>','>',' ','>','>' },
                { '<','<','<','<','<',' ','=' }, };
        int x = 0, y = 0;
        x = isSwitch(One);
        y = isSwitch(Two);
        return menu[x][y];
    }
    String[] shurubds(String s)
    {
    	char[]JSF = new char[50];//������ַ�ջ
    	int n1 = 0;//�ж��Ƿ�Ϸ�
    	String [] js= new String[50];
    	for(int i = 0;i<=49;i++) {
    		js[i] = new String();
    	}
    	JSF[0] = '#';
    	char e;
    	int i=0,j=0,jj=0;/*j�����׺���ʽ���±�*/
    	while((s.charAt(i) != '#')||(JSF[jj] != '#'))
    	{
    		if(Character.isDigit(s.charAt(i)))/*������ַ������ַ�,���������*/ 
    		{
    			js[j]=s.charAt(i)+"";
    			while(Character.isDigit(s.charAt(i+1))) {
    				js[j] = js[j]+s.charAt(i+1);
    				i++;
    				
    			}
    			++i;
    			++j;		              
    		}
    		else if(isSwitch(s.charAt(i))!=11)
    		{
    		switch(Judge(JSF[jj],s.charAt(i)))
    		{ 
    		/*��ջ�б�����������Ƚ�,���������,��ջ*/ 
    			case '<':
    			jj++;
    			JSF[jj] = s.charAt(i);
    			i++;
    			break;
    			
    			case '>':
    			e = JSF[jj];
    			jj--;
    			js[j]=e+"";
    			j++;
    			break;
    			
    			case '=':
    			e = JSF[jj];
        		jj--;
    			i++;
    			break;
    		}
    		}else {
    			System.out.println("ERROR\r\n#���ʽ�����Ƿ��ַ�");
    			js = null;
    			n1 = 1;
    			break;
    			
    		}
    		
    	}
    	
    	if(n1 == 0) {
    		js[j] = "#";
    	}
		return js;
    }  


	public int counter(String[] ex){
		int a1,b1,j = 0,he = 0,i = -1;
		int[] sz = new int[50];		
		while(ex[j]!="#")
		{
			if(isSwitch(ex[j].charAt(0))==7){
				
				++i;
				sz[i] = Integer.parseInt(ex[j]);
				j++;
				
			}
			else
			{
				switch(ex[j])
				{
					case"+":
						b1=sz[i--];
						a1=sz[i];
						he=a1+b1;
						sz[i] = he;
						break;
					case"-":
						b1=sz[i--];
						a1=sz[i];
						he=a1-b1;
						sz[i] = he;
						break;
					case"*":
						b1=sz[i--];
						a1=sz[i];
						he=a1*b1;
						sz[i] = he;
						break;
					case"/":
						b1=sz[i--];
						a1=sz[i];
						he=a1/b1;
						sz[i] = he;
						break;
				}
				++j;
			}
			
		}
		System.out.println("���Ϊ��"+he);
    	return he;
    }
	public void clearInfoForFile(File f) {
		try {
            if(!f.exists()) {
                f.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(f);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
