import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.print.DocFlavor.STRING;

public class ScheduleManager {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LectureSchedule lec1 = new LectureSchedule();
        lec1.makeLecture(reader);
        // ReportSchedule rep1 = new ReportSchedule();
        // rep1.makeReport(reader);

    }
}