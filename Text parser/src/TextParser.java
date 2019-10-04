import java.io.*;
import java.util.*;

public class TextParser {

	private Scanner s;
	private Formatter f;
	private int lineCounter = 0;
	private String longestWord = "";

	public static void main(String[] args) throws FileNotFoundException {
		TextParser tp = new TextParser();
		tp.openFiles();
		tp.setHyperlinks();
		tp.parseFiles();
		tp.closeFiles();
	}

	public void openFiles() throws FileNotFoundException {
		s = new Scanner(new File("alice.txt"));
		f = new Formatter("alice.html");
	}

	public void setHyperlinks() {
		f.format("<a href=\"#CHAPTER I - Down the Rabbit-Hole\">Chapter I</a>%n");
		f.format("<a href=\"#CHAPTER II - The Pool of Tears\">Chapter II</a>%n");
		f.format("<a href=\"#CHAPTER III - A Caucus-Race and a Long Tale\">Chapter III</a>");
	}

	public void parseFiles() {
		while (s.hasNext()) {
			lineCounter++;
			String a = s.nextLine();
			a = a.replace("\t", "&nbsp &nbsp &nbsp &nbsp ");
			if (a.equals("")) {
				f.format("<br />%n");
			} else if (a.substring(0, 7).equals("CHAPTER")) {
				f.format("<h1 id=\"" + a + "\"> %s </h1>%n", a);
			} else {
				f.format("<p> %s </p>%n", a);
			}
			String a2[] = a.split(" ");
			for (int i = 0; i < a2.length; i++) {
				if (a2[i].length() >= longestWord.length()) {
					longestWord = a2[i];
				}
			}
		}
		System.out.println("Number of lines: " + lineCounter);
		System.out.println("Longest word: " + longestWord);
	}

	public void closeFiles() {
		s.close();
		f.close();
	}
}
