class Cuboid extends Rectangle {
	int depth;

	Cuboid (String n, int w, int h, int d){
		super (n, w, h);
		this.depth=d;
	}

	int getSize() {
		return this.width*this.height*this.depth;
	}
	void print() {
		System.out.println("名前:"+this.name+" 横:"+this.width+" 縦:"+this.height+" 奥行き:"+this.depth+" 大きさ:"+this.getSize());
	}

	void compare(Cuboid cbd) {
		if (getSize() > cbd.getSize()) {
			System.out.println(getName() + "は" + cbd.getName() + "より大きい");
		} else if (getSize() < cbd.getSize()) {
			System.out.println(getName() + "は" + cbd.getName() + "より小さい");
		} else {
			System.out.println(getName() + "と" + cbd.getName() + "は同じ大きさ");
		}
	}
}

