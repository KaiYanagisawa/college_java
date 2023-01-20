
public class Heikin {
	public static void main(String[] args) {
		// ���̃��\�b�h�ł͐V���ɕϐ���錾���Ȃ�����
		String[] names; //���O�̃��X�g
		int[] times ; //�w��b���̃��X�g
		int[][] scores ; //���̃f�[�^
		
		// ���O�̃��X�g���쐬
		// names = new String[] {"����","�c��","�R��","�l�c","���{"} ; �ł�OK
		names = new String[5] ;
		names[0] = new String("����") ;
		names[1] = new String("�c��") ;
		names[2] = new String("�R��") ;
		names[3] = new String("�l�c") ;
		names[4] = new String("���{") ;
		//�w��b���̃��X�g���쐬
		times = new int[] {9, 11, 7, 5, 8, 14} ;
		//�_���̃f�[�^���쐬
		//scores = new int[][] {{126,�`,-986},{218,�`,-126},{524,�`,-263},{624,�`,211},{-911,�`,-241}} ; �ł�OK
		scores = new int[5][] ;
		scores[0] = new int [] {126, -36, 294, -935, -217, -986} ;
		scores[1] = new int [] {218, 425, 221, -126} ;
		scores[2] = new int [] {524, 18, -263} ;
		scores[3] = new int [] {624, 461, -890, -548, 211} ;
		scores[4] = new int [] {-911, 154, 165, -536, -982, -241} ;
		//���Z�҂��Ƃɍ��̕��ϒl���v�Z���C��ʂ֏o��
		System.out.print("�Q����: ") ;
		for(int i=0;i<names.length-1;i++)
			System.out.print(names[i]+", ") ;
		System.out.println(names[names.length-1]) ;
		System.out.print("�w��b��: ") ;
		for(int i=0;i<times.length-1;i++)
			System.out.print(i+1+"���:"+times[i]+"[s], ") ;
		System.out.println(times.length+"���:"+times[times.length-1]+"[s]") ;
		for (int i= 0; i<scores.length;i++) {
			double average = calAverage(scores[i]);
			printData(names[i], times, scores[i], average);
		}
	}
	
	static double calAverage(int[] ten) {
		int sum=0;
		for (int i =0; i<ten.length;i++) {
			if(ten[i]>0)
				sum+=ten[i] ;
			else
				sum-=ten[i] ;
		}
		return sum/(double)ten.length;
	}
	
	static void printData(String nm, int[] t, int[] s, double av) {
		System.out.print(nm+"����̋L�^-->") ;
		System.out.println("����: "+av+"[ms]") ;
		for (int i=0;i<s.length;i++) {
			int r = t[i] * 1000 ;
			r += s[i] ;
			System.out.print(i+1+"���: "+r+"[ms] ("+s[i]+")") ;
			if(i<s.length-1)
				System.out.print(", ") ;
			else
				System.out.println();
		}
	}
}
