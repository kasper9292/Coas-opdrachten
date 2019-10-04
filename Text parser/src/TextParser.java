import java.io.*;
import java.util.*;

public class TextParser {

	private Scanner s;
	private Formatter f;

	public static void main(String[] args) throws FileNotFoundException {
		TextParser tp = new TextParser();
		tp.openFiles();
		tp.parseFiles();
		tp.closeFiles();
	}

	public void openFiles() throws FileNotFoundException {
			s = new Scanner(new File("alice.txt"));
			f = new Formatter("alice.html");
	}

	public void parseFiles() {
		while (s.hasNext()) {
			String a = s.nextLine();
			a = a.replace("\t", "&nbsp &nbsp &nbsp &nbsp ");
			if (a.equals("")) {
				f.format("<br />%n");
			} else if (a.substring(0, 7).equals("CHAPTER")) {
				f.format("<h1> %s </h1>%n", a);
			} else {
				f.format("<p> %s </p>%n", a);
			}
		}
	}

	public void closeFiles() {
		s.close();
		f.close();
	}
}
