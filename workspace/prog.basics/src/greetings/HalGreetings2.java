package greetings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HalGreetings2 {
	public static void main(String[] args) throws IOException {
		String[] fullname;
		System.out.println("Hello, I am Hal, and you are?");
		fullname = readFullName();
		echoGreetings(fullname);
	}
	
	public static int computeNumberOfNames(String line) {
	    int nnames = 1;
	    int index = line.indexOf(' ');
	    while (index!=-1) {
	      line = line.substring(index+1);
	      index = line.indexOf(' ');
	      nnames = nnames + 1;
	    }
	    return nnames;
	  }
	
	public static String[] readFullName() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String line = br.readLine();
	    int nnames = computeNumberOfNames(line);
	    String[] names = new String[nnames];
	    int i = 0;
	    while (i < nnames-1) {
	      int index = line.indexOf(' ');
	      names[i] = line.substring(0, index);
	      line = line.substring(index+1);
	      i += 1;
	    }
	    names[i] = line;
	    return names;
	}

	public static void echoGreetings(String[] names) {
		int i = 0;
		System.out.print("Greetings");
		if(names != null) {
			while (i < names.length) {
				String s = names[i];
				if(s != null) {
					System.out.print(" " + s);
				}
				i += 1;
			}
		}
		System.out.println("!");
	}
}
