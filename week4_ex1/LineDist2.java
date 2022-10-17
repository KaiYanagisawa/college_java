import java.io.*;
import java.lang.Math;

public class LineDist2 {

  public static void main(String[] args) {
    double pt[][] = { { 0, 3 }, { 4, 0 } };
    Line2 ln = new Line2(pt);
    ln.print();
    ln.mv(2.6, 3.2);
    ln.print();
    //以下２行は課題２テスト用
    ln.input();
    ln.print();
  }
}

class Line2 {

  private Point2 ln[] = new Point2[2];

  Line2(double pt[][]) {
    for (int i = 0; i < 2; i++) {
      ln[i] = new Point2(pt[i][0], pt[i][1]);
    }
  }

  void mv(double x0, double y0) {
    Point2 xy0 = new Point2(x0, y0);
    for (int i = 0; i < 2; i++) {
      ln[i] = new Point2((xy0.x + ln[i].x), (xy0.y + ln[i].y));
    }
  }

  double distance() {
    return Math.sqrt(
      Math.pow(ln[0].x - ln[1].x, 2) + Math.pow(ln[0].y - ln[1].y, 2)
    );
  }

  void print() {
    System.out.println(
      "(" +
      ln[0].x +
      ", " +
      ln[0].y +
      ")と(" +
      ln[1].x +
      ", " +
      ln[1].y +
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

    double[][] point2s = { { x1, y1 }, { x2, y2 } };

    try {
      for (int i = 0; i < 2; i++) {
        System.out.print("点" + (i + 1) + "のx座標を入力してください:");
        String xString = br.readLine();
        point2s[i][0] = Double.parseDouble(xString);
        System.out.print("点" + (i + 1) + "のy座標を入力してください:");
        String yString = br.readLine();
        point2s[i][1] = Double.parseDouble(yString);
        ln[i] = new Point2(point2s[i][0], point2s[i][1]);
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  class Point2 {

    private double x, y;

    Point2(double x0, double y0) {
      x = x0;
      y = y0;
    }
  }
}
