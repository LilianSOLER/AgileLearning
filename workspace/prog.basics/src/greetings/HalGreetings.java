package greetings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HalGreetings {
	public static void main(String[] args) throws IOException {
		String[] fullname;
		System.out.println("Hello, I am Hal, and you are?");
		fullname = readFullName();
		echoGreetings(fullname);
	}
	
	public static String[] readFullName() throws IOException {
//		String[] names = new String[2];
//		names[0] = "Albert";
//		names[1] = "Einstein";
//		return names;
		InputStreamReader r = new InputStreamReader(System.in);
	 	BufferedReader br = new BufferedReader(r);
		String line = br.readLine();
		String[] names;
		int index = line.indexOf(' ');
	    if (index!=-1) {
	      names = new String[2];
	      names[0] = line.substring(0, index);
	      names[1] = line.substring(index+1);
	    } else {
	      names = new String[1];
	      names[0] = line;
	    }
	    return names;
	}

	public static void echoGreetings(String[] names) {
		int i = 0;
		System.out.print("Greetings");
		while (i < names.length) {
			String s = names[i];
			System.out.print(" " + s);
			i = i + 1;
		}
		System.out.println("!");
	}
}
