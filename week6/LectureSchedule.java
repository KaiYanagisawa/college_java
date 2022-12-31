import java.io.BufferedReader;
import java.io.IOException;

public class LectureSchedule {
    int month;
    int day;
    String sch;

    // LectureSchedule(int m, int d, String s) {
    // this.month = m;
    // this.day = d;
    // this.sch = s;
    // // printInfo();
    // }

    void printInfo() {
        System.out.println(this.month + "月" + this.day + "日の予定:" + this.sch);
    }

    // LectureSchedule makeLecture(BufferedReader reader) {
    // int monthInt;
    // int dayInt;
    // String s;
    // try {
    // System.out.print("何月?> ");
    // String m = reader.readLine();
    // monthInt = Integer.parseInt(m);

    // // this.month = monthInt;

    // System.out.print("何日?> ");
    // String d = reader.readLine();
    // dayInt = Integer.parseInt(d);
    // // this.day = dayInt;

    // System.out.print("授業? >");
    // s = reader.readLine();
    // // this.sch = s;

    // printInfo();

    // } catch (IOException e) {
    // System.out.println(e);
    // }
    // // LectureSchedule lec = new LectureSchedule(monthInt, dayInt, s);
    // // return lec;
    // }
}