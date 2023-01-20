
public class Heikin {
	public static void main(String[] args) {
		// このメソッドでは新たに変数を宣言しないこと
		String[] names; //名前のリスト
		int[] times ; //指定秒数のリスト
		int[][] scores ; //差のデータ
		
		// 名前のリストを作成
		// names = new String[] {"遠藤","田中","山崎","浜田","松本"} ; でもOK
		names = new String[5] ;
		names[0] = new String("遠藤") ;
		names[1] = new String("田中") ;
		names[2] = new String("山崎") ;
		names[3] = new String("浜田") ;
		names[4] = new String("松本") ;
		//指定秒数のリストを作成
		times = new int[] {9, 11, 7, 5, 8, 14} ;
		//点数のデータを作成
		//scores = new int[][] {{126,～,-986},{218,～,-126},{524,～,-263},{624,～,211},{-911,～,-241}} ; でもOK
		scores = new int[5][] ;
		scores[0] = new int [] {126, -36, 294, -935, -217, -986} ;
		scores[1] = new int [] {218, 425, 221, -126} ;
		scores[2] = new int [] {524, 18, -263} ;
		scores[3] = new int [] {624, 461, -890, -548, 211} ;
		scores[4] = new int [] {-911, 154, 165, -536, -982, -241} ;
		//競技者ごとに差の平均値を計算し，画面へ出力
		System.out.print("参加者: ") ;
		for(int i=0;i<names.length-1;i++)
			System.out.print(names[i]+", ") ;
		System.out.println(names[names.length-1]) ;
		System.out.print("指定秒数: ") ;
		for(int i=0;i<times.length-1;i++)
			System.out.print(i+1+"回目:"+times[i]+"[s], ") ;
		System.out.println(times.length+"回目:"+times[times.length-1]+"[s]") ;
		for (int i= 0; i<scores.length;i++) {
			double average = calAverage(scores[i]);
			printData(names[i], times, scores[i], average);
		}
	}
	
	static double calAverage(int[] ten) {
		int sum=0;
		for (int i =0; i<ten.length;i++) {
			if(ten[i]>0)
				sum+=ten[i] ;
			else
				sum-=ten[i] ;
		}
		return sum/(double)ten.length;
	}
	
	static void printData(String nm, int[] t, int[] s, double av) {
		System.out.print(nm+"さんの記録-->") ;
		System.out.println("平均: "+av+"[ms]") ;
		for (int i=0;i<s.length;i++) {
			int r = t[i] * 1000 ;
			r += s[i] ;
			System.out.print(i+1+"回目: "+r+"[ms] ("+s[i]+")") ;
			if(i<s.length-1)
				System.out.print(", ") ;
			else
				System.out.println();
		}
	}
}
