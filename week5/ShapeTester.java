import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ShapeTester {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int type=0;
		String nm = "";
		int yoko=0;
		int tate=0;
		int oku=0;
		while (true){
			try {
				System.out.println("1: 長方形入力   2: 直方体入力   3: 入力終了");
				type = Integer.parseInt(br.readLine());
				if (type==1){
					System.out.println("1つ目の長方形を作成...");
					System.out.print("名前を入力してください:");
					nm = br.readLine();
					System.out.print("横を整数で入力してください:");
					yoko = Integer.parseInt(br.readLine());
					System.out.print("縦を整数で入力してください:");
					tate = Integer.parseInt(br.readLine());
					Rectangle r1 = new Rectangle (nm, yoko, tate);
					r1.print();
					
					System.out.println("2つ目の長方形を作成...");
					System.out.print("名前を入力してください:");
					nm = br.readLine();
					System.out.print("横を整数で入力してください:");
					yoko = Integer.parseInt(br.readLine());
					System.out.print("縦を整数で入力してください:");
					tate = Integer.parseInt(br.readLine());
					Rectangle r2 = new Rectangle (nm, yoko, tate);
					r2.print();
					r1.compare(r2);
				} else if (type==2) {
					System.out.println("1つ目の直方体を作成...");
					System.out.print("名前を入力してください:");
					nm = br.readLine();
					System.out.print("横を整数で入力してください:");
					yoko = Integer.parseInt(br.readLine());
					System.out.print("縦を整数で入力してください:");
					tate = Integer.parseInt(br.readLine());
					System.out.print("奥行きを整数で入力してください:");
					oku = Integer.parseInt(br.readLine());
					Cuboid c1 = new Cuboid (nm, yoko, tate, oku);
					c1.print();
					
					System.out.println("2つ目の直方体を作成...");
					System.out.print("名前を入力してください:");
					nm = br.readLine();
					System.out.print("横を整数で入力してください:");
					yoko = Integer.parseInt(br.readLine());
					System.out.print("縦を整数で入力してください:");
					tate = Integer.parseInt(br.readLine());
					System.out.print("奥行きを整数で入力してください:");
					oku = Integer.parseInt(br.readLine());					
					Cuboid c2 = new Cuboid (nm, yoko, tate, oku);
					c2.print();
					c1.compare(c2);
				} else if (type==3) {
					System.out.println("システム終了");
					break;
				} else {
					System.out.println("入力番号が違います   1: 長方形入力   2: 直方体入力   3: 入力終了");
				}
			} catch(IOException e) {
				System.err.println(e);
			}
		}
	}
}

