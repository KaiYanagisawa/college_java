import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ScheduleManager {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		//for static method
		/*
		LectureSchedule lec1 = LectureSchedule.makeLecture(reader);
		ReportSchedule rep1 = ReportSchedule.makeReport(reader);
		*/
		//for instance method

		LectureSchedule lec1 = new LectureSchedule();
		lec1.makeLecture(reader);
		ReportSchedule rep1 = new ReportSchedule();
		rep1.makeReport(reader);
	}
}

	class LectureSchedule {
		int day ;
		int month ;
		String sch ;

		LectureSchedule() {

		}
		LectureSchedule(int m, int d, String s){
			this.day=d;
			this.month=m;
			this.sch=s;
		}
		void printInfo()
		{
			System.out.println(this.month+"��"+this.day+"���̗\��F"+this.sch) ;
		}
		//static LectureSchedule makeLecture(BufferedReader br){
		LectureSchedule makeLecture(BufferedReader br){
			int m=0;
			int d=0;
			String s=new String();
			LectureSchedule lec1 = new LectureSchedule();
			try{

				System.out.println("���Ɨ\�����");
				System.out.print("�����H> ") ;
				m = Integer.parseInt(br.readLine()) ;
				System.out.print("�����H> ") ;
				d = Integer.parseInt(br.readLine());
				System.out.print("���ƁH> ") ;
				s = br.readLine();
				lec1 = new LectureSchedule(m, d, s);
				lec1.printInfo();
			}catch(IOException e){
				System.out.println(e) ;
			}
			return lec1;
		}

	}


	class ReportSchedule extends LectureSchedule {
		String rep;

		ReportSchedule() {

		}
		ReportSchedule(int m, int d, String s, String r){
			super(m, d, s);
			this.rep=r;
		}
		void printInfo()
		{
			System.out.println(this.month+"��"+this.day+"���̗\��F"+this.sch+"  ���|�[�g���e�F"+this.rep) ;
		}

		//static ReportSchedule makeReport(BufferedReader br){
		ReportSchedule makeReport(BufferedReader br){
			int m=0;
			int d=0;
			String s=new String();
			String r=new String();
			ReportSchedule rs1 = new ReportSchedule();
			try{
				System.out.println("���|�[�g�\�����");
				System.out.print("�����H>  ") ;
				m = Integer.parseInt(br.readLine()) ;
				System.out.print("�����H> ") ;
				d = Integer.parseInt(br.readLine());
				System.out.print("���ƁH> ") ;
				s = br.readLine();
				System.out.print("���|�[�g���e�H> ") ;
				r = br.readLine();
				rs1 = new ReportSchedule(m, d, s, r);
				rs1.printInfo();
			}catch(IOException e){
				System.out.println(e) ;
			}
			return rs1;
		}

	}