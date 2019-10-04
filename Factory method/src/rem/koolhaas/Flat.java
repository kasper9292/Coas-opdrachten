package rem.koolhaas;

class Flat implements Building {
	private int _l, _b, _h;

	public Flat(int l, int b, int h) {
		_l = l;
		_h = h;
		_b = b;
	}

	public int volume() {
		return _l * _b * _h;
	}
}