public class MySelectionSort {

    public static void selectionSort(int[] data) {
      for(int i=0;i<data.length;i++){
          int min=i;
  for(int j=i+1;j<data.length;j++){
            if(data[min]>data[j]){
              int n;
              n=data[min];
              data[min]=data[j];
              data[j]=n;
            }
          }
      }
      printData(data);
    }

  //   public static void printData(int[] data) {
  //     // 配列の要素を列挙する
  //     for (int i = 0; i < data.length; i++) System.out.print(data[i] + ", ");
  //     System.out.println();
  //   }

  public static void main(String[] args) {
    // int dataSize = args.length; // データ数
    int[] data; // データ保存用配列
    // コマンドラインから入力したデータを配列 data に格納する
    data = new int[] { Integer.parseInt(args[0]) };
    // 選択ソートを実行
    selectionSort(data);
  }
}
