public class TaxCheck2 {
    public static void main(String[] args) {
        PreTax2 tv = new PreTax2("テレビ", 29800);
        PostTax2 egg = new PostTax2("卵", 168);
        tv.print();
        egg.print();
    }
}

// Tax インタフェースの宣言
interface Tax {
    // フィールドの定義
    double rate = 1.08;

    // メソッドの定義
    int cal(int p);

    void print();
} // 以下、PreTax2 クラスの定義と、PostTax2 クラスの定義

class PreTax2 implements Tax {
    String name;
    int price;

    PreTax2(String n, int p) {
        name = n;
        price = p;
    }

    public int cal(int p) {
        return (int) (rate * p);
    }

    public void print() {
        System.out.println(name + "の定価は" + price + "円で、税込み価格は" + cal(price) + "円です。");
    }
}

class PostTax2 implements Tax {
    String name;
    int price;

    PostTax2(String n, int p) {
        name = n;
        price = p;
    }

    public int cal(int p) {
        return (int) (p / rate);
    }

    public void print() {
        System.out.println(name + "の税込み価格は" + price + "円で、定価は" + cal(price) + "円です。");
    }
}