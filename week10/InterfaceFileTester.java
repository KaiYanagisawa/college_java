import java.io.*;
import java.util.ArrayList;

// StudentAdapterクラスに実装するためのDetailインタフェース
interface Detail {
  void printInfo();

  int getSubjectScore(String sn);
  
  double getAverage();
}

// 教科クラス
class Subject {

  private String subjectName;
  private int point;

  //コンストラクタ
  Subject(String sn, int p) {
    this.subjectName = sn;
    this.point = p;
  }

  // subjectName, pointのゲッター
  public String getSubjectName() {
    return subjectName;
  }

  public int getPoint() {
    return point;
  }
}

//  学生クラス
class Student {

  String name;
  Subject[] sList;

  //  コンストラクタ
  Student(String n, Subject[] sl) {
    this.name = n;
    this.sList = sl;
  }

  //  学生の科目情報を返すメソッド
  public String getInfo() {
    String result = "";
    result += "Name:" + name + "\n";
    for (int i = 0; i < sList.length; i++) {
      Subject s = sList[i];
      result += "科目:" + s.getSubjectName() + "  点数:" + s.getPoint() + "\n";
    }
    return result;
  }
}

//Studentクラスを継承し、Detailインタフェースを実装したStudentAdapterクラス
class StudentAdapter extends Student implements Detail {

  StudentAdapter(String n, Subject[] sl) {
    super(n, sl);
  }

  public int getSubjectScore(String sn) {
    int subjectScore = 0;
    if (sn == "Math") {
      subjectScore = sList[0].getPoint();
    } else if (sn == "English") {
      subjectScore = sList[1].getPoint();
    } else if (sn == "Japanese") {
      subjectScore = sList[2].getPoint();
    }
    return subjectScore;
  }

  public double getAverage() {
    double sum = 0;
    double ave = 0;
    for (int i = 0; i < sList.length; i++) {
      sum += sList[i].getPoint();
    }
    ave = sum / sList.length;
    return ave;
  }

  public void printInfo() {
    System.out.println("Name:" + name);
    for (int i = 0; i < sList.length; i++) {
      Subject s = sList[i];
      System.out.println(
        "科目:" +
        s.getSubjectName() +
        " 点数:" +
        getSubjectScore(s.getSubjectName())
      );
    }
  }
}

public class InterfaceFileTester {

  public static void main(String[] args) {
    ArrayList<StudentAdapter> studentList = new ArrayList<StudentAdapter>();
    try {
      //  データファイルを読み込み，学生ごとにStudentAdapterオブジェクトを作成し，4人分のデータをstudentListに格納
      BufferedReader reader = new BufferedReader(
        new FileReader("StudentData_UTF-8.txt")
      );
      String line;
      while ((line = reader.readLine()) != null) {
        String[] s = line.split(",");
        String name = s[0];
        Subject math_points = new Subject("Math", Integer.parseInt(s[1]));
        Subject english_points = new Subject("English", Integer.parseInt(s[2]));
        Subject japanese_points = new Subject(
          "Japanese",
          Integer.parseInt(s[3])
        );

        Subject[] slist = new Subject[] {
          math_points,
          english_points,
          japanese_points,
        };

        StudentAdapter student = new StudentAdapter(name, slist);
        studentList.add(student);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("FileReaderから投げられた例外" + e);
    } catch (IOException e) {
      System.out.println("readLineから投げられた例外" + e);
    }
    for (StudentAdapter sa : studentList) {
      sa.printInfo();
      System.out.println("３教科の平均点:" + sa.getAverage() + "\n");
    }
  }
}
