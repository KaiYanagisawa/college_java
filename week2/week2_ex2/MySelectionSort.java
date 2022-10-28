public class MySelectionSort {

  public static void selectionSort(int[] data) {
    for (int i = 0; i < data.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < data.length; j++) {
        if (data[min] > data[j]) min = j;
      }
      int n = data[i];
      data[i] = data[min];
      data[min] = n;

      printData(data);
    }
  }

  public static void printData(int[] data) {
    // 配列の要素を列挙する
    for (int i = 0; i < data.length; i++) System.out.print(
      data[i] + ((i < data.length - 1) ? ", " : "")
    );
    System.out.println();
  }

  public static void main(String[] args) {
    int dataSize = args.length; // データ数
    int[] data; // データ保存用配列
    // コマンドラインから入力したデータを配列 data に格納する
    data = new int[dataSize];
    for (int i = 0; i < dataSize; i++) data[i] = Integer.parseInt(args[i]);
    // 選択ソートを実行
    selectionSort(data);
  }
}
