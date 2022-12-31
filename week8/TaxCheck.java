public class TaxCheck {
    public static void main(String[] args) {
        PreTax tv = new PreTax("テレビ", 29800);
        PostTax egg = new PostTax("卵", 168);
        tv.print();
        egg.print();
    }

}

abstract class BaseTax {
    // フィールドの定義
    double rate = 1.08;
    String name;
    int price;

    // コンストラクタの定義（インスタンスは作らないがコンストラクタは定義可能）
    BaseTax(String n, int p) {
        name = n;
        price = p;
    }

    // cal メソッドの宣言
    abstract int cal();

    void print() {
        System.out.println(cal() + "円です。");
    }
} // 以下、PreTax クラスの定義と、PostTax クラスの定義

class PreTax extends BaseTax {
    PreTax(String n, int p) {
        super(n, p);
    }

    int cal() {
        return (int) (price * rate);
    }

    void print() {
        System.out.println(name + "の定価は" + price + "円で、税込価格は" + cal() + "円です。");
    }
}

class PostTax extends BaseTax {
    PostTax(String n, int p) {
        super(n, p);
    }

    int cal() {
        return (int) (price / rate);
    }

    void print() {
        System.out.println(name + "の税込価格は" + price + "円で、定価は" + cal() + "円です。");
    }
}
