
class Rectangle {
	String name;
	int width;
	int height;

	Rectangle () {
		this.name=null;
		this.width=0;
		this.height=0;
	}
	Rectangle (String n, int w, int h)
	{
		this.name = n ;
		this.width = w ;
		this.height = h;
	}

	String getName() {
		return name;
	}
	int getSize()
	{
		return this.width* this.height ;
	}
	void print() {
		System.out.println("名前:"+this.name+" 横:"+this.width+" 縦:"+this.height+" 大きさ:"+this.getSize());
	}

	void compare(Rectangle rct) {
		if (getSize() > rct.getSize()) {
			System.out.println(getName() + "は" + rct.getName() + "より大きい");
		} else if (getSize() < rct.getSize()) {
			System.out.println(getName() + "は" + rct.getName() + "より小さい");
		} else {
			System.out.println(getName() + "と" + rct.getName() + "は同じ大きさ");
		}
	}
}

