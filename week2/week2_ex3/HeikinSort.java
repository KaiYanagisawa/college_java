public class HeikinSort {

  public static void main(String[] args) {
    String[] names;
    int[] times;
    int[][] scores;

    names = new String[] { "遠藤", "田中", "山崎", "浜田", "松本" };
    times = new int[] { 9, 11, 7, 5, 8, 14 };
    scores =
      new int[][] {
        { 126, -36, 294, -935, -217, -986 },
        { 218, 425, 221, -126 },
        { 524, 18, -263 },
        { 624, 461, -890, -548, 211 },
        { -911, 154, 165, -536, -982, -241 },
      };

    System.out.print("参加者: ");
    for (int i = 0; i < names.length; i++) System.out.print(
      names[i] + ((i < names.length - 1) ? ", " : "")
    );
    System.out.println();
    System.out.print("指定秒数: ");
    for (int i = 0; i < times.length; i++) System.out.print(
      i + 1 + "回目:" + times[i] + "[s]" + ((i < times.length - 1) ? ", " : "")
    );
    System.out.println();

    double[] average_list;
    average_list = new double[scores.length];
    for (int i = 0; i < scores.length; i++) {
      average_list[i] = calAverage(scores[i]);
    }

    selectionSort(average_list, names, scores);

    for (int i = 0; i < scores.length; i++) {
      printData(names[i], times, scores[i], average_list[i]);
    }
  }

  public static void selectionSort(
    double[] average_list,
    String[] names,
    int[][] scores
  ) {
    for (int i = 0; i < average_list.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < average_list.length; j++) {
        if (average_list[min] > average_list[j]) min = j;
      }

      double n = average_list[i];
      average_list[i] = average_list[min];
      average_list[min] = n;

      String m = names[i];
      names[i] = names[min];
      names[min] = m;

      int[] l = scores[i];
      scores[i] = scores[min];
      scores[min] = l;
    }
  }

  static double calAverage(int[] score) {
    double ave = 0;
    double sum = 0;
    for (int i = 0; i < score.length; i++) sum =
      (score[i] < 0 ? sum - score[i] : sum + score[i]);

    ave = sum / score.length;
    return ave;
  }

  static void printData(String name, int[] time, int[] score, double average) {
    System.out.println(name + "さんの記録-->平均: " + average + "[ms]");
    for (int i = 0; i < score.length; i++) {
      System.out.print(
        (i + 1) +
        "回目:" +
        (time[i] * 1000 + score[i]) +
        "[ms]" +
        "(" +
        score[i] +
        ")" +
        ((i != score.length - 1) ? "," : "")
      );
    }
    System.out.println();
  }
}
