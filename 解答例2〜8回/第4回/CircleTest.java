import java.io.*;

public class CircleTest {
	public static void main(String[] args) {
		Circle c1 = new Circle("Circle1", 3.0);
		Circle c2 = new Circle("Circle2", 2.5);
		Circle c3 = new Circle("Circle3", 2.5);
		c1.print();
		c2.print();
		
		c1.compare(c2);
		c2.compare(c1);
		c2.compare(c3);
		
		c3.print();
		c3.input();
		c3.print();
		c3.compare(c1);
		c3.compare(c2);
	}
}

class Circle {
	private String name;
	private double r;
	
	Circle(String name, double r) {
		this.name = name;
		this.r = r;
	}
	double getArea() {
		return r * r * Math.PI;
	}
	String getName() {
		return name;
	}
	void compare(Circle rhs) {
		if (getArea() > rhs.getArea()) {
			System.out.println(getName() + "は" + rhs.getName() + "より大きい");
		} else if (getArea() < rhs.getArea()) {
			System.out.println(getName() + "は" + rhs.getName() + "より小さい");
		} else {
			System.out.println(getName() + "と" + rhs.getName() + "は同じ大きさ");
		}
	}
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nm = "";
		double r = 0.0;
		try {
			System.out.print("名前を入力してください:");
			nm = br.readLine();
			System.out.print("半径を入力してください:");
			r = Double.parseDouble(br.readLine());
		} catch(IOException e) {
			System.err.println(e);
		}
		this.name = nm;
		this.r = r;
	}
	void print() {
		System.out.println(getName() + "の面積は" + getArea());
	}
}
