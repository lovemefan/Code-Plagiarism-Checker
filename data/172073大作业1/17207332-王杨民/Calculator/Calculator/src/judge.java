

public class judge {
	public boolean j(String string){
		if(empty(string))
		{
			if(emptybracket(string))
			{
				if(illegalcharacter(string))
				{
					if(bracket(string))
					{
						if(continuesym(string))
						{
							if(cancell(string))
							{
								if(cancell2(string))
								{
									if(cancell3(string))
									{
										if(cancell4(string))
										{
											return true;
										}else return false;
									}else return false;
								}else return false;
							}else return false;
						}else return false;
					}else return false;
				}else return false;
			}return false;
		}else{
			return false;
		}
	}
	//�ж��Ƿ�Ϊ���ַ���
	public boolean empty(String string) {
		// TODO Auto-generated constructor stub
		if(string.isEmpty()){
			//System.out.println("ERROR\n#���ʽΪ��");
			Writeinto.ww("ERROR\n#���ʽΪ��"+"\n");
			return false;
		}else{
			return true;
		}		
	}
	//�ж��Ƿ��п�����
	public boolean emptybracket(String string){
		char a[] = string.toCharArray();
		for(int i = 0; i<a.length-1;i++)
		{
			if(a[i]=='('&&a[i+1]==')')
			{
				Writeinto.ww("ERROR\n#���ʽ���п�����");
				return false;				
			}
		}
		if(a[a.length-2]=='('&&a[a.length-1]==')')
		{
			Writeinto.ww("ERROR\n#���ʽ���п�����");
			return false;
		}

			return true;
	}
	//�жϺ��зǷ��ַ�
	public boolean illegalcharacter(String string){
		count count = new count();
		char a[] = string.toCharArray();
		for(char t:a){
			if(count.isChar(t)!=1&&count.isChar(t)!=0&&count.isChar(t)!=2)
			{
				Writeinto.ww("ERROR\n#���ʽ�а����Ƿ��ַ�");
				return false;
			}else{
				return true;
			}
		}
		return true;
	}
	public boolean bracket(String string){
		int l = 0,r = 0;
		char a[] = string.toCharArray();
		for(char t:a){		
			if(t=='(')l++;
			else if(t==')')r++;
		}
		if(l!=r){
			Writeinto.ww("ERROR\n#���Ų�ƥ��");
			return false;
		}else {
			return true;
		}
	}
	public boolean continuesym(String string){
		count c = new count();
		char a[] = string.toCharArray();
		for(int i = 0; i<a.length-1; i++){		
			if(c.isChar(a[i])==0&&c.isChar(a[i+1])==0){
				Writeinto.ww("ERROR\n#���������");
				return false;
			}
		}
		if(c.isChar(a[a.length-2])==0&&c.isChar(a[a.length-1])==0){
			Writeinto.ww("ERROR\n#���������");
			return false;
		}else{
			return true;
		}
	}
	
	public boolean cancell(String string){
		count c = new count();
		char a[] = string.toCharArray();
		for(int i = 0; i<a.length; i++){
			if(c.isChar(a[i])==0){
				if(i==0){
					Writeinto.ww("ERROR\n#�����ǰ��������");
					return false;
				}else if(i-1>=0&&c.isChar(a[i-1])==0){
					Writeinto.ww("ERROR\n#�����ǰ��������");
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean cancell2(String string){
		count c = new count();
		char a[] = string.toCharArray();
		for(int i = 0; i<a.length; i++){
			if(c.isChar(a[i])==0){
				if(i==a.length-1){
					Writeinto.ww("ERROR\n#���������������");
					return false;
				}else if(i+1<a.length&&c.isChar(a[i+1])==0){
					Writeinto.ww("ERROR\n#���������������");
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean cancell3(String string){
		count c = new count();
		int l = 0,r = 0;
		char a[] = string.toCharArray();
		for(int i = 0; i<a.length; i++){
			if(a[i]=='('){
						if(i-1>=0&&c.isChar(a[i-1])==1)
						{Writeinto.ww("ERROR\n#���ŷǵ�һ���ַ���֮ǰ�������");
						 return false;
						}
					}					
				}		
		return true;
	}
	
	public boolean cancell4(String string){
		count c = new count();
		int l = 0,r = 0;
		char a[] = string.toCharArray();
		for(int i = 0; i<a.length; i++){
			if(a[i]==')'){
						if(i+1<a.length&&c.isChar(a[i+1])==1)
						{Writeinto.ww("ERROR\n#С���ź�������������ŷ����һ���ַ�");
						return false;
						}
					}					
				}		
		return true;
	}
}
