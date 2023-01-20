public class TaxCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreTax tv=new PreTax("�e���r",29800);
		PostTax egg=new PostTax("��",168);
		
		tv.print();
		egg.print();
	}

}

abstract class BaseTax{
	double rate=1.08;
	String name;
	int price;
	BaseTax(){
		name=""; price=0;
	}
	BaseTax(String n, int p){
		name=n; price=p;
	}
	abstract int cal();
	void print(){
		System.out.println(cal()+"�~�ł��B");
	}
}

class PreTax extends BaseTax{
	PreTax(String n, int p){super(n,p);}
	int cal(){
		return (int)(price*rate);
	}
	void print(){
		System.out.print(name+"�̒艿��"+price+
				"�~�ŁA�ō��݉��i��");
		super.print();
	}
}

class PostTax extends BaseTax{
	PostTax(String n, int p){super(n,p);}
	int cal(){
		return (int)(price/rate);
	}
	void print(){
		System.out.print(name+"�̐ō����i��"+price+
				"�~�ŁA�艿��");
		super.print();
	}
}