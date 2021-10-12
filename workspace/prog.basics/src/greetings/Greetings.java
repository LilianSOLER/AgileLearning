package greetings;

public class Greetings {
	 public static void main(String[] args) {
		    System.out.print("Greetings");
		    int i=0;
		    while (i < args.length) {
		      System.out.printf(" %s", args[i]);
		      i = i + 1;
		    }
		    System.out.println("!");
		    return;
		  }
}
