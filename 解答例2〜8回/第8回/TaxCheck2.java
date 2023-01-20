public class TaxCheck2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreTax2 tv=new PreTax2("�e���r",29800);
		PostTax2 egg=new PostTax2("��",168);
		
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
		System.out.println(name+"�̒艿��"+price+
				"�~�ŁA�ō��݉��i��"+cal()+"�~�ł��B");
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
		System.out.println(name+"�̐ō����i��"+price+
				"�~�ŁA�艿��"+cal()+"�~�ł��B");
	}
}