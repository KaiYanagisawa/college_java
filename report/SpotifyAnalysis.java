import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpotifyAnalysis {

	public static void main(String[] args) {
		String filename_w = args[0];
		String filename_d = args[1];
		WeeklyDatabase wd = new WeeklyDatabase();
		wd.loadData(filename_w);  
		wd.printDatabase();
		DailyDatabase dd = new DailyDatabase();
		dd.loadData(filename_d);
		dd.printDatabase();

		System.out.println(
				"***** 今週のストリーミング回数トップ20のアーティスト *****");
		wd.getTop20Artists();
		System.out.println(
				"***** 今日のストリーミング回数トップ20のアーティスト *****");
		dd.getTop20Artists();
		String input;

		while (true) {
			System.out.println(
					"何を調べますか？  1:週間ランキング  2:本日ランキング  " +
							"3:チャートイン週数  4:チャートイン日数  5:終了");
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));
				input = reader.readLine();
				if (input.equals("5")) {
					break;
				} else if (input.equals("1")) {
					System.out.println("トラック名を入力->");
					input = reader.readLine();
					int num = wd.getTrackRanking(input);
					System.out.println(input + " の週間ランキング:" + num);
				} else if (input.equals("2")) {
					System.out.println("トラック名を入力->");
					input = reader.readLine();
					int num = dd.getTrackRanking(input);
					System.out.println(input + " の本日ランキング:" + num);
				} else if (input.equals("3")) {
					System.out.println("トラック名を入力->");
					input = reader.readLine();
					int num = wd.getChartIn(input);
					System.out.println(input + " のチャートイン週数:" + num);
				} else if (input.equals("4")) {
					System.out.println("トラック名を入力->");
					input = reader.readLine();
					int num = dd.getChartIn(input);
					System.out.println(input + " のチャートイン日数:" + num);
				} else {
					System.out.println("入力エラー");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
