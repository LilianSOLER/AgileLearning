package greetings;

public class Tests {
	public static void main(String[] args) {
	    System.out.println("Test1:");
	    test1();
	    System.out.println("Test2:");
	    test2();
	    System.out.println("Test3:");
	    test3();
	    System.out.println("Test4:");
	    test4();
	    System.out.println("Test5:");
	    test5();
	    System.out.println("PASSED.");
	  }
	  public static void test1() {
	    String[] names = null;
	    HalGreetings2.echoGreetings(names);
	  }
	  public static void test2() {
	    String[] names = new String[0];
	    HalGreetings2.echoGreetings(names);
	  }
	  public static void test3() {
	    String[] names = new String[1];
	    HalGreetings2.echoGreetings(names);
	  }
	  public static void test4() {
	    String[] names = new String[1];
	    names[0]="Albert";
	    HalGreetings2.echoGreetings(names);
	  }
	  public static void test5() {
	    String[] names = new String[3];
	    names[0]="Albert";
	    names[1]="Einstein";
	    names[2]="PhD";
	    HalGreetings2.echoGreetings(names);
	  }
}
