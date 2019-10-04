package rem.koolhaas;

import java.io.*;
import java.util.*;

public class BuildingFactory {

	private Properties p;
	private String _type;
	private int _l, _b, _h;

	public static void main(String[] args) throws Exception {
		new BuildingFactory();
	}

	public BuildingFactory() throws Exception {
		loadBuilding();
		setProperties();
		createBuilding(_type, _l, _b, _h);
	}

	public void loadBuilding() throws Exception {
		p = new Properties();
		InputStream is = new FileInputStream("config.properties");
		p.load(is);
	}

	public void setProperties() {
		_type = p.getProperty("Building");
		_l = Integer.parseInt(p.getProperty("Length"));
		_b = Integer.parseInt(p.getProperty("Width"));
		_h = Integer.parseInt(p.getProperty("Height"));
	}

	public void createBuilding(String type, int l, int b, int h) {
		Building bd = null;
		if (type.equals("rem.koolhaas.Flat")) {
			bd = new Flat(l, b, h);
		} else if (type.equals("rem.koolhaas.Pyramid")) {
			bd = new Pyramid(l, b, h);
		}
		
		System.out.println("Building '" + p.getProperty("Building") + "' is build");
		System.out.println("Volume of building is " + bd.volume() + "m3");
	}
}
