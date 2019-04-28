package dazuoye;


	public class fa {//´¦Àí×Ö·û´®
		private String u;
		private String shuzu[];

		public fa() {

		}

		public fa(String u) {
			this.u = u;
		}
		
	    public String getU(){
	    	return u;
	    }
	    
	    public void divide() {
			String a = u.replace(" ", "");
		    String b = a.replace("(", "");
			String c = b.replace(")", "");
			shuzu=c.split(",");
		}
	    
		public String[] getshuzu(){
			return shuzu;
		}
}
