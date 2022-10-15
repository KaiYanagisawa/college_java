import java.io.*;
import java.lang.Math;

public class LineDist {

  public static void main(String[] args) {
    double pt[][] = { { 0, 3 }, { 4, 0 } };
    Line ln = new Line(pt);
    ln.print();
    ln.mv(2.6, 3.2);
    ln.print();
    //以下２行は課題２テスト用
    ln.input();
    ln.print();
  }
}

class Line {

  private Point ln[] = new Point[2];

  Line(double pt[][]) {
    for (int i = 0; i < 2; i++) {
      ln[i] = new Point(pt[i][0], pt[i][1]);
    }
  }

  void mv(double x0, double y0) {
    for (int i = 0; i < 2; i++) {
      ln[i].set(x0 + ln[i].get_x(), y0 + ln[i].get_y());
    }
  }

  double distance() {
    return Math.sqrt(
      Math.pow(ln[0].get_x() - ln[1].get_x(), 2) +
      Math.pow(ln[0].get_y() - ln[1].get_y(), 2)
    );
  }

  void print() {
    System.out.println(
      "(" +
      ln[0].get_x() +
      ", " +
      ln[0].get_y() +
      ")と(" +
      ln[1].get_x() +
      ", " +
      ln[1].get_y() +
      ")の距離は" +
      distance() +
      "です。"
    );
  }

  void input() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double x1 = 0.0;
    double y1 = 0.0;
    double x2 = 0.0;
    double y2 = 0.0;

    double[][] points = { { x1, y1 }, { x2, y2 } };

    try {
      for (int i = 0; i < 2; i++) {
        System.out.print("点" + (i + 1) + "のx座標を入力してください:");
        String xString = br.readLine();
        points[i][0] = Double.parseDouble(xString);
        System.out.print("点" + (i + 1) + "のy座標を入力してください:");
        String yString = br.readLine();
        points[i][1] = Double.parseDouble(yString);
        ln[i].set(points[i][0], points[i][1]);
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}

class Point {

  private double x, y;

  Point(double x0, double y0) {
    x = x0;
    y = y0;
  }

  void set(double x0, double y0) {
    x = x0;
    y = y0;
  }

  double get_x() {
    return x;
  }

  double get_y() {
    return y;
  }
}
