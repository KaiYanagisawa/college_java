import java.io.*;
import java.util.ArrayList;

// StudentAdapterクラスに実装するためのDetailインタフェース

 // 教科クラス 
class Subject { 
    private String subjectName; 
    private int point; //  コンストラクタ 
    Subject (String sn, int p){ 
this.subjectName = sn; 
this.point = p; }  // subjectName, pointのゲッター 
public String getSubjectName(){ 
return subjectName; } 
public int getPoint(){ 
return point; } }  //  学生クラス 

class Student {
String name;
Subject[] sList; //  コンストラクタ
 Student (String n, Subject[] sl) { 
this.name=n;this.sList=sl;
} //  学生の科目情報を返すメソッド 

public String getInfo(){ String result = ""; result += "Name:" + name + "\n"; 
for(int i=0;i<sList.length;i++){ Subject s = sList[i]; result += "科目:" + s.getSubjectName() + "  点数:" + s.getPoint() + "\n"; } return result; }
}

//Studentクラスを継承し、Detailインタフェースを実装したStudentAdapterクラス

public class InterfaceFileTester { 
public static void main(String[] args) { ArrayList <StudentAdapter> studentList = new ArrayList <StudentAdapter> ();   try {   
    //  データファイルを読み込み，学生ごとにStudentAdapterオブジェクトを作成し，4人分のデータをstudentListに格納
  } catch (FileNotFoundException e) {    System.out.println("FileReaderから投げられた例外"+e);     } catch (IOException e) {    System.out.println("readLineから投げられた例外"+e);     }  for (StudentAdapter sa: studentList) {    sa.printInfo();    System.out.println("３教科の平均点:" + sa.getAverage() + "\n");   } } } 
