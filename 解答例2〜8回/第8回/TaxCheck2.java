public class TaxCheck2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreTax2 tv=new PreTax2("ƒeƒŒƒr",29800);
		PostTax2 egg=new PostTax2("—‘",168);
		
		tv.print();
		egg.print();
	}

}

interface Tax{
	double rate=1.08;	
	abstract int cal();
}

class PreTax2 implements Tax{
	private String name;
	private int price;
	PreTax2(String n, int p){name=n; price=p;}
	public int cal(){
		return (int)(price*rate);
	}
	void print(){
		System.out.println(name+"‚Ì’è‰¿‚Í"+price+
				"‰~‚ÅAÅ‚İ‰¿Ši‚Í"+cal()+"‰~‚Å‚·B");
	}
}

class PostTax2 implements Tax{
	private String name;
	private int price;
	PostTax2(String n, int p){name=n; price=p;}
	public int cal(){
		return (int)(price/rate);
	}
	void print(){
		System.out.println(name+"‚ÌÅ‰¿Ši‚Í"+price+
				"‰~‚ÅA’è‰¿‚Í"+cal()+"‰~‚Å‚·B");
	}
}