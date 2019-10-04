package rem.koolhaas;

class Pyramid implements Building {
	private int _l, _b, _h;

	public Pyramid(int l, int b, int h) {
		_l = l;
		_h = h;
		_b = b;
	}

	public int volume() {
		return _l * _b * _h / 3;
	}
}