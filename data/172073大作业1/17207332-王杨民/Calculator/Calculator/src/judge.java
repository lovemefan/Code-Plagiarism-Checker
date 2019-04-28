

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
	//判断是否为空字符串
	public boolean empty(String string) {
		// TODO Auto-generated constructor stub
		if(string.isEmpty()){
			//System.out.println("ERROR\n#表达式为空");
			Writeinto.ww("ERROR\n#表达式为空"+"\n");
			return false;
		}else{
			return true;
		}		
	}
	//判断是否含有空括号
	public boolean emptybracket(String string){
		char a[] = string.toCharArray();
		for(int i = 0; i<a.length-1;i++)
		{
			if(a[i]=='('&&a[i+1]==')')
			{
				Writeinto.ww("ERROR\n#表达式中有空括号");
				return false;				
			}
		}
		if(a[a.length-2]=='('&&a[a.length-1]==')')
		{
			Writeinto.ww("ERROR\n#表达式中有空括号");
			return false;
		}

			return true;
	}
	//判断含有非法字符
	public boolean illegalcharacter(String string){
		count count = new count();
		char a[] = string.toCharArray();
		for(char t:a){
			if(count.isChar(t)!=1&&count.isChar(t)!=0&&count.isChar(t)!=2)
			{
				Writeinto.ww("ERROR\n#表达式中包含非法字符");
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
			Writeinto.ww("ERROR\n#括号不匹配");
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
				Writeinto.ww("ERROR\n#运算符连续");
				return false;
			}
		}
		if(c.isChar(a[a.length-2])==0&&c.isChar(a[a.length-1])==0){
			Writeinto.ww("ERROR\n#运算符连续");
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
					Writeinto.ww("ERROR\n#运算符前无运算数");
					return false;
				}else if(i-1>=0&&c.isChar(a[i-1])==0){
					Writeinto.ww("ERROR\n#运算符前无运算数");
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
					Writeinto.ww("ERROR\n#运算符后无运算数");
					return false;
				}else if(i+1<a.length&&c.isChar(a[i+1])==0){
					Writeinto.ww("ERROR\n#运算符后无运算数");
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
						{Writeinto.ww("ERROR\n#括号非第一个字符且之前无运算符");
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
						{Writeinto.ww("ERROR\n#小括号后无运算符，括号非最后一个字符");
						return false;
						}
					}					
				}		
		return true;
	}
}
