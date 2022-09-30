public class MySelectionSort {
public static void selectionSort(int [] data){
    printData(data) ;
 }
 }
public static void printData(int [] data){
 // 配列の要素を列挙する
 for(int i=0;i<data.length;i++)
 System.out.print(data[i]+", ") ;
 System.out.println();
 }
public static void main(String[] args) {
 int dataSize = args.length ; // データ数
 int [] data ; // データ保存用配列
 // コマンドラインから入力したデータを配列 data に格納する
 // 選択ソートを実行
selectionSort(data) ;
}
